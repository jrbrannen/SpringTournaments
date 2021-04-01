/**
 * 
 */
package dmacc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Players;
import dmacc.beans.Tournament;
import dmacc.repository.PlayersRepository;
import dmacc.repository.TournamentRepository;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 26, 2021
 */
@Controller
public class TournamentController {
	
	@Autowired
	TournamentRepository repo; 

	
	@GetMapping({"viewTournaments"})
		public String viewAllTournaments(Model model) {
		if(repo.findAll().isEmpty()) {
			return createTournament(model);
		}
		model.addAttribute("tournament", repo.findAll());
		return "tournamentResults";
	}

	@GetMapping("/createTournament")
		public String createTournament(Model model) {
			Tournament t = new Tournament();
			model.addAttribute("newTournament", t);
			return "createTournament";
	}
	
	@GetMapping("/edit/{id}")
		public String showUpdateTournament(@PathVariable("id") long id, Model model) {
			Tournament t = repo.findById(id).orElse(null);
			model.addAttribute("newTournament", t);
			return "createTournament";
		}
	
	@PostMapping("/createTournament/{id}")
		public String createTournament(@ModelAttribute Tournament t, Model model) {
			repo.save(t);
			return viewAllTournaments(model);
		}
	
	@GetMapping("/delete/{id}")
		public String deleteTournament(@PathVariable("id") long id, Model model) {
			Tournament t = repo.findById(id).orElse(null);
			repo.delete(t);
			return viewAllTournaments(model);
		}	
	


}

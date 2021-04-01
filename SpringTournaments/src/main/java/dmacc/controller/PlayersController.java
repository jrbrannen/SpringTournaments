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

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 1, 2021
 */
@Controller
public class PlayersController {
	
	@Autowired
	PlayersRepository repo;
	
	@GetMapping({"viewAllPlayers"})
	public String viewAllPlayers(Model model) {
		if(repo.findAll().isEmpty()) {
			return createPlayers(model);
		}
		model.addAttribute("players", repo.findAll());
		return "playersResults";
		}

		@GetMapping("/createPlayers")
		public String createPlayers(Model model) {
			Players p = new Players();
			model.addAttribute("newPlayers", p);
			return "createPlayers";
		}
		
		@PostMapping("/createPlayers/{id}")
		public String createPlayers(@ModelAttribute Players p, Model model) {
			repo.save(p);
			return viewAllPlayers(model);
		}
		
		@GetMapping("/pEdit/{id}")
		public String showUpdatePlayers(@PathVariable("id") long id, Model model) {
			Players p = repo.findById(id).orElse(null);
			model.addAttribute("newPlayers", p);
			return "createPlayers";
		}
		
		@GetMapping("/pDelete/{id}")
		public String deletePlayers(@PathVariable("id") long id, Model model) {
			Players p = repo.findById(id).orElse(null);
			repo.delete(p);
			return viewAllPlayers(model);
		}
		
}

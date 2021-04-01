/**
 * 
 */
package dmacc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Players;
import dmacc.beans.Tournament;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 26, 2021
 */
public interface TournamentRepository extends JpaRepository<Tournament, Long>{


}

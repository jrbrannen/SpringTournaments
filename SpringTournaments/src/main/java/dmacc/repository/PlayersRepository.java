/**
 * 
 */
package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Players;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 1, 2021
 */
public interface PlayersRepository extends JpaRepository<Players, Long>{


}

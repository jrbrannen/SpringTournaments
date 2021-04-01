/**
 * 
 */
package dmacc.beans;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 26, 2021
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude= {"id", "players"})

@Data
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tournament_id")
	private long id;
	private String name;
	private int maxPlayers;
	private String games;
	private double prizeMoney;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name="players", joinColumns= {@JoinColumn(name="tournament_id", referencedColumnName="tournament_id")}, inverseJoinColumns= { @JoinColumn(name="players_id", referencedColumnName="players_id", unique = true)})	
	private List<Players> players;

}

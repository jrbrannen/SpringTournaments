/**
 * 
 */
package dmacc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 1, 2021
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString (exclude= {"id", "tournament"})
public class Players {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="players_id")
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	@ManyToOne
	@JoinColumn(name="tournament_id")
	private Tournament tournament;
}

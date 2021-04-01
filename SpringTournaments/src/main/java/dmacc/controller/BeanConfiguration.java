/**
 * 
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Players;
import dmacc.beans.Tournament;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 26, 2021
 */
@Configuration
public class BeanConfiguration {
	
	@Bean
	public Tournament tournament() {
	Tournament bean = new Tournament();
	return bean;
	}

	@Bean
	public Players players() {
	Players bean = new Players();
	return bean;
	}
}

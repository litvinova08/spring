package io.nology.polandspringfull.pokemon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

//if class does not have any extra words, it is a Entity class

@Entity // the name of this class will be a DB name lower cased;
		// we can update this name adding it to @Entity
public class Pokemon {

	// the properties here will be columns in the database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	String name;

	@Column
	String element;

	@Column
	Integer level;

	@Column
	Integer hp;

	@Column
	Integer attackPower; // mySQL may convert it to attack_power for the DB

	public Pokemon() {
	};

	public Pokemon(String name, String element, Integer hp, Integer attackPower) {
		this.name = name;
		this.element = element;
		this.hp = hp;
		this.attackPower = attackPower;
		this.level = 1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(Integer attackPower) {
		this.attackPower = attackPower;
	}

}

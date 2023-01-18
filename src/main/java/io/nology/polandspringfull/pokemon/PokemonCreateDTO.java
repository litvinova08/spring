package io.nology.polandspringfull.pokemon;


public class PokemonCreateDTO {

	private String name;
	private String element;
	private Integer hp;
	private Integer attackPower;

	public PokemonCreateDTO(String name, String element, Integer hp, Integer attackPower) {
		this.name = name;
		this.element = element;
		this.hp = hp;
		this.attackPower = attackPower;
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

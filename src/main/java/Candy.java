

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(name="getAllCandys", query="FROM Candy"),
	@NamedQuery(name="getCandyById", query="FROM Candy WHERE id = :grapes")
})
@NamedNativeQuery(
			name="originalSQL",
			query = "SELECT * FROM candy WHERE p_id = :bananas",
			resultClass = Candy.class
		)

public class Candy {
	private Integer id;
	private String name;
	private Integer sugar;
	private String flavor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSugar() {
		return sugar;
	}
	public void setSugar(Integer sugar) {
		this.sugar = sugar;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public Candy(Integer id, String name, Integer sugar, String flavor) {
		super();
		this.id = id;
		this.name = name;
		this.sugar = sugar;
		this.flavor = flavor;
	}
	public Candy() {
		super();
	}
	@Override
	public String toString() {
		return "Candy [id=" + id + ", name=" + name + ", sugar=" + sugar + ", flavor=" + flavor + "]";
	}

}

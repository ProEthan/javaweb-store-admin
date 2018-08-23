package sacc.domain;

public class Goods {
	private Integer id;
	private String name;
	private Double price;
	private String image;
	private String descr;
	private Integer is_hot;
	private Integer cid;

	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", image='" + image + '\'' +
				", descr='" + descr + '\'' +
				", is_hot=" + is_hot +
				", cid=" + cid +
				'}';
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

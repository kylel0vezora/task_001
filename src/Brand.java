/**
 * 一副扑克牌中的每一张牌
 *
 */
public class Brand {
 
	// 扑克牌的类型
	private Type type;
	// 扑克牌的实际点数
	private Integer num;
	//扑克牌排面显示值
	private String label;
 
	// 直接创建一个构造器用来 创建每一张扑克牌
	public Brand(Type type, Integer num, String label) {
		super();
		this.type = type;
		this.num = num;
		this.label = label;
	}
 
	public Type getType() {
		return type;
	}
 
	public void setType(Type type) {
		this.type = type;
	}
 
	public Integer getNum() {
		return num;
	}
 
	public void setNum(Integer num) {
		this.num = num;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Brand ["+type + " " + label + ", num=" + num + "]";
	}	
}
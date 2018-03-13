package site;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NavigationPage {
	private String menu = "_menu.xhtml";
	private String style = "css/zelocallcenter.css";
	
	public String navPageIndex() {
		System.out.println("[PAGE] index");
		return "pretty:index";
	}

	public String navPageProdutos() {
		System.out.println("[PAGE] produtos");
		return "pretty:produtos";
	}

	public String navPageLocalizacao() {
		System.out.println("[PAGE] localizacao");
		return "pretty:localizacao";
	}

	public String navPageContato() {
		System.out.println("[PAGE] contato");
		return "pretty:contato";
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}

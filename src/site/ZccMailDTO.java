package site;

public class ZccMailDTO {
	private String formNome;
	private String formTelefone;
	private String formCPF;
	private int formAssunto;
	private String formMensagem;
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getFormNome() {
		return formNome;
	}

	public void setFormNome(String formNome) {
		this.formNome = formNome;
	}

	public String getFormTelefone() {
		return formTelefone;
	}

	public void setFormTelefone(String formTelefone) {
		this.formTelefone = formTelefone;
	}

	public String getFormCPF() {
		return formCPF;
	}

	public void setFormCPF(String formCPF) {
		this.formCPF = formCPF;
	}

	public int getFormAssunto() {
		return formAssunto;
	}

	public void setFormAssunto(int formAssunto) {
		this.formAssunto = formAssunto;
	}

	public String getFormMensagem() {
		return formMensagem;
	}

	public void setFormMensagem(String formMensagem) {
		this.formMensagem = formMensagem;
	}
	
}

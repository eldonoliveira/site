package site;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@RequestScoped
public class FormularioContato {
	private ZccMailDTO formDTO = new ZccMailDTO();

	@Inject
	private ZccMail zccMail;

	public void enviarFormulario() {
		String assunto = "";
		String msgFormatada = "";
		
		switch (formDTO.getFormAssunto()) {
		case 1:
			assunto = "Consignado - INSS";
			break;
		case 2:
			assunto = "Consignado - SIAPE";
			break;
		case 3:
			assunto = "Plano NET";
			break;
		}

		msgFormatada = "<h4>Contato via Site (www.zelocallcenter.com.br)</h4>" 
				+ "<p><small>Nome: </small>" + formDTO.getFormNome() + "</p>" 
				+ "<p><small>Fone: </small>" + formDTO.getFormTelefone() + "</p>"
				+ "<p><small>CPF: </small>" + formDTO.getFormCPF() + "</p>" 
				+ "<p><small>Assunto: </small>" + assunto + "</p>" 
				+ "<p><small>Mensagem: </small>" + formDTO.getFormMensagem() + "</p>";

		formDTO.setMensagem(msgFormatada);

//		System.out.println("[FORM-NOME] - " + formDTO.getFormNome());
//		System.out.println("[FORM-FONE] - " + formDTO.getFormTelefone());
//		System.out.println("[FORM-CPF ] - " + formDTO.getFormCPF());
//		System.out.println("[FORM-ASSU] - " + formDTO.getFormAssunto());
//		System.out.println("[FORM-MENS] - " + formDTO.getFormMensagem());

		zccMail.enviarEmailZcc(formDTO);

//		System.out.println("[FORM-SEND] - Mensagem enviada!!!");
		FacesMessages.info("Mensagem enviada com sucesso!", "");
		formDTO = new ZccMailDTO();
	}

	public ZccMailDTO getFormDTO() {
		return formDTO;
	}

}

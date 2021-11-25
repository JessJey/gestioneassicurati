package it.prova.gestioneassicurati.marshall;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.xml.Assicurati;

@Component
public class Unmarshal {

	public static List<Assicurato> faiUnmarshal() throws JAXBException, FileNotFoundException {

		List<Assicurato> listaAss = new ArrayList<>();
		
		

		JAXBContext context = JAXBContext.newInstance(Assicurati.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Assicurati assicurati;
		assicurati = (Assicurati) unmarshaller.unmarshal(new FileReader("C:\\CorsoST\\ws_eclipse2parte\\gestioneassicurati\\src\\filexml\\assicurato.xml"));

		for (it.prova.gestioneassicurati.xml.Assicurati.Assicurato assicurato : assicurati.getAssicurato()) {
			Assicurato assicuratoModel = new Assicurato();
			assicuratoModel.setNome(assicurato.getNome());
			assicuratoModel.setCognome(assicurato.getCognome());
			assicuratoModel.setDataDiNascita(assicurato.getDatadinascita());
			assicuratoModel.setCodiceFiscale(assicurato.getCodicefiscale());
			assicuratoModel.setNumerosinistri(assicurato.getNumerosinistri());
			listaAss.add(assicuratoModel);
		}
		return listaAss;
	}

}

package it.prova.gestioneassicurati.marshall;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import it.prova.gestioneassicurati.xml.Assicurati;
import it.prova.gestioneassicurati.xml.Assicurati.Assicurato;

public class Marshal {

	public static void faiMarshal(it.prova.gestioneassicurati.model.Assicurato assicuratoItem, String file)
			throws JAXBException, FileNotFoundException {

		JAXBContext contextObj = JAXBContext.newInstance(Assicurati.class);
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Assicurati assicurati = new Assicurati();

		it.prova.gestioneassicurati.xml.Assicurati.Assicurato assicuratoSingolo = new Assicurato();

		assicuratoSingolo.setNome(assicuratoItem.getNome());
		assicuratoSingolo.setCognome(assicuratoItem.getCognome());
		assicuratoSingolo.setDatadinascita(assicuratoItem.getDataDiNascita());
		assicuratoSingolo.setNumerosinistri(assicuratoItem.getNumeroSinistri());
		assicuratoSingolo.setCodicefiscale(assicuratoItem.getCodiceFiscale());

		assicurati.getAssicurato().add(assicuratoSingolo);

		marshallerObj.marshal(assicurati, new FileOutputStream(file));
	}
}

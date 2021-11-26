package it.prova.gestioneassicurati.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class UnmarshallingServiceImpl implements UnmarshallingService {

	@Override
	public List<Assicurato> unmarshal(String percorso) {

		List<Assicurato> assicuratiDaPassare = new ArrayList<Assicurato>();
		
		try{
		    File file = new File(percorso);
		    JAXBContext jContext = JAXBContext.newInstance(Assicurati.class);
		    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
		    Assicurati assicurati=(Assicurati) unmarshallerObj.unmarshal(file);
		    
		   
		    for (Assicurati.Assicurato assicuratoItem : assicurati.getAssicurato()) {
		    	 Assicurato assicuratoDaAggiungere = new Assicurato();
		    	assicuratoDaAggiungere.setNome(assicuratoItem.getNome());
		    	assicuratoDaAggiungere.setCognome(assicuratoItem.getCognome());
		    	assicuratoDaAggiungere.setCodiceFiscale(assicuratoItem.getCodicefiscale());
		    	assicuratoDaAggiungere.setDataDiNascita(assicuratoItem.getDatadinascita());
		    	assicuratoDaAggiungere.setNumerosinistri(assicuratoItem.getNumerosinistri());
		    	assicuratiDaPassare.add(assicuratoDaAggiungere);
				
		    	System.out.println(assicuratoItem.getNome());
			}
		}catch(Exception e){
		    e.printStackTrace();
		}
		return assicuratiDaPassare;

	}

}

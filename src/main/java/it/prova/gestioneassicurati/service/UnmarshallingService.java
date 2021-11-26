package it.prova.gestioneassicurati.service;

import java.util.List;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.xml.Assicurati;

public interface UnmarshallingService {

	public List<Assicurato> unmarshal(String percorso); 
	
}

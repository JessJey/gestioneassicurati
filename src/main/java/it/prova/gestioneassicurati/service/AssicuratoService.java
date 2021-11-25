package it.prova.gestioneassicurati.service;

import java.util.List;

import it.prova.gestioneassicurati.model.Assicurato;

public interface AssicuratoService {

	List<Assicurato> listAll();
	
	Assicurato caricaSingoloElemento(Long id);
	
	Assicurato aggiorna(Assicurato assicuratoInstance);
	
	Assicurato inserisciNuovo(Assicurato assicuratoInstance);
	
	public void rimuovi(Assicurato assicuratoInstance);

	Assicurato searchAssicurato(Assicurato assicuratoInstance);
	
	public void sommaSinistri(Assicurato assicuratoInstance);
}

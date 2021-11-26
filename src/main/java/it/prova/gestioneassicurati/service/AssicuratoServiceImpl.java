package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.repository.AssicuratoRepository;
import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class AssicuratoServiceImpl implements AssicuratoService {

	@Autowired
	private AssicuratoRepository repository;
	
	@Override
	public List<Assicurato> listAll() {
		return (List<Assicurato>) repository.findAll();
	}

	@Override
	public Assicurato caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Assicurato aggiorna(Assicurato assicuratoInstance) {
		return repository.save(assicuratoInstance);
	}

	@Override
	public Assicurato inserisciNuovo(Assicurato assicuratoInstance) {
		return repository.save(assicuratoInstance);
	}

	@Override
	public void rimuovi(Assicurato assicuratoInstance) {
		repository.delete(assicuratoInstance);
		
	}

	@Override
	public Assicurato searchAssicurato(Assicurato  assicuratoInstance) {
		String nome = assicuratoInstance.getNome();
		String cognome = assicuratoInstance.getCognome();
		String codiceFiscale = assicuratoInstance.getCodiceFiscale();
		return repository.findByNomeAndCognomeAndCodiceFiscale(nome, cognome, codiceFiscale);
	}

	@Override
	public void sommaSinistri(Assicurato assicuratoInstance) {
		String nome = assicuratoInstance.getNome();
		String cognome = assicuratoInstance.getCognome();
		String codiceFiscale = assicuratoInstance.getCodiceFiscale();
		Assicurato assicurato = repository.findByNomeAndCognomeAndCodiceFiscale(nome, cognome, codiceFiscale);
		assicurato.setNumerosinistri(assicuratoInstance.getNumeroSinistri().add(assicurato.getNumeroSinistri()));
		repository.save(assicurato);
	}
	

}

package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private AssicuratoService assicuratoService;

	@Override
	public void create(List<Assicurato> assicuratiInstance) {

		for (Assicurato assItem : assicuratiInstance) {
			Assicurato assDaCercare = assicuratoService.searchAssicurato(assItem);
			if (assDaCercare != null) {
				assicuratoService.sommaSinistri(assDaCercare);
			} else {
				assicuratoService.inserisciNuovo(assItem);
			}

		}
	}

}

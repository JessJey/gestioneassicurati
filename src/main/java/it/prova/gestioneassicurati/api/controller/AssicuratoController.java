package it.prova.gestioneassicurati.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;
import it.prova.gestioneassicurati.service.CheckService;
import it.prova.gestioneassicurati.service.RootFileService;
import it.prova.gestioneassicurati.service.UnmarshallingService;

@RestController
@RequestMapping(value = "/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AssicuratoController {

	@Autowired
	AssicuratoService assicuratoService;
	@Autowired
	UnmarshallingService unmarshallService;
	@Autowired
	RootFileService rootService;
	@Autowired
	CheckService checkService;

	
	@GetMapping
	public List<Assicurato> getAll() {
		return assicuratoService.listAll();
	}
	
	
	@GetMapping("/check")
	@ResponseStatus(HttpStatus.OK)
	public void checkAssicurato() throws Exception {
		String percorso = "C://Users/petru/Desktop/Esercizi/assicurato.xml";
		List<Assicurato> lista = unmarshallService.unmarshal(percorso);

		for (Assicurato assItem : lista) {
			if (assItem.getNumeroSinistri().intValue() < 0) {
				rootService.scarti(percorso);
			}
		}

		checkService.create(lista);

		rootService.processed(percorso);

	}
}

package it.prova.gestioneassicurati.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.marshall.Marshal;
import it.prova.gestioneassicurati.marshall.Unmarshal;
import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;

@RestController
@RequestMapping(value ="/assicurato", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AssicuratoController {

	@Autowired
	private AssicuratoService assicuratoService;
	
	
	@GetMapping
	private void checkAssicurato() throws Exception {

		List<Assicurato> listaAss = Unmarshal.faiUnmarshal();
		
		for (Assicurato assicuratoItem : listaAss) {
			
			if(assicuratoItem.getNumeroSinistri().intValue() < 0 ) {
				
				if(assicuratoService.searchAssicurato(assicuratoItem) == null) {
					
					assicuratoService.inserisciNuovo(assicuratoItem);
					Marshal.faiMarshal(assicuratoItem, "C:\\CorsoST\\ws_eclipse2parte\\gestioneassicurati\\src\\filexml\\Processed.xml");
				}else {
					assicuratoService.sommaSinistri(assicuratoItem);
					Marshal.faiMarshal(assicuratoItem, "C:\\CorsoST\\ws_eclipse2parte\\gestioneassicurati\\src\\filexml\\Processed.xml");
				}
				
			}else {
				Marshal.faiMarshal(assicuratoItem, "C:\\CorsoST\\ws_eclipse2parte\\gestioneassicurati\\src\\filexml\\Scarti.xml");
			}
		}
	}
	
	
}

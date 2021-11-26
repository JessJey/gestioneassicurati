package it.prova.gestioneassicurati.service;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class RootFileServiceImpl implements RootFileService{

	@Override
	public void scarti(String percorso) {
		File xmlFile = new File(percorso);
		int n = (int) (Math.random() * 20);
		xmlFile.renameTo(new File("C:\\Users\\petru\\Desktop\\Esercizi\\Scarti\\Scarti" + n + ".xml" ));
	}

	@Override
	public void processed(String percorso) {
		File xmlFile = new File(percorso);
		int n = (int) (Math.random() * 20);
		xmlFile.renameTo(new File("C:\\Users\\petru\\Desktop\\Esercizi\\Processed\\Processed" + n + ".xml"));
	}

}

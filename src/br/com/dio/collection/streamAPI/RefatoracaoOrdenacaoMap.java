package br.com.dio.collection.streamAPI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import br.com.dio.collection.streamAPI.model.entities.Contato;

public class RefatoracaoOrdenacaoMap {

	public static void main(String[] args) {

		Map<Integer, Contato> agenda = new HashMap<>() {
			{
				put(1, new Contato("Simba", 5555));
				put(4, new Contato("Cami", 1111));
				put(3, new Contato("Jon", 2222));
			}
		};
		System.out.println("--\tOrdem número telefone\t--");
		// classe anônima - inicio
//		Set<Map.Entry<Integer,Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
//			@Override
//			public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
//				return Integer.compare(cont1.getValue().getNumber(),cont2.getValue().getNumber());
//			}
//		});
		// classe anônima - fim

		// Método Comparing + classe anonima - inicio
		/*
		 * Set<Map.Entry<Integer,Contato>> set = new TreeSet<>(Comparator.comparing( new
		 * Function<Map.Entry<Integer, Contato>, Integer>() {
		 * 
		 * @Override public Integer apply(Entry<Integer, Contato> cont) { // TODO
		 * Auto-generated method stub return cont.getValue().getNumber(); } }));
		 */
		// Método Comparing + classe anonima - inicio

		
		// Lambda - inicio
		Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumber()));
		// Lambda - fim 
		
		set.addAll(agenda.entrySet());
		for (

		Map.Entry<Integer, Contato> entry : set) {
			System.out
					.println(entry.getKey() + " - " + entry.getValue().getNumber() + ": " + entry.getValue().getNome());
		}
	}

}

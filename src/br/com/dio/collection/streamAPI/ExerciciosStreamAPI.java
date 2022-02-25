package br.com.dio.collection.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {

	public static void main(String[] args) {
		List<String>numerosAleatorios =
				Arrays.asList("1","0","4","3","2","3","9","9","6","5");
		
		System.out.println("Imprima todos elementos dessa lista de String");
		
		System.out.println("Interface Funcional");
		numerosAleatorios.stream().forEach(new Consumer<String>() {
		@Override
		public void accept(String s) {
			System.out.println(s);
		}
		});
		
		System.out.println("stream().forEach");
		numerosAleatorios.stream().forEach(s-> System.out.println(s));
		System.out.println("forEach");
		numerosAleatorios.forEach(s-> System.out.println(s));
		
		System.out.println("Referenced Method");
		numerosAleatorios.forEach(System.out::println);
		
		System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
		
		numerosAleatorios.stream()
			.limit(5)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		Set<String> collectSet = numerosAleatorios.stream()
				.limit(5)
				.collect(Collectors.toSet());
		
		System.out.println("Transforme esta lista de String em uma lista de números interios.");
		
		numerosAleatorios.stream()
			.map(new Function<String, Integer>() {
				@Override
				public Integer apply(String s) {
					return Integer.parseInt(s);
				}
			});
		
		numerosAleatorios.stream()
		.map(Integer::parseInt).collect(Collectors.toList()).forEach(System.out::println);;
		
		
		List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());
		
		System.out.println("Pegue os numeros pares e maiores que 2 e coloque em uma lista: ");
		
		List<Integer> ListParesMaioresQue2 = numerosAleatorios.stream()
			.map(Integer::parseInt)
			.filter(new Predicate<Integer>() {
				@Override
				public boolean test(Integer i) {
					if(i % 2 == 0 && i>2)return true;
					return false;
				}
			}).collect(Collectors.toList());
		
		List<Integer> ListParesMaioresQue2OutraForma = numerosAleatorios.stream()
				.map(Integer::parseInt)
				.filter(i->(i%2==0 && i>2))
				.collect(Collectors.toList());
		
		System.out.println(ListParesMaioresQue2OutraForma);
		
		System.out.println("Mostre a média dos números : ");
		
		numerosAleatorios.stream()
			.mapToInt(Integer::parseInt)
			.average()
			.ifPresent( new DoubleConsumer() {
				@Override
				public void accept(double v) {
					System.out.println(v);
				}
			});
		
		numerosAleatorios.stream()
		.mapToInt(Integer::parseInt)
		.average()
		.ifPresent(System.out::println);
		
		System.out.println("Remova os valores impares : ");
		
		numerosAleatoriosInteger.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				if(integer%2 !=0)return true;
				return false;
			}
		});
		// Ou
		numerosAleatoriosInteger.removeIf(i -> (i%2 != 0 ));
		System.out.println(numerosAleatoriosInteger);

			
	}
}

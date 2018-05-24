package paquete;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		
		final String regex = "(@\\w+)(?: cuántos | cuántas )(\\w+|\\w+ \\w+)(?: son )(\\d+) (\\w+)";
		final String strings = "@jenkins cuántos gramos son 1 kilo\n"
				 			 + "@jenkins cuántos kilos son 1000 gramos\n"
				 			 + "@jenkins cuántas onzas son 1000 gramos\n"
				 			 + "@jenkins cuántos metros cubicos son 10 litros";
		
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(strings);
		
		while(matcher.find()) {
			System.out.println("Cadena: " + matcher.group(0));
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Grupo " + i + ": " + matcher.group(i));
			}
			System.out.println();
		}
	}
}

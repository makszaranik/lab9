package lab9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import lab9.Variant5.Car;
import lab9.Variant5.Ship;
import lab9.Variant8.*;

public class Main {

  public static void main(String[] args) {
    Car car1 = new Car(350, "Lamborghini", "red");
    Car car2 = new Car(250, "Ferrari", "blue");
    Car[] cars = {car1, car2};

    Arrays.sort(cars, Comparator.comparingInt(car -> car.getMaxSpeed()));
    System.out.println("Sorted cars by speed:");
    for (Car car : cars) {
      System.out.println(car);
    }


    TreeSet<Car> carSet = new TreeSet<>( Comparator.comparing((Car car) -> car.getColor()).reversed() );

    carSet.add(car1);
    carSet.add(car2);
    System.out.println("Cars in TreeSet sorted by color in reverse order:");
    for (Car car : carSet) {
      System.out.println(car);
    }

    Ship ship1 = new Ship(200, 3000);
    Ship ship2 = new Ship(150, 2000);
    Ship[] ships = {ship1, ship2};


    Arrays.sort(ships, Comparator.comparing((Ship ship) -> ship.getDeadWeight()).thenComparing((Ship ship) -> ship.getMaxSpeed()));
    System.out.println("Sorted ships by weight and max speed:");
    for (Ship ship : ships) {
      System.out.println(ship);
    }


    TreeSet<Ship> shipSetWithNullsFirst = new TreeSet<>(Comparator.nullsFirst(Comparator.comparing((Ship ship) -> ship.getDeadWeight())));
    shipSetWithNullsFirst.add(ship1);
    shipSetWithNullsFirst.add(ship2);
    shipSetWithNullsFirst.add(null);
    System.out.println("Ships in TreeSet sorted by weight with nulls first:");
    for (Ship ship : shipSetWithNullsFirst) {
      System.out.println(ship);
    }

    Document document1 = new TextDocument("document1");
    Document document2 = new TextDocument("document2 is larger than document1");

    Document[] documents = {document1, document2};

    Arrays.sort(documents, Comparator.comparingInt((Document doc) -> doc.read().length()));
    System.out.println("Sorted documents by length:");
    for (Document doc : documents) {
      System.out.println(doc);
    }

    TreeSet<TextDocument> textDocumentsWithNullsLast = new TreeSet<>(Comparator.nullsLast(Comparator.comparing((TextDocument textDocument) -> textDocument.getAmountSymbols())));
    textDocumentsWithNullsLast.add(new TextDocument("Hello"));
    textDocumentsWithNullsLast.add(new TextDocument("Welcome to the Java world"));
    textDocumentsWithNullsLast.add(new TextDocument("Short"));
    System.out.println("TextDocuments in TreeSet sorted by symbol count with nulls last:");
    for (TextDocument doc : textDocumentsWithNullsLast) {
      System.out.println(doc);
    }
  }
}

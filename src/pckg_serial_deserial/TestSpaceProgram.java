package pckg_serial_deserial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestSpaceProgram {

    public static void main(String[] args) {
        StarShip starShip1 = new StarShip("Enterprise");
        StarShip starShip2 = new StarShip("Voyager");
        StarShip starShip3 = new StarShip("Normandy");
        StarShip starShip4 = new StarShip("Millennium Falcon");
        ArrayList<StarShip> ships = new ArrayList<>();
        ships.add(starShip1);
        ships.add(starShip2);
        ships.add(starShip3);
        ships.add(starShip4);
        SerDeserial.saveObjects2File("spaceprog1.bin", ships, false);
        System.out.println(ships);
//        SerDeserial.saveObjects2File("spaceprog1.bin", ships, false);
//        List<StarShip> ships2 = SerDeserial.readObjectsFromFile("spaceprog1.bin");
//        System.out.println(ships2);
//        ships2.clear();
//        ships2.add(new StarShip("Serenity"));
//        SerDeserial.saveObjects2File("spaceprog1.bin", ships2, false);
//        List<StarShip> ships3 = SerDeserial.readObjectsFromFile("spaceprog1.bin");
//        System.out.println(ships3);
//        boolean status = SerDeserial.checkBinFile("spaceprog1.bin");
//        System.out.println("Exists and isn't empty: " + status);
//        SerDeserial.saveElements2File("spaceprog1.bin", ships);
//        System.out.println(ships);
        ships.add(new StarShip("Serenity"));
        ships.add(new StarShip ("Apollo 10"));
        SerDeserial.saveObjects2File("spaceprog1.bin", ships, true);
        System.out.println(ships);


    }
}

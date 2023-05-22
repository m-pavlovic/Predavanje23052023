package pckg_serial_deserial;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class StarShip implements java.io.Serializable {

    private static final int MAX_MISSIONS = 75;
    private static final int MIN_MISSIONS = 1;
    private String name;
    private int id;
    private static int cntID = 10;
    private int numMissions;
    private LocalDate firstMissionDate;


    public StarShip(String name) {
        this.name = name;
        this.id = cntID++;
        generateNumMissions();
        randomFirstMissionDate();
    }


    private void generateNumMissions() {
        this.numMissions = ThreadLocalRandom.current().nextInt(MIN_MISSIONS, MAX_MISSIONS + 1);
    }

    private void randomFirstMissionDate() {
        LocalDate startDate = LocalDate.of(2001, 1, 1);
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.now();
        long end = endDate.toEpochDay();
        long randomDate = start + (long) ((end - start) * Math.random());
        this.firstMissionDate = LocalDate.ofEpochDay(randomDate);
    }


    @Override
    public String toString() {
        return "StarShip{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", numMissions=" + numMissions +
                ", firstMissionDate=" + firstMissionDate +
                '}';
    }
}

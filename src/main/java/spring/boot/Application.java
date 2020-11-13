package spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.boot.bo.Game;
import spring.boot.bo.Prize;
import spring.boot.bo.State;
import spring.boot.dao.GameRepository;
import spring.boot.dao.PrizeRepository;
import spring.boot.dao.StateRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    //Create Logger using Log4j
    private static final Logger Log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(GameRepository gameRepository, StateRepository stateRepository, PrizeRepository prizeRepository) {
        return (args) -> {
            Log.info("---ITS WORKING---");
            InsertData(gameRepository, stateRepository, prizeRepository);
            DisplayDataFromDatabase(gameRepository, stateRepository, prizeRepository);
        }; //end of return
    }

    public static void InsertData(GameRepository gameRepository, StateRepository stateRepository, PrizeRepository prizeRepository) {

        //Insert Games
        Game powerball = new Game("Powerball");
        gameRepository.save(new Game("Mega Millions"));
        gameRepository.save(new Game("Lotto America"));
        gameRepository.save(new Game("Lucky For Life"));

        //Insert Prizes
        //One Game Many Prizes
        List<Prize> prizeList = new ArrayList<>();
        prizeList.add(new Prize("5 of 5 + Powerball", "JACKPOT*", "1 in 292,201,338.00"));
        prizeList.add(new Prize("5 of 5", "$1,000,000", "1 in 11,688,054.00"));
        prizeList.add(new Prize("4 of 5 + Powerball", "$50,000", "1 in 913,129.00"));
        prizeList.add(new Prize("4 of 5", "$100", "1 in 36,525.00"));
        prizeList.add(new Prize("3 of 5 + Powerball", "$100", "1 in 14,494.00"));
        prizeList.add(new Prize("3 of 5", "$7", "1 in 580.00"));
        prizeList.add(new Prize("2 of 5 + Powerball", "$7", "1 in 701.00"));
        prizeList.add(new Prize("1 of 5 + Powerball", "$4", "1 in 92.00"));
        prizeList.add(new Prize("Powerball Only", "$4", "1 in 38.00"));

        powerball.setPrizeList(prizeList);
        //prizeRepository.save(prizeList);
        gameRepository.save(powerball);

        //Insert States
        stateRepository.save(new State("Minnesota", "MN"));
        stateRepository.save(new State("California", "CA"));
        stateRepository.save(new State("North Carolina", "NC"));
        stateRepository.save(new State("Georgia", "GA"));
        stateRepository.save(new State("Illinois", "IL"));
        stateRepository.save(new State("Hawaii", "HI"));
        stateRepository.save(new State("Florida", "FL"));

        //Many Games to Many States
        //Get game that you want to add states you can play in
        Game game1 = gameRepository.findOne(4);

        //Create a list to add the states that a game can be played in
        List<State> stateList = new ArrayList<>();
        stateList.add(stateRepository.findOne(1));
        stateList.add(stateRepository.findOne(2));
        stateList.add(stateRepository.findOne(3));
        stateList.add(stateRepository.findOne(4));
        stateList.add(stateRepository.findOne(5));
        stateList.add(stateRepository.findOne(6));
        stateList.add(stateRepository.findOne(7));

        //Set states to the game object
        game1.setStateList(stateList);
        //Save it to the database
        gameRepository.save(game1);
    }

    public static void DisplayDataFromDatabase(GameRepository gameRepository, StateRepository stateRepository, PrizeRepository prizeRepository) {
        //Get Game Powerball from Database
        Game powerball = gameRepository.findOne(4);

        //Display Powerball Name using getGameName
        Log.info("Game: " + powerball.getGameName());

        //Display Powerball States including State Name and Initials
        Log.info(powerball.getGameName() + " can be played in: ");
        for(State state : powerball.getStateList()) {
            Log.info(state.getStateName() + ", " + state.getStateInitials());
        }

        //Display Powerball Prizes including Match, Win and Odds
        Log.info(powerball.getGameName() + " Prizes");
        Log.info("List Size: " + powerball.getPrizeList().size());
        for(Prize prize : powerball.getPrizeList()) {
            Log.info("Match: " + prize.getMatch() + " Win: " + prize.getWin() + " Odds: " + prize.getOdds());
        }
    }
}

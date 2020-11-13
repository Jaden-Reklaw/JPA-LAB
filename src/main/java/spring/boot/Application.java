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
        }; //end of return
    }

    public static void InsertData(GameRepository gameRepository, StateRepository stateRepository, PrizeRepository prizeRepository) {

        //Insert Games
        gameRepository.save(new Game("Powerball"));
        gameRepository.save(new Game("Mega Millions"));
        gameRepository.save(new Game("Lotto America"));
        gameRepository.save(new Game("Lucky For Life"));

        //Insert Prizes
        prizeRepository.save(new Prize("5 of 5 + Powerball", "JACKPOT*", "1 in 292,201,338.00"));
        prizeRepository.save(new Prize("5 of 5", "$1,000,000", "1 in 11,688,054.00"));
        prizeRepository.save(new Prize("4 of 5 + Powerball", "$50,000", "1 in 913,129.00"));
        prizeRepository.save(new Prize("4 of 5", "$100", "1 in 36,525.00"));
        prizeRepository.save(new Prize("3 of 5 + Powerball", "$100", "1 in 14,494.00"));
        prizeRepository.save(new Prize("3 of 5", "$7", "1 in 580.00"));
        prizeRepository.save(new Prize("2 of 5 + Powerball", "$7", "1 in 701.00"));
        prizeRepository.save(new Prize("1 of 5 + Powerball", "$4", "1 in 92.00"));
        prizeRepository.save(new Prize("Powerball Only", "$4", "1 in 38.00"));

        //Insert States
        stateRepository.save(new State("Minnesota", "MN"));
        stateRepository.save(new State("California", "CA"));
        stateRepository.save(new State("North Carolina", "NC"));
        stateRepository.save(new State("Georgia", "GA"));
        stateRepository.save(new State("Illinois", "IL"));
        stateRepository.save(new State("Hawaii", "HI"));
        stateRepository.save(new State("Florida", "FL"));
    }
}

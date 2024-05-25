import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem();

        System.out.println("Welcome to the Voting System!");

        int numCandidates = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the number of candidates: ");
                numCandidates = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        for (int i = 0; i < numCandidates; i++) {
            System.out.print("Enter the name of candidate " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter the party of candidate " + (i + 1) + ": ");
            String party = scanner.nextLine();
            Candidate candidate = new Candidate(name, party);
            votingSystem.addCandidate(candidate);
        }

        boolean votingComplete = false;
        while (!votingComplete) {
            System.out.println("Candidates:");
            List<Candidate> candidates = votingSystem.getCandidates();
            for (int i = 0; i < candidates.size(); i++) {
                System.out.println((i + 1) + ". " + candidates.get(i).getName() + " (" + candidates.get(i).getParty() + ")");
            }
            System.out.println("0. Stop Voting");

            int choice = 0;
            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            if (choice == 0) {
                votingComplete = true;
            } else {
                votingSystem.vote(choice - 1);
            }
        }

        System.out.println("Voting has ended. Tabulating votes...");
        votingSystem.tabulateVotes();

        scanner.close();
    }
}
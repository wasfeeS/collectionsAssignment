import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public 
class VotingSystem {
    private List<Candidate> candidates;
    private Map<Candidate, Integer> voteCount;

    public VotingSystem() {
        candidates = new ArrayList<>();
        voteCount = new HashMap<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        voteCount.put(candidate, 0);
    }

    public void vote(int candidateIndex) {
        if (candidateIndex >= 0 && candidateIndex < candidates.size()) {
            Candidate candidate = candidates.get(candidateIndex);
            voteCount.put(candidate, voteCount.get(candidate) + 1);
            System.out.println("Vote for " + candidate.getName() + " recorded.");
        } else {
            System.out.println("Invalid candidate index.");
        }
    }

    public void tabulateVotes() {
        List<Candidate> winners = new ArrayList<>();
        int maxVotes = 0;
        for (Candidate candidate : candidates) {
            int votes = voteCount.get(candidate);
            if (votes > maxVotes) {
                winners.clear();
                winners.add(candidate);
                maxVotes = votes;
            } else if (votes == maxVotes) {
                winners.add(candidate);
            }
        }

        if (winners.size() == 1) {
            Candidate winner = winners.get(0);
            System.out.println("Winner: " + winner.getName() + " from " + winner.getParty() + " with " + maxVotes + " votes.");
        } else {
            System.out.println("It's a tie between the following candidates:");
            for (Candidate winner : winners) {
                System.out.println(winner.getName() + " from " + winner.getParty() + "tie the elections with " + maxVotes + " votes.");
            }
        }
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }
}
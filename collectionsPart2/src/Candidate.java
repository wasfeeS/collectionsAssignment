public class Candidate {
    private String name;
    private int votes;
    private String party;

    public Candidate(String name, String party) {
        this.name = name;
        this.party = party;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void plusVote() {
        votes++;
    }

    public String getParty() {
        return party;
    }

    @Override
    public String toString() {
        return name + " (" + party + "): " + votes + " votes";
    }
}

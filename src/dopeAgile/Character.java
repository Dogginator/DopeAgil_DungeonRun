
package dopeAgile;

public abstract class Character extends Creature {

    int initiative;
    int endurance;
    int attack;
    int agility;
    int positionX;
    int positionY;
    private String name;
    int points;
    int playerId;
    int idGenerator;
    int combatEndurance;
    Role role;

    public Character() {
       this.positionX = 0;
       this.positionY = 0;
       this.name = name;
       this.points = 0;
       this.playerId = idGenerator;
    }

    public enum Role {
        WIZARD, ROUGE, KNIGHT;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    // Returns the calculated attack score
    public int calcAttackScore() {
        int attackScore = 0;
        for (int i = 0; i < attack; i++) {
            attackScore += Utility.throwSixSidedDie();
        }
        return attackScore;
    }

    // Restores "health" to full. Should be called after
    // each successful combat and successful flee attempt
    public void refreshCombatEndurance() {
        combatEndurance = endurance;
    }

    @Override
    public int getCombatEndurance() {
        return combatEndurance;
    }

    abstract Role getRole();

    abstract void setRole(Role newRole);
    
    @Override
    public String toString() {
        return "Character{" + " initiative : " + initiative + ", endurance : " + endurance + ", attack : " + attack + ", agility : " + agility + '}';
    }

    abstract String toString(boolean conjugate);
   
    abstract void specialAbility();

}

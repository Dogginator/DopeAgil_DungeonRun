
package dopeAgile;

public class Rouge extends Character {
       
    public Rouge() {
        super();
        this.initiative = 7;
        this.endurance = 5;
        this.attack = 5;
        this.agility = 7;
        setRole(Role.ROUGE);
        super.refreshCombatEndurance();
    }

    public void specialAbility() {

    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Tjuven" : "Tjuv";
    }

    @Override
    public void setRole(Role newRole) {
        super.role = newRole;
    }

    @Override
    public Role getRole() {
        return super.role;
    }

}
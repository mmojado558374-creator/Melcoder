import javax.swing.JOptionPane;

// 🔹 Abstract class (blueprint for tanks)
abstract class Tank {
    protected int capacity;       // maximum liters
    protected int currentLevel;   // current liters

    public Tank(int capacity) {
        this.capacity = capacity;
        this.currentLevel = 0; // start empty
    }

    // abstract methods = must be written by child classes
    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract String checkStatus();
}

// 🔹 HomeTank (200 liters)
class HomeTank extends Tank {
    public HomeTank() {
        super(200);
    }

    @Override
    public void fillTank(int liters) {
        currentLevel = Math.min(capacity, currentLevel + liters);
        JOptionPane.showMessageDialog(null, "Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void useWater(int liters) {
        currentLevel = Math.max(0, currentLevel - liters);
        JOptionPane.showMessageDialog(null, "Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public String checkStatus() {
        if (currentLevel == capacity) return "Tank is Full!";
        if (currentLevel == 0) return "Tank is Empty!";
        return "Tank is In Use.";
    }
}

// 🔹 BuildingTank (1000 liters)
class BuildingTank extends Tank {
    public BuildingTank() {
        super(1000);
    }

    @Override
    public void fillTank(int liters) {
        currentLevel = Math.min(capacity, currentLevel + liters);
        JOptionPane.showMessageDialog(null, "Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void useWater(int liters) {
        currentLevel = Math.max(0, currentLevel - liters);
        JOptionPane.showMessageDialog(null, "Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public String checkStatus() {
        if (currentLevel == capacity) return "Tank is Full!";
        if (currentLevel == 0) return "Tank is Empty!";
        return "Tank is In Use.";
    }
}

// 🔹 Main Program (must match filename)
public class watertank {
    public static void main(String[] args) {
        Tank tank;

        // choose tank
        String choice = JOptionPane.showInputDialog("Choose tank:\n1. HomeTank (200L)\n2. BuildingTank (1000L)");
        if ("1".equals(choice)) tank = new HomeTank();
        else if ("2".equals(choice)) tank = new BuildingTank();
        else {
            JOptionPane.showMessageDialog(null, "Invalid choice. Exiting.");
            return;
        }

        // loop until empty or full
        while (true) {
            String action = JOptionPane.showInputDialog("Choose:\n1. Fill Tank\n2. Use Water\n3. Check Status\n4. Exit");

            if ("1".equals(action)) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Liters to fill:"));
                tank.fillTank(liters);
            } else if ("2".equals(action)) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Liters to use:"));
                tank.useWater(liters);
            } else if ("3".equals(action)) {
                JOptionPane.showMessageDialog(null, tank.checkStatus());
            } else if ("4".equals(action)) {
                JOptionPane.showMessageDialog(null, "Program ended.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option.");
            }

            // stop when empty or full
            if (tank.currentLevel == 0 || tank.currentLevel == tank.capacity) {
                JOptionPane.showMessageDialog(null, tank.checkStatus() + " Program ended.");
                break;
            }
        }
    }
}

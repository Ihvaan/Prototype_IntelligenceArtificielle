import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class IntelligentAgent implements Cloneable {
    public abstract IntelligentAgent clone();
    public abstract void processRequest();
}

class MobileAgent extends IntelligentAgent {
    @Override
    public MobileAgent clone() {
        return new MobileAgent();
    }

    @Override
    public void processRequest() {
        Random rand = new Random();
        System.out.println("Request processed by computer: " + rand.nextInt(10));
    }
}

class InformationAgent extends IntelligentAgent {
    @Override
    public InformationAgent clone() {
        return new InformationAgent();
    }

    @Override
    public void processRequest() {
        System.out.println("Request processed using various information sources.");
    }
}

class InterfaceAgent extends IntelligentAgent {
    @Override
    public InterfaceAgent clone() {
        return new InterfaceAgent();
    }

    @Override
    public void processRequest() {
        Random rand = new Random();
        System.out.println("Request processed using graphical components: " +
                rand.nextInt(10) + ", " + rand.nextInt(10) + ", " + rand.nextInt(10));
    }
}

class CollaborativeAgent extends IntelligentAgent {
    @Override
    public CollaborativeAgent clone() {
        return new CollaborativeAgent();
    }

    @Override
    public void processRequest() {
        Random rand = new Random();
        System.out.println("Request processed with contributors: " +
                rand.nextInt(10) + ", " + rand.nextInt(10));
    }
}

class ReferenceBatchAgent {
    private static ReferenceBatchAgent instance;
    private List<IntelligentAgent> agents = new ArrayList<>();

    private ReferenceBatchAgent() {
        agents.add(new MobileAgent());
        agents.add(new InformationAgent());
        agents.add(new InterfaceAgent());
        agents.add(new CollaborativeAgent());
    }

    public static synchronized ReferenceBatchAgent getInstance() {
        if (instance == null) {
            instance = new ReferenceBatchAgent();
        }
        return instance;
    }

    public List<IntelligentAgent> getAgents() {
        return agents;
    }
}

class CustomerBatchAgent {
    private List<IntelligentAgent> agents = new ArrayList<>();

    public void addAgent(IntelligentAgent agent) {
        agents.add(agent.clone());
    }

    public List<IntelligentAgent> getAgents() {
        return agents;
    }
}

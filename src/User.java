public class User {
    public static void main(String[] args) {
        ReferenceBatchAgent referenceBatchAgent = ReferenceBatchAgent.getInstance();

        CustomerBatchAgent customerBatchAgent = new CustomerBatchAgent();
        for (IntelligentAgent agent : referenceBatchAgent.getAgents()) {
            customerBatchAgent.addAgent(agent);
        }

        for (IntelligentAgent agent : customerBatchAgent.getAgents()) {
            agent.processRequest();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // create new blockchain object
        Blockchain blockchain = new Blockchain();

        // add blocks to the blockchain
        blockchain.addBlock("First block");
        blockchain.addBlock("Second block");
        blockchain.addBlock("Third block");

        // print is blockchain is valid
        System.out.println("Blockchain is valid: " + blockchain.isValid());

        // print the hash of each block
        System.out.println("Blockchain: ");
        for (Block block : blockchain.getBlocks()) {
            System.out.println(block.getHash());
        }
        
        // print number of blocks in the blockchain
        System.out.println("Number of blocks: " + blockchain.getBlocks().size());
    }
}

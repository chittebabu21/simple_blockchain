import java.util.ArrayList;

public class Blockchain {
    // declare arraylist to store blocks
    private ArrayList<Block> blocks;

    // constructor
    public Blockchain() {
        this.blocks = new ArrayList<Block>();
        this.blocks.add(createGenesisBlock());
    }

    // create genesis block
    public Block createGenesisBlock() {
        return new Block(0, System.currentTimeMillis(), "Genesis block", "0");
    }

    // get latest block
    public Block getLatestBlock() {
        return this.blocks.get(this.blocks.size() - 1);
    }

    // add block to blockchain
    public Block addBlock(String data) {
        Block previousblock = getLatestBlock();
        Block block = new Block(previousblock.getIndex() + 1, System.currentTimeMillis(),
                data, previousblock.getHash());

        blocks.add(block);
        return block;
    }

    // check if blockchain is valid
    public boolean isValid() {
        for (int i = 1; i < this.blocks.size(); i++) {
            Block currentBlock = this.blocks.get(i);
            Block previousBlock = this.blocks.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }

        return true;
    }

    // getters
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
}

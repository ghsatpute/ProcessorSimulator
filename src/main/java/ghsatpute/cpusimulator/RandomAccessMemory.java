package ghsatpute.cpusimulator;

public class RandomAccessMemory implements Memory {
    private final int MAX_ADDR;
    private byte[] memory;

    public RandomAccessMemory(int memorySize) {
        MAX_ADDR = memorySize;
        memory = new byte[memorySize];
    }
    @Override
    public byte read(int address) {
        if (address > MAX_ADDR - 1) {
            throw new RuntimeException("Error flag");
            // TODO: See if we can simulate error flags
        }
        return memory[address];
    }

    @Override
    public void write(int address, byte data) {
        if (address > MAX_ADDR - 1) {
            throw new RuntimeException("Error flag");
            // TODO: See if we can simulate error flags
        }

        memory[address] = data;
    }

    @Override
    public void clear() {
        for (byte addr: memory) {
            addr = 0; // TODO: Check if this works
        }
    }
}

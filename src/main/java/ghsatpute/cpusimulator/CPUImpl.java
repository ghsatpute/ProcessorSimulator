package ghsatpute.cpusimulator;

public class CPUImpl implements CPU {
    private byte programCounter;
    private byte currentOperationCode;
    private byte register0;
    private byte register1;

    private final byte maxAddressCeil = 127;

    boolean overflowBit;
    boolean underflowBit;
    boolean signBit;
    boolean haltBit;

    private Memory memory;

    public CPUImpl(Memory memory) {
        this.memory = memory;
        reset();
    }

    @Override
    public void reset() {
        programCounter = 0;
        register0 = 0;
        register1 = 0;

        overflowBit = false;
        underflowBit = false;
        signBit = false;
        haltBit = false;
    }

    @Override
    public void run() {
        System.out.println("Starting the program execution. The " +
                "starting address of program is " + programCounter);
        while(!this.haltBit) {
            currentOperationCode = fetch();
            decode(currentOperationCode);
            programCounter++;
            if (programCounter >= maxAddressCeil) {
                this.haltBit = true;
            }
        }
        System.out.println("Program execution complete. " +
                "\nIs Underflow? " + this.underflowBit +
                "\nIs Overflow? " + this.overflowBit +
                "\nIs sign bit? " + this.signBit);
    }

    private byte fetch() {
        return memory.read(programCounter);
    }

    private void decode(byte instruction) {
        switch (instruction) {
            // HALT
            case 0:
                System.out.println("Halting the CPU");
                this.haltBit = true;
                break;
            // LOAD0
            case 1:
                this.register0 = memory.read(++programCounter);
                break;
            // LOAD1
            case 2:
                this.register1 = memory.read(++programCounter);
                break;
            // ADD
            case 3:
                register0 = (byte) (register0 + register1);
                break;
            // STORE
            case 4:
                // Read the target address
                register1 = memory.read(++programCounter);
                memory.write(register1, register0);
                break;
            // PRINT
            case 5:
                register0 = memory.read(++programCounter);
                System.out.println(memory.read(register0));
                break;
            default:
                System.out.println("Unknown operation code");
        }
    }
}

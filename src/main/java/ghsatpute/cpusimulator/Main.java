package ghsatpute.cpusimulator;

public class Main {
    public static void main(String[] args) {
        byte[] program = createAdditionProgram();

        Memory memory = new RandomAccessMemory(128);

        loadProgramIntoMemory(memory, program);

        CPU cpu = new CPUImpl(memory);

        cpu.run();
    }

    private static void loadProgramIntoMemory(Memory memory, byte[] program) {
        int i = 0;
        for (byte code: program) {
            memory.write(i, code);
            i++;
        }
    }

    private static byte[] createAdditionProgram() {
        byte[] program = new byte[10];

        program[0] = 1;         // LOAD0        <- 1 is opcode
        program[1] = 11;        // 11           <- 11 is data
        program[2] = 2;         // LOAD1
        program[3] = 22;        // 22
        program[4] = 3;         // ADD
        program[5] = 4;         // STORE
        program[6] = 6;         // 6            <- address where result is stored
        program[7] = 5;         // PRINT
        program[8] = 6;         // 6            <- address from where result should be printed
        program[9] = 0;         // HALT

        return program;
    }
}

package ghsatpute.cpusimulator;

public interface Memory {
    byte read(int address);

    void write(int address, byte data);

    void clear();
}

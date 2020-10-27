package cp510.assignments;

/** This class encapsulates a 16-bit register. 
 * It can encode and decode an integer representing the control, 
 * start, count, data, security and origin fields.
 * 
 * @author Chris Bragg
 */
public class ControlReg {
    
    /** Constructor for ControlReg Class.
     * @param reg
     */
    public ControlReg(int reg) {
        decodeReg(reg);
    }
    
    private int controlField;
    private int startField;
    private int countField; 
    private int dataField; 
    private int securityField;
    private int originField;
    private static int controlMask = 0b1111000000000000;
    private static int startMask = 0b0000100000000000;
    private static int countMask = 0b0000011000000000;
    private static int dataMask = 0b0000000111100000;
    private static int securityMask = 0b0000000000011000;
    private static int originMask = 0b0000000000000111;
    
    /** Getter for controlField property.
     * @return integer controlField
     */
    public int getControl() {
        return controlField;
    }
    
    /** Setter for controlField property.
     * @param control
     */
    public void setControl(int control) {
        controlField = control;
    }
    
    /** Getter for startField property.
     * @return integer startField
     */
    public int getStart() {
        return startField;
    }
    
    /** Setter for startField property.
     * @param start
     */
    public void setStart(int start) {
        startField = start;
    }
    
    /** Getter for countField property.
     * @return integer countField
     */
    public int getCount() {
        return countField;
    }
    
    /** Setter for countField property.
     * @param count
     */
    public void setCount(int count) {
        countField = count;
    }
    
    /** Getter for dataField property.
     * @return integer dataField
     */
    public int getData() {
        return dataField;
    }
    
    /** Setter for dataField property.
     * @param data
     */
    public void setData(int data) {
        dataField = data;
    }
    
    /** Getter for securityField property.
     * @return integer securityField
     */
    public int getSecurity() {
        return securityField;
    }
    
    /** Setter for securityField property.
     * @param security
     */
    public void setSecurity(int security) {
        securityField = security;
    }
    
    /** Getter for originField property.
     * @return integer originField
     */
    public int getOrigin() {
        return originField;
    }
    
    /** Setter for originField property.
     * @param origin
     */
    public void setOrigin(int origin) {
        originField = origin;
    }
    
    /** Decodes a given register and uses the decoded values 
     * to set this object's properties.
     * @param reg
     */
    public void decodeReg( int reg ) {
        setControl((reg & controlMask) >>> 12);
        setStart((reg & startMask) >>> 11);
        setCount((reg & countMask) >>> 9);
        setData((reg & dataMask) >>> 5);
        setSecurity((reg & securityMask) >>> 3);
        setOrigin((reg & originMask) >>> 0);
    }

    /** Encodes the encapsulated properties into an integer value.
     * @return integer 
     */
    public int encodeReg() {
        int reg = 0;
        reg = reg | controlField << 12;
        reg = reg | startField << 11;
        reg = reg | countField << 9;
        reg = reg | dataField << 5;
        reg = reg | securityField << 3;
        reg = reg | originField << 0;
        return reg;
    }
    
    /**
     * Formats the values of the encapsulated properties 
     * into a human readable string.
     * @return string
     */
    public String toString() {
        String returnString = 
                "origin=" + getOrigin() + 
                ",security=" + getSecurity() + 
                ",data=" + getData() + 
                ",count=" + getCount() + 
                ",start=" + getStart() + 
                ",control=" + getControl();
                
        return returnString;
    }
}

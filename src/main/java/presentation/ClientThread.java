package presentation;

public class ClientThread extends Thread {

    private static final int COMPLEX_ATTRIBUTE = 0;
    private static final int COMPOSITE_ATTRIBUTE = 2;
    final int SIMPLE_ATTRIBUTE = 1;
    private int width;
    private int d;

    public Attribute createAttribute(final int attributeId) throws UnknownAttributeIdException {
        switch (attributeId) {
            case SIMPLE_ATTRIBUTE:
                return new SimpleAttribute();
            case COMPLEX_ATTRIBUTE:
                return new ComplexAttribute();
                // case COMPOSITE_ATTRIBUTE:
                // return new CompositeAttribute();
            default:
                throw new UnknownAttributeIdException(attributeId);
        }
    }

    /**
     * Sets server port. Default port is 8080
     */
    public void setServerPort(final int port) {
        // Create buffer. Buffer size is header size + additional
        // information like filter and other data
        final byte[] buffer = new byte[150 + width + 3 + d * 15];
    }

}

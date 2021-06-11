package org.java_websocket.exceptions;
/* loaded from: classes8.dex */
public class IncompleteHandshakeException extends RuntimeException {
    public static final long serialVersionUID = 7906596804233893092L;
    public int preferedSize;

    public IncompleteHandshakeException(int i2) {
        this.preferedSize = i2;
    }

    public int getPreferedSize() {
        return this.preferedSize;
    }

    public IncompleteHandshakeException() {
        this.preferedSize = 0;
    }
}

package org.java_websocket.exceptions;
/* loaded from: classes2.dex */
public class IncompleteHandshakeException extends RuntimeException {
    public static final long serialVersionUID = 7906596804233893092L;
    public int preferedSize;

    public IncompleteHandshakeException() {
        this.preferedSize = 0;
    }

    public int getPreferedSize() {
        return this.preferedSize;
    }

    public IncompleteHandshakeException(int i) {
        this.preferedSize = i;
    }
}

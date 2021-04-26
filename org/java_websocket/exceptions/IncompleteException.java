package org.java_websocket.exceptions;
/* loaded from: classes7.dex */
public class IncompleteException extends Throwable {
    public static final long serialVersionUID = 7330519489840500997L;
    public int preferredSize;

    public IncompleteException(int i2) {
        this.preferredSize = i2;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }
}

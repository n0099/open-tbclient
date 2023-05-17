package org.java_websocket.exceptions;
/* loaded from: classes10.dex */
public class IncompleteException extends Throwable {
    public static final long serialVersionUID = 7330519489840500997L;
    public int preferredSize;

    public IncompleteException(int i) {
        this.preferredSize = i;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }
}

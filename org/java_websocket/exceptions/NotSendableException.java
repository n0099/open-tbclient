package org.java_websocket.exceptions;
/* loaded from: classes2.dex */
public class NotSendableException extends RuntimeException {
    public static final long serialVersionUID = -6468967874576651628L;

    public NotSendableException(String str) {
        super(str);
    }

    public NotSendableException(String str, Throwable th) {
        super(str, th);
    }

    public NotSendableException(Throwable th) {
        super(th);
    }
}

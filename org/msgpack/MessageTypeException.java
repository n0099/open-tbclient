package org.msgpack;
/* loaded from: classes.dex */
public class MessageTypeException extends RuntimeException {
    public MessageTypeException() {
    }

    public MessageTypeException(String str) {
        super(str);
    }

    public MessageTypeException(String str, Throwable th) {
        super(str, th);
    }

    public MessageTypeException(Throwable th) {
        super(th);
    }
}

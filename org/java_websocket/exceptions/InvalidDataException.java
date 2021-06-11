package org.java_websocket.exceptions;
/* loaded from: classes8.dex */
public class InvalidDataException extends Exception {
    public static final long serialVersionUID = 3731842424390998726L;
    public int closecode;

    public InvalidDataException(int i2) {
        this.closecode = i2;
    }

    public int getCloseCode() {
        return this.closecode;
    }

    public InvalidDataException(int i2, String str) {
        super(str);
        this.closecode = i2;
    }

    public InvalidDataException(int i2, Throwable th) {
        super(th);
        this.closecode = i2;
    }

    public InvalidDataException(int i2, String str, Throwable th) {
        super(str, th);
        this.closecode = i2;
    }
}

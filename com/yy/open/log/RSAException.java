package com.yy.open.log;
/* loaded from: classes2.dex */
public class RSAException extends Exception {
    public static final long serialVersionUID = -5880250001612327539L;

    public RSAException() {
    }

    public RSAException(Exception exc) {
        super(exc.getMessage(), exc.getCause());
    }

    public RSAException(String str) {
        super(str);
    }

    public RSAException(String str, Throwable th) {
        super(str, th);
    }

    public RSAException(Throwable th) {
        super(th);
    }
}

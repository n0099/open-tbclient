package org.aspectj.lang;
/* loaded from: classes2.dex */
public class NoAspectBoundException extends RuntimeException {
    Throwable cause;

    public NoAspectBoundException(String str, Throwable th) {
        super(th != null ? new StringBuffer().append("Exception while initializing ").append(str).append(": ").append(th).toString() : str);
        this.cause = th;
    }

    public NoAspectBoundException() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}

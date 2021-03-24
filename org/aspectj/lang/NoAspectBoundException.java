package org.aspectj.lang;
/* loaded from: classes7.dex */
public class NoAspectBoundException extends RuntimeException {
    public Throwable cause;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NoAspectBoundException(String str, Throwable th) {
        super(str);
        if (th != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception while initializing ");
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(th);
            str = stringBuffer.toString();
        }
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public NoAspectBoundException() {
    }
}

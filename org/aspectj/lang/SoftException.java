package org.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes2.dex */
public class SoftException extends RuntimeException {
    private static final boolean hnD;
    Throwable inner;

    static {
        boolean z = false;
        try {
            Class.forName("java.nio.Buffer");
            z = true;
        } catch (Throwable th) {
        }
        hnD = z;
    }

    public SoftException(Throwable th) {
        this.inner = th;
    }

    public Throwable getWrappedThrowable() {
        return this.inner;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.inner;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th = this.inner;
        if (!hnD && th != null) {
            printStream.print("Caused by: ");
            th.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th = this.inner;
        if (!hnD && th != null) {
            printWriter.print("Caused by: ");
            th.printStackTrace(printWriter);
        }
    }
}

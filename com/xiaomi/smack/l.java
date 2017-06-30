package com.xiaomi.smack;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes2.dex */
public class l extends Exception {
    private com.xiaomi.smack.packet.g a;
    private com.xiaomi.smack.packet.h b;
    private Throwable c;

    public l() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public l(com.xiaomi.smack.packet.g gVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = gVar;
    }

    public l(String str) {
        super(str);
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public l(String str, Throwable th) {
        super(str);
        this.a = null;
        this.b = null;
        this.c = null;
        this.c = th;
    }

    public l(Throwable th) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.c = th;
    }

    public Throwable a() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.b == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.b.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.c != null) {
            printStream.println("Nested Exception: ");
            this.c.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.c != null) {
            printWriter.println("Nested Exception: ");
            this.c.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.b != null) {
            sb.append(this.b);
        }
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.c != null) {
            sb.append("\n  -- caused by: ").append(this.c);
        }
        return sb.toString();
    }
}

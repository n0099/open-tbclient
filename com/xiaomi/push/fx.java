package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public class fx extends Exception {
    private gg a;

    /* renamed from: a  reason: collision with other field name */
    private gh f400a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f401a;

    public fx() {
        this.a = null;
        this.f400a = null;
        this.f401a = null;
    }

    public fx(gg ggVar) {
        this.a = null;
        this.f400a = null;
        this.f401a = null;
        this.a = ggVar;
    }

    public fx(String str) {
        super(str);
        this.a = null;
        this.f400a = null;
        this.f401a = null;
    }

    public fx(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f400a = null;
        this.f401a = null;
        this.f401a = th;
    }

    public fx(Throwable th) {
        this.a = null;
        this.f400a = null;
        this.f401a = null;
        this.f401a = th;
    }

    public Throwable a() {
        return this.f401a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f400a == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.f400a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f401a != null) {
            printStream.println("Nested Exception: ");
            this.f401a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f401a != null) {
            printWriter.println("Nested Exception: ");
            this.f401a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f400a != null) {
            sb.append(this.f400a);
        }
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.f401a != null) {
            sb.append("\n  -- caused by: ").append(this.f401a);
        }
        return sb.toString();
    }
}

package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes8.dex */
public class fx extends Exception {
    private gg a;

    /* renamed from: a  reason: collision with other field name */
    private gh f397a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f398a;

    public fx() {
        this.a = null;
        this.f397a = null;
        this.f398a = null;
    }

    public fx(gg ggVar) {
        this.a = null;
        this.f397a = null;
        this.f398a = null;
        this.a = ggVar;
    }

    public fx(String str) {
        super(str);
        this.a = null;
        this.f397a = null;
        this.f398a = null;
    }

    public fx(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f397a = null;
        this.f398a = null;
        this.f398a = th;
    }

    public fx(Throwable th) {
        this.a = null;
        this.f397a = null;
        this.f398a = null;
        this.f398a = th;
    }

    public Throwable a() {
        return this.f398a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f397a == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.f397a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f398a != null) {
            printStream.println("Nested Exception: ");
            this.f398a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f398a != null) {
            printWriter.println("Nested Exception: ");
            this.f398a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f397a != null) {
            sb.append(this.f397a);
        }
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.f398a != null) {
            sb.append("\n  -- caused by: ").append(this.f398a);
        }
        return sb.toString();
    }
}

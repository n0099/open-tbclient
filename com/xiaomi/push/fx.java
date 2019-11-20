package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public class fx extends Exception {
    private gg a;

    /* renamed from: a  reason: collision with other field name */
    private gh f396a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f397a;

    public fx() {
        this.a = null;
        this.f396a = null;
        this.f397a = null;
    }

    public fx(gg ggVar) {
        this.a = null;
        this.f396a = null;
        this.f397a = null;
        this.a = ggVar;
    }

    public fx(String str) {
        super(str);
        this.a = null;
        this.f396a = null;
        this.f397a = null;
    }

    public fx(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f396a = null;
        this.f397a = null;
        this.f397a = th;
    }

    public fx(Throwable th) {
        this.a = null;
        this.f396a = null;
        this.f397a = null;
        this.f397a = th;
    }

    public Throwable a() {
        return this.f397a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f396a == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.f396a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f397a != null) {
            printStream.println("Nested Exception: ");
            this.f397a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f397a != null) {
            printWriter.println("Nested Exception: ");
            this.f397a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f396a != null) {
            sb.append(this.f396a);
        }
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.f397a != null) {
            sb.append("\n  -- caused by: ").append(this.f397a);
        }
        return sb.toString();
    }
}

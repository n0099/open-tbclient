package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public class fx extends Exception {
    private gg a;

    /* renamed from: a  reason: collision with other field name */
    private gh f399a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f400a;

    public fx() {
        this.a = null;
        this.f399a = null;
        this.f400a = null;
    }

    public fx(gg ggVar) {
        this.a = null;
        this.f399a = null;
        this.f400a = null;
        this.a = ggVar;
    }

    public fx(String str) {
        super(str);
        this.a = null;
        this.f399a = null;
        this.f400a = null;
    }

    public fx(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f399a = null;
        this.f400a = null;
        this.f400a = th;
    }

    public fx(Throwable th) {
        this.a = null;
        this.f399a = null;
        this.f400a = null;
        this.f400a = th;
    }

    public Throwable a() {
        return this.f400a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f399a == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.f399a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f400a != null) {
            printStream.println("Nested Exception: ");
            this.f400a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f400a != null) {
            printWriter.println("Nested Exception: ");
            this.f400a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f399a != null) {
            sb.append(this.f399a);
        }
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.f400a != null) {
            sb.append("\n  -- caused by: ").append(this.f400a);
        }
        return sb.toString();
    }
}

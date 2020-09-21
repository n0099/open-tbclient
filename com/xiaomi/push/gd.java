package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes9.dex */
public class gd extends Exception {
    private gm a;

    /* renamed from: a  reason: collision with other field name */
    private gn f385a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f386a;

    public gd() {
        this.a = null;
        this.f385a = null;
        this.f386a = null;
    }

    public gd(gm gmVar) {
        this.a = null;
        this.f385a = null;
        this.f386a = null;
        this.a = gmVar;
    }

    public gd(String str) {
        super(str);
        this.a = null;
        this.f385a = null;
        this.f386a = null;
    }

    public gd(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f385a = null;
        this.f386a = null;
        this.f386a = th;
    }

    public gd(Throwable th) {
        this.a = null;
        this.f385a = null;
        this.f386a = null;
        this.f386a = th;
    }

    public Throwable a() {
        return this.f386a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f385a == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.f385a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f386a != null) {
            printStream.println("Nested Exception: ");
            this.f386a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f386a != null) {
            printWriter.println("Nested Exception: ");
            this.f386a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f385a != null) {
            sb.append(this.f385a);
        }
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.f386a != null) {
            sb.append("\n  -- caused by: ").append(this.f386a);
        }
        return sb.toString();
    }
}

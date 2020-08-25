package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes7.dex */
public class gd extends Exception {
    private gm a;

    /* renamed from: a  reason: collision with other field name */
    private gn f387a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f388a;

    public gd() {
        this.a = null;
        this.f387a = null;
        this.f388a = null;
    }

    public gd(gm gmVar) {
        this.a = null;
        this.f387a = null;
        this.f388a = null;
        this.a = gmVar;
    }

    public gd(String str) {
        super(str);
        this.a = null;
        this.f387a = null;
        this.f388a = null;
    }

    public gd(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f387a = null;
        this.f388a = null;
        this.f388a = th;
    }

    public gd(Throwable th) {
        this.a = null;
        this.f387a = null;
        this.f388a = null;
        this.f388a = th;
    }

    public Throwable a() {
        return this.f388a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f387a == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.f387a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f388a != null) {
            printStream.println("Nested Exception: ");
            this.f388a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f388a != null) {
            printWriter.println("Nested Exception: ");
            this.f388a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f387a != null) {
            sb.append(this.f387a);
        }
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.f388a != null) {
            sb.append("\n  -- caused by: ").append(this.f388a);
        }
        return sb.toString();
    }
}

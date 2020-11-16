package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes18.dex */
public class gd extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private gm f4920a;

    /* renamed from: a  reason: collision with other field name */
    private gn f388a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f389a;

    public gd() {
        this.f4920a = null;
        this.f388a = null;
        this.f389a = null;
    }

    public gd(gm gmVar) {
        this.f4920a = null;
        this.f388a = null;
        this.f389a = null;
        this.f4920a = gmVar;
    }

    public gd(String str) {
        super(str);
        this.f4920a = null;
        this.f388a = null;
        this.f389a = null;
    }

    public gd(String str, Throwable th) {
        super(str);
        this.f4920a = null;
        this.f388a = null;
        this.f389a = null;
        this.f389a = th;
    }

    public gd(Throwable th) {
        this.f4920a = null;
        this.f388a = null;
        this.f389a = null;
        this.f389a = th;
    }

    public Throwable a() {
        return this.f389a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f388a == null) ? (message != null || this.f4920a == null) ? message : this.f4920a.toString() : this.f388a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f389a != null) {
            printStream.println("Nested Exception: ");
            this.f389a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f389a != null) {
            printWriter.println("Nested Exception: ");
            this.f389a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f388a != null) {
            sb.append(this.f388a);
        }
        if (this.f4920a != null) {
            sb.append(this.f4920a);
        }
        if (this.f389a != null) {
            sb.append("\n  -- caused by: ").append(this.f389a);
        }
        return sb.toString();
    }
}

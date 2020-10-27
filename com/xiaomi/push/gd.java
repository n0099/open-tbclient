package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes12.dex */
public class gd extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private gm f4918a;

    /* renamed from: a  reason: collision with other field name */
    private gn f383a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f384a;

    public gd() {
        this.f4918a = null;
        this.f383a = null;
        this.f384a = null;
    }

    public gd(gm gmVar) {
        this.f4918a = null;
        this.f383a = null;
        this.f384a = null;
        this.f4918a = gmVar;
    }

    public gd(String str) {
        super(str);
        this.f4918a = null;
        this.f383a = null;
        this.f384a = null;
    }

    public gd(String str, Throwable th) {
        super(str);
        this.f4918a = null;
        this.f383a = null;
        this.f384a = null;
        this.f384a = th;
    }

    public gd(Throwable th) {
        this.f4918a = null;
        this.f383a = null;
        this.f384a = null;
        this.f384a = th;
    }

    public Throwable a() {
        return this.f384a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f383a == null) ? (message != null || this.f4918a == null) ? message : this.f4918a.toString() : this.f383a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f384a != null) {
            printStream.println("Nested Exception: ");
            this.f384a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f384a != null) {
            printWriter.println("Nested Exception: ");
            this.f384a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f383a != null) {
            sb.append(this.f383a);
        }
        if (this.f4918a != null) {
            sb.append(this.f4918a);
        }
        if (this.f384a != null) {
            sb.append("\n  -- caused by: ").append(this.f384a);
        }
        return sb.toString();
    }
}

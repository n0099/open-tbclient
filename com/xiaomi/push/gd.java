package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes18.dex */
public class gd extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private gm f4690a;

    /* renamed from: a  reason: collision with other field name */
    private gn f386a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f387a;

    public gd() {
        this.f4690a = null;
        this.f386a = null;
        this.f387a = null;
    }

    public gd(gm gmVar) {
        this.f4690a = null;
        this.f386a = null;
        this.f387a = null;
        this.f4690a = gmVar;
    }

    public gd(String str) {
        super(str);
        this.f4690a = null;
        this.f386a = null;
        this.f387a = null;
    }

    public gd(String str, Throwable th) {
        super(str);
        this.f4690a = null;
        this.f386a = null;
        this.f387a = null;
        this.f387a = th;
    }

    public gd(Throwable th) {
        this.f4690a = null;
        this.f386a = null;
        this.f387a = null;
        this.f387a = th;
    }

    public Throwable a() {
        return this.f387a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f386a == null) ? (message != null || this.f4690a == null) ? message : this.f4690a.toString() : this.f386a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f387a != null) {
            printStream.println("Nested Exception: ");
            this.f387a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f387a != null) {
            printWriter.println("Nested Exception: ");
            this.f387a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f386a != null) {
            sb.append(this.f386a);
        }
        if (this.f4690a != null) {
            sb.append(this.f4690a);
        }
        if (this.f387a != null) {
            sb.append("\n  -- caused by: ").append(this.f387a);
        }
        return sb.toString();
    }
}

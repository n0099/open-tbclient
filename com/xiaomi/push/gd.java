package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public class gd extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private gm f14044a;

    /* renamed from: a  reason: collision with other field name */
    private gn f464a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f465a;

    public gd() {
        this.f14044a = null;
        this.f464a = null;
        this.f465a = null;
    }

    public gd(gm gmVar) {
        this.f14044a = null;
        this.f464a = null;
        this.f465a = null;
        this.f14044a = gmVar;
    }

    public gd(String str) {
        super(str);
        this.f14044a = null;
        this.f464a = null;
        this.f465a = null;
    }

    public gd(String str, Throwable th) {
        super(str);
        this.f14044a = null;
        this.f464a = null;
        this.f465a = null;
        this.f465a = th;
    }

    public gd(Throwable th) {
        this.f14044a = null;
        this.f464a = null;
        this.f465a = null;
        this.f465a = th;
    }

    public Throwable a() {
        return this.f465a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f464a == null) ? (message != null || this.f14044a == null) ? message : this.f14044a.toString() : this.f464a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f465a != null) {
            printStream.println("Nested Exception: ");
            this.f465a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f465a != null) {
            printWriter.println("Nested Exception: ");
            this.f465a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f464a != null) {
            sb.append(this.f464a);
        }
        if (this.f14044a != null) {
            sb.append(this.f14044a);
        }
        if (this.f465a != null) {
            sb.append("\n  -- caused by: ").append(this.f465a);
        }
        return sb.toString();
    }
}

package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes10.dex */
public class gg extends Exception {
    public gp a;

    /* renamed from: a  reason: collision with other field name */
    public gq f434a;

    /* renamed from: a  reason: collision with other field name */
    public Throwable f435a;

    public gg() {
        this.a = null;
        this.f434a = null;
        this.f435a = null;
    }

    public gg(gp gpVar) {
        this.a = null;
        this.f434a = null;
        this.f435a = null;
        this.a = gpVar;
    }

    public gg(String str) {
        super(str);
        this.a = null;
        this.f434a = null;
        this.f435a = null;
    }

    public gg(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f434a = null;
        this.f435a = null;
        this.f435a = th;
    }

    public gg(Throwable th) {
        this.a = null;
        this.f434a = null;
        this.f435a = null;
        this.f435a = th;
    }

    public Throwable a() {
        return this.f435a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        gp gpVar;
        gq gqVar;
        String message = super.getMessage();
        return (message != null || (gqVar = this.f434a) == null) ? (message != null || (gpVar = this.a) == null) ? message : gpVar.toString() : gqVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f435a != null) {
            printStream.println("Nested Exception: ");
            this.f435a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f435a != null) {
            printWriter.println("Nested Exception: ");
            this.f435a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        gq gqVar = this.f434a;
        if (gqVar != null) {
            sb.append(gqVar);
        }
        gp gpVar = this.a;
        if (gpVar != null) {
            sb.append(gpVar);
        }
        if (this.f435a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f435a);
        }
        return sb.toString();
    }
}

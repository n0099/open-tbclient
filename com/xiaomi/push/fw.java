package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes7.dex */
public class fw extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public gf f41397a;

    /* renamed from: a  reason: collision with other field name */
    public gg f413a;

    /* renamed from: a  reason: collision with other field name */
    public Throwable f414a;

    public fw() {
        this.f41397a = null;
        this.f413a = null;
        this.f414a = null;
    }

    public fw(gf gfVar) {
        this.f41397a = null;
        this.f413a = null;
        this.f414a = null;
        this.f41397a = gfVar;
    }

    public fw(String str) {
        super(str);
        this.f41397a = null;
        this.f413a = null;
        this.f414a = null;
    }

    public fw(String str, Throwable th) {
        super(str);
        this.f41397a = null;
        this.f413a = null;
        this.f414a = null;
        this.f414a = th;
    }

    public fw(Throwable th) {
        this.f41397a = null;
        this.f413a = null;
        this.f414a = null;
        this.f414a = th;
    }

    public Throwable a() {
        return this.f414a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        gf gfVar;
        gg ggVar;
        String message = super.getMessage();
        return (message != null || (ggVar = this.f413a) == null) ? (message != null || (gfVar = this.f41397a) == null) ? message : gfVar.toString() : ggVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f414a != null) {
            printStream.println("Nested Exception: ");
            this.f414a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f414a != null) {
            printWriter.println("Nested Exception: ");
            this.f414a.printStackTrace(printWriter);
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
        gg ggVar = this.f413a;
        if (ggVar != null) {
            sb.append(ggVar);
        }
        gf gfVar = this.f41397a;
        if (gfVar != null) {
            sb.append(gfVar);
        }
        if (this.f414a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f414a);
        }
        return sb.toString();
    }
}

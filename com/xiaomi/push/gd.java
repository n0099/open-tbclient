package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public class gd extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private gm f14342a;

    /* renamed from: a  reason: collision with other field name */
    private gn f465a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f466a;

    public gd() {
        this.f14342a = null;
        this.f465a = null;
        this.f466a = null;
    }

    public gd(gm gmVar) {
        this.f14342a = null;
        this.f465a = null;
        this.f466a = null;
        this.f14342a = gmVar;
    }

    public gd(String str) {
        super(str);
        this.f14342a = null;
        this.f465a = null;
        this.f466a = null;
    }

    public gd(String str, Throwable th) {
        super(str);
        this.f14342a = null;
        this.f465a = null;
        this.f466a = null;
        this.f466a = th;
    }

    public gd(Throwable th) {
        this.f14342a = null;
        this.f465a = null;
        this.f466a = null;
        this.f466a = th;
    }

    public Throwable a() {
        return this.f466a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f465a == null) ? (message != null || this.f14342a == null) ? message : this.f14342a.toString() : this.f465a.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f466a != null) {
            printStream.println("Nested Exception: ");
            this.f466a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f466a != null) {
            printWriter.println("Nested Exception: ");
            this.f466a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        if (this.f465a != null) {
            sb.append(this.f465a);
        }
        if (this.f14342a != null) {
            sb.append(this.f14342a);
        }
        if (this.f466a != null) {
            sb.append("\n  -- caused by: ").append(this.f466a);
        }
        return sb.toString();
    }
}

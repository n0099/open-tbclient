package com.ss.android.socialbase.appdownloader.f.a;

import d.o.a.e.a.h.a;
import java.io.PrintStream;
/* loaded from: classes6.dex */
public class h extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public Throwable f36664a;

    /* renamed from: b  reason: collision with root package name */
    public int f36665b;

    /* renamed from: c  reason: collision with root package name */
    public int f36666c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(String str, a.g gVar, Throwable th) {
        super(r0.toString());
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (gVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + gVar.d() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        this.f36665b = -1;
        this.f36666c = -1;
        if (gVar != null) {
            this.f36665b = gVar.c();
            this.f36666c = gVar.f();
        }
        this.f36664a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f36664a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.f36664a.printStackTrace();
        }
    }
}

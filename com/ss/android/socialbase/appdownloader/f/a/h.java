package com.ss.android.socialbase.appdownloader.f.a;

import d.p.a.e.a.h.a;
import java.io.PrintStream;
/* loaded from: classes6.dex */
public class h extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public Throwable f39078a;

    /* renamed from: b  reason: collision with root package name */
    public int f39079b;

    /* renamed from: c  reason: collision with root package name */
    public int f39080c;

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
        this.f39079b = -1;
        this.f39080c = -1;
        if (gVar != null) {
            this.f39079b = gVar.c();
            this.f39080c = gVar.f();
        }
        this.f39078a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f39078a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.f39078a.printStackTrace();
        }
    }
}

package com.ss.android.socialbase.appdownloader.f.a;

import d.o.a.e.a.h.a;
import java.io.PrintStream;
/* loaded from: classes7.dex */
public class h extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public Throwable f35838a;

    /* renamed from: b  reason: collision with root package name */
    public int f35839b;

    /* renamed from: c  reason: collision with root package name */
    public int f35840c;

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
        this.f35839b = -1;
        this.f35840c = -1;
        if (gVar != null) {
            this.f35839b = gVar.c();
            this.f35840c = gVar.f();
        }
        this.f35838a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f35838a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.f35838a.printStackTrace();
        }
    }
}

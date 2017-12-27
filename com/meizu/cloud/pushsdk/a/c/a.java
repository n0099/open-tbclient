package com.meizu.cloud.pushsdk.a.c;

import com.meizu.cloud.pushsdk.a.d.k;
/* loaded from: classes2.dex */
public class a extends Exception {
    private String a;
    private int b;
    private String c;
    private k d;

    public a() {
        this.b = 0;
    }

    public a(k kVar) {
        this.b = 0;
        this.d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.b = 0;
    }

    public k a() {
        return this.d;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public void a(int i) {
        this.b = i;
    }

    public int c() {
        return this.b;
    }

    public void d() {
        this.c = "requestCancelledError";
    }

    public String e() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }
}

package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes16.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f4089a;
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

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public int b() {
        return this.b;
    }

    public void b(String str) {
        this.f4089a = str;
    }

    public String c() {
        return this.f4089a;
    }
}

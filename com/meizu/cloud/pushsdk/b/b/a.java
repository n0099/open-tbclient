package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes2.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f67267a;

    /* renamed from: b  reason: collision with root package name */
    public int f67268b;

    /* renamed from: c  reason: collision with root package name */
    public String f67269c;

    /* renamed from: d  reason: collision with root package name */
    public k f67270d;

    public a() {
        this.f67268b = 0;
    }

    public a(k kVar) {
        this.f67268b = 0;
        this.f67270d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f67268b = 0;
    }

    public k a() {
        return this.f67270d;
    }

    public void a(int i2) {
        this.f67268b = i2;
    }

    public void a(String str) {
        this.f67269c = str;
    }

    public int b() {
        return this.f67268b;
    }

    public void b(String str) {
        this.f67267a = str;
    }

    public String c() {
        return this.f67267a;
    }
}

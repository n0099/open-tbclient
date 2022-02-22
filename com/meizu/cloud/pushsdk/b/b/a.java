package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes4.dex */
public class a extends Exception {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f58732b;

    /* renamed from: c  reason: collision with root package name */
    public String f58733c;

    /* renamed from: d  reason: collision with root package name */
    public k f58734d;

    public a() {
        this.f58732b = 0;
    }

    public a(k kVar) {
        this.f58732b = 0;
        this.f58734d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f58732b = 0;
    }

    public k a() {
        return this.f58734d;
    }

    public void a(int i2) {
        this.f58732b = i2;
    }

    public void a(String str) {
        this.f58733c = str;
    }

    public int b() {
        return this.f58732b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}

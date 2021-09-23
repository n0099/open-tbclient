package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes10.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f74866a;

    /* renamed from: b  reason: collision with root package name */
    public int f74867b;

    /* renamed from: c  reason: collision with root package name */
    public String f74868c;

    /* renamed from: d  reason: collision with root package name */
    public k f74869d;

    public a() {
        this.f74867b = 0;
    }

    public a(k kVar) {
        this.f74867b = 0;
        this.f74869d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f74867b = 0;
    }

    public k a() {
        return this.f74869d;
    }

    public void a(int i2) {
        this.f74867b = i2;
    }

    public void a(String str) {
        this.f74868c = str;
    }

    public int b() {
        return this.f74867b;
    }

    public void b(String str) {
        this.f74866a = str;
    }

    public String c() {
        return this.f74866a;
    }
}

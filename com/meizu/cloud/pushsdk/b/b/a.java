package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes10.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f74901a;

    /* renamed from: b  reason: collision with root package name */
    public int f74902b;

    /* renamed from: c  reason: collision with root package name */
    public String f74903c;

    /* renamed from: d  reason: collision with root package name */
    public k f74904d;

    public a() {
        this.f74902b = 0;
    }

    public a(k kVar) {
        this.f74902b = 0;
        this.f74904d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f74902b = 0;
    }

    public k a() {
        return this.f74904d;
    }

    public void a(int i2) {
        this.f74902b = i2;
    }

    public void a(String str) {
        this.f74903c = str;
    }

    public int b() {
        return this.f74902b;
    }

    public void b(String str) {
        this.f74901a = str;
    }

    public String c() {
        return this.f74901a;
    }
}

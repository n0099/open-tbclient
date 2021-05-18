package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f34655a;

    /* renamed from: b  reason: collision with root package name */
    public int f34656b;

    /* renamed from: c  reason: collision with root package name */
    public String f34657c;

    /* renamed from: d  reason: collision with root package name */
    public k f34658d;

    public a() {
        this.f34656b = 0;
    }

    public a(k kVar) {
        this.f34656b = 0;
        this.f34658d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f34656b = 0;
    }

    public k a() {
        return this.f34658d;
    }

    public void a(int i2) {
        this.f34656b = i2;
    }

    public void a(String str) {
        this.f34657c = str;
    }

    public int b() {
        return this.f34656b;
    }

    public void b(String str) {
        this.f34655a = str;
    }

    public String c() {
        return this.f34655a;
    }
}

package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes2.dex */
public class a extends Exception {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f60245b;

    /* renamed from: c  reason: collision with root package name */
    public String f60246c;

    /* renamed from: d  reason: collision with root package name */
    public k f60247d;

    public a() {
        this.f60245b = 0;
    }

    public a(k kVar) {
        this.f60245b = 0;
        this.f60247d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f60245b = 0;
    }

    public k a() {
        return this.f60247d;
    }

    public void a(int i2) {
        this.f60245b = i2;
    }

    public void a(String str) {
        this.f60246c = str;
    }

    public int b() {
        return this.f60245b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}

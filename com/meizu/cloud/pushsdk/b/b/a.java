package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes2.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f67266a;

    /* renamed from: b  reason: collision with root package name */
    public int f67267b;

    /* renamed from: c  reason: collision with root package name */
    public String f67268c;

    /* renamed from: d  reason: collision with root package name */
    public k f67269d;

    public a() {
        this.f67267b = 0;
    }

    public a(k kVar) {
        this.f67267b = 0;
        this.f67269d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f67267b = 0;
    }

    public k a() {
        return this.f67269d;
    }

    public void a(int i2) {
        this.f67267b = i2;
    }

    public void a(String str) {
        this.f67268c = str;
    }

    public int b() {
        return this.f67267b;
    }

    public void b(String str) {
        this.f67266a = str;
    }

    public String c() {
        return this.f67266a;
    }
}

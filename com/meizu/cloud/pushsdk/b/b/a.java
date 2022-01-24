package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes3.dex */
public class a extends Exception {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f58565b;

    /* renamed from: c  reason: collision with root package name */
    public String f58566c;

    /* renamed from: d  reason: collision with root package name */
    public k f58567d;

    public a() {
        this.f58565b = 0;
    }

    public a(k kVar) {
        this.f58565b = 0;
        this.f58567d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f58565b = 0;
    }

    public k a() {
        return this.f58567d;
    }

    public void a(int i2) {
        this.f58565b = i2;
    }

    public void a(String str) {
        this.f58566c = str;
    }

    public int b() {
        return this.f58565b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}

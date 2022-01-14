package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes3.dex */
public class a extends Exception {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f58520b;

    /* renamed from: c  reason: collision with root package name */
    public String f58521c;

    /* renamed from: d  reason: collision with root package name */
    public k f58522d;

    public a() {
        this.f58520b = 0;
    }

    public a(k kVar) {
        this.f58520b = 0;
        this.f58522d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f58520b = 0;
    }

    public k a() {
        return this.f58522d;
    }

    public void a(int i2) {
        this.f58520b = i2;
    }

    public void a(String str) {
        this.f58521c = str;
    }

    public int b() {
        return this.f58520b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}

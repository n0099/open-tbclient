package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes8.dex */
public class a extends Exception {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f57082b;

    /* renamed from: c  reason: collision with root package name */
    public String f57083c;

    /* renamed from: d  reason: collision with root package name */
    public k f57084d;

    public a() {
        this.f57082b = 0;
    }

    public a(k kVar) {
        this.f57082b = 0;
        this.f57084d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f57082b = 0;
    }

    public k a() {
        return this.f57084d;
    }

    public void a(int i2) {
        this.f57082b = i2;
    }

    public void a(String str) {
        this.f57083c = str;
    }

    public int b() {
        return this.f57082b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}

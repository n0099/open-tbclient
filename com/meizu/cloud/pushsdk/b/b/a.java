package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes3.dex */
public class a extends Exception {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f60826b;

    /* renamed from: c  reason: collision with root package name */
    public String f60827c;

    /* renamed from: d  reason: collision with root package name */
    public k f60828d;

    public a() {
        this.f60826b = 0;
    }

    public a(k kVar) {
        this.f60826b = 0;
        this.f60828d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f60826b = 0;
    }

    public k a() {
        return this.f60828d;
    }

    public void a(int i2) {
        this.f60826b = i2;
    }

    public void a(String str) {
        this.f60827c = str;
    }

    public int b() {
        return this.f60826b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}

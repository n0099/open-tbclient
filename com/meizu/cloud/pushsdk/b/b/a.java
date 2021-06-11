package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f38263a;

    /* renamed from: b  reason: collision with root package name */
    public int f38264b;

    /* renamed from: c  reason: collision with root package name */
    public String f38265c;

    /* renamed from: d  reason: collision with root package name */
    public k f38266d;

    public a() {
        this.f38264b = 0;
    }

    public a(k kVar) {
        this.f38264b = 0;
        this.f38266d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f38264b = 0;
    }

    public k a() {
        return this.f38266d;
    }

    public void a(int i2) {
        this.f38264b = i2;
    }

    public void a(String str) {
        this.f38265c = str;
    }

    public int b() {
        return this.f38264b;
    }

    public void b(String str) {
        this.f38263a = str;
    }

    public String c() {
        return this.f38263a;
    }
}

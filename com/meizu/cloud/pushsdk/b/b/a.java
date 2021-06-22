package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f38361a;

    /* renamed from: b  reason: collision with root package name */
    public int f38362b;

    /* renamed from: c  reason: collision with root package name */
    public String f38363c;

    /* renamed from: d  reason: collision with root package name */
    public k f38364d;

    public a() {
        this.f38362b = 0;
    }

    public a(k kVar) {
        this.f38362b = 0;
        this.f38364d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f38362b = 0;
    }

    public k a() {
        return this.f38364d;
    }

    public void a(int i2) {
        this.f38362b = i2;
    }

    public void a(String str) {
        this.f38363c = str;
    }

    public int b() {
        return this.f38362b;
    }

    public void b(String str) {
        this.f38361a = str;
    }

    public String c() {
        return this.f38361a;
    }
}

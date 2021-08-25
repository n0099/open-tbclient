package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes10.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f74367a;

    /* renamed from: b  reason: collision with root package name */
    public int f74368b;

    /* renamed from: c  reason: collision with root package name */
    public String f74369c;

    /* renamed from: d  reason: collision with root package name */
    public k f74370d;

    public a() {
        this.f74368b = 0;
    }

    public a(k kVar) {
        this.f74368b = 0;
        this.f74370d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f74368b = 0;
    }

    public k a() {
        return this.f74370d;
    }

    public void a(int i2) {
        this.f74368b = i2;
    }

    public void a(String str) {
        this.f74369c = str;
    }

    public int b() {
        return this.f74368b;
    }

    public void b(String str) {
        this.f74367a = str;
    }

    public String c() {
        return this.f74367a;
    }
}

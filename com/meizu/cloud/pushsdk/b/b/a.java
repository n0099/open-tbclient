package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes10.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f74167a;

    /* renamed from: b  reason: collision with root package name */
    public int f74168b;

    /* renamed from: c  reason: collision with root package name */
    public String f74169c;

    /* renamed from: d  reason: collision with root package name */
    public k f74170d;

    public a() {
        this.f74168b = 0;
    }

    public a(k kVar) {
        this.f74168b = 0;
        this.f74170d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f74168b = 0;
    }

    public k a() {
        return this.f74170d;
    }

    public void a(int i2) {
        this.f74168b = i2;
    }

    public void a(String str) {
        this.f74169c = str;
    }

    public int b() {
        return this.f74168b;
    }

    public void b(String str) {
        this.f74167a = str;
    }

    public String c() {
        return this.f74167a;
    }
}

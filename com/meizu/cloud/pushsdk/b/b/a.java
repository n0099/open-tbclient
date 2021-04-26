package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f35410a;

    /* renamed from: b  reason: collision with root package name */
    public int f35411b;

    /* renamed from: c  reason: collision with root package name */
    public String f35412c;

    /* renamed from: d  reason: collision with root package name */
    public k f35413d;

    public a() {
        this.f35411b = 0;
    }

    public a(k kVar) {
        this.f35411b = 0;
        this.f35413d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f35411b = 0;
    }

    public k a() {
        return this.f35413d;
    }

    public void a(int i2) {
        this.f35411b = i2;
    }

    public void a(String str) {
        this.f35412c = str;
    }

    public int b() {
        return this.f35411b;
    }

    public void b(String str) {
        this.f35410a = str;
    }

    public String c() {
        return this.f35410a;
    }
}

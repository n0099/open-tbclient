package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f34584a;

    /* renamed from: b  reason: collision with root package name */
    public int f34585b;

    /* renamed from: c  reason: collision with root package name */
    public String f34586c;

    /* renamed from: d  reason: collision with root package name */
    public k f34587d;

    public a() {
        this.f34585b = 0;
    }

    public a(k kVar) {
        this.f34585b = 0;
        this.f34587d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f34585b = 0;
    }

    public k a() {
        return this.f34587d;
    }

    public void a(int i2) {
        this.f34585b = i2;
    }

    public void a(String str) {
        this.f34586c = str;
    }

    public int b() {
        return this.f34585b;
    }

    public void b(String str) {
        this.f34584a = str;
    }

    public String c() {
        return this.f34584a;
    }
}

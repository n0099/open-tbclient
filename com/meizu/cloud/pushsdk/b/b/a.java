package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public class a extends Exception {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f41925b;

    /* renamed from: c  reason: collision with root package name */
    public String f41926c;

    /* renamed from: d  reason: collision with root package name */
    public k f41927d;

    public a() {
        this.f41925b = 0;
    }

    public a(k kVar) {
        this.f41925b = 0;
        this.f41927d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f41925b = 0;
    }

    public k a() {
        return this.f41927d;
    }

    public void a(int i) {
        this.f41925b = i;
    }

    public void a(String str) {
        this.f41926c = str;
    }

    public int b() {
        return this.f41925b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}

package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f37861a;

    /* renamed from: b  reason: collision with root package name */
    public int f37862b;

    /* renamed from: c  reason: collision with root package name */
    public String f37863c;

    /* renamed from: d  reason: collision with root package name */
    public k f37864d;

    public a() {
        this.f37862b = 0;
    }

    public a(k kVar) {
        this.f37862b = 0;
        this.f37864d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f37862b = 0;
    }

    public k a() {
        return this.f37864d;
    }

    public void a(int i) {
        this.f37862b = i;
    }

    public void a(String str) {
        this.f37863c = str;
    }

    public int b() {
        return this.f37862b;
    }

    public void b(String str) {
        this.f37861a = str;
    }

    public String c() {
        return this.f37861a;
    }
}

package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes10.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f74547a;

    /* renamed from: b  reason: collision with root package name */
    public int f74548b;

    /* renamed from: c  reason: collision with root package name */
    public String f74549c;

    /* renamed from: d  reason: collision with root package name */
    public k f74550d;

    public a() {
        this.f74548b = 0;
    }

    public a(k kVar) {
        this.f74548b = 0;
        this.f74550d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f74548b = 0;
    }

    public k a() {
        return this.f74550d;
    }

    public void a(int i2) {
        this.f74548b = i2;
    }

    public void a(String str) {
        this.f74549c = str;
    }

    public int b() {
        return this.f74548b;
    }

    public void b(String str) {
        this.f74547a = str;
    }

    public String c() {
        return this.f74547a;
    }
}

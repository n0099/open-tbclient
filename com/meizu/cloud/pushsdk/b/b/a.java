package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes2.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f68179a;

    /* renamed from: b  reason: collision with root package name */
    public int f68180b;

    /* renamed from: c  reason: collision with root package name */
    public String f68181c;

    /* renamed from: d  reason: collision with root package name */
    public k f68182d;

    public a() {
        this.f68180b = 0;
    }

    public a(k kVar) {
        this.f68180b = 0;
        this.f68182d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f68180b = 0;
    }

    public k a() {
        return this.f68182d;
    }

    public void a(int i2) {
        this.f68180b = i2;
    }

    public void a(String str) {
        this.f68181c = str;
    }

    public int b() {
        return this.f68180b;
    }

    public void b(String str) {
        this.f68179a = str;
    }

    public String c() {
        return this.f68179a;
    }
}

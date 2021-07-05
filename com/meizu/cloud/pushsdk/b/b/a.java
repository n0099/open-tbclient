package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f40124a;

    /* renamed from: b  reason: collision with root package name */
    public int f40125b;

    /* renamed from: c  reason: collision with root package name */
    public String f40126c;

    /* renamed from: d  reason: collision with root package name */
    public k f40127d;

    public a() {
        this.f40125b = 0;
    }

    public a(k kVar) {
        this.f40125b = 0;
        this.f40127d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f40125b = 0;
    }

    public k a() {
        return this.f40127d;
    }

    public void a(int i2) {
        this.f40125b = i2;
    }

    public void a(String str) {
        this.f40126c = str;
    }

    public int b() {
        return this.f40125b;
    }

    public void b(String str) {
        this.f40124a = str;
    }

    public String c() {
        return this.f40124a;
    }
}

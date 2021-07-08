package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f37138a;

    /* renamed from: b  reason: collision with root package name */
    public int f37139b;

    /* renamed from: c  reason: collision with root package name */
    public String f37140c;

    /* renamed from: d  reason: collision with root package name */
    public k f37141d;

    public a() {
        this.f37139b = 0;
    }

    public a(k kVar) {
        this.f37139b = 0;
        this.f37141d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f37139b = 0;
    }

    public k a() {
        return this.f37141d;
    }

    public void a(int i2) {
        this.f37139b = i2;
    }

    public void a(String str) {
        this.f37140c = str;
    }

    public int b() {
        return this.f37139b;
    }

    public void b(String str) {
        this.f37138a = str;
    }

    public String c() {
        return this.f37138a;
    }
}

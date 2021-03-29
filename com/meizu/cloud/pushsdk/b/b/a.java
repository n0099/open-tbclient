package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f37477a;

    /* renamed from: b  reason: collision with root package name */
    public int f37478b;

    /* renamed from: c  reason: collision with root package name */
    public String f37479c;

    /* renamed from: d  reason: collision with root package name */
    public k f37480d;

    public a() {
        this.f37478b = 0;
    }

    public a(k kVar) {
        this.f37478b = 0;
        this.f37480d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f37478b = 0;
    }

    public k a() {
        return this.f37480d;
    }

    public void a(int i) {
        this.f37478b = i;
    }

    public void a(String str) {
        this.f37479c = str;
    }

    public int b() {
        return this.f37478b;
    }

    public void b(String str) {
        this.f37477a = str;
    }

    public String c() {
        return this.f37477a;
    }
}

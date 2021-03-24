package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f37476a;

    /* renamed from: b  reason: collision with root package name */
    public int f37477b;

    /* renamed from: c  reason: collision with root package name */
    public String f37478c;

    /* renamed from: d  reason: collision with root package name */
    public k f37479d;

    public a() {
        this.f37477b = 0;
    }

    public a(k kVar) {
        this.f37477b = 0;
        this.f37479d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f37477b = 0;
    }

    public k a() {
        return this.f37479d;
    }

    public void a(int i) {
        this.f37477b = i;
    }

    public void a(String str) {
        this.f37478c = str;
    }

    public int b() {
        return this.f37477b;
    }

    public void b(String str) {
        this.f37476a = str;
    }

    public String c() {
        return this.f37476a;
    }
}

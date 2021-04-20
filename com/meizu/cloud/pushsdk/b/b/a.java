package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f37766a;

    /* renamed from: b  reason: collision with root package name */
    public int f37767b;

    /* renamed from: c  reason: collision with root package name */
    public String f37768c;

    /* renamed from: d  reason: collision with root package name */
    public k f37769d;

    public a() {
        this.f37767b = 0;
    }

    public a(k kVar) {
        this.f37767b = 0;
        this.f37769d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f37767b = 0;
    }

    public k a() {
        return this.f37769d;
    }

    public void a(int i) {
        this.f37767b = i;
    }

    public void a(String str) {
        this.f37768c = str;
    }

    public int b() {
        return this.f37767b;
    }

    public void b(String str) {
        this.f37766a = str;
    }

    public String c() {
        return this.f37766a;
    }
}

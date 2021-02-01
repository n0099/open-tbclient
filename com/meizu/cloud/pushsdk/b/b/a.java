package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes4.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f11144a;

    /* renamed from: b  reason: collision with root package name */
    private int f11145b;
    private String c;
    private k d;

    public a() {
        this.f11145b = 0;
    }

    public a(k kVar) {
        this.f11145b = 0;
        this.d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f11145b = 0;
    }

    public k a() {
        return this.d;
    }

    public void a(int i) {
        this.f11145b = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public int b() {
        return this.f11145b;
    }

    public void b(String str) {
        this.f11144a = str;
    }

    public String c() {
        return this.f11144a;
    }
}

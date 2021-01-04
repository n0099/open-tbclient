package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f11441a;

    /* renamed from: b  reason: collision with root package name */
    private int f11442b;
    private String c;
    private k d;

    public a() {
        this.f11442b = 0;
    }

    public a(k kVar) {
        this.f11442b = 0;
        this.d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f11442b = 0;
    }

    public k a() {
        return this.d;
    }

    public void a(int i) {
        this.f11442b = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public int b() {
        return this.f11442b;
    }

    public void b(String str) {
        this.f11441a = str;
    }

    public String c() {
        return this.f11441a;
    }
}

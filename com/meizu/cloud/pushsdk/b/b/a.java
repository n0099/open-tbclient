package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public String f37327a;

    /* renamed from: b  reason: collision with root package name */
    public int f37328b;

    /* renamed from: c  reason: collision with root package name */
    public String f37329c;

    /* renamed from: d  reason: collision with root package name */
    public k f37330d;

    public a() {
        this.f37328b = 0;
    }

    public a(k kVar) {
        this.f37328b = 0;
        this.f37330d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.f37328b = 0;
    }

    public k a() {
        return this.f37330d;
    }

    public void a(int i2) {
        this.f37328b = i2;
    }

    public void a(String str) {
        this.f37329c = str;
    }

    public int b() {
        return this.f37328b;
    }

    public void b(String str) {
        this.f37327a = str;
    }

    public String c() {
        return this.f37327a;
    }
}

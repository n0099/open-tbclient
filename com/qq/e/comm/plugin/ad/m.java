package com.qq.e.comm.plugin.ad;
/* loaded from: classes15.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private String f11902a;

    /* renamed from: b  reason: collision with root package name */
    private e f11903b;
    private d c;

    public m(String str, e eVar, int i) {
        this.f11902a = str;
        this.f11903b = eVar;
        this.c = c.a(eVar, i);
    }

    public m(String str, e eVar, d dVar) {
        this.f11902a = str;
        this.f11903b = eVar;
        this.c = dVar;
    }

    public String a() {
        return this.f11902a;
    }

    public e b() {
        return this.f11903b;
    }

    public int c() {
        if (this.c == null) {
            return -1;
        }
        return this.c.a();
    }

    public int d() {
        if (this.c == null) {
            return -1;
        }
        return this.c.b();
    }
}

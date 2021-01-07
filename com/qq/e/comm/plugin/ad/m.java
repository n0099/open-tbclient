package com.qq.e.comm.plugin.ad;
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private String f12200a;

    /* renamed from: b  reason: collision with root package name */
    private e f12201b;
    private d c;

    public m(String str, e eVar, int i) {
        this.f12200a = str;
        this.f12201b = eVar;
        this.c = c.a(eVar, i);
    }

    public m(String str, e eVar, d dVar) {
        this.f12200a = str;
        this.f12201b = eVar;
        this.c = dVar;
    }

    public String a() {
        return this.f12200a;
    }

    public e b() {
        return this.f12201b;
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

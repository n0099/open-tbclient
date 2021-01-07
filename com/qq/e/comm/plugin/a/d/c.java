package com.qq.e.comm.plugin.a.d;

import com.qq.e.comm.plugin.util.bf;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final bf<String, a> f11912a = new bf<>();

    public void a(a aVar) {
        this.f11912a.a((bf<String, a>) "*", (String) aVar);
    }

    public void a(String str, int i, int i2, long j) {
        for (a aVar : this.f11912a.a(str)) {
            aVar.a(str, i, i2, j);
        }
        for (a aVar2 : this.f11912a.a("*")) {
            aVar2.a(str, i, i2, j);
        }
    }

    public void a(String str, a aVar) {
        this.f11912a.a((bf<String, a>) str, (String) aVar);
    }

    public void b(a aVar) {
        b("*", aVar);
    }

    public void b(String str, a aVar) {
        this.f11912a.a(str, (String) aVar);
    }
}

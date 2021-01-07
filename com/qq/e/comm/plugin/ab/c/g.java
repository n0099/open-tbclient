package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.e;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, e> f12035a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.h f12036b;

    public g(com.qq.e.comm.plugin.ab.h hVar) {
        this.f12036b = hVar;
    }

    public e a(String str) {
        return this.f12035a.get(str);
    }

    public void a(com.qq.e.comm.plugin.ab.b.d dVar) {
        e a2 = a(dVar.a());
        if (a2 != null) {
            a2.a(this.f12036b, dVar);
        } else {
            this.f12036b.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.HANDLER_NOT_FOUND_EXCEPTION, "handler not found."));
        }
    }

    public void a(String str, e eVar) {
        if (str == null || eVar == null) {
            return;
        }
        this.f12035a.put(str, eVar);
    }
}

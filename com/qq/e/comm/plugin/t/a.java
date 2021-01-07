package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements a.InterfaceC1223a {

    /* renamed from: a  reason: collision with root package name */
    private final int f12823a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.t.a.a> f12824b;
    private final com.qq.e.comm.plugin.t.b.e c;

    public a(int i, List<com.qq.e.comm.plugin.t.a.a> list, com.qq.e.comm.plugin.t.b.e eVar) {
        this.f12823a = i;
        this.f12824b = list;
        this.c = eVar;
    }

    @Override // com.qq.e.comm.plugin.t.a.a.InterfaceC1223a
    public com.qq.e.comm.plugin.t.b.e a() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.t.a.a.InterfaceC1223a
    public com.qq.e.comm.plugin.t.b.f a(com.qq.e.comm.plugin.t.b.e eVar) throws Exception {
        if (this.f12823a >= this.f12824b.size()) {
            return null;
        }
        return this.f12824b.get(this.f12823a).a(new a(this.f12823a + 1, this.f12824b, eVar));
    }
}

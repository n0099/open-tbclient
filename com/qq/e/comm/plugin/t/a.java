package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.a.a;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements a.InterfaceC1206a {

    /* renamed from: a  reason: collision with root package name */
    private final int f12523a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.t.a.a> f12524b;
    private final com.qq.e.comm.plugin.t.b.e c;

    public a(int i, List<com.qq.e.comm.plugin.t.a.a> list, com.qq.e.comm.plugin.t.b.e eVar) {
        this.f12523a = i;
        this.f12524b = list;
        this.c = eVar;
    }

    @Override // com.qq.e.comm.plugin.t.a.a.InterfaceC1206a
    public com.qq.e.comm.plugin.t.b.e a() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.t.a.a.InterfaceC1206a
    public com.qq.e.comm.plugin.t.b.f a(com.qq.e.comm.plugin.t.b.e eVar) throws Exception {
        if (this.f12523a >= this.f12524b.size()) {
            return null;
        }
        return this.f12524b.get(this.f12523a).a(new a(this.f12523a + 1, this.f12524b, eVar));
    }
}

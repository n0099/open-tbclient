package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.a.a;
import java.util.List;
/* loaded from: classes15.dex */
public class a implements a.InterfaceC1210a {

    /* renamed from: a  reason: collision with root package name */
    private final int f12525a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.t.a.a> f12526b;
    private final com.qq.e.comm.plugin.t.b.e c;

    public a(int i, List<com.qq.e.comm.plugin.t.a.a> list, com.qq.e.comm.plugin.t.b.e eVar) {
        this.f12525a = i;
        this.f12526b = list;
        this.c = eVar;
    }

    @Override // com.qq.e.comm.plugin.t.a.a.InterfaceC1210a
    public com.qq.e.comm.plugin.t.b.e a() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.t.a.a.InterfaceC1210a
    public com.qq.e.comm.plugin.t.b.f a(com.qq.e.comm.plugin.t.b.e eVar) throws Exception {
        if (this.f12525a >= this.f12526b.size()) {
            return null;
        }
        return this.f12526b.get(this.f12525a).a(new a(this.f12525a + 1, this.f12526b, eVar));
    }
}

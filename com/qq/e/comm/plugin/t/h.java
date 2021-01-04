package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.w.d;
/* loaded from: classes3.dex */
public class h extends i {

    /* renamed from: a  reason: collision with root package name */
    private d.b f12839a;

    public h(d.b bVar) {
        this.f12839a = bVar;
    }

    @Override // com.qq.e.comm.plugin.t.i
    public void a(int i, Exception exc) {
        if (this.f12839a == null) {
            return;
        }
        this.f12839a.a(i, exc);
    }

    @Override // com.qq.e.comm.plugin.t.b
    public void a(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b.f fVar) {
        if (this.f12839a == null) {
            return;
        }
        int e = fVar == null ? 0 : fVar.e();
        if (e == 200 || e == 204) {
            this.f12839a.a();
        } else {
            this.f12839a.a(e, null);
        }
    }
}

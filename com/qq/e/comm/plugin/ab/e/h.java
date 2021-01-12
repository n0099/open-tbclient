package com.qq.e.comm.plugin.ab.e;

import android.content.Context;
import android.view.View;
/* loaded from: classes3.dex */
class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private final i f11773a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final g f11774b = new g();
    private final com.qq.e.comm.plugin.ab.f.i c;

    public h(Context context) {
        this.c = new com.qq.e.comm.plugin.ab.f.i(context, this.f11773a, this.f11774b, null);
    }

    @Override // com.qq.e.comm.plugin.ab.e.a
    public void a() {
        this.c.goBack();
    }

    @Override // com.qq.e.comm.plugin.ab.e.a
    public void a(f fVar) {
        this.f11773a.a(fVar);
        this.f11774b.a(fVar);
    }

    @Override // com.qq.e.comm.plugin.ab.e.a
    public boolean a(int i) {
        return this.c.canGoBackOrForward(i);
    }

    @Override // com.qq.e.comm.plugin.ab.e.a
    public void b() {
        this.c.destroy();
    }

    @Override // com.qq.e.comm.plugin.ab.k
    public void b(String str) {
        this.c.b(str);
    }

    @Override // com.qq.e.comm.plugin.ab.f.a
    public View c() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.ab.f.a
    public com.qq.e.comm.plugin.ab.f.e d() {
        return this.c.d();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        this.c.loadUrl(str);
    }
}

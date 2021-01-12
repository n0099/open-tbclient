package com.qq.e.comm.plugin.ab.e;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
/* loaded from: classes3.dex */
class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final d f11768a = new d();

    /* renamed from: b  reason: collision with root package name */
    private final b f11769b = new b();
    private final com.qq.e.comm.plugin.ab.f.c c;

    public c(Context context) {
        com.qq.e.comm.plugin.ab.f.c cVar;
        try {
            cVar = new com.qq.e.comm.plugin.ab.f.c(context, this.f11768a, this.f11769b, null);
        } catch (Resources.NotFoundException e) {
            cVar = (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 23) ? new com.qq.e.comm.plugin.ab.f.c(context.getApplicationContext(), this.f11768a, this.f11769b, null) : new com.qq.e.comm.plugin.ab.f.c(context.createConfigurationContext(new Configuration()), this.f11768a, this.f11769b, null);
        }
        this.c = cVar;
    }

    @Override // com.qq.e.comm.plugin.ab.e.a
    public void a() {
        this.c.goBack();
    }

    @Override // com.qq.e.comm.plugin.ab.e.a
    public void a(f fVar) {
        this.f11768a.a(fVar);
        this.f11769b.a(fVar);
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

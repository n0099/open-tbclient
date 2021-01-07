package com.kwai.sodler.lib;

import com.kwai.sodler.lib.a.b;
/* loaded from: classes5.dex */
public class b implements com.kwai.sodler.lib.a.b {

    /* renamed from: a  reason: collision with root package name */
    private b.a f11300a;

    @Override // com.kwai.sodler.lib.a.b
    public com.kwai.sodler.lib.a.b a(b.a aVar) {
        this.f11300a = aVar;
        return this;
    }

    @Override // com.kwai.sodler.lib.a.b
    public void a(com.kwai.sodler.lib.a.f fVar) {
        if (this.f11300a != null) {
            fVar.a(this.f11300a.a(fVar.i()));
        } else {
            a.e("Sodler.PluginConfigUpdater", "config reqester not set");
        }
    }
}

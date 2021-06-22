package com.kwai.sodler.lib;

import com.kwai.sodler.lib.a.b;
/* loaded from: classes7.dex */
public class b implements com.kwai.sodler.lib.a.b {

    /* renamed from: a  reason: collision with root package name */
    public b.a f38004a;

    @Override // com.kwai.sodler.lib.a.b
    public com.kwai.sodler.lib.a.b a(b.a aVar) {
        this.f38004a = aVar;
        return this;
    }

    @Override // com.kwai.sodler.lib.a.b
    public void a(com.kwai.sodler.lib.a.f fVar) {
        b.a aVar = this.f38004a;
        if (aVar != null) {
            fVar.a(aVar.a(fVar.i()));
        } else {
            a.e("Sodler.PluginConfigUpdater", "config reqester not set");
        }
    }
}

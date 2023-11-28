package com.kwad.components.offline.a;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.core.config.d;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.n.b.a<IAdLiveOfflineCompo> {
    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final int oD() {
        return 2;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oE() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oF() {
        return "3.3.54";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oG() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.54-6a9edb7f47-422.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oH() {
        return "f0857c461080551e87562bdf66e5c2a9";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oI() {
        return "ks_live_3354";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oJ() {
        return IAdLiveOfflineCompo.IMPL;
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static final b acp = new b((byte) 0);
    }

    public b() {
    }

    public static b tu() {
        return a.acp;
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.apD)).booleanValue();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        tu().init(context);
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.a.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                b.this.oC();
            }
        });
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, boolean, com.kwad.components.offline.api.IOfflineCompo] */
    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        a(context, iAdLiveOfflineCompo);
    }
}

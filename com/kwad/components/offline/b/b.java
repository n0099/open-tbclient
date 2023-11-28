package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.n.b.a<IObiwanOfflineCompo> {
    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final int oD() {
        return 3;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oE() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oF() {
        return "3.3.44";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oG() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.44-d884574fc8-340.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oH() {
        return "d945ab0533c29de4146475cc3b8cc310";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oI() {
        return "ks_obiwan_3344";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oJ() {
        return IObiwanOfflineCompo.IMPL;
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static final b acD = new b((byte) 0);
    }

    public b() {
    }

    public static b tx() {
        return a.acD;
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aqb)).booleanValue();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        tx().init(context);
    }

    private void a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                final com.kwad.components.offline.b.a aVar = new com.kwad.components.offline.b.a(iObiwanOfflineCompo);
                com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.c.a.class, aVar);
                com.kwad.sdk.core.e.c.a(new c(aVar.getLog()));
                b.this.oC();
                g.b(new g.a() { // from class: com.kwad.components.offline.b.b.1.1
                    private void updateConfigs() {
                        c cVar;
                        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqb)) {
                            cVar = new c(aVar.getLog());
                        } else {
                            cVar = null;
                        }
                        com.kwad.sdk.core.e.c.a(cVar);
                        aVar.updateConfigs();
                    }

                    @Override // com.kwad.components.core.request.g.a
                    public final void qi() {
                        updateConfigs();
                    }

                    @Override // com.kwad.components.core.request.g.a
                    public final void a(@NonNull SdkConfigData sdkConfigData) {
                        updateConfigs();
                    }
                });
            }
        });
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, boolean, com.kwad.components.offline.api.IOfflineCompo] */
    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IObiwanOfflineCompo iObiwanOfflineCompo) {
        a(context, iObiwanOfflineCompo);
    }
}

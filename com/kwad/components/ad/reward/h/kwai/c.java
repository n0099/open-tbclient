package com.kwad.components.ad.reward.h.kwai;

import android.text.TextUtils;
import com.kwad.components.ad.reward.b.f;
import com.kwad.sdk.components.h;
/* loaded from: classes8.dex */
public final class c extends com.kwad.components.core.webview.b.b.c implements e {
    public a tU;

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        a aVar = this.tU;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(hVar, bVar);
        hVar.c(new f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.h.kwai.c.1
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.e.b.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.gs());
                c.this.a(bVar2);
            }
        }));
        hVar.c(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.ad.reward.h.kwai.c.2
            @Override // com.kwad.components.core.webview.jshandler.b
            public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    aVar.a(com.kwad.components.ad.reward.b.a.gp().gq());
                    com.kwad.components.ad.reward.b.a.gp().a(aVar);
                }
            }
        }));
    }

    @Override // com.kwad.components.core.webview.b.b.a
    public final com.kwad.components.core.webview.b.d ip() {
        a aVar = (a) this.Ob;
        this.tU = aVar;
        return new d(null, aVar.tS, getContext());
    }
}

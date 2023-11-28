package com.kwad.components.ad.reward.k.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.sdk.components.p;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.c.c implements e {
    public a xt;

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final i hL() {
        this.xt = (a) this.aal;
        return new d(this.xt.jg(), this.xt.xr, getContext());
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        a aVar = this.xt;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        pVar.c(new f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.k.a.c.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.e.c.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.gM());
                c.this.a(bVar2);
            }
        }));
        pVar.c(new h(new n() { // from class: com.kwad.components.ad.reward.k.a.c.2
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(h hVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    hVar.a(com.kwad.components.ad.reward.c.a.gJ().gK());
                    com.kwad.components.ad.reward.c.a.gJ().a(hVar);
                }
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        super.a(aVar);
        a aVar2 = this.xt;
        if (aVar2 != null && aVar2.jg() != null) {
            this.xt.jg().oH.bJ();
        }
    }
}

package com.kwad.components.ad.reward.k.a;

import com.kwad.components.ad.reward.g;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.core.webview.tachikoma.c.b {
    public g xp;

    public a(g gVar) {
        this.xp = gVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.gJ().a(this.mAdTemplate, bVar);
    }

    public final g jg() {
        return this.xp;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.xp = null;
    }
}

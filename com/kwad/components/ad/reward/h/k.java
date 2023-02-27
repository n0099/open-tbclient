package com.kwad.components.ad.reward.h;

import com.kwad.components.core.webview.jshandler.s;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public final class k extends s {
    public WeakReference<com.kwad.components.ad.reward.k> ns;
    public long tQ;

    public k(com.kwad.components.ad.reward.k kVar, long j, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.tQ = -1L;
        this.tQ = j;
        if (kVar != null) {
            this.ns = new WeakReference<>(kVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.s
    public final void a(com.kwad.sdk.core.report.f fVar) {
        super.a(fVar);
        WeakReference<com.kwad.components.ad.reward.k> weakReference = this.ns;
        if (weakReference != null && weakReference.get() != null) {
            fVar.F(this.ns.get().eF.getPlayDuration());
            return;
        }
        long j = this.tQ;
        if (j > 0) {
            fVar.F(j);
        }
    }
}

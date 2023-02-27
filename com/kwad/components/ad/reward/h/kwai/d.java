package com.kwad.components.ad.reward.h.kwai;

import android.content.Context;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.h.l;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.sdk.components.h;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public final class d extends com.kwad.components.core.webview.b.d {
    public WeakReference<k> ns;
    public com.kwad.components.ad.reward.b.e tW;

    public d(k kVar, long j, Context context) {
        super(j, context);
        this.ns = new WeakReference<>(kVar);
    }

    @Override // com.kwad.components.core.webview.b.d
    public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.c.a.c cVar, h hVar, ViewGroup viewGroup) {
        super.a(bVar, cVar, hVar, viewGroup);
        hVar.c(new l(bVar, cVar, null, this.tS, this.Nf.getClickListener()));
        com.kwad.components.ad.reward.b.e eVar = new com.kwad.components.ad.reward.b.e();
        this.tW = eVar;
        hVar.c(eVar);
    }

    @Override // com.kwad.components.core.webview.b.d
    public final s c(com.kwad.sdk.core.webview.b bVar) {
        WeakReference<k> weakReference = this.ns;
        return new com.kwad.components.ad.reward.h.k(weakReference != null ? weakReference.get() : null, this.tS, bVar);
    }

    public final com.kwad.components.ad.reward.b.e iq() {
        return this.tW;
    }
}

package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public final class l extends com.kwad.components.core.webview.jshandler.f {
    public long ss;
    public WeakReference<com.kwad.components.ad.reward.k> tR;

    public l(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.components.ad.reward.k kVar, long j, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        super(bVar, cVar, aVar);
        this.ss = -1L;
        this.ss = j;
        if (kVar != null) {
            this.tR = new WeakReference<>(kVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r0 > 0) goto L6;
     */
    @Override // com.kwad.components.core.webview.jshandler.f
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final u.b a(com.kwad.sdk.core.webview.a.a.a aVar, AdTemplate adTemplate) {
        u.b a = super.a(aVar, adTemplate);
        WeakReference<com.kwad.components.ad.reward.k> weakReference = this.tR;
        long j = (weakReference == null || weakReference.get() == null) ? this.ss : this.tR.get().eF.getPlayDuration();
        a.ss = j;
        return a;
    }

    @Override // com.kwad.components.core.webview.jshandler.f
    public final void ik() {
        super.ik();
        if (this.Lk != null) {
            com.kwad.components.ad.reward.b.a.gp().b(this.Lk.getAdTemplate(), com.kwad.components.ad.reward.b.b.STATUS_NONE);
        }
    }
}

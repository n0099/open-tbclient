package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class q extends x {
    public long vy;
    public WeakReference<com.kwad.components.ad.reward.g> xo;

    public q(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.components.ad.reward.g gVar, long j, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.vy = -1L;
        this.vy = j;
        if (gVar != null) {
            this.xo = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.x
    @NonNull
    public final y.b a(com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        y.b a = super.a(aVar, adTemplate);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.xo;
        if (weakReference != null && weakReference.get() != null) {
            a.vy = this.xo.get().oI.getPlayDuration();
        } else {
            long j = this.vy;
            if (j > 0) {
                a.vy = j;
            }
        }
        return a;
    }

    @Override // com.kwad.components.core.webview.jshandler.x
    public final void jf() {
        super.jf();
        if (this.VP != null) {
            com.kwad.components.ad.reward.c.a.gJ().c(this.VP.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }
}

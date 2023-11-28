package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class p extends ak {
    public WeakReference<com.kwad.components.ad.reward.g> qg;
    public long xl;
    public String xm;

    public p(com.kwad.components.ad.reward.g gVar, String str, long j, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.xl = -1L;
        this.xm = str;
        this.xl = j;
        if (gVar != null) {
            this.qg = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.report.j jVar) {
        com.kwad.components.ad.reward.j.b.a(z, adTemplate, null, jVar);
    }

    public static boolean Q(String str) {
        try {
            if (new JSONObject(str).optInt("elementType") == 18) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean b(ak.b bVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (bVar.getActionType() == 140 && com.kwad.sdk.core.config.d.yD() && Q(bVar.sd()) && (weakReference = this.qg) != null && weakReference.get() != null) {
            final com.kwad.components.ad.reward.g gVar = this.qg.get();
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.k.p.1
                @Override // java.lang.Runnable
                public final void run() {
                    gVar.x(p.this.xm);
                }
            }, 1500L);
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void a(@NonNull ak.b bVar) {
        if (!b(bVar)) {
            super.a(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void a(com.kwad.sdk.core.report.j jVar) {
        super.a(jVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.qg;
        if (weakReference != null && weakReference.get() != null) {
            jVar.ai(this.qg.get().oI.getPlayDuration());
            return;
        }
        long j = this.xl;
        if (j > 0) {
            jVar.ai(j);
        }
    }
}

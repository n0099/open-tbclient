package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class am implements com.kwad.sdk.core.webview.c.a {
    public List<c> mHolders = new ArrayList();

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.download.a.a {
        public c Xp;

        public a(c cVar) {
            this.Xp = cVar;
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            am.a(this.Xp, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            am.a(this.Xp, 2, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            am.a(this.Xp, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            am.a(this.Xp, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            am.a(this.Xp, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            am.a(this.Xp, 6, 1.0f);
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public com.kwad.components.core.e.d.c Xq;
        public a Xr;
        public AdTemplate mAdTemplate;
        public com.kwad.sdk.core.webview.c.c nr;

        public c(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
            this.Xq = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void a(a aVar) {
            this.Xq.b(aVar);
            this.Xr = aVar;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.e.d.c cVar = this.Xq;
            if (cVar != null && (aVar = this.Xr) != null) {
                cVar.c(aVar);
            }
        }

        public final long se() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.b.e.dZ(adTemplate);
        }
    }

    public am(List<AdTemplate> list, List<com.kwad.components.core.e.d.c> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.mHolders.add(new c(list2.get(i), list.get(i)));
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c G = G(bVar.creativeId);
                if (G != null) {
                    G.nr = cVar;
                    G.a(new a(G));
                }
            } catch (Exception unused) {
            }
        }
    }

    private c G(long j) {
        if (j == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.se() == j) {
                return cVar;
            }
        }
        return null;
    }

    public static void a(c cVar, int i, float f) {
        if (cVar != null && cVar.nr != null) {
            com.kwad.sdk.core.e.c.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.nr + f);
            com.kwad.sdk.core.webview.c.c cVar2 = cVar.nr;
            az.a aVar = new az.a();
            aVar.XL = f;
            aVar.status = i;
            aVar.creativeId = cVar.se();
            aVar.totalBytes = com.kwad.sdk.core.response.b.e.dP(cVar.mAdTemplate).totalBytes;
            cVar2.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        for (c cVar : this.mHolders) {
            cVar.destroy();
        }
    }
}

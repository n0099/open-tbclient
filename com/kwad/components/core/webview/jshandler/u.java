package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class u implements com.kwad.sdk.core.webview.kwai.a {
    public List<c> mHolders = new ArrayList();

    /* loaded from: classes9.dex */
    public static class a extends com.kwad.sdk.core.download.kwai.a {
        public c Mz;

        public a(c cVar) {
            this.Mz = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            u.a(this.Mz, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            u.a(this.Mz, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            u.a(this.Mz, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            u.a(this.Mz, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i) {
            u.a(this.Mz, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            u.a(this.Mz, 2, (i * 1.0f) / 100.0f);
        }
    }

    @KsJson
    /* loaded from: classes9.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long creativeId = -1;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public com.kwad.components.core.c.a.c MA;
        public a MB;
        public com.kwad.sdk.core.webview.kwai.c kr;
        public AdTemplate mAdTemplate;

        public c(com.kwad.components.core.c.a.c cVar, AdTemplate adTemplate) {
            this.MA = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void a(a aVar) {
            this.MA.b(aVar);
            this.MB = aVar;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.c.a.c cVar = this.MA;
            if (cVar == null || (aVar = this.MB) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long pv() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.a.d.ca(adTemplate);
        }
    }

    public u(List<AdTemplate> list, List<com.kwad.components.core.c.a.c> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.mHolders.add(new c(list2.get(i), list.get(i)));
        }
    }

    public static void a(c cVar, int i, float f) {
        if (cVar == null || cVar.kr == null) {
            return;
        }
        com.kwad.sdk.core.e.b.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.kr + f);
        com.kwad.sdk.core.webview.kwai.c cVar2 = cVar.kr;
        ac.a aVar = new ac.a();
        aVar.MO = f;
        aVar.status = i;
        aVar.creativeId = cVar.pv();
        aVar.totalBytes = com.kwad.sdk.core.response.a.d.bQ(cVar.mAdTemplate).totalBytes;
        cVar2.a(aVar);
    }

    private c t(long j) {
        if (j == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.pv() == j) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c t = t(bVar.creativeId);
                if (t != null) {
                    t.kr = cVar;
                    t.a(new a(t));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        for (c cVar : this.mHolders) {
            cVar.destroy();
        }
    }
}

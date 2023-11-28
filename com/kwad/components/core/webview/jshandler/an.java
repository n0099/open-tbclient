package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class an implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b cO;

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String Xm;
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public double Xt;
        public int status;
        public long totalBytes;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    private KsAppDownloadListener aE(String str) {
        return new com.kwad.sdk.core.download.a.a(str) { // from class: com.kwad.components.core.webview.jshandler.an.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (an.this.cO.aCH != null) {
                    an.this.a(1, 0.0f, an.this.cO.aCH.fT(nN()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (an.this.cO.aCH != null) {
                    an.this.a(5, 1.0f, an.this.cO.aCH.fT(nN()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (an.this.cO.aCH != null) {
                    an.this.a(1, 0.0f, an.this.cO.aCH.fT(nN()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (an.this.cO.aCH != null) {
                    an.this.a(6, 1.0f, an.this.cO.aCH.fT(nN()));
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                if (an.this.cO.aCH != null) {
                    an.this.a(3, (i * 1.0f) / 100.0f, an.this.cO.aCH.fT(nN()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (an.this.cO.aCH != null) {
                    an.this.a(2, (i * 1.0f) / 100.0f, an.this.cO.aCH.fT(nN()));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.c.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.Xt = f;
            bVar.status = i;
            bVar.totalBytes = com.kwad.sdk.core.response.b.e.dP(this.cO.getAdTemplate()).totalBytes;
            cVar.a(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.Xm));
        } catch (Exception e) {
            adTemplate = null;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        if (adTemplate != null && com.kwad.sdk.core.response.b.e.dH(adTemplate) && this.cO.aCH != null) {
            com.kwad.components.core.e.d.c cVar2 = new com.kwad.components.core.e.d.c(adTemplate);
            String nN = cVar2.nN();
            cVar2.b(aE(nN));
            this.cO.aCH.a(nN, cVar2);
            this.cO.aCH.b(nN, cVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.af afVar = this.cO.aCH;
        if (afVar != null) {
            afVar.release();
        }
    }
}

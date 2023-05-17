package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class v implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.b mJsBridgeContext;

    @KsJson
    /* loaded from: classes9.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String Mw;
    }

    @KsJson
    /* loaded from: classes9.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public double MD;
        public int status;
        public long totalBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.kwai.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.MD = f;
            bVar.status = i;
            bVar.totalBytes = com.kwad.sdk.core.response.a.d.bQ(this.mJsBridgeContext.getAdTemplate()).totalBytes;
            cVar.a(bVar);
        }
    }

    private KsAppDownloadListener aE(String str) {
        return new com.kwad.sdk.core.download.kwai.a(str) { // from class: com.kwad.components.core.webview.jshandler.v.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (v.this.mJsBridgeContext.age != null) {
                    v.this.a(1, 0.0f, v.this.mJsBridgeContext.age.dL(mJ()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (v.this.mJsBridgeContext.age != null) {
                    v.this.a(5, 1.0f, v.this.mJsBridgeContext.age.dL(mJ()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (v.this.mJsBridgeContext.age != null) {
                    v.this.a(1, 0.0f, v.this.mJsBridgeContext.age.dL(mJ()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (v.this.mJsBridgeContext.age != null) {
                    v.this.a(6, 1.0f, v.this.mJsBridgeContext.age.dL(mJ()));
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                if (v.this.mJsBridgeContext.age != null) {
                    v.this.a(3, (i * 1.0f) / 100.0f, v.this.mJsBridgeContext.age.dL(mJ()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (v.this.mJsBridgeContext.age != null) {
                    v.this.a(2, (i * 1.0f) / 100.0f, v.this.mJsBridgeContext.age.dL(mJ()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.Mw));
        } catch (Exception e) {
            adTemplate = null;
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.a.d.bI(adTemplate) || this.mJsBridgeContext.age == null) {
            return;
        }
        com.kwad.components.core.c.a.c cVar2 = new com.kwad.components.core.c.a.c(adTemplate);
        String mJ = cVar2.mJ();
        cVar2.b(aE(mJ));
        this.mJsBridgeContext.age.a(mJ, cVar2);
        this.mJsBridgeContext.age.b(mJ, cVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        com.kwad.sdk.utils.ad adVar = this.mJsBridgeContext.age;
        if (adVar != null) {
            adVar.release();
        }
    }
}

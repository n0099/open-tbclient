package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ac implements com.kwad.sdk.core.webview.kwai.a {
    @Nullable
    public KsAppDownloadListener KW;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c Lb;
    public final com.kwad.components.core.c.a.c mApkDownloadHelper;
    public final com.kwad.sdk.core.webview.b mJsBridgeContext;

    /* loaded from: classes8.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public float MO;
        public long creativeId;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.r.putValue(jSONObject, "progress", this.MO);
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.r.putValue(jSONObject, "totalBytes", this.totalBytes);
            com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public ac(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar) {
        this.mJsBridgeContext = bVar;
        this.mApkDownloadHelper = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.Lb != null) {
            a aVar = new a();
            aVar.MO = f;
            aVar.status = i;
            aVar.totalBytes = com.kwad.sdk.core.response.a.d.bQ(this.mJsBridgeContext.getAdTemplate()).totalBytes;
            this.Lb.a(aVar);
        }
    }

    private KsAppDownloadListener pu() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.ac.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                ac.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                ac.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                ac.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                ac.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                ac.this.a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                ac.this.a(2, (i * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.mJsBridgeContext.wh()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.Lb = cVar;
        com.kwad.components.core.c.a.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.KW;
            if (ksAppDownloadListener != null) {
                cVar2.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener pu = pu();
            this.KW = pu;
            this.mApkDownloadHelper.b(pu);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.Lb = null;
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.KW) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.KW = null;
    }
}

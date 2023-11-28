package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class az implements com.kwad.sdk.core.webview.c.a {
    @Nullable
    public com.kwad.sdk.core.webview.c.c VH;
    @Nullable
    public KsAppDownloadListener Vt;
    @Nullable
    public KsAppDownloadListener XJ;
    public final com.kwad.sdk.core.webview.b cO;
    public final com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    /* loaded from: classes10.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public float XL;
        public long creativeId;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "progress", this.XL);
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.t.putValue(jSONObject, "totalBytes", this.totalBytes);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public az(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar) {
        this.cO = bVar;
        this.mApkDownloadHelper = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.VH != null) {
            a aVar = new a();
            aVar.XL = f;
            aVar.status = i;
            aVar.totalBytes = com.kwad.sdk.core.response.b.e.dP(this.cO.getAdTemplate()).totalBytes;
            this.VH.a(aVar);
        }
    }

    public az(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAppDownloadListener ksAppDownloadListener) {
        this.cO = bVar;
        this.mApkDownloadHelper = cVar;
        this.XJ = ksAppDownloadListener;
    }

    private KsAppDownloadListener sa() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.az.1
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                az.this.a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                az.this.a(2, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                az.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                az.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                az.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                az.this.a(6, 1.0f);
                if (az.this.XJ != null) {
                    az.this.XJ.onInstalled();
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.VH = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.Vt) != null) {
            cVar.c(ksAppDownloadListener);
            this.Vt = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.cO.FE()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.VH = cVar;
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.Vt;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener sa = sa();
                this.Vt = sa;
                this.mApkDownloadHelper.b(sa);
                return;
            }
            cVar2.d(ksAppDownloadListener);
        }
    }
}

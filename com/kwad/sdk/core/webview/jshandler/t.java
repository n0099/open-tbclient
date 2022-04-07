package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;
    public final com.kwad.sdk.core.download.a.b b;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c c;
    @Nullable
    public KsAppDownloadListener d;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public float a;
        public int b;
        public long c;
        public long d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "progress", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "status", this.b);
            com.kwad.sdk.utils.t.a(jSONObject, "totalBytes", this.c);
            com.kwad.sdk.utils.t.a(jSONObject, "creativeId", this.d);
            return jSONObject;
        }
    }

    public t(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar) {
        this.a = aVar;
        this.b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.c != null) {
            a aVar = new a();
            aVar.a = f;
            aVar.b = i;
            aVar.c = com.kwad.sdk.core.response.a.d.j(this.a.a()).totalBytes;
            this.c.a(aVar);
        }
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.webview.jshandler.t.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                t.this.a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                t.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                t.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                t.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                t.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                t.this.a(2, (i * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.a.c()) {
            cVar.a(-1, "native photo is null");
            return;
        }
        this.c = cVar;
        com.kwad.sdk.core.download.a.b bVar = this.b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.d;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c = c();
            this.d = c;
            this.b.a(c);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.c = null;
        com.kwad.sdk.core.download.a.b bVar = this.b;
        if (bVar == null || (ksAppDownloadListener = this.d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.d = null;
    }
}

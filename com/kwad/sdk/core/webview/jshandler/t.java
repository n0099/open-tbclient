package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.download.a.b f40088b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f40089c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f40090d;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public int f40092b;

        /* renamed from: c  reason: collision with root package name */
        public long f40093c;

        /* renamed from: d  reason: collision with root package name */
        public long f40094d;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "progress", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "status", this.f40092b);
            com.kwad.sdk.utils.t.a(jSONObject, "totalBytes", this.f40093c);
            com.kwad.sdk.utils.t.a(jSONObject, "creativeId", this.f40094d);
            return jSONObject;
        }
    }

    public t(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar) {
        this.a = aVar;
        this.f40088b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f2) {
        if (this.f40089c != null) {
            a aVar = new a();
            aVar.a = f2;
            aVar.f40092b = i;
            aVar.f40093c = com.kwad.sdk.core.response.a.d.j(this.a.a()).totalBytes;
            this.f40089c.a(aVar);
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
        this.f40089c = cVar;
        com.kwad.sdk.core.download.a.b bVar = this.f40088b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f40090d;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f40090d = c2;
            this.f40088b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f40089c = null;
        com.kwad.sdk.core.download.a.b bVar = this.f40088b;
        if (bVar == null || (ksAppDownloadListener = this.f40090d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f40090d = null;
    }
}

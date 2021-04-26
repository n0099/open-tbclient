package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f33738a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f33739b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f33740c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f33741d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public float f33743a;

        /* renamed from: b  reason: collision with root package name */
        public int f33744b;

        /* renamed from: c  reason: collision with root package name */
        public long f33745c;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "progress", this.f33743a);
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f33744b);
            com.kwad.sdk.utils.o.a(jSONObject, "totalBytes", this.f33745c);
            return jSONObject;
        }
    }

    public n(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        this.f33738a = aVar;
        this.f33739b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f33740c != null) {
            a aVar = new a();
            aVar.f33743a = f2;
            aVar.f33744b = i2;
            aVar.f33745c = com.kwad.sdk.core.response.b.c.g(this.f33738a.f33622b).totalBytes;
            this.f33740c.a(aVar);
        }
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.webview.jshandler.n.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                n.this.a(3, (i2 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                n.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                n.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                n.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                n.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                n.this.a(2, (i2 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f33738a.f33622b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        this.f33740c = cVar;
        com.kwad.sdk.core.download.b.b bVar = this.f33739b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f33741d;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f33741d = c2;
            this.f33739b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f33740c = null;
        com.kwad.sdk.core.download.b.b bVar = this.f33739b;
        if (bVar == null || (ksAppDownloadListener = this.f33741d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f33741d = null;
    }
}

package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f32912a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f32913b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f32914c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f32915d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public float f32917a;

        /* renamed from: b  reason: collision with root package name */
        public int f32918b;

        /* renamed from: c  reason: collision with root package name */
        public long f32919c;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "progress", this.f32917a);
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f32918b);
            com.kwad.sdk.utils.o.a(jSONObject, "totalBytes", this.f32919c);
            return jSONObject;
        }
    }

    public n(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        this.f32912a = aVar;
        this.f32913b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f32914c != null) {
            a aVar = new a();
            aVar.f32917a = f2;
            aVar.f32918b = i2;
            aVar.f32919c = com.kwad.sdk.core.response.b.c.g(this.f32912a.f32796b).totalBytes;
            this.f32914c.a(aVar);
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
        if (this.f32912a.f32796b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        this.f32914c = cVar;
        com.kwad.sdk.core.download.b.b bVar = this.f32913b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f32915d;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f32915d = c2;
            this.f32913b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f32914c = null;
        com.kwad.sdk.core.download.b.b bVar = this.f32913b;
        if (bVar == null || (ksAppDownloadListener = this.f32915d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f32915d = null;
    }
}

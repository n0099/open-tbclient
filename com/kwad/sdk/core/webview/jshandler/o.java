package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34394a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f34395b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34396c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f34397d;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public float f34399a;

        /* renamed from: b  reason: collision with root package name */
        public int f34400b;

        /* renamed from: c  reason: collision with root package name */
        public long f34401c;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "progress", this.f34399a);
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f34400b);
            com.kwad.sdk.utils.o.a(jSONObject, "totalBytes", this.f34401c);
            return jSONObject;
        }
    }

    public o(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        this.f34394a = aVar;
        this.f34395b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f2) {
        if (this.f34396c != null) {
            a aVar = new a();
            aVar.f34399a = f2;
            aVar.f34400b = i;
            aVar.f34401c = com.kwad.sdk.core.response.b.c.j(this.f34394a.f34286b).totalBytes;
            this.f34396c.a(aVar);
        }
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.webview.jshandler.o.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                o.this.a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                o.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                o.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                o.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                o.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                o.this.a(2, (i * 1.0f) / 100.0f);
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
        if (this.f34394a.f34286b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        this.f34396c = cVar;
        com.kwad.sdk.core.download.b.b bVar = this.f34395b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f34397d;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f34397d = c2;
            this.f34395b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f34396c = null;
        com.kwad.sdk.core.download.b.b bVar = this.f34395b;
        if (bVar == null || (ksAppDownloadListener = this.f34397d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f34397d = null;
    }
}

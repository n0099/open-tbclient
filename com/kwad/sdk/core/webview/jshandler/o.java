package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35040a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f35041b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f35042c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f35043d;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public float f35045a;

        /* renamed from: b  reason: collision with root package name */
        public int f35046b;

        /* renamed from: c  reason: collision with root package name */
        public long f35047c;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "progress", this.f35045a);
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f35046b);
            com.kwad.sdk.utils.o.a(jSONObject, "totalBytes", this.f35047c);
            return jSONObject;
        }
    }

    public o(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        this.f35040a = aVar;
        this.f35041b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f35042c != null) {
            a aVar = new a();
            aVar.f35045a = f2;
            aVar.f35046b = i2;
            aVar.f35047c = com.kwad.sdk.core.response.b.c.j(this.f35040a.f34929b).totalBytes;
            this.f35042c.a(aVar);
        }
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.webview.jshandler.o.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                o.this.a(3, (i2 * 1.0f) / 100.0f);
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
            public void onProgressUpdate(int i2) {
                o.this.a(2, (i2 * 1.0f) / 100.0f);
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
        if (this.f35040a.f34929b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        this.f35042c = cVar;
        com.kwad.sdk.core.download.b.b bVar = this.f35041b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f35043d;
            if (ksAppDownloadListener != null) {
                bVar.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f35043d = c2;
            this.f35041b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f35042c = null;
        com.kwad.sdk.core.download.b.b bVar = this.f35041b;
        if (bVar == null || (ksAppDownloadListener = this.f35043d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f35043d = null;
    }
}

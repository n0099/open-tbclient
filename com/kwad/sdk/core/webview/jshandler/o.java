package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f6362a;
    private final com.kwad.sdk.core.download.b.b b;
    @Nullable
    private com.kwad.sdk.core.webview.a.c c;
    @Nullable
    private KsAppDownloadListener d;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public float f6364a;
        public int b;
        public long c;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "progress", this.f6364a);
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.b);
            com.kwad.sdk.utils.o.a(jSONObject, "totalBytes", this.c);
            return jSONObject;
        }
    }

    public o(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        this.f6362a = aVar;
        this.b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.c != null) {
            a aVar = new a();
            aVar.f6364a = f;
            aVar.b = i;
            aVar.c = com.kwad.sdk.core.response.b.c.j(this.f6362a.b).totalBytes;
            this.c.a(aVar);
        }
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.webview.jshandler.o.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                o.this.a(3, (1.0f * i) / 100.0f);
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
                o.this.a(2, (1.0f * i) / 100.0f);
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
        if (this.f6362a.b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        this.c = cVar;
        if (this.b != null) {
            if (this.d != null) {
                this.b.c(this.d);
                return;
            }
            this.d = c();
            this.b.a(this.d);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.c = null;
        if (this.b == null || this.d == null) {
            return;
        }
        this.b.b(this.d);
        this.d = null;
    }
}

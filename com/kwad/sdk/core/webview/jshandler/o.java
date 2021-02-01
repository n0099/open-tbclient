package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9607a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.core.download.b.b f9608b;
    @Nullable
    private com.kwad.sdk.core.webview.a.c c;
    @Nullable
    private KsAppDownloadListener d;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public float f9610a;

        /* renamed from: b  reason: collision with root package name */
        public int f9611b;
        public long c;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "progress", this.f9610a);
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f9611b);
            com.kwad.sdk.utils.o.a(jSONObject, "totalBytes", this.c);
            return jSONObject;
        }
    }

    public o(com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        this.f9607a = aVar;
        this.f9608b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.c != null) {
            a aVar = new a();
            aVar.f9610a = f;
            aVar.f9611b = i;
            aVar.c = com.kwad.sdk.core.response.b.c.j(this.f9607a.f9539b).totalBytes;
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
        if (this.f9607a.f9539b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        this.c = cVar;
        if (this.f9608b != null) {
            if (this.d != null) {
                this.f9608b.c(this.d);
                return;
            }
            this.d = c();
            this.f9608b.a(this.d);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.c = null;
        if (this.f9608b == null || this.d == null) {
            return;
        }
        this.f9608b.b(this.d);
        this.d = null;
    }
}

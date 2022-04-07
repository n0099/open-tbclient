package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String a;
    }

    /* loaded from: classes5.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public double a;
        public int b;
        public long c;
    }

    private KsAppDownloadListener a(String str) {
        return new com.kwad.sdk.core.download.a.c(str) { // from class: com.kwad.sdk.core.webview.jshandler.n.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                if (n.this.a.g != null) {
                    n.this.a(3, (i * 1.0f) / 100.0f, n.this.a.g.b(a()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                if (n.this.a.g != null) {
                    n.this.a(1, 0.0f, n.this.a.g.b(a()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                if (n.this.a.g != null) {
                    n.this.a(5, 1.0f, n.this.a.g.b(a()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                if (n.this.a.g != null) {
                    n.this.a(1, 0.0f, n.this.a.g.b(a()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                if (n.this.a.g != null) {
                    n.this.a(6, 1.0f, n.this.a.g.b(a()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                if (n.this.a.g != null) {
                    n.this.a(2, (i * 1.0f) / 100.0f, n.this.a.g.b(a()));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.kwai.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.a = f;
            bVar.b = i;
            bVar.c = com.kwad.sdk.core.response.a.d.j(this.a.a()).totalBytes;
            cVar.a(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.a));
        } catch (Exception e) {
            adTemplate = null;
            com.kwad.sdk.core.d.a.b(e);
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.a.d.c(adTemplate) || this.a.g == null) {
            return;
        }
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(adTemplate);
        String a2 = bVar.a();
        bVar.a(a(a2));
        this.a.g.a(a2, bVar);
        this.a.g.a(a2, cVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        ac acVar = this.a.g;
        if (acVar != null) {
            acVar.a();
        }
    }
}

package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m implements com.kwad.sdk.core.webview.kwai.a {
    public List<c> a = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.download.a.c {
        public c b;

        public a(c cVar) {
            this.b = cVar;
        }

        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i) {
            m.b(this.b, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            m.b(this.b, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            m.b(this.b, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            m.b(this.b, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            m.b(this.b, 6, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            m.b(this.b, 2, (i * 1.0f) / 100.0f);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long a = -1;
    }

    /* loaded from: classes5.dex */
    public static class c {
        public com.kwad.sdk.core.webview.kwai.c a;
        public com.kwad.sdk.core.download.a.b b;
        public AdTemplate c;
        public a d;

        public c(com.kwad.sdk.core.download.a.b bVar, AdTemplate adTemplate) {
            this.b = bVar;
            this.c = adTemplate;
        }

        public void a() {
            a aVar;
            com.kwad.sdk.core.download.a.b bVar = this.b;
            if (bVar == null || (aVar = this.d) == null) {
                return;
            }
            bVar.b(aVar);
        }

        public void a(a aVar) {
            this.b.a(aVar);
            this.d = aVar;
        }

        public long b() {
            AdTemplate adTemplate = this.c;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.a.d.y(adTemplate);
        }
    }

    public m(List<AdTemplate> list, List<com.kwad.sdk.core.download.a.b> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.a.add(new c(list2.get(i), list.get(i)));
        }
    }

    private c a(long j) {
        if (j == -1) {
            return null;
        }
        for (c cVar : this.a) {
            if (cVar.b() == j) {
                return cVar;
            }
        }
        return null;
    }

    public static void b(c cVar, int i, float f) {
        if (cVar == null || cVar.a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("MultiProgressListener", "notifyDownloadProgress: " + cVar.a + f + "");
        com.kwad.sdk.core.webview.kwai.c cVar2 = cVar.a;
        t.a aVar = new t.a();
        aVar.a = f;
        aVar.b = i;
        aVar.d = cVar.b();
        aVar.c = com.kwad.sdk.core.response.a.d.j(cVar.c).totalBytes;
        cVar2.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c a2 = a(bVar.a);
                if (a2 != null) {
                    a2.a = cVar;
                    a2.a(new a(a2));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        for (c cVar : this.a) {
            cVar.a();
        }
    }
}

package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m implements com.kwad.sdk.core.webview.kwai.a {
    public List<c> a = new ArrayList();

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.download.a.c {

        /* renamed from: b  reason: collision with root package name */
        public c f40064b;

        public a(c cVar) {
            this.f40064b = cVar;
        }

        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i) {
            m.b(this.f40064b, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            m.b(this.f40064b, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            m.b(this.f40064b, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            m.b(this.f40064b, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            m.b(this.f40064b, 6, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            m.b(this.f40064b, 2, (i * 1.0f) / 100.0f);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long a = -1;
    }

    /* loaded from: classes7.dex */
    public static class c {
        public com.kwad.sdk.core.webview.kwai.c a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f40065b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f40066c;

        /* renamed from: d  reason: collision with root package name */
        public a f40067d;

        public c(com.kwad.sdk.core.download.a.b bVar, AdTemplate adTemplate) {
            this.f40065b = bVar;
            this.f40066c = adTemplate;
        }

        public void a() {
            a aVar;
            com.kwad.sdk.core.download.a.b bVar = this.f40065b;
            if (bVar == null || (aVar = this.f40067d) == null) {
                return;
            }
            bVar.b(aVar);
        }

        public void a(a aVar) {
            this.f40065b.a(aVar);
            this.f40067d = aVar;
        }

        public long b() {
            AdTemplate adTemplate = this.f40066c;
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

    public static void b(c cVar, int i, float f2) {
        if (cVar == null || cVar.a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("MultiProgressListener", "notifyDownloadProgress: " + cVar.a + f2 + "");
        com.kwad.sdk.core.webview.kwai.c cVar2 = cVar.a;
        t.a aVar = new t.a();
        aVar.a = f2;
        aVar.f40092b = i;
        aVar.f40094d = cVar.b();
        aVar.f40093c = com.kwad.sdk.core.response.a.d.j(cVar.f40066c).totalBytes;
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

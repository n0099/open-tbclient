package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements com.kwad.sdk.core.webview.kwai.a {
    public List<c> a = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.download.a.c {

        /* renamed from: b  reason: collision with root package name */
        public c f56416b;

        public a(c cVar) {
            this.f56416b = cVar;
        }

        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i2) {
            m.b(this.f56416b, 3, (i2 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            m.b(this.f56416b, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            m.b(this.f56416b, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            m.b(this.f56416b, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            m.b(this.f56416b, 6, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            m.b(this.f56416b, 2, (i2 * 1.0f) / 100.0f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long a = -1;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public com.kwad.sdk.core.webview.kwai.c a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f56417b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f56418c;

        /* renamed from: d  reason: collision with root package name */
        public a f56419d;

        public c(com.kwad.sdk.core.download.a.b bVar, AdTemplate adTemplate) {
            this.f56417b = bVar;
            this.f56418c = adTemplate;
        }

        public void a() {
            a aVar;
            com.kwad.sdk.core.download.a.b bVar = this.f56417b;
            if (bVar == null || (aVar = this.f56419d) == null) {
                return;
            }
            bVar.b(aVar);
        }

        public void a(a aVar) {
            this.f56417b.a(aVar);
            this.f56419d = aVar;
        }

        public long b() {
            AdTemplate adTemplate = this.f56418c;
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
        for (int i2 = 0; i2 < size; i2++) {
            this.a.add(new c(list2.get(i2), list.get(i2)));
        }
    }

    private c a(long j2) {
        if (j2 == -1) {
            return null;
        }
        for (c cVar : this.a) {
            if (cVar.b() == j2) {
                return cVar;
            }
        }
        return null;
    }

    public static void b(c cVar, int i2, float f2) {
        if (cVar == null || cVar.a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("MultiProgressListener", "notifyDownloadProgress: " + cVar.a + f2 + "");
        com.kwad.sdk.core.webview.kwai.c cVar2 = cVar.a;
        t.a aVar = new t.a();
        aVar.a = f2;
        aVar.f56445b = i2;
        aVar.f56447d = cVar.b();
        aVar.f56446c = com.kwad.sdk.core.response.a.d.j(cVar.f56418c).totalBytes;
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

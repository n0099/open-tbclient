package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class e implements com.kwad.sdk.core.webview.kwai.a {
    public List<AdTemplate> Lj;
    public b mf;

    @KsJson
    /* loaded from: classes9.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* loaded from: classes9.dex */
    public interface b {
        void b(AdTemplate adTemplate, long j);
    }

    public e(List<AdTemplate> list) {
        this.Lj = list;
    }

    public final void a(b bVar) {
        this.mf = bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            long j = aVar.creativeId;
            AdTemplate a2 = com.kwad.sdk.core.response.a.d.a(this.Lj, j, aVar.adStyle);
            if (this.mf != null) {
                this.mf.b(a2, j);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}

package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class w implements com.kwad.sdk.core.webview.c.a {
    public List<AdTemplate> Wa;
    public com.kwad.sdk.core.webview.b cO;
    public b oC;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* loaded from: classes10.dex */
    public interface b {
        void N(AdTemplate adTemplate);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public w(com.kwad.sdk.core.webview.b bVar) {
        this.cO = bVar;
    }

    public final void a(b bVar) {
        this.oC = bVar;
    }

    public w(List<AdTemplate> list) {
        this.Wa = list;
    }

    private List<AdTemplate> sb() {
        List<AdTemplate> list = this.Wa;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.cO;
        if (bVar != null) {
            return bVar.FD();
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate a2 = com.kwad.sdk.core.response.b.e.a(sb(), aVar.creativeId, aVar.adStyle);
            if (this.oC != null) {
                this.oC.N(a2);
            }
        } catch (JSONException unused) {
        }
    }
}

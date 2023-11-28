package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class al implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;
    public final Handler Wk;
    @Nullable
    public final b Xf;

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public boolean Xl;
        public String Xm;
        public int Xn;
        public com.kwad.sdk.core.webview.d.b.c Xo;
    }

    /* loaded from: classes10.dex */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.e.d.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.Xm));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (!com.kwad.sdk.core.response.b.e.dH(adTemplate)) {
            return;
        }
        if (this.VP.aCH != null) {
            cVar2 = (com.kwad.components.core.e.d.c) this.VP.aCH.fS(com.kwad.sdk.core.response.b.e.dP(adTemplate).downloadId);
        } else {
            cVar2 = null;
        }
        if (this.VP.aCI) {
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.al.1
                @Override // java.lang.Runnable
                public final void run() {
                    y.b bVar = new y.b();
                    bVar.Xd = aVar.Xo.Xd;
                    com.kwad.components.core.e.d.a.a(new a.C0644a(al.this.VP.Ov.getContext()).aq(adTemplate).b(cVar2).an(aVar.Xn).ao(true).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.al.1.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                        }
                    }));
                }
            });
        } else if (this.Xf != null) {
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.al.2
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Wk.removeCallbacksAndMessages(null);
    }
}

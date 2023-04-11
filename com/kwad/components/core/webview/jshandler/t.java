package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class t implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.b Lk;
    public final Handler Ll;
    @Nullable
    public final b Mp;

    @KsJson
    /* loaded from: classes8.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean Mv;
        public String Mw;
        public int Mx;
        public com.kwad.sdk.core.webview.a.a.c My;
    }

    /* loaded from: classes8.dex */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        final com.kwad.components.core.c.a.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.Mw));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        if (com.kwad.sdk.core.response.a.d.bI(adTemplate)) {
            if (this.Lk.age != null) {
                cVar2 = (com.kwad.components.core.c.a.c) this.Lk.age.dK(com.kwad.sdk.core.response.a.d.bQ(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.Lk.agf) {
                this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.t.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.b bVar = new u.b();
                        bVar.Mn = aVar.My.Mn;
                        com.kwad.components.core.c.a.a.a(new a.C0594a(t.this.Lk.Gl.getContext()).L(adTemplate).b(cVar2).ae(aVar.Mx).aj(true).a(bVar).al(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.t.1.1
                            @Override // com.kwad.components.core.c.a.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.Mp != null) {
                this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.t.2
                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Ll.removeCallbacksAndMessages(null);
    }
}

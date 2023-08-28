package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c Lb;
    public com.kwad.components.core.webview.jshandler.b Lc;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0665a extends com.kwad.sdk.core.response.kwai.a {
        public String Ld;

        public final String getTarget() {
            return this.Ld;
        }
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public int Le;
        public int Lf;
        public int Lg;
        public int oQ;
    }

    public a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.Lc = bVar;
    }

    public final void a(com.kwad.sdk.core.response.kwai.a aVar) {
        com.kwad.sdk.core.webview.kwai.c cVar = this.Lb;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.Lb = cVar;
        try {
            C0665a c0665a = new C0665a();
            c0665a.parseJson(new JSONObject(str));
            String target = c0665a.getTarget();
            if (this.Lc != null) {
                this.Lc.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    public final void as(int i) {
        b bVar = new b();
        bVar.oQ = i;
        a(bVar);
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.Le = playableSource.getCode();
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    public final void h(boolean z, boolean z2) {
        b bVar = new b();
        bVar.Lf = z ? 1 : 0;
        bVar.Lg = z2 ? 1 : 0;
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Lb = null;
    }
}

package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
/* loaded from: classes10.dex */
public final class ar implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c VH;
    public a Xx = new a();

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }

    @KsJson
    /* loaded from: classes10.dex */
    public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int id;
        public int status;

        public a() {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VH = null;
    }

    private void t(int i, int i2) {
        com.kwad.sdk.core.webview.c.c cVar = this.VH;
        if (cVar != null) {
            a aVar = this.Xx;
            aVar.id = i;
            aVar.status = 2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VH = cVar;
    }

    public final void aK(int i) {
        t(1, 2);
    }
}

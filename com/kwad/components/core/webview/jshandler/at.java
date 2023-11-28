package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
/* loaded from: classes10.dex */
public final class at implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c VH;
    public c XB;

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    /* loaded from: classes10.dex */
    public interface b {
        void pu();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void px();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerBackClickListener";
    }

    public at(c cVar) {
        this.XB = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VH = cVar;
        c cVar2 = this.XB;
        if (cVar2 != null) {
            cVar2.px();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VH = null;
    }

    public final void sf() {
        if (this.VH != null) {
            a aVar = new a();
            aVar.status = 1;
            this.VH.a(aVar);
        }
    }
}

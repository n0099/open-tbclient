package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
/* loaded from: classes10.dex */
public final class h extends w {
    public a Zt;

    /* loaded from: classes10.dex */
    public interface a {
        void a(h hVar);
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int Zu;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        this.Zt = null;
    }

    public final void a(a aVar) {
        this.Zt = aVar;
    }

    public final void aU(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        b bVar = new b();
        bVar.Zu = i;
        b(bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        a aVar = this.Zt;
        if (aVar != null) {
            aVar.a(this);
        }
    }
}

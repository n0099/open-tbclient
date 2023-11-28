package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class ab implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;
    public a Ws;
    public Handler fS = new Handler(Looper.getMainLooper());

    /* loaded from: classes10.dex */
    public interface a {
        void bA();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    public ab(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.VP = bVar;
        this.Ws = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.fS.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ab.1
            @Override // java.lang.Runnable
            public final void run() {
                ab.this.Ws.bA();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fS.removeCallbacksAndMessages(null);
    }
}

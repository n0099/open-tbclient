package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class j implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.b Lk;
    public a Ly;
    public Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes10.dex */
    public interface a {
        void bx();
    }

    public j(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.Lk = bVar;
        this.Ly = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.j.1
            @Override // java.lang.Runnable
            public final void run() {
                j.this.Ly.bx();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}

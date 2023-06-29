package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
/* loaded from: classes10.dex */
public final class c implements com.kwad.sdk.core.webview.kwai.a {
    public a Lh;

    /* loaded from: classes10.dex */
    public interface a {
        void onPlayAgainClick();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.Lh != null) {
                    c.this.Lh.onPlayAgainClick();
                }
            }
        });
    }

    public final void b(a aVar) {
        this.Lh = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "showPlayAgain";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}

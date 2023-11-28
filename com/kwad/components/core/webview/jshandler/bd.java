package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {
    public a XR;

    /* loaded from: classes10.dex */
    public interface a {
        void rV();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bd(a aVar) {
        this.XR = aVar;
    }

    private void sm() {
        if (com.kwad.components.core.e.c.b.nj()) {
            return;
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.bd.1
            @Override // java.lang.Runnable
            public final void run() {
                if (bd.this.XR != null) {
                    bd.this.XR.rV();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        sm();
    }
}

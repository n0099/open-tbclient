package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
/* loaded from: classes8.dex */
public final class af implements com.kwad.sdk.core.webview.kwai.a {
    public a MR;

    /* loaded from: classes8.dex */
    public interface a {
        void nH();
    }

    public af(a aVar) {
        this.MR = aVar;
    }

    private void pE() {
        if (com.kwad.components.core.c.kwai.b.mq()) {
            return;
        }
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.af.1
            @Override // java.lang.Runnable
            public final void run() {
                if (af.this.MR != null) {
                    af.this.MR.nH();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        pE();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}

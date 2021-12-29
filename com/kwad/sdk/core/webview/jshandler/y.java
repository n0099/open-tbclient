package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ax;
/* loaded from: classes3.dex */
public class y implements com.kwad.sdk.core.webview.kwai.a {
    public a a;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public y(a aVar) {
        this.a = aVar;
    }

    private void c() {
        if (com.kwad.sdk.core.download.kwai.b.a()) {
            return;
        }
        ax.a(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.y.1
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.a != null) {
                    y.this.a.a();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        c();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}

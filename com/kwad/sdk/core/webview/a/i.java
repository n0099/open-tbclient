package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ax;
/* loaded from: classes7.dex */
public abstract class i implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c a;

    public void a(final com.kwad.sdk.core.response.kwai.a aVar) {
        if (this.a != null) {
            ax.a(new Runnable() { // from class: com.kwad.sdk.core.webview.a.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.a.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}

package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public class e implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c nr;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerConvertStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nr = null;
    }

    public final void b(final com.kwad.sdk.core.response.a.a aVar) {
        if (this.nr != null) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.nr.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nr = cVar;
    }
}

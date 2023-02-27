package com.kwad.components.core.webview.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
/* loaded from: classes8.dex */
public class c implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c kr;

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.kr = cVar;
    }

    public final void b(final com.kwad.sdk.core.response.kwai.a aVar) {
        if (this.kr != null) {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.b.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.kr.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerConvertStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.kr = null;
    }
}

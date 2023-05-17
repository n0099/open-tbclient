package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
/* loaded from: classes9.dex */
public final class ab implements com.kwad.sdk.core.webview.kwai.a {
    public final a MK;

    /* loaded from: classes9.dex */
    public interface a {
        @MainThread
        void dd();
    }

    public ab(a aVar) {
        this.MK = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.kwai.c cVar) {
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ab.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ab.this.MK != null) {
                    ab.this.MK.dd();
                }
                cVar.a(null);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}

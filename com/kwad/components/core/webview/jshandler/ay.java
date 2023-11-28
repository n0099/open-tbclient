package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class ay implements com.kwad.sdk.core.webview.c.a {
    public final a XH;

    /* loaded from: classes10.dex */
    public interface a {
        @MainThread
        void bB();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ay(a aVar) {
        this.XH = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ay.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ay.this.XH != null) {
                    ay.this.XH.bB();
                }
                cVar.a(null);
            }
        });
    }
}

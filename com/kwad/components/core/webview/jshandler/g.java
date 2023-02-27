package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public final class g implements com.kwad.sdk.core.webview.kwai.a {
    public Handler Ll = new Handler(Looper.getMainLooper());
    public com.kwad.sdk.core.webview.a.kwai.b Lt;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c Lu;

    public g(com.kwad.sdk.core.webview.a.kwai.b bVar) {
        this.Lt = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        com.kwad.sdk.core.webview.a.kwai.b bVar = this.Lt;
        if (bVar != null) {
            bVar.onClose();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.Lu = cVar;
        this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.g.1
            @Override // java.lang.Runnable
            public final void run() {
                g.this.pw();
                if (g.this.Lu != null) {
                    g.this.Lu.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "close";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Lt = null;
        this.Lu = null;
        this.Ll.removeCallbacksAndMessages(null);
    }
}

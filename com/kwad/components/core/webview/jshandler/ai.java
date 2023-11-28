package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ai implements com.kwad.sdk.core.webview.c.a {
    public final Handler Wk = new Handler(Looper.getMainLooper());
    @Nullable
    public com.kwad.sdk.core.webview.c.c Wl;
    public b cT;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int WX = -1;
        public int type;
    }

    /* loaded from: classes10.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    public ai(b bVar) {
        this.cT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cT;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.Wl = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ai.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ai.this.Wl != null) {
                        ai.this.Wl.a(null);
                    }
                    ai.this.b(aVar);
                }
            });
        } catch (Exception e) {
            this.Wl.onError(-1, e.getMessage());
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cT = null;
        this.Wl = null;
        this.Wk.removeCallbacksAndMessages(null);
    }
}

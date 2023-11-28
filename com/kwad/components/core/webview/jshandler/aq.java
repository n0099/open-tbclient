package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class aq implements com.kwad.sdk.core.webview.c.a {
    public Handler Wk = new Handler(Looper.getMainLooper());
    public com.kwad.sdk.core.webview.c.c Wl;
    public b cU;
    public String mUrl;

    /* loaded from: classes10.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            if (this.status == 1) {
                return true;
            }
            return false;
        }
    }

    @Deprecated
    public aq(b bVar) {
        this.cU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cU;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public aq(b bVar, String str) {
        this.cU = bVar;
        this.mUrl = str;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Wl = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.aq.1
                @Override // java.lang.Runnable
                public final void run() {
                    aq.this.b(aVar);
                    if (aq.this.Wl != null) {
                        aq.this.Wl.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            com.kwad.sdk.core.webview.b.c.b.ae(this.mUrl, e.getMessage());
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cU = null;
        this.Wl = null;
        this.Wk.removeCallbacksAndMessages(null);
    }
}

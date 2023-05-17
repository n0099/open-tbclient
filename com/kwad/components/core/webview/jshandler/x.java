package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class x implements com.kwad.sdk.core.webview.kwai.a {
    public Handler Ll = new Handler(Looper.getMainLooper());
    public com.kwad.sdk.core.webview.kwai.c Lu;
    public b bM;
    public String mUrl;

    @KsJson
    /* loaded from: classes9.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Deprecated
    public x(b bVar) {
        this.bM = bVar;
    }

    public x(b bVar, String str) {
        this.bM = bVar;
        this.mUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.bM;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.Lu = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.x.1
                @Override // java.lang.Runnable
                public final void run() {
                    x.this.b(aVar);
                    if (x.this.Lu != null) {
                        x.this.Lu.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            com.kwad.components.a.b.b.t(this.mUrl, e.getMessage());
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.bM = null;
        this.Lu = null;
        this.Ll.removeCallbacksAndMessages(null);
    }
}

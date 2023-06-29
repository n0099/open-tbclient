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
public final class q implements com.kwad.sdk.core.webview.kwai.a {
    public final Handler Ll = new Handler(Looper.getMainLooper());
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c Lu;
    public b bL;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int Mh = -1;
        public int type;
    }

    /* loaded from: classes10.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public q(b bVar) {
        this.bL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.bL;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        try {
            this.Lu = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.q.1
                @Override // java.lang.Runnable
                public final void run() {
                    q.this.b(aVar);
                    if (q.this.Lu != null) {
                        q.this.Lu.a(null);
                    }
                }
            });
        } catch (Exception e) {
            this.Lu.onError(-1, e.getMessage());
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.bL = null;
        this.Lu = null;
        this.Ll.removeCallbacksAndMessages(null);
    }
}

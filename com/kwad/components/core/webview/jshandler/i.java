package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.c.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class i implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.b Lk;
    public Handler Ll;
    public boolean Ln;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    @Nullable
    public final com.kwad.components.core.c.a.c mApkDownloadHelper;

    public i(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, cVar, aVar, false);
    }

    public i(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, boolean z) {
        this.Ln = false;
        this.Ln = z;
        this.Ll = new Handler(Looper.getMainLooper());
        this.Lk = bVar;
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.ah(1);
        }
        this.bJ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.Lk.wh()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.DS = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        if (!this.Lk.agf) {
            if (this.bJ != null) {
                handler = this.Ll;
                runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.i.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (i.this.bJ != null) {
                            i.this.bJ.a(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.Ll;
        runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.i.1
            @Override // java.lang.Runnable
            public final void run() {
                if (i.this.Lk.agg || aVar.Mv) {
                    com.kwad.components.core.c.a.a.a(i.this.Lk.Gl.getContext(), i.this.Lk.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.i.1.1
                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            if (i.this.bJ != null) {
                                i.this.bJ.a(aVar);
                            }
                        }
                    }, i.this.mApkDownloadHelper, aVar.Mv, i.this.Ln);
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Ll.removeCallbacksAndMessages(null);
        this.bJ = null;
    }
}

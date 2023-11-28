package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class be implements com.kwad.sdk.core.webview.c.a {
    public static Handler XX;
    public com.kwad.components.core.e.d.c Kx;
    public com.kwad.sdk.core.webview.b XW;
    public b XY;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int kk;
    }

    /* loaded from: classes10.dex */
    public interface b {
        @MainThread
        void Q(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public be(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, b bVar2) {
        this.XW = bVar;
        this.Kx = cVar;
        this.XY = bVar2;
        if (XX == null) {
            XX = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.kk;
            XX.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.be.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (be.this.XY != null) {
                        be.this.XY.Q(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }
}

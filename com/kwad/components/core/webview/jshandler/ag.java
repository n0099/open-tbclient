package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class ag implements com.kwad.sdk.core.webview.kwai.a {
    public static Handler MX;
    public com.kwad.components.core.c.a.c DV;
    public com.kwad.sdk.core.webview.b MW;
    public b MY;

    @KsJson
    /* loaded from: classes9.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int gJ;
    }

    /* loaded from: classes9.dex */
    public interface b {
        @MainThread
        void al(int i);
    }

    public ag(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.c.a.c cVar, b bVar2) {
        this.MW = bVar;
        this.DV = cVar;
        this.MY = bVar2;
        if (MX == null) {
            MX = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.gJ;
            MX.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ag.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ag.this.MY != null) {
                        ag.this.MY.al(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}

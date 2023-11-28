package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class aa implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;
    public boolean Wc;
    public Handler Wk;
    public boolean Wo;
    public boolean Wp;
    @Nullable
    public com.kwad.sdk.core.webview.d.a.a cR;
    @Nullable
    public final com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, byte b) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z, boolean z2, boolean z3) {
        this.Wc = false;
        this.Wo = false;
        this.Wp = false;
        this.Wc = z;
        this.Wk = new Handler(Looper.getMainLooper());
        this.VP = bVar;
        this.mApkDownloadHelper = cVar;
        this.Wo = false;
        if (cVar != null) {
            cVar.aq(1);
        }
        this.cR = aVar;
        this.Wp = z3;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.VP.FE()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.Kq = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (this.VP.aCI) {
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.aa.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (!aa.this.VP.aCJ && !aVar.Xl) {
                        return;
                    }
                    aa.this.VP.getAdTemplate();
                    com.kwad.components.core.e.d.a.a(aa.this.VP.Ov.getContext(), aa.this.VP.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.aa.1.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            if (aa.this.cR != null) {
                                aa.this.cR.a(aVar);
                            }
                        }
                    }, aa.this.mApkDownloadHelper, aVar.Xl, aa.this.Wc, aa.this.Wo, aa.this.Wp);
                }
            });
        } else if (this.cR != null) {
            this.Wk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.aa.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (aa.this.cR != null) {
                        aa.this.cR.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Wk.removeCallbacksAndMessages(null);
        this.cR = null;
    }
}

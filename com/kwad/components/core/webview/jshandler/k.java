package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.components.core.e.d.c Kx;
    public KsAppDownloadListener Vt;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public com.kwad.sdk.core.webview.c.c nr;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String VO;
        public String packageName;
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    public k(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    private synchronized void l(String str, String str2) {
        this.Kx = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.Vt == null) {
            KsAppDownloadListener sa = sa();
            this.Vt = sa;
            this.Kx.b(sa);
        }
    }

    public static boolean m(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, int i2) {
        if (this.nr != null) {
            b bVar = new b();
            bVar.status = i;
            bVar.progress = i2;
            this.nr.a(bVar);
        }
    }

    private KsAppDownloadListener sa() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.k.1
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                k.this.r(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    k.this.r(1, 0);
                } else {
                    k.this.r(2, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                k.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                k.this.r(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                k.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                k.this.r(12, 100);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nr = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nr = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (m(aVar.VO, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.Kx == null) {
                l(aVar.VO, aVar.packageName);
            }
            a.C0644a ar = new a.C0644a(this.mContext).ao(true).ap(false).aq(this.mAdTemplate).ar(false);
            if (this.Kx.t(ar)) {
                return;
            }
            this.Kx.d(this.Vt);
            this.Kx.s(ar);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }
}

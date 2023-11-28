package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public com.kwad.components.core.e.d.c Kx;
    public WebView NP;
    public boolean Vi;
    public KsAppDownloadListener Vt;
    public int Vu = -100;
    public int Vv = 0;
    public com.kwad.sdk.core.webview.b cO;
    public AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0663a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.NP = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.cO = bVar;
    }

    private void k(String str, String str2) {
        WebView webView;
        if (this.Vi || TextUtils.isEmpty(str) || (webView = this.NP) == null) {
            return;
        }
        bt.a(webView, str, str2);
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, int i2) {
        this.Vv = i2;
        if (this.Vu != i) {
            this.Vu = i;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            k("onDownLoadStatusCallback", sb.toString());
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (m(str, str2)) {
            return 0;
        }
        if (this.Kx == null) {
            l(str, str2);
        }
        return this.Kx.nM();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (m(str, str2)) {
            return 0;
        }
        if (this.Kx == null) {
            l(str, str2);
        }
        return this.Vv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(String str) {
        try {
            C0663a c0663a = new C0663a();
            c0663a.parseJson(new JSONObject(str));
            if (m(c0663a.url, c0663a.packageName)) {
                return;
            }
            if (this.Kx == null) {
                l(c0663a.url, c0663a.packageName);
            }
            a.C0644a ar = new a.C0644a(this.cO.NP.getContext()).ao(true).ap(false).aq(this.mAdTemplate).ar(false);
            if (this.Kx.t(ar)) {
                return;
            }
            this.Kx.d(this.Vt);
            this.Kx.s(ar);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private KsAppDownloadListener sa() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.r(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    a.this.r(1, 0);
                } else {
                    a.this.r(2, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.r(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.r(12, 100);
            }
        };
    }

    public final void destroy() {
        this.Vi = true;
        com.kwad.components.core.e.d.c cVar = this.Kx;
        if (cVar != null) {
            cVar.c(this.Vt);
        }
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(final String str) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.az(str);
            }
        });
    }
}

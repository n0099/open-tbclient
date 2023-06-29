package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public c DV;
    public WebView Fv;
    public boolean KE;
    public KsAppDownloadListener KW;
    public int KX = -100;
    public int KY = 0;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0653a extends com.kwad.sdk.core.response.kwai.a {
        public String packageName;
        public String url;
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.Fv = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.mJsBridgeContext = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(String str) {
        try {
            C0653a c0653a = new C0653a();
            c0653a.parseJson(new JSONObject(str));
            if (k(c0653a.url, c0653a.packageName)) {
                return;
            }
            if (this.DV == null) {
                j(c0653a.url, c0653a.packageName);
            }
            if (this.DV.mR()) {
                return;
            }
            this.DV.d(this.KW);
            this.DV.m(new a.C0641a(this.mJsBridgeContext.Fv.getContext()).aj(true).ak(false).L(this.mAdTemplate).am(false));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    private void h(String str, String str2) {
        WebView webView;
        if (this.KE || TextUtils.isEmpty(str) || (webView = this.Fv) == null) {
            return;
        }
        bh.a(webView, str, str2);
    }

    private synchronized void j(String str, String str2) {
        this.DV = new c(this.mAdTemplate, null, str, str2);
        if (this.KW == null) {
            KsAppDownloadListener pu = pu();
            this.KW = pu;
            this.DV.b(pu);
        }
    }

    public static boolean k(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, int i2) {
        this.KY = i2;
        if (this.KX != i) {
            this.KX = i;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            h("onDownLoadStatusCallback", sb.toString());
        }
    }

    private KsAppDownloadListener pu() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.m(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.m(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.m(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.m(12, 100);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                a.this.m(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    a.this.m(1, 0);
                } else {
                    a.this.m(2, i);
                }
            }
        };
    }

    public final void destroy() {
        this.KE = true;
        c cVar = this.DV;
        if (cVar != null) {
            cVar.c(this.KW);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (k(str, str2)) {
            return 0;
        }
        if (this.DV == null) {
            j(str, str2);
        }
        return this.DV.mI();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (k(str, str2)) {
            return 0;
        }
        if (this.DV == null) {
            j(str, str2);
        }
        return this.KY;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(final String str) {
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aD(str);
            }
        });
    }
}

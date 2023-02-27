package com.kwad.components.core.webview.kwai;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class c extends com.kwad.components.core.webview.kwai.a {
    public long KK;
    public boolean KQ;
    public a gX;

    /* loaded from: classes8.dex */
    public static class a {
        public boolean KN;
        public KsAdWebView.b KR;
        public u.b KS;
        public KsAdWebView.c KU;
        public AdTemplate mAdTemplate;
        public final Context mContext;
        public KsAdWebView.d rb;
        public boolean KT = true;
        public boolean KV = true;
        public boolean KP = true;

        public a(Context context) {
            this.mContext = context;
        }

        public final a R(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final a a(KsAdWebView.b bVar) {
            this.KR = bVar;
            return this;
        }

        public final a a(KsAdWebView.c cVar) {
            this.KU = cVar;
            return this;
        }

        public final a aA(boolean z) {
            this.KV = z;
            return this;
        }

        public final a aB(boolean z) {
            this.KT = z;
            return this;
        }

        public final a aC(boolean z) {
            this.KN = true;
            return this;
        }

        public final a b(KsAdWebView.d dVar) {
            this.rb = dVar;
            return this;
        }

        public final a b(u.b bVar) {
            this.KS = bVar;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final u.b getClientParams() {
            return this.KS;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.c getOnWebViewScrollChangeListener() {
            return this.KU;
        }

        public final KsAdWebView.d getWebListener() {
            return this.rb;
        }

        public final KsAdWebView.b kS() {
            return this.KR;
        }

        public final boolean pq() {
            return this.KV;
        }

        public final boolean pr() {
            return this.KP;
        }

        public final boolean ps() {
            return this.KT;
        }

        public final boolean pt() {
            return this.KN;
        }
    }

    public final void aC(String str) {
        this.mUniqueId = str;
    }

    public final a getClientConfig() {
        return this.gX;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.components.a.b.b.r(this.mUniqueId, "onPageFinished");
        a aVar = this.gX;
        if (aVar != null && aVar.pt() && !this.KQ) {
            this.KQ = true;
            if (this.KK > 0) {
                if (this.gX.getClientParams() == null) {
                    this.gX.b(new u.b());
                }
                this.gX.getClientParams().abR = System.currentTimeMillis() - this.KK;
                this.KK = -1L;
            }
            com.kwad.sdk.core.report.a.c(this.gX.getAdTemplate(), this.gX.getClientParams());
        }
        a aVar2 = this.gX;
        if (aVar2 == null || aVar2.getWebListener() == null) {
            return;
        }
        this.gX.getWebListener().bw();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.components.a.b.b.r(this.mUniqueId, "onPageStart");
        a aVar = this.gX;
        if (aVar == null || aVar.getWebListener() == null) {
            return;
        }
        this.gX.getWebListener().bv();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.kwad.sdk.core.e.b.d("KsAdWebViewClient", "onReceivedError " + i);
        a aVar = this.gX;
        if (aVar != null && aVar.getWebListener() != null) {
            this.gX.getWebListener().a(i, str, str2);
        }
        com.kwad.components.a.b.b.t(str2, str);
        a aVar2 = this.gX;
        if (aVar2 == null || !aVar2.pt()) {
            return;
        }
        com.kwad.sdk.core.report.a.e(this.gX.getAdTemplate(), this.gX.getClientParams());
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void r(long j) {
        this.KK = j;
    }

    public final void setClientConfig(a aVar) {
        this.gX = aVar;
        setNeedHybridLoad(aVar.pr());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.e.b.e("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.components.a.b.b.r(this.mUniqueId, "shouldOverrideUrlLoading");
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                if (this.gX != null && this.gX.pq()) {
                    int s = com.kwad.sdk.core.download.kwai.b.s(this.gX.getContext(), str);
                    if (s == 1) {
                        if (this.gX.kS() != null) {
                            this.gX.kS().onSuccess();
                        }
                        com.kwad.sdk.core.report.a.j(this.gX.getAdTemplate(), 2);
                        return true;
                    }
                    if (this.gX.kS() != null) {
                        this.gX.kS().kU();
                    }
                    if (s == -1) {
                        com.kwad.sdk.core.report.a.k(this.gX.getAdTemplate(), 2);
                    }
                }
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (this.gX != null) {
                this.gX.getContext().startActivity(intent);
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}

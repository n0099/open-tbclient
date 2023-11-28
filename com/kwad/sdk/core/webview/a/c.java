package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    public a HE;

    /* loaded from: classes10.dex */
    public static class a {
        public KsAdWebView.c OA;
        public KsAdWebView.d aCV;
        public KsAdWebView.b aCW;
        public boolean aCZ;
        public y.b awZ;
        public AdTemplate mAdTemplate;
        public final Context mContext;
        public boolean aCX = true;
        public boolean aCY = true;
        public boolean aCU = true;
        public boolean aDa = false;
        public long aDb = 600;
        public long aDc = 0;

        public a(Context context) {
            this.mContext = context;
        }

        public final a a(KsAdWebView.b bVar) {
            this.aCW = bVar;
            return this;
        }

        public final void an(long j) {
            this.aDc = j;
        }

        public final a b(y.b bVar) {
            this.awZ = bVar;
            return this;
        }

        public final a bs(boolean z) {
            this.aDa = true;
            return this;
        }

        public final a bt(boolean z) {
            this.aCY = z;
            return this;
        }

        public final a bu(boolean z) {
            this.aCX = z;
            return this;
        }

        public final a bv(boolean z) {
            this.aCZ = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.OA = cVar;
            return this;
        }

        public final a eh(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        private boolean FG() {
            return this.aDa;
        }

        public final boolean FH() {
            return this.aCY;
        }

        public final boolean FI() {
            return this.aCU;
        }

        public final boolean FJ() {
            return this.aCX;
        }

        public final boolean FK() {
            return this.aCZ;
        }

        public final boolean FL() {
            if (!FG()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.aDc;
            if (j > 0 && currentTimeMillis - j <= this.aDb) {
                return true;
            }
            return false;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final y.b getClientParams() {
            return this.awZ;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.d ih() {
            return this.aCV;
        }

        public final KsAdWebView.b ma() {
            return this.aCW;
        }

        public final KsAdWebView.c pq() {
            return this.OA;
        }

        public final a b(KsAdWebView.d dVar) {
            this.aCV = dVar;
            return this;
        }
    }

    public final a getClientConfig() {
        return this.HE;
    }

    private boolean ep(String str) {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                if (this.HE != null && this.HE.FH()) {
                    int D = com.kwad.sdk.core.download.a.b.D(this.HE.getContext(), str);
                    if (D == 1) {
                        if (this.HE.ma() != null) {
                            this.HE.ma().onSuccess();
                        }
                        com.kwad.sdk.core.report.a.a(this.HE.getAdTemplate(), "", 2, (y.b) null);
                    } else {
                        if (this.HE.ma() != null) {
                            this.HE.ma().onFailed();
                        }
                        if (D == -1) {
                            com.kwad.sdk.core.report.a.b(this.HE.getAdTemplate(), "", 2, null);
                        }
                    }
                    return true;
                }
                return false;
            }
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
            if (this.HE != null) {
                this.HE.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    public final void K(String str) {
        this.mUniqueId = str;
    }

    public final void setClientConfig(a aVar) {
        this.HE = aVar;
        setNeedHybridLoad(aVar.FI());
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.ac(this.mUniqueId, "onPageFinished");
        a aVar = this.HE;
        if (aVar != null && aVar.ih() != null) {
            this.HE.ih().onPageFinished();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) {
            z = true;
        } else {
            z = false;
        }
        if (z || super.onRenderProcessGone(webView, renderProcessGoneDetail)) {
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.e.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.ac(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.HE;
        if (aVar != null && aVar.FL() && !ep(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.ac(this.mUniqueId, "onPageStart");
        a aVar = this.HE;
        if (aVar != null && aVar.ih() != null) {
            this.HE.ih().onPageStart();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.kwad.sdk.core.e.c.d("KsAdWebViewClient", "onReceivedError " + i);
        a aVar = this.HE;
        if (aVar != null && aVar.ih() != null) {
            this.HE.ih().onReceivedHttpError(i, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.ae(str2, str);
    }
}

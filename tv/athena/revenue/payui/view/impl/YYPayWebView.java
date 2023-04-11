package tv.athena.revenue.payui.view.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.aab;
import com.baidu.tieba.c9b;
import com.baidu.tieba.cab;
import com.baidu.tieba.d9b;
import com.baidu.tieba.uab;
import com.baidu.tieba.vab;
import com.baidu.tieba.z6b;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import java.net.URL;
import java.util.Locale;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes9.dex */
public class YYPayWebView extends LinearLayout implements cab, vab.h {
    public c a;
    public WebView b;
    public boolean c;
    public boolean d;
    public Context e;

    /* loaded from: classes9.dex */
    public interface c {
        void b(NativeOperationParams nativeOperationParams);

        void c(d9b d9bVar, c9b c9bVar);

        void d(WebView webView, String str);

        void e(c9b c9bVar);

        String getToken();
    }

    @Override // com.baidu.tieba.cab
    public void attachWindow(Window window) {
    }

    @Override // com.baidu.tieba.cab
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.cab
    public void refreshView() {
    }

    @Override // com.baidu.tieba.cab
    public void refreshWindow(WindowParams windowParams) {
    }

    /* loaded from: classes9.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            RLog.info("YYPayWebView", "onPageFinished: url:" + aab.a(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            RLog.info("YYPayWebView", "onPageStarted: url:" + aab.a(str));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (Build.VERSION.SDK_INT >= 23 && webResourceRequest.isForMainFrame()) {
                RLog.error("YYPayWebView", "onReceivedHttpError: statusCode" + webResourceResponse.getStatusCode(), new Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (sslError != null) {
                str = sslError.toString();
            } else {
                str = "";
            }
            RLog.error("YYPayWebView", "onReceivedSslError: errorMsg" + str, new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            RLog.error("YYPayWebView", "onReceivedError: statusCode" + i + ", desc=" + str, new Object[0]);
            YYPayWebView.this.l();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            RLog.info("YYPayWebView", "OriginalUrl : " + webView.getOriginalUrl());
            RLog.info("YYPayWebView", "shouldOverrideUrlLoading url = " + str);
            if (str == null) {
                return false;
            }
            RLog.info("YYPayWebView", "shouldOverrideUrlLoading url:" + str);
            try {
                if (str.startsWith("upwrp://")) {
                    YYPayWebView.this.e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } else if (str.endsWith("html/help/download.html")) {
                    try {
                        YYPayWebView.this.e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    } catch (Exception e) {
                        RLog.error("YYPayWebView", "shouldOverrideUrlLoading exception:" + e.getLocalizedMessage(), new Object[0]);
                    }
                    return true;
                } else {
                    if (YYPayWebView.this.a != null) {
                        YYPayWebView.this.a.d(webView, str);
                    }
                    if (str.toLowerCase(Locale.CHINA).startsWith("http") || str.toLowerCase(Locale.CHINA).startsWith("https") || str.toLowerCase(Locale.CHINA).startsWith("file")) {
                        return false;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            } catch (Exception e2) {
                RLog.error("YYPayWebView", "shouldOverrideUrlLoading exception:" + e2.getLocalizedMessage(), new Object[0]);
                return false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (str != null) {
                if (str.contains("500") || str.contains("404")) {
                    RLog.error("YYPayWebView", "onReceivedTitle: contains error: " + str, new Object[0]);
                }
            }
        }
    }

    public YYPayWebView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.vab.h
    public void b(NativeOperationParams nativeOperationParams) {
        if (nativeOperationParams == null) {
            RLog.error("YYPayWebView", "onNativeOperation params = null", new Object[0]);
            return;
        }
        RLog.debug("YYPayWebView", "onNativeOperation params: %s", nativeOperationParams);
        c cVar = this.a;
        if (cVar != null) {
            cVar.b(nativeOperationParams);
        }
    }

    @Override // com.baidu.tieba.vab.h
    public void c(UrlPageParams urlPageParams) {
        if (urlPageParams == null) {
            RLog.error("YYPayWebView", "onUpdateTopUi pageParams is null", new Object[0]);
            return;
        }
        RLog.debug("YYPayWebView", "onUpdateTopUi pageParams: %s", urlPageParams);
        c cVar = this.a;
        if (cVar != null) {
            cVar.e(new c9b(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl, urlPageParams.rightIcon, urlPageParams.rightIconTitle, urlPageParams.rightIconUrl));
        }
    }

    public final String i(String str) {
        Object[] objArr = z6b.a;
        if (objArr == null || objArr.length <= 0 || str == null) {
            return null;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= objArr.length) {
                break;
            } else if (str.equals(objArr[i2])) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        int i3 = i + 1;
        if (i3 >= objArr.length) {
            return null;
        }
        return objArr[i3];
    }

    public void k(String str) {
        RLog.info("YYPayWebView", "loadUrl: " + aab.a(str));
        this.b.loadUrl(str);
    }

    public void setCallback(c cVar) {
        this.a = cVar;
    }

    public YYPayWebView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYPayWebView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
        this.d = true;
        j(context, attributeSet);
    }

    @Override // com.baidu.tieba.vab.h
    public void e(UrlPageParams urlPageParams) {
        if (urlPageParams == null) {
            RLog.error("YYPayWebView", "openPage null pageParams", new Object[0]);
            return;
        }
        RLog.debug("YYPayWebView", "onOpenUrl pageParams: %s", urlPageParams);
        if (this.a != null) {
            this.a.c(new d9b(urlPageParams.url, urlPageParams.pageType), new c9b(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl, urlPageParams.rightIcon, urlPageParams.rightIconTitle, urlPageParams.rightIconUrl));
        }
    }

    @Override // com.baidu.tieba.vab.h
    public String getToken() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.getToken();
        }
        RLog.error("YYPayWebView", "getToken() mCallback null", new Object[0]);
        return "";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = false;
    }

    public final void j(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.pay_ui_layout_pay_wallet_view, (ViewGroup) this, true);
        WebView webView = (WebView) findViewById(R.id.obfuscated_res_0x7f09285f);
        this.b = webView;
        this.e = context;
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            String str = settings.getUserAgentString() + " YYPaySdk(SdkVersion:" + BuildConfig.VERSION_NAME + SmallTailInfo.EMOTION_SUFFIX;
            RLog.info("YYPayWebView", "init newUA:" + str);
            settings.setUserAgentString(str);
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(false);
            settings.setTextZoom(100);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setUseWideViewPort(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        }
        this.b.addJavascriptInterface(new vab(this), "YYPaySdkJsInterface");
        this.b.setWebViewClient(new a());
        if (Build.VERSION.SDK_INT < 23) {
            this.b.setWebChromeClient(new b());
        }
        uab.a(this.b);
        this.d = !Env.instance().isTestEnv();
        RLog.info("YYPayWebView", "isEnableBackupDomain=" + this.d);
    }

    public final void l() {
        String str;
        if (!this.d) {
            return;
        }
        if (!this.c) {
            RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, cur has detached from window");
            return;
        }
        WebView webView = this.b;
        if (webView != null) {
            str = webView.getUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, invalid url");
            return;
        }
        try {
            String host = new URL(str).getHost();
            String str2 = str.split(host)[1];
            String i = i("https://" + host);
            if (!TextUtils.isEmpty(i)) {
                RLog.info("YYPayWebView", "reloadWithBackupDomains: load empty page before retry");
                this.b.stopLoading();
                this.b.loadUrl("about:blank");
                k(i + str2);
            }
        } catch (Exception e) {
            RLog.error("YYPayWebView", "reloadWithBackupDomains: error=" + Log.getStackTraceString(e), new Object[0]);
        }
    }
}

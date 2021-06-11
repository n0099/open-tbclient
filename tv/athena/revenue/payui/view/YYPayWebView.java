package tv.athena.revenue.payui.view;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import i.a.a.e.l.d;
import i.a.a.e.l.e;
import i.a.a.e.p.b;
import java.net.URL;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes8.dex */
public class YYPayWebView extends LinearLayout implements i.a.a.e.o.a, b.f {

    /* renamed from: e  reason: collision with root package name */
    public c f72959e;

    /* renamed from: f  reason: collision with root package name */
    public WebView f72960f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72961g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72962h;

    /* loaded from: classes8.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            RLog.error("YYPayWebView", "onReceivedError: statusCode" + i2 + ", desc=" + str, new Object[0]);
            YYPayWebView.this.i();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (Build.VERSION.SDK_INT < 23 || !webResourceRequest.isForMainFrame()) {
                return;
            }
            RLog.error("YYPayWebView", "onReceivedHttpError: statusCode" + webResourceResponse.getStatusCode(), new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            RLog.debug("YYPayWebView", "shouldOverrideUrlLoading->url:" + str);
            YYPayWebView.this.f72960f.loadUrl(str);
            if (YYPayWebView.this.f72959e != null) {
                YYPayWebView.this.f72959e.onUrlLoading(webView, str);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (str != null) {
                if (str.contains("500") || str.contains(XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH)) {
                    RLog.error("YYPayWebView", "onReceivedTitle: contains error: " + str, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);

        void onOpenNewUrl(e eVar, d dVar);

        void onUpdateTopUi(d dVar);

        void onUrlLoading(WebView webView, String str);
    }

    public YYPayWebView(Context context) {
        this(context, null);
    }

    @Override // i.a.a.e.p.b.f
    public void a(UrlPageParams urlPageParams) {
        if (urlPageParams == null) {
            RLog.error("YYPayWebView", "onUpdateTopUi pageParams is null", new Object[0]);
            return;
        }
        RLog.debug("YYPayWebView", "onUpdateTopUi pageParams: %s", urlPageParams);
        c cVar = this.f72959e;
        if (cVar != null) {
            cVar.onUpdateTopUi(new d(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
        }
    }

    @Override // i.a.a.e.p.b.f
    public void b(UrlPageParams urlPageParams) {
        if (urlPageParams == null) {
            RLog.error("YYPayWebView", "openPage null pageParams", new Object[0]);
            return;
        }
        RLog.debug("YYPayWebView", "onOpenUrl pageParams: %s", urlPageParams);
        if (this.f72959e != null) {
            this.f72959e.onOpenNewUrl(new e(urlPageParams.url, urlPageParams.pageType), new d(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
        }
    }

    public final String f(String str) {
        Object[] objArr = i.a.a.e.j.a.f72085a;
        if (objArr == null || objArr.length <= 0 || str == null) {
            return null;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= objArr.length) {
                break;
            } else if (str.equals(objArr[i3])) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        int i4 = i2 + 1;
        if (i4 < objArr.length) {
            return objArr[i4];
        }
        return null;
    }

    public final void g(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(i.a.a.e.e.pay_ui_layout_pay_wallet_view, (ViewGroup) this, true);
        WebView webView = (WebView) findViewById(i.a.a.e.d.webview);
        this.f72960f = webView;
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(false);
            settings.setTextZoom(100);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setUseWideViewPort(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        }
        this.f72960f.addJavascriptInterface(new i.a.a.e.p.b(this), "YYPaySdkJsInterface");
        this.f72960f.setWebViewClient(new a());
        if (Build.VERSION.SDK_INT < 23) {
            this.f72960f.setWebChromeClient(new b());
        }
        i.a.a.e.p.a.a(this.f72960f);
        this.f72962h = !Env.instance().isTestEnv();
        RLog.info("YYPayWebView", "isEnableBackupDomain=" + this.f72962h);
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        return this;
    }

    @Override // i.a.a.e.p.b.f
    public String getToken() {
        c cVar = this.f72959e;
        if (cVar != null) {
            return cVar.getToken();
        }
        RLog.error("YYPayWebView", "getToken() mCallback null", new Object[0]);
        return "";
    }

    public void h(String str) {
        RLog.info("YYPayWebView", "loadUrl: " + str);
        this.f72960f.loadUrl(str);
    }

    public final void i() {
        if (this.f72962h) {
            if (!this.f72961g) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, cur has detached from window");
                return;
            }
            WebView webView = this.f72960f;
            String url = webView != null ? webView.getUrl() : null;
            if (TextUtils.isEmpty(url)) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, invalid url");
                return;
            }
            try {
                String host = new URL(url).getHost();
                String str = url.split(host)[1];
                String f2 = f("https://" + host);
                if (TextUtils.isEmpty(f2)) {
                    return;
                }
                RLog.info("YYPayWebView", "reloadWithBackupDomains: load empty page before retry");
                this.f72960f.stopLoading();
                this.f72960f.loadUrl("about:blank");
                h(f2 + str);
            } catch (Exception e2) {
                RLog.error("YYPayWebView", "reloadWithBackupDomains: error=" + Log.getStackTraceString(e2), new Object[0]);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f72961g = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f72961g = false;
    }

    @Override // i.a.a.e.p.b.f
    public void onNativeOperation(NativeOperationParams nativeOperationParams) {
        if (nativeOperationParams == null) {
            RLog.error("YYPayWebView", "onNativeOperation params = null", new Object[0]);
            return;
        }
        RLog.debug("YYPayWebView", "onNativeOperation params: %s", nativeOperationParams);
        c cVar = this.f72959e;
        if (cVar != null) {
            cVar.onNativeOperation(nativeOperationParams);
        }
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
    }

    public void setCallback(c cVar) {
        this.f72959e = cVar;
    }

    public YYPayWebView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYPayWebView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f72961g = true;
        this.f72962h = true;
        g(context, attributeSet);
    }
}

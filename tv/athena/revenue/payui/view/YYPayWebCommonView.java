package tv.athena.revenue.payui.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import d.r.b.a.a.f.d.d;
import i.a.a.e.c;
import i.a.a.e.j.e;
import i.a.a.e.j.f;
import i.a.a.e.n.b;
import tv.athena.revenue.payui.controller.IYYPayCallback;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes8.dex */
public class YYPayWebCommonView extends LinearLayout implements i.a.a.e.m.a, b.c {

    /* renamed from: e  reason: collision with root package name */
    public a f69592e;

    /* renamed from: f  reason: collision with root package name */
    public WebView f69593f;

    /* loaded from: classes8.dex */
    public interface a {
        String getToken();

        void onNativeOperation(i.a.a.e.j.a aVar);

        void onOpenNewUrl(f fVar, e eVar);

        void onUpdateTopUi(e eVar);
    }

    public YYPayWebCommonView(Context context) {
        this(context, null);
    }

    @Override // i.a.a.e.n.b.c
    public void a(UrlPageParams urlPageParams) {
        if (urlPageParams == null) {
            d.e("YYPayWalletView", "onUpdateTopUi pageParams is null", new Object[0]);
            return;
        }
        d.g("YYPayWalletView", "onUpdateTopUi pageParams: %s", urlPageParams);
        a aVar = this.f69592e;
        if (aVar != null) {
            aVar.onUpdateTopUi(new e(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
        }
    }

    @Override // i.a.a.e.n.b.c
    public void b(UrlPageParams urlPageParams) {
        if (urlPageParams == null) {
            d.e("YYPayWalletView", "openPage null pageParams", new Object[0]);
            return;
        }
        d.g("YYPayWalletView", "onOpenUrl pageParams: %s", urlPageParams);
        if (this.f69592e != null) {
            this.f69592e.onOpenNewUrl(new f(IYYPayCallback.Code.OPEN_URL_FROM_WALLET, urlPageParams.url, urlPageParams.pageType), new e(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(i.a.a.e.d.yy_layout_pay_wallet_view, (ViewGroup) this, true);
        WebView webView = (WebView) findViewById(c.webview);
        this.f69593f = webView;
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
        this.f69593f.addJavascriptInterface(new b(this), "YYPaySdkJsInterface");
        i.a.a.e.n.a.a(this.f69593f);
    }

    public void d(String str) {
        this.f69593f.loadUrl(str);
    }

    @Override // i.a.a.e.m.a
    public View getContentView() {
        return this;
    }

    @Override // i.a.a.e.n.b.c
    public String getToken() {
        a aVar = this.f69592e;
        if (aVar != null) {
            return aVar.getToken();
        }
        d.e("YYPayWalletView", "getToken() mCallback null", new Object[0]);
        return "";
    }

    @Override // i.a.a.e.n.b.c
    public void onNativeOperation(i.a.a.e.j.a aVar) {
        if (aVar == null) {
            d.e("YYPayWalletView", "onNativeOperation params = null", new Object[0]);
            return;
        }
        d.g("YYPayWalletView", "onNativeOperation params: %s", aVar);
        a aVar2 = this.f69592e;
        if (aVar2 != null) {
            aVar2.onNativeOperation(aVar);
        }
    }

    public void setCallback(a aVar) {
        this.f69592e = aVar;
    }

    public YYPayWebCommonView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYPayWebCommonView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}

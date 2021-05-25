package d.a.n0.r1.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.searchbox.live.interfaces.browser.IBrowserView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.medialive.browser.HkWebView;
import d.a.c.a.j;
/* loaded from: classes3.dex */
public class a implements IBrowserView {

    /* renamed from: a  reason: collision with root package name */
    public HkWebView f59884a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f59885b;

    /* renamed from: c  reason: collision with root package name */
    public View f59886c;

    /* renamed from: d  reason: collision with root package name */
    public View f59887d;

    /* renamed from: e  reason: collision with root package name */
    public View f59888e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f59889f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59890g = false;

    /* renamed from: d.a.n0.r1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1562a extends WebViewClient {
        public C1562a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            a.this.i();
            if (a.this.f59889f != null) {
                a.this.f59889f.onHideLoading();
            }
            if (a.this.f59890g) {
                a.this.j();
                if (a.this.f59889f != null) {
                    a.this.f59889f.onLoadFailure();
                }
            } else if (a.this.f59889f != null) {
                a.this.f59889f.onLoadSuccess();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a.this.f59890g = false;
            a.this.k();
            a.this.h();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            a.this.f59890g = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            a.this.f59890g = true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Activity b2;
            if (TextUtils.isEmpty(str) || (b2 = d.a.c.a.b.f().b()) == null) {
                return false;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(b2), new String[]{str}, true);
            return true;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i2) {
        HkWebView hkWebView = this.f59884a;
        if (hkWebView != null) {
            return hkWebView.canScrollVertically(i2);
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public View getView(Context context) {
        if (this.f59885b == null) {
            this.f59885b = new FrameLayout(context);
        }
        if (this.f59888e == null) {
            View view = new View(context);
            this.f59888e = view;
            view.setBackgroundColor(context.getResources().getColor(17170443));
        }
        if (this.f59884a == null) {
            HkWebView hkWebView = new HkWebView(context);
            this.f59884a = hkWebView;
            hkWebView.setWebViewClient(new C1562a());
        }
        this.f59885b.addView(this.f59884a);
        return this.f59885b;
    }

    public final void h() {
        if (this.f59887d != null && this.f59888e.getParent() != null) {
            ((ViewGroup) this.f59888e.getParent()).removeView(this.f59888e);
        }
        View view = this.f59886c;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f59886c.getParent()).removeView(this.f59886c);
    }

    public final void i() {
        if (this.f59887d != null && this.f59888e.getParent() != null) {
            ((ViewGroup) this.f59888e.getParent()).removeView(this.f59888e);
        }
        View view = this.f59887d;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f59887d.getParent()).removeView(this.f59887d);
    }

    public final void j() {
        View view;
        View view2;
        if (this.f59885b != null && (view2 = this.f59888e) != null && view2.getParent() == null) {
            this.f59885b.addView(this.f59888e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f59885b == null || (view = this.f59886c) == null || view.getParent() != null) {
            return;
        }
        this.f59885b.addView(this.f59886c, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void k() {
        View view;
        View view2;
        if (this.f59885b != null && (view2 = this.f59888e) != null && view2.getParent() == null) {
            this.f59885b.addView(this.f59888e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f59885b == null || (view = this.f59887d) == null || view.getParent() != null) {
            return;
        }
        this.f59885b.addView(this.f59887d, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        HkWebView hkWebView = this.f59884a;
        if (hkWebView != null) {
            hkWebView.loadUrl(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        this.f59884a = null;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        HkWebView hkWebView = this.f59884a;
        if (hkWebView != null) {
            hkWebView.reload();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDynamicDispatcherEnabled(boolean z) {
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setErrorView(View view) {
        this.f59886c = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        this.f59887d = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        this.f59889f = onBrowserStatusChangeCallBack;
    }
}

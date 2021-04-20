package d.b.i0.q1.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.searchbox.live.interfaces.browser.IBrowserView;
/* loaded from: classes3.dex */
public class a implements IBrowserView {

    /* renamed from: a  reason: collision with root package name */
    public WebView f60459a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f60460b;

    /* renamed from: c  reason: collision with root package name */
    public View f60461c;

    /* renamed from: d  reason: collision with root package name */
    public View f60462d;

    /* renamed from: e  reason: collision with root package name */
    public View f60463e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f60464f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60465g = false;

    /* renamed from: d.b.i0.q1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1513a extends WebViewClient {
        public C1513a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            a.this.i();
            if (a.this.f60464f != null) {
                a.this.f60464f.onHideLoading();
            }
            if (a.this.f60465g) {
                a.this.j();
                if (a.this.f60464f != null) {
                    a.this.f60464f.onLoadFailure();
                }
            } else if (a.this.f60464f != null) {
                a.this.f60464f.onLoadSuccess();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a.this.f60465g = false;
            a.this.k();
            a.this.h();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            a.this.f60465g = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            a.this.f60465g = true;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i) {
        WebView webView = this.f60459a;
        if (webView != null) {
            return webView.canScrollVertically(i);
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public View getView(Context context) {
        if (this.f60460b == null) {
            this.f60460b = new FrameLayout(context);
        }
        if (this.f60463e == null) {
            View view = new View(context);
            this.f60463e = view;
            view.setBackgroundColor(context.getResources().getColor(17170443));
        }
        if (this.f60459a == null) {
            WebView webView = new WebView(context);
            this.f60459a = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            this.f60459a.setWebViewClient(new C1513a());
        }
        this.f60460b.addView(this.f60459a);
        return this.f60460b;
    }

    public final void h() {
        if (this.f60462d != null && this.f60463e.getParent() != null) {
            ((ViewGroup) this.f60463e.getParent()).removeView(this.f60463e);
        }
        View view = this.f60461c;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f60461c.getParent()).removeView(this.f60461c);
    }

    public final void i() {
        if (this.f60462d != null && this.f60463e.getParent() != null) {
            ((ViewGroup) this.f60463e.getParent()).removeView(this.f60463e);
        }
        View view = this.f60462d;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f60462d.getParent()).removeView(this.f60462d);
    }

    public final void j() {
        View view;
        View view2;
        if (this.f60460b != null && (view2 = this.f60463e) != null && view2.getParent() == null) {
            this.f60460b.addView(this.f60463e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f60460b == null || (view = this.f60461c) == null || view.getParent() != null) {
            return;
        }
        this.f60460b.addView(this.f60461c, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void k() {
        View view;
        View view2;
        if (this.f60460b != null && (view2 = this.f60463e) != null && view2.getParent() == null) {
            this.f60460b.addView(this.f60463e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f60460b == null || (view = this.f60462d) == null || view.getParent() != null) {
            return;
        }
        this.f60460b.addView(this.f60462d, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        WebView webView = this.f60459a;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        this.f60459a = null;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        WebView webView = this.f60459a;
        if (webView != null) {
            webView.reload();
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
        this.f60461c = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        this.f60462d = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        this.f60464f = onBrowserStatusChangeCallBack;
    }
}

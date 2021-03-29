package d.b.i0.p1.e;

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
    public WebView f58791a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f58792b;

    /* renamed from: c  reason: collision with root package name */
    public View f58793c;

    /* renamed from: d  reason: collision with root package name */
    public View f58794d;

    /* renamed from: e  reason: collision with root package name */
    public View f58795e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f58796f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58797g = false;

    /* renamed from: d.b.i0.p1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1450a extends WebViewClient {
        public C1450a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            a.this.i();
            if (a.this.f58796f != null) {
                a.this.f58796f.onHideLoading();
            }
            if (a.this.f58797g) {
                a.this.j();
                if (a.this.f58796f != null) {
                    a.this.f58796f.onLoadFailure();
                }
            } else if (a.this.f58796f != null) {
                a.this.f58796f.onLoadSuccess();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a.this.f58797g = false;
            a.this.k();
            a.this.h();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            a.this.f58797g = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            a.this.f58797g = true;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i) {
        WebView webView = this.f58791a;
        if (webView != null) {
            return webView.canScrollVertically(i);
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public View getView(Context context) {
        if (this.f58792b == null) {
            this.f58792b = new FrameLayout(context);
        }
        if (this.f58795e == null) {
            View view = new View(context);
            this.f58795e = view;
            view.setBackgroundColor(context.getResources().getColor(17170443));
        }
        if (this.f58791a == null) {
            WebView webView = new WebView(context);
            this.f58791a = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            this.f58791a.setWebViewClient(new C1450a());
        }
        this.f58792b.addView(this.f58791a);
        return this.f58792b;
    }

    public final void h() {
        if (this.f58794d != null && this.f58795e.getParent() != null) {
            ((ViewGroup) this.f58795e.getParent()).removeView(this.f58795e);
        }
        View view = this.f58793c;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f58793c.getParent()).removeView(this.f58793c);
    }

    public final void i() {
        if (this.f58794d != null && this.f58795e.getParent() != null) {
            ((ViewGroup) this.f58795e.getParent()).removeView(this.f58795e);
        }
        View view = this.f58794d;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f58794d.getParent()).removeView(this.f58794d);
    }

    public final void j() {
        View view;
        View view2;
        if (this.f58792b != null && (view2 = this.f58795e) != null && view2.getParent() == null) {
            this.f58792b.addView(this.f58795e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f58792b == null || (view = this.f58793c) == null || view.getParent() != null) {
            return;
        }
        this.f58792b.addView(this.f58793c, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void k() {
        View view;
        View view2;
        if (this.f58792b != null && (view2 = this.f58795e) != null && view2.getParent() == null) {
            this.f58792b.addView(this.f58795e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f58792b == null || (view = this.f58794d) == null || view.getParent() != null) {
            return;
        }
        this.f58792b.addView(this.f58794d, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        WebView webView = this.f58791a;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        this.f58791a = null;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        WebView webView = this.f58791a;
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
        this.f58793c = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        this.f58794d = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        this.f58796f = onBrowserStatusChangeCallBack;
    }
}

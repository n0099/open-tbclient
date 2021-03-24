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
    public WebView f58790a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f58791b;

    /* renamed from: c  reason: collision with root package name */
    public View f58792c;

    /* renamed from: d  reason: collision with root package name */
    public View f58793d;

    /* renamed from: e  reason: collision with root package name */
    public View f58794e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f58795f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58796g = false;

    /* renamed from: d.b.i0.p1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1449a extends WebViewClient {
        public C1449a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            a.this.i();
            if (a.this.f58795f != null) {
                a.this.f58795f.onHideLoading();
            }
            if (a.this.f58796g) {
                a.this.j();
                if (a.this.f58795f != null) {
                    a.this.f58795f.onLoadFailure();
                }
            } else if (a.this.f58795f != null) {
                a.this.f58795f.onLoadSuccess();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a.this.f58796g = false;
            a.this.k();
            a.this.h();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            a.this.f58796g = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            a.this.f58796g = true;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i) {
        WebView webView = this.f58790a;
        if (webView != null) {
            return webView.canScrollVertically(i);
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public View getView(Context context) {
        if (this.f58791b == null) {
            this.f58791b = new FrameLayout(context);
        }
        if (this.f58794e == null) {
            View view = new View(context);
            this.f58794e = view;
            view.setBackgroundColor(context.getResources().getColor(17170443));
        }
        if (this.f58790a == null) {
            WebView webView = new WebView(context);
            this.f58790a = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            this.f58790a.setWebViewClient(new C1449a());
        }
        this.f58791b.addView(this.f58790a);
        return this.f58791b;
    }

    public final void h() {
        if (this.f58793d != null && this.f58794e.getParent() != null) {
            ((ViewGroup) this.f58794e.getParent()).removeView(this.f58794e);
        }
        View view = this.f58792c;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f58792c.getParent()).removeView(this.f58792c);
    }

    public final void i() {
        if (this.f58793d != null && this.f58794e.getParent() != null) {
            ((ViewGroup) this.f58794e.getParent()).removeView(this.f58794e);
        }
        View view = this.f58793d;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f58793d.getParent()).removeView(this.f58793d);
    }

    public final void j() {
        View view;
        View view2;
        if (this.f58791b != null && (view2 = this.f58794e) != null && view2.getParent() == null) {
            this.f58791b.addView(this.f58794e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f58791b == null || (view = this.f58792c) == null || view.getParent() != null) {
            return;
        }
        this.f58791b.addView(this.f58792c, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void k() {
        View view;
        View view2;
        if (this.f58791b != null && (view2 = this.f58794e) != null && view2.getParent() == null) {
            this.f58791b.addView(this.f58794e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f58791b == null || (view = this.f58793d) == null || view.getParent() != null) {
            return;
        }
        this.f58791b.addView(this.f58793d, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        WebView webView = this.f58790a;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        this.f58790a = null;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        WebView webView = this.f58790a;
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
        this.f58792c = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        this.f58793d = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        this.f58795f = onBrowserStatusChangeCallBack;
    }
}

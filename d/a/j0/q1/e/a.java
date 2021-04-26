package d.a.j0.q1.e;

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
    public HkWebView f59001a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f59002b;

    /* renamed from: c  reason: collision with root package name */
    public View f59003c;

    /* renamed from: d  reason: collision with root package name */
    public View f59004d;

    /* renamed from: e  reason: collision with root package name */
    public View f59005e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f59006f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59007g = false;

    /* renamed from: d.a.j0.q1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1475a extends WebViewClient {
        public C1475a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            a.this.i();
            if (a.this.f59006f != null) {
                a.this.f59006f.onHideLoading();
            }
            if (a.this.f59007g) {
                a.this.j();
                if (a.this.f59006f != null) {
                    a.this.f59006f.onLoadFailure();
                }
            } else if (a.this.f59006f != null) {
                a.this.f59006f.onLoadSuccess();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a.this.f59007g = false;
            a.this.k();
            a.this.h();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            a.this.f59007g = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            a.this.f59007g = true;
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
        HkWebView hkWebView = this.f59001a;
        if (hkWebView != null) {
            return hkWebView.canScrollVertically(i2);
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public View getView(Context context) {
        if (this.f59002b == null) {
            this.f59002b = new FrameLayout(context);
        }
        if (this.f59005e == null) {
            View view = new View(context);
            this.f59005e = view;
            view.setBackgroundColor(context.getResources().getColor(17170443));
        }
        if (this.f59001a == null) {
            HkWebView hkWebView = new HkWebView(context);
            this.f59001a = hkWebView;
            hkWebView.setWebViewClient(new C1475a());
        }
        this.f59002b.addView(this.f59001a);
        return this.f59002b;
    }

    public final void h() {
        if (this.f59004d != null && this.f59005e.getParent() != null) {
            ((ViewGroup) this.f59005e.getParent()).removeView(this.f59005e);
        }
        View view = this.f59003c;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f59003c.getParent()).removeView(this.f59003c);
    }

    public final void i() {
        if (this.f59004d != null && this.f59005e.getParent() != null) {
            ((ViewGroup) this.f59005e.getParent()).removeView(this.f59005e);
        }
        View view = this.f59004d;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f59004d.getParent()).removeView(this.f59004d);
    }

    public final void j() {
        View view;
        View view2;
        if (this.f59002b != null && (view2 = this.f59005e) != null && view2.getParent() == null) {
            this.f59002b.addView(this.f59005e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f59002b == null || (view = this.f59003c) == null || view.getParent() != null) {
            return;
        }
        this.f59002b.addView(this.f59003c, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void k() {
        View view;
        View view2;
        if (this.f59002b != null && (view2 = this.f59005e) != null && view2.getParent() == null) {
            this.f59002b.addView(this.f59005e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f59002b == null || (view = this.f59004d) == null || view.getParent() != null) {
            return;
        }
        this.f59002b.addView(this.f59004d, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        HkWebView hkWebView = this.f59001a;
        if (hkWebView != null) {
            hkWebView.loadUrl(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        this.f59001a = null;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        HkWebView hkWebView = this.f59001a;
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
        this.f59003c = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        this.f59004d = view;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        this.f59006f = onBrowserStatusChangeCallBack;
    }
}

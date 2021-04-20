package d.b.i0.o.c.b;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import d.b.c.e.m.g;
/* loaded from: classes4.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public AdWebViewActivity f58616a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.d3.l0.c f58617b;

    public b(AdWebViewActivity adWebViewActivity) {
        this.f58616a = adWebViewActivity;
    }

    public void a(d.b.i0.d3.l0.c cVar) {
        this.f58617b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.f58616a.getPageContext().getPageActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(j2 * 2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        AdWebViewActivity adWebViewActivity = this.f58616a;
        if (adWebViewActivity == null || !g.f(adWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        AdWebViewActivity adWebViewActivity = this.f58616a;
        if (adWebViewActivity == null || !g.f(adWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        AdWebViewActivity adWebViewActivity = this.f58616a;
        if (adWebViewActivity == null || !g.f(adWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AdWebViewActivity adWebViewActivity;
        d.b.i0.d3.l0.c cVar = this.f58617b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (adWebViewActivity = this.f58616a) != null && g.f(adWebViewActivity.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

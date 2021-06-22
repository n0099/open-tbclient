package d.a.o0.q.c.b;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import d.a.c.e.m.g;
/* loaded from: classes4.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public AdWebViewActivity f61999a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.e3.l0.c f62000b;

    public b(AdWebViewActivity adWebViewActivity) {
        this.f61999a = adWebViewActivity;
    }

    public void a(d.a.o0.e3.l0.c cVar) {
        this.f62000b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.f61999a.getPageContext().getPageActivity());
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
        AdWebViewActivity adWebViewActivity = this.f61999a;
        if (adWebViewActivity == null || !g.f(adWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        AdWebViewActivity adWebViewActivity = this.f61999a;
        if (adWebViewActivity == null || !g.f(adWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        AdWebViewActivity adWebViewActivity = this.f61999a;
        if (adWebViewActivity == null || !g.f(adWebViewActivity.getPageContext())) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AdWebViewActivity adWebViewActivity;
        d.a.o0.e3.l0.c cVar = this.f62000b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (adWebViewActivity = this.f61999a) != null && g.f(adWebViewActivity.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

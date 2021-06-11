package d.a.n0.b1.j.i;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import d.a.c.a.f;
import d.a.c.e.m.g;
import d.a.n0.e3.l0.c;
/* loaded from: classes4.dex */
public class a extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public f f55595a;

    /* renamed from: b  reason: collision with root package name */
    public c f55596b;

    public a(f fVar) {
        this.f55595a = fVar;
    }

    public void a(c cVar) {
        this.f55596b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.f55595a.getPageActivity());
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
        f fVar = this.f55595a;
        if (fVar == null || !g.f(fVar)) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        f fVar = this.f55595a;
        if (fVar == null || !g.f(fVar)) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        f fVar = this.f55595a;
        if (fVar == null || !g.f(fVar)) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        f fVar;
        c cVar = this.f55596b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (fVar = this.f55595a) != null && g.f(fVar)) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

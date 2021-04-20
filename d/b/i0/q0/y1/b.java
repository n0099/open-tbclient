package d.b.i0.q0.y1;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import d.b.c.a.f;
import d.b.c.e.m.g;
/* loaded from: classes4.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public f f60421a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.d3.l0.c f60422b;

    public b(f fVar) {
        this.f60421a = fVar;
    }

    public void a(d.b.i0.d3.l0.c cVar) {
        this.f60422b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.f60421a.getPageActivity());
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
        f fVar = this.f60421a;
        if (fVar == null || !g.f(fVar)) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        f fVar = this.f60421a;
        if (fVar == null || !g.f(fVar)) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        f fVar = this.f60421a;
        if (fVar == null || !g.f(fVar)) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        f fVar;
        d.b.i0.d3.l0.c cVar = this.f60422b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (fVar = this.f60421a) != null && g.f(fVar)) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

package d.a.n0.d2;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.tieba.payment.PayVcodeActivity;
import d.a.c.e.m.g;
/* loaded from: classes5.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f56400a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e3.l0.c f56401b;

    public b(PayVcodeActivity payVcodeActivity) {
        this.f56400a = payVcodeActivity;
    }

    public void a(d.a.n0.e3.l0.c cVar) {
        this.f56401b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        PayVcodeActivity payVcodeActivity;
        d.a.n0.e3.l0.c cVar = this.f56401b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (payVcodeActivity = this.f56400a) != null && g.f(payVcodeActivity.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

package d.a.k0.c2;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.tieba.payment.PayVcodeActivity;
import d.a.c.e.m.g;
/* loaded from: classes4.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f52531a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.d3.l0.c f52532b;

    public b(PayVcodeActivity payVcodeActivity) {
        this.f52531a = payVcodeActivity;
    }

    public void a(d.a.k0.d3.l0.c cVar) {
        this.f52532b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        PayVcodeActivity payVcodeActivity;
        d.a.k0.d3.l0.c cVar = this.f52532b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (payVcodeActivity = this.f52531a) != null && g.f(payVcodeActivity.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

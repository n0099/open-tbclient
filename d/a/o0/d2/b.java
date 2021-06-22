package d.a.o0.d2;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.tieba.payment.PayVcodeActivity;
import d.a.c.e.m.g;
/* loaded from: classes5.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f56525a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.e3.l0.c f56526b;

    public b(PayVcodeActivity payVcodeActivity) {
        this.f56525a = payVcodeActivity;
    }

    public void a(d.a.o0.e3.l0.c cVar) {
        this.f56526b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        PayVcodeActivity payVcodeActivity;
        d.a.o0.e3.l0.c cVar = this.f56526b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (payVcodeActivity = this.f56525a) != null && g.f(payVcodeActivity.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

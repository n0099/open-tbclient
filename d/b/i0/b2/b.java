package d.b.i0.b2;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.tieba.payment.PayVcodeActivity;
import d.b.b.e.m.g;
/* loaded from: classes3.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f52237a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.c3.l0.c f52238b;

    public b(PayVcodeActivity payVcodeActivity) {
        this.f52237a = payVcodeActivity;
    }

    public void a(d.b.i0.c3.l0.c cVar) {
        this.f52238b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        PayVcodeActivity payVcodeActivity;
        d.b.i0.c3.l0.c cVar = this.f52238b;
        if ((cVar == null || !cVar.onJsPrompt(str2, jsPromptResult)) && (payVcodeActivity = this.f52237a) != null && g.f(payVcodeActivity.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}

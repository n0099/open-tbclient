package com.tencent.open.web.security;

import android.webkit.WebView;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.tencent.open.a;
import com.tencent.open.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends a.C0519a {

    /* renamed from: d  reason: collision with root package name */
    public String f40286d;

    public c(WebView webView, long j, String str, String str2) {
        super(webView, j, str);
        this.f40286d = str2;
    }

    private void b(String str) {
        WebView webView = this.f40128a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f40286d);
            stringBuffer.append("){");
            stringBuffer.append(this.f40286d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            f.a("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.a.C0519a
    public void a(Object obj) {
        f.a("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.a.C0519a
    public void a() {
        f.b("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.a.C0519a
    public void a(String str) {
        f.a("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !com.tencent.open.c.c.f40216a ? -4 : 0);
            jSONObject.put(IAdRequestParam.SN, this.f40129b);
            jSONObject.put("data", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b(jSONObject.toString());
    }
}

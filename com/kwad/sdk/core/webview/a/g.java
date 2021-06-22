package com.kwad.sdk.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.utils.as;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public WebView f35041b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35043d;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f35040a = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public a f35042c = new d();

    public g(WebView webView) {
        this.f35041b = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3;
        if (this.f35043d) {
            str3 = "callJS after destroy jsInterface, " + str2;
        } else if (!TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.f35041b;
            if (webView == null) {
                return;
            }
            as.a(webView, str, str2);
            return;
        } else {
            str3 = "callJS callback is empty";
        }
        com.kwad.sdk.core.d.a.b("KSAdJSBridge", str3);
    }

    public void a() {
        com.kwad.sdk.core.d.a.b("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, a> entry : this.f35040a.entrySet()) {
            a value = entry.getValue();
            if (value != null) {
                value.b();
            }
        }
        this.f35043d = true;
    }

    public void a(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a())) {
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.f35040a.containsKey(aVar.a())) {
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "cannot register handler again, handler: " + aVar.a());
        }
        this.f35040a.put(aVar.a(), aVar);
    }

    @JavascriptInterface
    public void callAdBridge(String str) {
        com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final b bVar = new b();
            bVar.a(new JSONObject(str));
            a aVar = this.f35040a.get(bVar.f35033a);
            if (aVar == null) {
                aVar = this.f35042c;
            }
            if (aVar != null) {
                aVar.a(bVar.f35034b, !TextUtils.isEmpty(bVar.f35035c) ? new c() { // from class: com.kwad.sdk.core.webview.a.g.1
                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(int i2, String str2) {
                        g.this.a(bVar.f35035c, new e(i2, str2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(com.kwad.sdk.core.b bVar2) {
                        g.this.a(bVar.f35035c, new f(bVar2).toJson().toString());
                    }
                } : new c() { // from class: com.kwad.sdk.core.webview.a.g.2
                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(int i2, String str2) {
                    }

                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(com.kwad.sdk.core.b bVar2) {
                    }
                });
            } else {
                com.kwad.sdk.core.d.a.d("KSAdJSBridge", "bridgeHandler is null");
            }
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "callAdBridge JSONException:" + e2);
        }
    }
}

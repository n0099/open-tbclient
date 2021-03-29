package com.kwad.sdk.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.utils.as;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public WebView f34300b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34302d;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f34299a = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public a f34301c = new d();

    public g(WebView webView) {
        this.f34300b = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3;
        if (this.f34302d) {
            str3 = "callJS after destroy jsInterface, " + str2;
        } else if (!TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.f34300b;
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
        for (Map.Entry<String, a> entry : this.f34299a.entrySet()) {
            a value = entry.getValue();
            if (value != null) {
                value.b();
            }
        }
        this.f34302d = true;
    }

    public void a(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a())) {
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.f34299a.containsKey(aVar.a())) {
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "cannot register handler again, handler: " + aVar.a());
        }
        this.f34299a.put(aVar.a(), aVar);
    }

    @JavascriptInterface
    public void callAdBridge(String str) {
        com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final b bVar = new b();
            bVar.a(new JSONObject(str));
            a aVar = this.f34299a.get(bVar.f34292a);
            if (aVar == null) {
                aVar = this.f34301c;
            }
            if (aVar != null) {
                aVar.a(bVar.f34293b, !TextUtils.isEmpty(bVar.f34294c) ? new c() { // from class: com.kwad.sdk.core.webview.a.g.1
                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(int i, String str2) {
                        g.this.a(bVar.f34294c, new e(i, str2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(com.kwad.sdk.core.b bVar2) {
                        g.this.a(bVar.f34294c, new f(bVar2).toJson().toString());
                    }
                } : new c() { // from class: com.kwad.sdk.core.webview.a.g.2
                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(int i, String str2) {
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

package com.kwad.sdk.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.utils.ar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public WebView f32811b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32813d;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f32810a = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public a f32812c = new d();

    public g(WebView webView) {
        this.f32811b = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3;
        if (this.f32813d) {
            str3 = "callJS after destroy jsInterface, " + str2;
        } else if (!TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.a.a("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.f32811b;
            if (webView == null) {
                return;
            }
            ar.a(webView, str, str2);
            return;
        } else {
            str3 = "callJS callback is empty";
        }
        com.kwad.sdk.core.d.a.a("KSAdJSBridge", str3);
    }

    public void a() {
        com.kwad.sdk.core.d.a.c("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, a> entry : this.f32810a.entrySet()) {
            a value = entry.getValue();
            if (value != null) {
                value.b();
            }
        }
        this.f32813d = true;
    }

    public void a(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a())) {
            com.kwad.sdk.core.d.a.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.f32810a.containsKey(aVar.a())) {
            com.kwad.sdk.core.d.a.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.a());
        }
        this.f32810a.put(aVar.a(), aVar);
    }

    @JavascriptInterface
    public void callAdBridge(String str) {
        com.kwad.sdk.core.d.a.a("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final b bVar = new b();
            bVar.a(new JSONObject(str));
            a aVar = this.f32810a.get(bVar.f32803a);
            if (aVar == null) {
                aVar = this.f32812c;
            }
            if (aVar != null) {
                aVar.a(bVar.f32804b, !TextUtils.isEmpty(bVar.f32805c) ? new c() { // from class: com.kwad.sdk.core.webview.a.g.1
                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(int i2, String str2) {
                        g.this.a(bVar.f32805c, new e(i2, str2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(com.kwad.sdk.core.b bVar2) {
                        g.this.a(bVar.f32805c, new f(bVar2).toJson().toString());
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
                com.kwad.sdk.core.d.a.e("KSAdJSBridge", "bridgeHandler is null");
            }
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            com.kwad.sdk.core.d.a.e("KSAdJSBridge", "callAdBridge JSONException:" + e2);
        }
    }
}

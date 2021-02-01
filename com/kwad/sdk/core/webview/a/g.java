package com.kwad.sdk.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.utils.as;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    private WebView f9547b;
    private boolean d;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f9546a = new ConcurrentHashMap();
    private a c = new d();

    public g(WebView webView) {
        this.f9547b = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.d) {
            com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else if (TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callJS callback is empty");
        } else {
            com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.f9547b;
            if (webView != null) {
                as.a(webView, str, str2);
            }
        }
    }

    public void a() {
        com.kwad.sdk.core.d.a.b("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, a> entry : this.f9546a.entrySet()) {
            a value = entry.getValue();
            if (value != null) {
                value.b();
            }
        }
        this.d = true;
    }

    public void a(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a())) {
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.f9546a.containsKey(aVar.a())) {
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "cannot register handler again, handler: " + aVar.a());
        }
        this.f9546a.put(aVar.a(), aVar);
    }

    @JavascriptInterface
    public void callAdBridge(String str) {
        com.kwad.sdk.core.d.a.b("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final b bVar = new b();
            bVar.a(new JSONObject(str));
            a aVar = this.f9546a.get(bVar.f9540a);
            a aVar2 = aVar == null ? this.c : aVar;
            if (aVar2 != null) {
                aVar2.a(bVar.f9541b, !TextUtils.isEmpty(bVar.c) ? new c() { // from class: com.kwad.sdk.core.webview.a.g.1
                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(int i, String str2) {
                        g.this.a(bVar.c, new e(i, str2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.a.c
                    public void a(com.kwad.sdk.core.b bVar2) {
                        g.this.a(bVar.c, new f(bVar2).toJson().toString());
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
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.d.a.d("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }
}

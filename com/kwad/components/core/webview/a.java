package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.core.webview.kwai.d;
import com.kwad.sdk.core.webview.kwai.e;
import com.kwad.sdk.core.webview.kwai.f;
import com.kwad.sdk.utils.bh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public WebView Fv;
    public final Map<String, com.kwad.sdk.core.webview.kwai.a> KC = new ConcurrentHashMap(32);
    public com.kwad.sdk.core.webview.kwai.a KD = new d();
    public boolean KE;

    public a(WebView webView) {
        this.Fv = webView;
        pn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2) {
        String str3;
        if (this.KE) {
            str3 = "callJS after destroy jsInterface, " + str2;
        } else if (!TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.e.b.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.Fv;
            if (webView == null) {
                return;
            }
            bh.a(webView, str, str2);
            return;
        } else {
            str3 = "callJS callback is empty";
        }
        com.kwad.sdk.core.e.b.d("KSAdJSBridge", str3);
    }

    private void pn() {
        a(new com.kwad.sdk.core.webview.a.a());
        a(new com.kwad.sdk.core.webview.a.b());
        a(new h());
    }

    public final void a(com.kwad.sdk.core.webview.kwai.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.e.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.KC.containsKey(aVar.getKey())) {
            com.kwad.sdk.core.e.b.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
        }
        this.KC.put(aVar.getKey(), aVar);
    }

    public final void b(com.kwad.sdk.core.webview.kwai.a aVar) {
        if (TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.e.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
        } else {
            this.KC.put(aVar.getKey(), aVar);
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.e.b.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.kwai.b bVar = new com.kwad.sdk.core.webview.kwai.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.kwai.a aVar = this.KC.get(bVar.agi);
            if (aVar == null) {
                aVar = this.KD;
            }
            if (this.Fv != null && (this.Fv instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) this.Fv;
                com.kwad.components.a.b.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.agi, bVar.data);
            }
            if (aVar != null) {
                aVar.a(bVar.data, !TextUtils.isEmpty(bVar.agj) ? new c() { // from class: com.kwad.components.core.webview.a.1
                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                        a.this.h(bVar.agj, new f(bVar2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public final void onError(int i, String str2) {
                        a.this.h(bVar.agj, new e(i, str2).toJson().toString());
                    }
                } : new c() { // from class: com.kwad.components.core.webview.a.2
                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public final void onError(int i, String str2) {
                    }
                });
            } else {
                com.kwad.sdk.core.e.b.e("KSAdJSBridge", "bridgeHandler is null");
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            com.kwad.sdk.core.e.b.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.e.b.i("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, com.kwad.sdk.core.webview.kwai.a> entry : this.KC.entrySet()) {
            com.kwad.sdk.core.webview.kwai.a value = entry.getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.KE = true;
    }
}

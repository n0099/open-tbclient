package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.c.d;
import com.kwad.sdk.core.webview.c.e;
import com.kwad.sdk.core.webview.c.f;
import com.kwad.sdk.utils.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public WebView NP;
    public final Map<String, com.kwad.sdk.core.webview.c.a> Vg = new ConcurrentHashMap(32);
    public com.kwad.sdk.core.webview.c.a Vh = new d();
    public boolean Vi;

    public a(WebView webView) {
        this.NP = webView;
        rN();
    }

    public final void b(com.kwad.sdk.core.webview.c.a aVar) {
        if (!TextUtils.isEmpty(aVar.getKey())) {
            this.Vg.put(aVar.getKey(), aVar);
        } else {
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, String str2) {
        if (this.Vi) {
            com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else if (TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS callback is empty");
        } else {
            com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.NP;
            if (webView == null) {
                return;
            }
            bt.a(webView, str, str2);
        }
    }

    private void rN() {
        a(new com.kwad.sdk.core.webview.d.a());
        a(new com.kwad.sdk.core.webview.d.b());
        a(new z());
    }

    public final void destroy() {
        com.kwad.sdk.core.e.c.i("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, com.kwad.sdk.core.webview.c.a> entry : this.Vg.entrySet()) {
            com.kwad.sdk.core.webview.c.a value = entry.getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.Vi = true;
    }

    public final void a(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.getKey())) {
            if (this.Vg.containsKey(aVar.getKey())) {
                com.kwad.sdk.core.e.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
            }
            this.Vg.put(aVar.getKey(), aVar);
            return;
        }
        com.kwad.sdk.core.e.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.webview.c.c cVar;
        com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.c.b bVar = new com.kwad.sdk.core.webview.c.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.Vg.get(bVar.aDy);
            if (aVar == null) {
                aVar = this.Vh;
            }
            if (this.NP != null && (this.NP instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) this.NP;
                com.kwad.sdk.core.webview.b.c.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.aDy, bVar.data);
            }
            if (aVar != null) {
                if (!TextUtils.isEmpty(bVar.aDz)) {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.1
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                            a.this.k(bVar.aDz, new e(i, str2).toJson().toString());
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            a.this.k(bVar.aDz, new f(bVar2).toJson().toString());
                        }
                    };
                } else {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.2
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                        }
                    };
                }
                aVar.a(bVar.data, cVar);
                return;
            }
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "bridgeHandler is null");
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }
}

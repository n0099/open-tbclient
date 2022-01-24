package com.kwad.sdk.core.webview.kwai;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.core.webview.jshandler.w;
import com.kwad.sdk.utils.bf;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public WebView f56514b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56516d;
    public final Map<String, a> a = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public a f56515c = new d();

    public g(WebView webView) {
        this.f56514b = webView;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3;
        if (this.f56516d) {
            str3 = "callJS after destroy jsInterface, " + str2;
        } else if (!TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.a.a("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.f56514b;
            if (webView == null) {
                return;
            }
            bf.a(webView, str, str2);
            return;
        } else {
            str3 = "callJS callback is empty";
        }
        com.kwad.sdk.core.d.a.a("KSAdJSBridge", str3);
    }

    private void b() {
        a(new com.kwad.sdk.core.webview.jshandler.e());
        a(new w());
    }

    public void a() {
        com.kwad.sdk.core.d.a.c("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, a> entry : this.a.entrySet()) {
            a value = entry.getValue();
            if (value != null) {
                value.b();
            }
        }
        this.f56516d = true;
    }

    public void a(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a())) {
            com.kwad.sdk.core.d.a.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.a.containsKey(aVar.a())) {
            com.kwad.sdk.core.d.a.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.a());
        }
        this.a.put(aVar.a(), aVar);
    }

    @JavascriptInterface
    public void callAdBridge(String str) {
        com.kwad.sdk.core.d.a.a("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            a aVar = this.a.get(bVar.a);
            if (aVar == null) {
                aVar = this.f56515c;
            }
            if (aVar != null) {
                aVar.a(bVar.f56510b, !TextUtils.isEmpty(bVar.f56511c) ? new c() { // from class: com.kwad.sdk.core.webview.kwai.g.1
                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public void a(int i2, String str2) {
                        g.this.a(bVar.f56511c, new e(i2, str2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public void a(com.kwad.sdk.core.b bVar2) {
                        g.this.a(bVar.f56511c, new f(bVar2).toJson().toString());
                    }
                } : new c() { // from class: com.kwad.sdk.core.webview.kwai.g.2
                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public void a(int i2, String str2) {
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
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

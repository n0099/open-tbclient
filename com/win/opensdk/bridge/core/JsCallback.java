package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import com.win.opensdk.bridge.async.AsyncTaskExecutor;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsCallback {
    private String java;
    private WeakReference<WebView> qkh;

    private JsCallback(WebView webView, String str) {
        this.qkh = new WeakReference<>(webView);
        this.java = str;
    }

    public static JsCallback g(WebView webView, String str) {
        return new JsCallback(webView, str);
    }

    public void b(boolean z, JSONObject jSONObject, String str) {
        final WebView webView = this.qkh.get();
        if (webView == null) {
            throw new JsCallbackException("The WebView related to the JsCallback has been recycled!");
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("code", z ? 0 : 1);
            if (!TextUtils.isEmpty(str)) {
                jSONObject3.put("msg", str);
            } else {
                jSONObject3.put("msg", "");
            }
            jSONObject2.put("status", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String format = String.format(Locale.getDefault(), "javascript:JsBridge.onComplete(%s,%s);", this.java, jSONObject2.toString());
        if (AsyncTaskExecutor.isMainThread()) {
            webView.loadUrl(format);
        } else {
            AsyncTaskExecutor.B(new Runnable() { // from class: com.win.opensdk.bridge.core.JsCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    webView.loadUrl(format);
                }
            });
        }
    }

    public static void a(JsCallback jsCallback, boolean z, JSONObject jSONObject, String str) {
        if (jsCallback != null) {
            try {
                jsCallback.b(z, jSONObject, str);
            } catch (JsCallbackException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class JsCallbackException extends Exception {
        public JsCallbackException(String str) {
            super(str);
        }
    }
}

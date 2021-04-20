package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import com.win.opensdk.bridge.async.AsyncTaskExecutor;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class JsCallback {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f40186a;

    /* renamed from: b  reason: collision with root package name */
    public String f40187b;

    /* loaded from: classes7.dex */
    public class JsCallbackException extends Exception {
        public JsCallbackException(String str) {
            super(str);
        }
    }

    public JsCallback(WebView webView, String str) {
        this.f40186a = new WeakReference(webView);
        this.f40187b = str;
    }

    public static void invokeJsCallback(JsCallback jsCallback, boolean z, JSONObject jSONObject, String str) {
        if (jsCallback == null) {
            return;
        }
        try {
            jsCallback.call(z, jSONObject, str);
        } catch (JsCallbackException e2) {
            e2.printStackTrace();
        }
    }

    public static JsCallback newInstance(WebView webView, String str) {
        return new JsCallback(webView, str);
    }

    public void call(boolean z, JSONObject jSONObject, String str) {
        final WebView webView = (WebView) this.f40186a.get();
        if (webView == null) {
            throw new JsCallbackException("The WebView related to the JsCallback has been recycled!");
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("code", !z ? 1 : 0);
            if (TextUtils.isEmpty(str)) {
                jSONObject3.put("msg", "");
            } else {
                jSONObject3.put("msg", str);
            }
            jSONObject2.put("status", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        final String format = String.format(Locale.getDefault(), "javascript:JsBridge.onComplete(%s,%s);", this.f40187b, jSONObject2.toString());
        if (AsyncTaskExecutor.isMainThread()) {
            webView.loadUrl(format);
        } else {
            AsyncTaskExecutor.runOnMainThread(new Runnable(this) { // from class: com.win.opensdk.bridge.core.JsCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    webView.loadUrl(format);
                }
            });
        }
    }
}

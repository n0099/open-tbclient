package com.win.opensdk.bridge;

import android.webkit.WebView;
import android.widget.Toast;
import com.win.opensdk.bridge.core.JsCallback;
import com.win.opensdk.f1;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class JsInvokeJavaScope {
    public static void finish(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        f1.a("hcl", "hcl", null);
    }

    public static void onPlayProgress(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        f1.a("onPlayProgress", "onPlayProgress", Integer.valueOf(jSONObject.optInt("message", 0)));
    }

    public static void onRewardedAdFinish(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        f1.a("onRewardedAdFinish", "onRewardedAdFinish", Integer.valueOf(jSONObject.optInt("message", 0)));
    }

    public static void onRewardedAdStart(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        f1.a("onRewardedAdStart", "onRewardedAdStart", null);
    }

    public static void onRewardedShowFail(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        f1.a("onRewardedShowFail", "onRewardedShowFail", jSONObject.optString("message"));
    }

    public static void onT(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        f1.a("onT", "onT", jSONObject.optString("message"));
    }

    public static void showToast(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Toast.makeText(webView.getContext(), jSONObject.toString(), 0).show();
        JsCallback.invokeJsCallback(jsCallback, true, null, null);
    }
}

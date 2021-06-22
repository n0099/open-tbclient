package com.win.opensdk.bridge.core;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class JsCallJava {

    /* renamed from: a  reason: collision with root package name */
    public String f40793a;

    /* renamed from: b  reason: collision with root package name */
    public String f40794b;

    /* renamed from: c  reason: collision with root package name */
    public String f40795c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f40796d;

    public static JsCallJava newInstance() {
        return new JsCallJava();
    }

    public void call(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("rainbow")) {
            Uri parse = Uri.parse(str);
            this.f40793a = parse.getHost();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                this.f40794b = "";
            } else {
                this.f40794b = path.replace("/", "");
            }
            this.f40795c = String.valueOf(parse.getPort());
            try {
                this.f40796d = new JSONObject(parse.getQuery());
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f40796d = new JSONObject();
            }
        }
        Method findMethod = NativeMethodInjectHelper.getInstance().findMethod(this.f40793a, this.f40794b);
        JsCallback newInstance = JsCallback.newInstance(webView, this.f40795c);
        if (findMethod == null) {
            JsCallback.invokeJsCallback(newInstance, false, null, "Method (" + this.f40794b + ") in this class (" + this.f40793a + ") not found!");
            return;
        }
        try {
            findMethod.invoke(null, webView, this.f40796d, newInstance);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}

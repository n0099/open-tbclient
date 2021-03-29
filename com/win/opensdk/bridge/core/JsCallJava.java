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
    public String f39893a;

    /* renamed from: b  reason: collision with root package name */
    public String f39894b;

    /* renamed from: c  reason: collision with root package name */
    public String f39895c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f39896d;

    public static JsCallJava newInstance() {
        return new JsCallJava();
    }

    public void call(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("rainbow")) {
            Uri parse = Uri.parse(str);
            this.f39893a = parse.getHost();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                this.f39894b = "";
            } else {
                this.f39894b = path.replace("/", "");
            }
            this.f39895c = String.valueOf(parse.getPort());
            try {
                this.f39896d = new JSONObject(parse.getQuery());
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f39896d = new JSONObject();
            }
        }
        Method findMethod = NativeMethodInjectHelper.getInstance().findMethod(this.f39893a, this.f39894b);
        JsCallback newInstance = JsCallback.newInstance(webView, this.f39895c);
        if (findMethod == null) {
            JsCallback.invokeJsCallback(newInstance, false, null, "Method (" + this.f39894b + ") in this class (" + this.f39893a + ") not found!");
            return;
        }
        try {
            findMethod.invoke(null, webView, this.f39896d, newInstance);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}

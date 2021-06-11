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
    public String f40690a;

    /* renamed from: b  reason: collision with root package name */
    public String f40691b;

    /* renamed from: c  reason: collision with root package name */
    public String f40692c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f40693d;

    public static JsCallJava newInstance() {
        return new JsCallJava();
    }

    public void call(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("rainbow")) {
            Uri parse = Uri.parse(str);
            this.f40690a = parse.getHost();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                this.f40691b = "";
            } else {
                this.f40691b = path.replace("/", "");
            }
            this.f40692c = String.valueOf(parse.getPort());
            try {
                this.f40693d = new JSONObject(parse.getQuery());
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f40693d = new JSONObject();
            }
        }
        Method findMethod = NativeMethodInjectHelper.getInstance().findMethod(this.f40690a, this.f40691b);
        JsCallback newInstance = JsCallback.newInstance(webView, this.f40692c);
        if (findMethod == null) {
            JsCallback.invokeJsCallback(newInstance, false, null, "Method (" + this.f40691b + ") in this class (" + this.f40690a + ") not found!");
            return;
        }
        try {
            findMethod.invoke(null, webView, this.f40693d, newInstance);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}

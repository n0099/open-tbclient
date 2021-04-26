package com.win.opensdk.bridge.core;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class JsCallJava {

    /* renamed from: a  reason: collision with root package name */
    public String f37837a;

    /* renamed from: b  reason: collision with root package name */
    public String f37838b;

    /* renamed from: c  reason: collision with root package name */
    public String f37839c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f37840d;

    public static JsCallJava newInstance() {
        return new JsCallJava();
    }

    public void call(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("rainbow")) {
            Uri parse = Uri.parse(str);
            this.f37837a = parse.getHost();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                this.f37838b = "";
            } else {
                this.f37838b = path.replace("/", "");
            }
            this.f37839c = String.valueOf(parse.getPort());
            try {
                this.f37840d = new JSONObject(parse.getQuery());
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f37840d = new JSONObject();
            }
        }
        Method findMethod = NativeMethodInjectHelper.getInstance().findMethod(this.f37837a, this.f37838b);
        JsCallback newInstance = JsCallback.newInstance(webView, this.f37839c);
        if (findMethod == null) {
            JsCallback.invokeJsCallback(newInstance, false, null, "Method (" + this.f37838b + ") in this class (" + this.f37837a + ") not found!");
            return;
        }
        try {
            findMethod.invoke(null, webView, this.f37840d, newInstance);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}

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
    public String f37082a;

    /* renamed from: b  reason: collision with root package name */
    public String f37083b;

    /* renamed from: c  reason: collision with root package name */
    public String f37084c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f37085d;

    public static JsCallJava newInstance() {
        return new JsCallJava();
    }

    public void call(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("rainbow")) {
            Uri parse = Uri.parse(str);
            this.f37082a = parse.getHost();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                this.f37083b = "";
            } else {
                this.f37083b = path.replace("/", "");
            }
            this.f37084c = String.valueOf(parse.getPort());
            try {
                this.f37085d = new JSONObject(parse.getQuery());
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f37085d = new JSONObject();
            }
        }
        Method findMethod = NativeMethodInjectHelper.getInstance().findMethod(this.f37082a, this.f37083b);
        JsCallback newInstance = JsCallback.newInstance(webView, this.f37084c);
        if (findMethod == null) {
            JsCallback.invokeJsCallback(newInstance, false, null, "Method (" + this.f37083b + ") in this class (" + this.f37082a + ") not found!");
            return;
        }
        try {
            findMethod.invoke(null, webView, this.f37085d, newInstance);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}

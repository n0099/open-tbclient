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
    public String f37011a;

    /* renamed from: b  reason: collision with root package name */
    public String f37012b;

    /* renamed from: c  reason: collision with root package name */
    public String f37013c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f37014d;

    public static JsCallJava newInstance() {
        return new JsCallJava();
    }

    public void call(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("rainbow")) {
            Uri parse = Uri.parse(str);
            this.f37011a = parse.getHost();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                this.f37012b = "";
            } else {
                this.f37012b = path.replace("/", "");
            }
            this.f37013c = String.valueOf(parse.getPort());
            try {
                this.f37014d = new JSONObject(parse.getQuery());
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f37014d = new JSONObject();
            }
        }
        Method findMethod = NativeMethodInjectHelper.getInstance().findMethod(this.f37011a, this.f37012b);
        JsCallback newInstance = JsCallback.newInstance(webView, this.f37013c);
        if (findMethod == null) {
            JsCallback.invokeJsCallback(newInstance, false, null, "Method (" + this.f37012b + ") in this class (" + this.f37011a + ") not found!");
            return;
        }
        try {
            findMethod.invoke(null, webView, this.f37014d, newInstance);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}

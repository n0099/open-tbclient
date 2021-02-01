package com.win.opensdk.bridge.core;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsCallJava {

    /* renamed from: a  reason: collision with root package name */
    private String f13732a;

    /* renamed from: case  reason: not valid java name */
    private String f29case;
    private String java;
    private JSONObject qkd;

    private JsCallJava() {
    }

    public static JsCallJava eJg() {
        return new JsCallJava();
    }

    public void f(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            if (str.startsWith("rainbow")) {
                Uri parse = Uri.parse(str);
                this.java = parse.getHost();
                String path = parse.getPath();
                if (!TextUtils.isEmpty(path)) {
                    this.f29case = path.replace("/", "");
                } else {
                    this.f29case = "";
                }
                this.f13732a = String.valueOf(parse.getPort());
                try {
                    this.qkd = new JSONObject(parse.getQuery());
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.qkd = new JSONObject();
                }
            }
            Method hD = NativeMethodInjectHelper.eJh().hD(this.java, this.f29case);
            JsCallback g = JsCallback.g(webView, this.f13732a);
            if (hD == null) {
                JsCallback.a(g, false, null, "Method (" + this.f29case + ") in this class (" + this.java + ") not found!");
                return;
            }
            try {
                hD.invoke(null, webView, this.qkd, g);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}

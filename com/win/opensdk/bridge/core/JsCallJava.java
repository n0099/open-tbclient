package com.win.opensdk.bridge.core;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class JsCallJava {

    /* renamed from: a  reason: collision with root package name */
    private String f14030a;

    /* renamed from: case  reason: not valid java name */
    private String f30case;
    private String java;
    private JSONObject qez;

    private JsCallJava() {
    }

    public static JsCallJava eKG() {
        return new JsCallJava();
    }

    public void f(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            if (str.startsWith("rainbow")) {
                Uri parse = Uri.parse(str);
                this.java = parse.getHost();
                String path = parse.getPath();
                if (!TextUtils.isEmpty(path)) {
                    this.f30case = path.replace("/", "");
                } else {
                    this.f30case = "";
                }
                this.f14030a = String.valueOf(parse.getPort());
                try {
                    this.qez = new JSONObject(parse.getQuery());
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.qez = new JSONObject();
                }
            }
            Method hx = NativeMethodInjectHelper.eKH().hx(this.java, this.f30case);
            JsCallback g = JsCallback.g(webView, this.f14030a);
            if (hx == null) {
                JsCallback.a(g, false, null, "Method (" + this.f30case + ") in this class (" + this.java + ") not found!");
                return;
            }
            try {
                hx.invoke(null, webView, this.qez, g);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}

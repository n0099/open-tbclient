package com.win.opensdk.bridge.core;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class JsCallJava {

    /* renamed from: a  reason: collision with root package name */
    public String f8126a;
    public String b;
    public String c;
    public JSONObject d;

    public static JsCallJava eJg() {
        return new JsCallJava();
    }

    public void d(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            if (str.startsWith("rainbow")) {
                Uri parse = Uri.parse(str);
                this.f8126a = parse.getHost();
                String path = parse.getPath();
                if (TextUtils.isEmpty(path)) {
                    this.b = "";
                } else {
                    this.b = path.replace("/", "");
                }
                this.c = String.valueOf(parse.getPort());
                try {
                    this.d = new JSONObject(parse.getQuery());
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.d = new JSONObject();
                }
            }
            Method hE = NativeMethodInjectHelper.eJh().hE(this.f8126a, this.b);
            JsCallback e2 = JsCallback.e(webView, this.c);
            if (hE == null) {
                JsCallback.a(e2, false, null, "Method (" + this.b + ") in this class (" + this.f8126a + ") not found!");
                return;
            }
            try {
                hE.invoke(null, webView, this.d, e2);
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }
}

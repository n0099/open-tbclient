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
    private String f14029a;

    /* renamed from: case  reason: not valid java name */
    private String f29case;
    private String java;
    private JSONObject qcR;

    private JsCallJava() {
    }

    public static JsCallJava eKc() {
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
                this.f14029a = String.valueOf(parse.getPort());
                try {
                    this.qcR = new JSONObject(parse.getQuery());
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.qcR = new JSONObject();
                }
            }
            Method hw = NativeMethodInjectHelper.eKd().hw(this.java, this.f29case);
            JsCallback g = JsCallback.g(webView, this.f14029a);
            if (hw == null) {
                JsCallback.a(g, false, null, "Method (" + this.f29case + ") in this class (" + this.java + ") not found!");
                return;
            }
            try {
                hw.invoke(null, webView, this.qcR, g);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}

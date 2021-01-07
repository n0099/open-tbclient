package com.qq.e.comm.plugin.ab.f;

import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
/* loaded from: classes4.dex */
public class h extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private e f12107a;

    public void a(e eVar) {
        this.f12107a = eVar;
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        geolocationPermissionsCallback.invoke(str, true, false);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.f12107a == null) {
            u.a(100292, 2, null, new com.qq.e.comm.plugin.y.d().a("msg", str2));
            return false;
        }
        com.qq.e.comm.plugin.ab.c.f<String> a2 = this.f12107a.a(str2);
        if (a2.d()) {
            jsPromptResult.confirm(a2.a());
            return true;
        } else if (a2.c() == 1000) {
            jsPromptResult.confirm("message:" + a2.b() + ",code:" + a2.c());
            GDTLogger.i(String.format("failed message: %s --> (%d,%s)", str2, Integer.valueOf(a2.c()), a2.b()));
            return true;
        } else {
            jsPromptResult.confirm("message:" + a2.b() + ",code:" + a2.c());
            GDTLogger.d(String.format("failed message: %s --> (%d,%s)", str2, Integer.valueOf(a2.c()), a2.b()));
            return false;
        }
    }
}

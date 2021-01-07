package com.qq.e.comm.plugin.ab.f;

import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes4.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private e f12086a;

    public void a(e eVar) {
        this.f12086a = eVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.f12086a == null) {
            u.a(100292, 1, null, new com.qq.e.comm.plugin.y.d().a("msg", str2));
            return false;
        }
        com.qq.e.comm.plugin.ab.c.f<String> a2 = this.f12086a.a(str2);
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

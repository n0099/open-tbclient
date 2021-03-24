package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class d2 {

    /* renamed from: a  reason: collision with root package name */
    public Context f39917a;

    /* renamed from: b  reason: collision with root package name */
    public Info f39918b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f39919c = new b2(this);

    public static boolean a(Uri uri) {
        return "appmarket".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean b(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        return "market".equalsIgnoreCase(scheme) || "market.android.com".equalsIgnoreCase(host) || "play.google.com".equalsIgnoreCase(host);
    }

    public void a(Context context, String str, Info info) {
        this.f39917a = context;
        this.f39918b = info;
        WebView webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        webView.setWebViewClient(new c2(this, context, info, str));
        HashMap hashMap = new HashMap();
        hashMap.put("X-Requested-With", "");
        webView.loadUrl(str, hashMap);
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = str;
        this.f39919c.sendMessageDelayed(obtain, 5000L);
    }
}

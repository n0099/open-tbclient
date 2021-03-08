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
/* loaded from: classes14.dex */
public class ck {

    /* renamed from: a  reason: collision with root package name */
    public Context f8146a;
    public Handler c = new ce(this);
    public Info qlv;

    public static boolean a(Uri uri) {
        return "appmarket".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean b(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        return "market".equalsIgnoreCase(scheme) || "market.android.com".equalsIgnoreCase(host) || "play.google.com".equalsIgnoreCase(host);
    }

    public void a(Context context, String str, Info info) {
        this.f8146a = context;
        this.qlv = info;
        WebView webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        webView.setWebViewClient(new ch(this, context, info, str));
        HashMap hashMap = new HashMap();
        hashMap.put("X-Requested-With", "");
        webView.loadUrl(str, hashMap);
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = str;
        this.c.sendMessageDelayed(obtain, 5000L);
    }
}

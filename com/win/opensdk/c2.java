package com.win.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class c2 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public boolean f40293a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f40294b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Info f40295c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40296d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d2 f40297e;

    public c2(d2 d2Var, Context context, Info info, String str) {
        this.f40297e = d2Var;
        this.f40294b = context;
        this.f40295c = info;
        this.f40296d = str;
    }

    public final boolean a(String str) {
        Uri parse = Uri.parse(str);
        if (d2.a(parse) || d2.b(parse)) {
            this.f40293a = true;
            if (!R1.a(this.f40294b, parse, null)) {
                a2.a(this.f40294b, parse);
            }
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f40297e.f40304c.removeMessages(11);
        if (this.f40293a) {
            return;
        }
        Z0 a2 = a1.a(this.f40294b);
        try {
            a2.f40234b = a1.a("ps", new b1(this.f40295c));
            a2.a("co", 2004);
            a2.a("msg", str);
        } catch (JSONException unused) {
        }
        a2.a();
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = this.f40296d;
        this.f40297e.f40304c.sendMessage(obtain);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return Build.VERSION.SDK_INT >= 24 ? a(webResourceRequest.getUrl().toString()) : super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return Build.VERSION.SDK_INT < 24 ? a(str) : super.shouldOverrideUrlLoading(webView, str);
    }
}

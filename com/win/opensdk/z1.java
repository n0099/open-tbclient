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
/* loaded from: classes6.dex */
public class z1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public boolean f38013a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f38014b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Info f38015c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f38016d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ A1 f38017e;

    public z1(A1 a1, Context context, Info info, String str) {
        this.f38017e = a1;
        this.f38014b = context;
        this.f38015c = info;
        this.f38016d = str;
    }

    public final boolean a(String str) {
        Uri parse = Uri.parse(str);
        if (A1.a(parse) || A1.b(parse)) {
            this.f38013a = true;
            if (!o1.a(this.f38014b, parse, null)) {
                x1.a(this.f38014b, parse);
            }
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f38017e.f37610c.removeMessages(11);
        if (this.f38013a) {
            return;
        }
        w0 a2 = x0.a(this.f38014b);
        try {
            a2.f37984b = x0.a("ps", new y0(this.f38015c));
            a2.a("co", 2004);
            a2.a("msg", str);
        } catch (JSONException unused) {
        }
        a2.a();
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = this.f38016d;
        this.f38017e.f37610c.sendMessage(obtain);
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

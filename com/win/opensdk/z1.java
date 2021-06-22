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
public class z1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public boolean f40969a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f40970b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Info f40971c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40972d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ A1 f40973e;

    public z1(A1 a1, Context context, Info info, String str) {
        this.f40973e = a1;
        this.f40970b = context;
        this.f40971c = info;
        this.f40972d = str;
    }

    public final boolean a(String str) {
        Uri parse = Uri.parse(str);
        if (A1.a(parse) || A1.b(parse)) {
            this.f40969a = true;
            if (!o1.a(this.f40970b, parse, null)) {
                x1.a(this.f40970b, parse);
            }
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f40973e.f40566c.removeMessages(11);
        if (this.f40969a) {
            return;
        }
        w0 a2 = x0.a(this.f40970b);
        try {
            a2.f40940b = x0.a("ps", new y0(this.f40971c));
            a2.a("co", 2004);
            a2.a("msg", str);
        } catch (JSONException unused) {
        }
        a2.a();
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = this.f40972d;
        this.f40973e.f40566c.sendMessage(obtain);
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

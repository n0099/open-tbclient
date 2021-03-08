package com.win.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class ch extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8144a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String d;
    public final /* synthetic */ Info qkh;
    public final /* synthetic */ ck qly;

    public ch(ck ckVar, Context context, Info info, String str) {
        this.qly = ckVar;
        this.b = context;
        this.qkh = info;
        this.d = str;
    }

    public final boolean a(String str) {
        Uri parse = Uri.parse(str);
        if (ck.a(parse) || ck.b(parse)) {
            this.f8144a = true;
            if (bf.a(this.b, parse, null)) {
                return true;
            }
            cb.i(this.b, parse);
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.qly.c.removeMessages(11);
        if (this.f8144a) {
            return;
        }
        bx iT = ca.iT(this.b);
        try {
            iT.qlo = ca.a("ps", new cd(this.qkh));
            iT.P(BdStatsConstant.StatsKey.COUNT, 2004);
            iT.hD("msg", str);
        } catch (JSONException e) {
        }
        iT.a();
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = this.d;
        this.qly.c.sendMessage(obtain);
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

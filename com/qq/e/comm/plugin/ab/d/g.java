package com.qq.e.comm.plugin.ab.d;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.y.u;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g extends com.qq.e.comm.plugin.ab.f.h {

    /* renamed from: a  reason: collision with root package name */
    private f f11760a;

    public void a(f fVar) {
        this.f11760a = fVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (this.f11760a != null) {
            this.f11760a.a(i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f11760a != null) {
            this.f11760a.c(str);
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        ai.b("gdt_tag_inner_webview", "X5onShowFileChooser(%s,%s)", valueCallback, fileChooserParams);
        if (this.f11760a == null || fileChooserParams == null) {
            return false;
        }
        try {
            return this.f11760a.b(valueCallback, fileChooserParams.createIntent());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        try {
            ai.b("gdt_tag_inner_webview", "X5openFileChooser(%s,%s,%s)", valueCallback, str, str2);
            if (this.f11760a != null) {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                if (TextUtils.isEmpty(str)) {
                    str = "*/*";
                }
                intent.setType(str);
                this.f11760a.a((android.webkit.ValueCallback<Uri>) valueCallback, intent);
            } else if (valueCallback != null) {
                valueCallback.onReceiveValue((Object) null);
            }
        } catch (NullPointerException e) {
            u.a(1130002, null);
            e.printStackTrace();
        }
    }
}

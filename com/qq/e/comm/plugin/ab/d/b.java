package com.qq.e.comm.plugin.ab.d;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.qq.e.comm.plugin.util.ai;
/* loaded from: classes3.dex */
class b extends com.qq.e.comm.plugin.ab.f.b {

    /* renamed from: a  reason: collision with root package name */
    private f f12052a;

    public void a(f fVar) {
        this.f12052a = fVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (this.f12052a != null) {
            this.f12052a.a(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f12052a != null) {
            this.f12052a.c(str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        ai.b("gdt_tag_inner_webview", "onShowFileChooser(%s,%s)", valueCallback, fileChooserParams);
        if (this.f12052a == null || Build.VERSION.SDK_INT < 21 || fileChooserParams == null) {
            return false;
        }
        return this.f12052a.b(valueCallback, fileChooserParams.createIntent());
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        ai.b("gdt_tag_inner_webview", "openFileChooser(%s,%s)", valueCallback, str);
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        ai.b("gdt_tag_inner_webview", "openFileChooser(%s,%s,%s)", valueCallback, str, str2);
        if (this.f12052a == null) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (TextUtils.isEmpty(str)) {
            str = "*/*";
        }
        intent.setType(str);
        this.f12052a.a(valueCallback, intent);
    }
}

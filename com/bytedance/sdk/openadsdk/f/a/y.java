package com.bytedance.sdk.openadsdk.f.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes5.dex */
public class y extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f29068h = !y.class.desiredAssertionStatus();
    public String i;
    public WebView j;

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void b(j jVar) {
        WebView webView = jVar.f29005a;
        this.j = webView;
        this.i = jVar.f29007c;
        if (Build.VERSION.SDK_INT < 17 || jVar.n) {
            return;
        }
        if (!f29068h && webView == null) {
            throw new AssertionError();
        }
        this.j.addJavascriptInterface(this, this.i);
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    @NonNull
    public Context a(j jVar) {
        Context context = jVar.f29009e;
        if (context != null) {
            return context;
        }
        WebView webView = jVar.f29005a;
        if (webView != null) {
            return webView.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    public String a() {
        return this.j.getUrl();
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    public void a(String str, @Nullable p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.f29020h)) {
            String str2 = pVar.f29020h;
            a(str, String.format("javascript:(function(){   const iframe = document.querySelector('iframe[src=\"%s\"');   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, '%s');   }})()", str2, str, str2));
            return;
        }
        super.a(str, pVar);
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    public void a(String str) {
        a(str, "javascript:" + this.i + "._handleMessageFromToutiao(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    private void a(String str, final String str2) {
        if (this.f28974f || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.y.1
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.f28974f) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    i.a("Invoking Jsb using evaluateJavascript: " + str2);
                    y.this.j.evaluateJavascript(str2, null);
                    return;
                }
                i.a("Invoking Jsb using loadUrl: " + str2);
                y.this.j.loadUrl(str2);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            i.a("Received call on sub-thread, posting to main thread: " + str2);
            this.f28972d.post(runnable);
            return;
        }
        runnable.run();
    }
}

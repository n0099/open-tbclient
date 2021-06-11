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
/* loaded from: classes6.dex */
public class y extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f29245h = !y.class.desiredAssertionStatus();

    /* renamed from: i  reason: collision with root package name */
    public String f29246i;
    public WebView j;

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void b(j jVar) {
        WebView webView = jVar.f29181a;
        this.j = webView;
        this.f29246i = jVar.f29183c;
        if (Build.VERSION.SDK_INT < 17 || jVar.n) {
            return;
        }
        if (!f29245h && webView == null) {
            throw new AssertionError();
        }
        this.j.addJavascriptInterface(this, this.f29246i);
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    @NonNull
    public Context a(j jVar) {
        Context context = jVar.f29185e;
        if (context != null) {
            return context;
        }
        WebView webView = jVar.f29181a;
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
        if (pVar != null && !TextUtils.isEmpty(pVar.f29197h)) {
            String str2 = pVar.f29197h;
            a(str, String.format("javascript:(function(){   const iframe = document.querySelector('iframe[src=\"%s\"');   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, '%s');   }})()", str2, str, str2));
            return;
        }
        super.a(str, pVar);
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    public void a(String str) {
        a(str, "javascript:" + this.f29246i + "._handleMessageFromToutiao(" + str + SmallTailInfo.EMOTION_SUFFIX);
    }

    private void a(String str, final String str2) {
        if (this.f29149f || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.y.1
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.f29149f) {
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
            this.f29147d.post(runnable);
            return;
        }
        runnable.run();
    }
}

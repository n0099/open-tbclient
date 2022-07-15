package com.kwad.sdk.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bd {
    public static void a(final WebView webView, final String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            a(new Runnable() { // from class: com.kwad.sdk.utils.bd.1
                @Override // java.lang.Runnable
                public final void run() {
                    webView.evaluateJavascript(str, r3);
                }
            });
        } else {
            webView.loadUrl(str);
        }
    }

    public static void a(WebView webView, String str, String str2) {
        a(webView, "javascript:" + str + "(" + JSONObject.quote(str2) + SmallTailInfo.EMOTION_SUFFIX, (ValueCallback<String>) null);
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}

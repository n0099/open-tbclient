package com.kwad.sdk.utils;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ar {
    public static void a(final WebView webView, final String str, final ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            ak.a(new Runnable() { // from class: com.kwad.sdk.utils.ar.1
                @Override // java.lang.Runnable
                public void run() {
                    webView.evaluateJavascript(str, valueCallback);
                }
            });
            return;
        }
        webView.loadUrl(str);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
    }

    public static void a(WebView webView, String str, String str2) {
        a(webView, "javascript:" + str + "(" + JSONObject.quote(str2) + SmallTailInfo.EMOTION_SUFFIX, (ValueCallback<String>) null);
    }
}

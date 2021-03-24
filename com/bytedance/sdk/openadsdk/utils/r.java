package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes6.dex */
public class r {
    public static void a(Uri uri, com.bytedance.sdk.openadsdk.core.x xVar) {
        if (xVar == null || !xVar.a(uri)) {
            return;
        }
        try {
            xVar.b(uri);
        } catch (Exception e2) {
            u.d(WebView.LOGTAG, "TTAndroidObj handleUri exception: " + e2);
        }
    }

    public static String a(android.webkit.WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        return userAgentString + " open_news open_news_u_s/" + i;
    }
}

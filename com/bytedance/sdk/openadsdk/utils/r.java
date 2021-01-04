package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
/* loaded from: classes4.dex */
public class r {
    public static void a(Uri uri, com.bytedance.sdk.openadsdk.core.x xVar) {
        if (xVar != null && xVar.a(uri)) {
            try {
                xVar.b(uri);
            } catch (Exception e) {
                u.d("WebView", "TTAndroidObj handleUri exception: " + e);
            }
        }
    }

    public static String a(WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(userAgentString);
        sb.append(" open_news").append(" open_news_u_s/").append(i);
        return sb.toString();
    }
}

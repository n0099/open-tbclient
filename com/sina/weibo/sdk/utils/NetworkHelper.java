package com.sina.weibo.sdk.utils;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes2.dex */
public class NetworkHelper {
    public static boolean hasInternetPermission(Context context) {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static String generateUA(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append("__");
        sb.append("weibo");
        sb.append("__");
        sb.append("sdk");
        sb.append("__");
        try {
            sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", BaseRequestAction.SPLITE));
        } catch (Exception e) {
            sb.append("unknown");
        }
        return sb.toString();
    }
}

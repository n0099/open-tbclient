package com.sina.weibo.sdk.utils;

import android.content.Context;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
/* loaded from: classes24.dex */
public class NetworkHelper {
    public static boolean hasInternetPermission(Context context) {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static String generateUA(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append("__");
        sb.append(LogConfig.LIVE_SHARE_HK_WEIBO);
        sb.append("__");
        sb.append(CashierData.SDK);
        sb.append("__");
        try {
            sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
        } catch (Exception e) {
            sb.append("unknown");
        }
        return sb.toString();
    }
}

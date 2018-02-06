package com.sina.weibo.sdk.call;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
/* loaded from: classes3.dex */
class CommonUtils {
    CommonUtils() {
    }

    public static String buildUriQuery(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            if (str2 != null) {
                sb.append("&").append(str).append("=").append(str2);
            }
        }
        return sb.toString().replaceFirst("&", "?");
    }

    public static void openWeiboActivity(Context context, String str, String str2, String str3) throws WeiboNotInstalledException {
        try {
            if (str3 != null) {
                Intent intent = new Intent();
                intent.setAction(str);
                intent.setData(Uri.parse(str2));
                intent.setPackage(str3);
                context.startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.setAction(str);
                intent2.setData(Uri.parse(str2));
                context.startActivity(intent2);
            }
        } catch (ActivityNotFoundException e) {
            if (str3 != null) {
                try {
                    Intent intent3 = new Intent();
                    intent3.setAction(str);
                    intent3.setData(Uri.parse(str2));
                    context.startActivity(intent3);
                    return;
                } catch (ActivityNotFoundException e2) {
                    throw new WeiboNotInstalledException(WBPageConstants.ExceptionMsg.WEIBO_NOT_INSTALLED);
                }
            }
            throw new WeiboNotInstalledException(WBPageConstants.ExceptionMsg.WEIBO_NOT_INSTALLED);
        }
    }

    public static void openWeiboActivity(Context context, String str, String str2) throws WeiboNotInstalledException {
        try {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.setData(Uri.parse(str2));
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new WeiboNotInstalledException(WBPageConstants.ExceptionMsg.WEIBO_NOT_INSTALLED);
        }
    }
}

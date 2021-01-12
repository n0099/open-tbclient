package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f10816a = new HashMap();

    static {
        f10816a.put("HUAWEI", "com.huawei.appmarket");
        f10816a.put(RomUtils.ROM_OPPO, "com.oppo.market");
        f10816a.put(RomUtils.MANUFACTURER_VIVO, "com.bbk.appstore");
        f10816a.put(RomUtils.MANUFACTURER_XIAOMI, "com.xiaomi.market");
        f10816a.put("OnePlus", "com.oppo.market");
        f10816a.put("Meizu", "com.meizu.mstore");
        f10816a.put("samsung", "com.sec.android.app.samsungapps");
        f10816a.put(RomUtils.ROM_SMARTISAN, "com.smartisanos.appstore");
        f10816a.put("Realme", "com.oppo.market");
        f10816a.put("HONOR", "com.huawei.appmarket");
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("samsung".equals(Build.BRAND)) {
            str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
        }
        try {
            String str3 = f10816a.get(Build.BRAND);
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addFlags(268435456);
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(parseUri, 0)) {
                if (!a(resolveInfo)) {
                    String str4 = resolveInfo.activityInfo.packageName;
                    if (str4.equals(str3) || a(str4)) {
                        parseUri.setComponent(new ComponentName(str4, resolveInfo.activityInfo.name));
                        context.startActivity(parseUri);
                        return true;
                    }
                }
            }
            return a(context, str);
        } catch (Exception e) {
            return a(context, str);
        }
    }

    private static boolean a(ResolveInfo resolveInfo) {
        return resolveInfo == null || resolveInfo.activityInfo == null || TextUtils.isEmpty(resolveInfo.activityInfo.packageName);
    }

    private static boolean a(String str) {
        return RomUtils.ROM_OPPO.equals(Build.BRAND) && "com.heytap.market".equals(str);
    }
}

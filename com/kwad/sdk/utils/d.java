package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.google.android.material.internal.ManufacturerUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class d {
    public static final Map amI;

    static {
        HashMap hashMap = new HashMap();
        amI = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        amI.put("OPPO", "com.oppo.market");
        amI.put("vivo", "com.bbk.appstore");
        amI.put(RomUtils.MANUFACTURER_XIAOMI, "com.xiaomi.market");
        amI.put("OnePlus", "com.oppo.market");
        amI.put("Meizu", "com.meizu.mstore");
        amI.put(ManufacturerUtils.SAMSUNG, "com.sec.android.app.samsungapps");
        amI.put("SMARTISAN", "com.smartisanos.appstore");
        amI.put("Realme", "com.oppo.market");
        amI.put("HONOR", "com.huawei.appmarket");
    }

    public static boolean a(Context context, String str, AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (!ap.zQ() || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.adStyle == 4 || com.kwad.sdk.core.download.kwai.b.s(context, str) != 1) {
            return false;
        }
        adTemplate.mXiaomiAppStoreDetailViewOpen = true;
        return true;
    }

    public static boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        return resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName);
    }

    public static boolean dx(String str) {
        return "OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str);
    }

    public static boolean e(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (ManufacturerUtils.SAMSUNG.equals(Build.BRAND)) {
            str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
        }
        try {
            String str3 = (String) amI.get(Build.BRAND);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (!a(resolveInfo)) {
                    String str4 = resolveInfo.activityInfo.packageName;
                    if (str4.equals(str3) || dx(str4)) {
                        intent.setComponent(new ComponentName(str4, resolveInfo.activityInfo.name));
                        context.startActivity(intent);
                        return true;
                    }
                }
            }
            return v(context, str);
        } catch (Exception unused) {
            return v(context, str);
        }
    }

    public static boolean v(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

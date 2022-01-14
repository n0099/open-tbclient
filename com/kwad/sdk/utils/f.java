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
import com.google.android.material.internal.ManufacturerUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class f {
    public static final Map<String, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        a.put("OPPO", "com.oppo.market");
        a.put(RomUtils.MANUFACTURER_VIVO, "com.bbk.appstore");
        a.put(RomUtils.MANUFACTURER_XIAOMI, "com.xiaomi.market");
        a.put(com.kuaishou.weapon.un.g.f55061i, "com.oppo.market");
        a.put("Meizu", "com.meizu.mstore");
        a.put(ManufacturerUtils.SAMSUNG, "com.sec.android.app.samsungapps");
        a.put("SMARTISAN", "com.smartisanos.appstore");
        a.put("Realme", "com.oppo.market");
        a.put("HONOR", "com.huawei.appmarket");
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (!an.b() || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.adStyle == 4 || com.kwad.sdk.core.download.a.d.a(context, str) != 1) {
            return false;
        }
        adTemplate.mXiaomiAppStoreDetailViewOpen = true;
        return true;
    }

    public static boolean a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (ManufacturerUtils.SAMSUNG.equals(Build.BRAND)) {
            str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
        }
        try {
            String str3 = a.get(Build.BRAND);
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
        } catch (Exception unused) {
            return a(context, str);
        }
    }

    public static boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        return resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName);
    }

    public static boolean a(String str) {
        return "OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str);
    }
}

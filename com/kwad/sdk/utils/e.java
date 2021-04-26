package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f34888a;

    static {
        HashMap hashMap = new HashMap();
        f34888a = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        f34888a.put("OPPO", "com.oppo.market");
        f34888a.put(RomUtils.MANUFACTURER_VIVO, "com.bbk.appstore");
        f34888a.put(RomUtils.MANUFACTURER_XIAOMI, "com.xiaomi.market");
        f34888a.put("OnePlus", "com.oppo.market");
        f34888a.put("Meizu", "com.meizu.mstore");
        f34888a.put(ManufacturerUtils.SAMSUNG, "com.sec.android.app.samsungapps");
        f34888a.put("SMARTISAN", "com.smartisanos.appstore");
        f34888a.put("Realme", "com.oppo.market");
        f34888a.put("HONOR", "com.huawei.appmarket");
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (ManufacturerUtils.SAMSUNG.equals(Build.BRAND)) {
            str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
        }
        try {
            String str3 = f34888a.get(Build.BRAND);
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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

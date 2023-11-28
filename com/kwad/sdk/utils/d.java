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
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.google.android.material.internal.ManufacturerUtils;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class d {
    public static final Map<String, String> aMC;

    static {
        HashMap hashMap = new HashMap();
        aMC = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        aMC.put("OPPO", "com.oppo.market");
        aMC.put("vivo", "com.bbk.appstore");
        aMC.put(RomUtils.MANUFACTURER_XIAOMI, "com.xiaomi.market");
        aMC.put("OnePlus", "com.oppo.market");
        aMC.put("Meizu", "com.meizu.mstore");
        aMC.put(ManufacturerUtils.SAMSUNG, "com.sec.android.app.samsungapps");
        aMC.put("SMARTISAN", "com.smartisanos.appstore");
        aMC.put("Realme", "com.oppo.market");
        aMC.put("HONOR", "com.huawei.appmarket");
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (!at.KC() || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.adStyle == 4 || com.kwad.sdk.core.download.a.b.a(context, str, new b.C0705b() { // from class: com.kwad.sdk.utils.d.1
            @Override // com.kwad.sdk.core.download.a.b.C0705b, com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                super.onError(th);
                com.kwad.sdk.commercial.c.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bn.s(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.C0705b, com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                super.onStart();
                com.kwad.sdk.commercial.c.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
            }

            @Override // com.kwad.sdk.core.download.a.b.C0705b, com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                super.onSuccess();
                AdTemplate adTemplate2 = AdTemplate.this;
                adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                adTemplate2.mClickOpenAppStore = true;
                com.kwad.sdk.commercial.c.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
            }
        }) != 1) {
            return false;
        }
        return true;
    }

    public static boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName)) {
            return false;
        }
        return true;
    }

    public static boolean fI(String str) {
        if ("OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean h(Context context, AdTemplate adTemplate) {
        String str;
        String str2;
        int i;
        String str3;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        String cN = com.kwad.sdk.core.response.b.a.cN(dP);
        String ay = com.kwad.sdk.core.response.b.a.ay(dP);
        if (context != null && !TextUtils.isEmpty(cN)) {
            try {
                if (ManufacturerUtils.SAMSUNG.equals(Build.BRAND)) {
                    cN = "http://apps.samsung.com/appquery/appDetail.as?appId=" + ay;
                }
                str3 = aMC.get(Build.BRAND);
            } catch (Throwable th) {
                th = th;
                str = cN;
                str2 = null;
            }
            try {
                com.kwad.sdk.commercial.c.a.a(adTemplate, cN, str3, 1, 0);
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(cN));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                    if (!a(resolveInfo)) {
                        String str4 = resolveInfo.activityInfo.packageName;
                        if (str4.equals(str3) || fI(str4)) {
                            intent.setComponent(new ComponentName(str4, resolveInfo.activityInfo.name));
                            context.startActivity(intent);
                            adTemplate.mClickOpenAppStore = true;
                            com.kwad.sdk.commercial.c.a.b(adTemplate, cN, str3, 1, 0);
                            return true;
                        }
                    }
                }
                try {
                    context.startActivity(intent);
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.c.a.b(adTemplate, cN, str3, 0, 0);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str3;
                    str = cN;
                    i = 0;
                    com.kwad.sdk.commercial.c.a.a(adTemplate, str, str2, i, 0, bn.s(th));
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = str3;
                str = cN;
                i = 1;
                com.kwad.sdk.commercial.c.a.a(adTemplate, str, str2, i, 0, bn.s(th));
                return false;
            }
        }
        return false;
    }
}

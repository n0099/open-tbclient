package com.ss.android.socialbase.downloader.i;

import android.content.Context;
import android.content.pm.ServiceInfo;
/* loaded from: classes8.dex */
public class j {
    public static boolean a(Context context, String str, String str2) {
        ServiceInfo[] serviceInfoArr;
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}

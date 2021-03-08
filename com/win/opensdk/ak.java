package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes14.dex */
public class ak {
    public static ai iM(Context context) {
        if (!RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        ah ahVar = new ah(context);
        try {
            try {
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                if (context.bindService(intent, ahVar, 1)) {
                    a aVar = (a) b.a(ahVar.a());
                    return new ai(aVar.a(), aVar.b());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } finally {
            context.unbindService(ahVar);
        }
    }
}

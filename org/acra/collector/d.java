package org.acra.collector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {
    public static String a(Context context) {
        Object[] objArr;
        if (a.a() < 5) {
            return "Data available only with API Level >= 5";
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (Object obj : (Object[]) PackageManager.class.getMethod("getSystemAvailableFeatures", null).invoke(context.getPackageManager(), new Object[0])) {
                String str = (String) obj.getClass().getField("name").get(obj);
                if (str != null) {
                    sb.append(str);
                } else {
                    sb.append("glEsVersion = ");
                    sb.append((String) obj.getClass().getMethod("getGlEsVersion", null).invoke(obj, new Object[0]));
                }
                sb.append("\n");
            }
        } catch (Throwable th) {
            Log.w(org.acra.a.a, "Couldn't retrieve DeviceFeatures for " + context.getPackageName(), th);
            sb.append("Could not retrieve data: ");
            sb.append(th.getMessage());
        }
        return sb.toString();
    }
}

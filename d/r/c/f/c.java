package d.r.c.f;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes7.dex */
public final class c {
    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null || str2 != null) {
            if (str == null) {
                return -1;
            }
            if (str.equals(str2)) {
                return 0;
            }
            if (str.startsWith(str2)) {
                return 1;
            }
            if (str2.startsWith(str)) {
                return -1;
            }
            String[] split = str.split("\\.|-");
            String[] split2 = str2.split("\\.|-");
            int length = split.length <= split2.length ? split.length : split2.length;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    int parseInt = Integer.parseInt(split[i2]);
                    int parseInt2 = Integer.parseInt(split2[i2]);
                    Integer.parseInt(split[i2]);
                    Integer.parseInt(split2[i2]);
                    if (parseInt > parseInt2) {
                        return 1;
                    }
                    if (parseInt < parseInt2) {
                        return -1;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            if (split.length > length) {
                return 1;
            }
            if (split2.length > length) {
                return -1;
            }
            return str.compareTo(str2);
        }
        return 1;
    }

    public static String b(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.packageName + "(" + packageInfo.versionName + SmallTailInfo.EMOTION_SUFFIX;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean d(Context context, Class<? extends Activity> cls) {
        if (context != null && cls != null) {
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), cls.getName()), 0);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean e(android.content.Context r1, android.content.Intent r2) {
        /*
            r0 = 0
            if (r1 == 0) goto L15
            if (r2 != 0) goto L6
            goto L15
        L6:
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L15
            java.util.List r1 = r1.queryIntentActivities(r2, r0)     // Catch: java.lang.Exception -> L15
            int r1 = r1.size()     // Catch: java.lang.Exception -> L15
            if (r1 <= 0) goto L15
            r0 = 1
        L15:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.r.c.f.c.e(android.content.Context, android.content.Intent):boolean");
    }
}

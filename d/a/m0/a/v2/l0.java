package d.a.m0.a.v2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.io.File;
/* loaded from: classes3.dex */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49206a = d.a.m0.a.k.f46983a;

    public static boolean a(String str, String str2) {
        return b(str) > b(str2);
    }

    public static long b(String str) {
        String[] g2 = g(str);
        if (g2 == null) {
            return 0L;
        }
        long j = 0;
        for (int i2 = 0; i2 < g2.length; i2++) {
            try {
                j += Integer.parseInt(g2[i2]) * ((long) Math.pow(1000.0d, (g2.length - i2) - 1));
            } catch (NumberFormatException e2) {
                d.a.m0.a.e0.d.i("SwanAppSwanCoreUtils", "getVersionCode exception", e2);
                return 0L;
            }
        }
        d.a.m0.a.e0.d.a("SwanAppSwanCoreUtils", "getVersion version: ", str, " ,versionCode: ", Long.valueOf(j));
        return j;
    }

    @Deprecated
    public static long c(String str) {
        String[] g2 = g(str);
        if (g2 == null) {
            return 0L;
        }
        int i2 = 0;
        long j = 0;
        while (i2 < 3) {
            try {
                j = (j << 16) | (i2 < g2.length ? Integer.parseInt(g2[i2]) : 0L);
                i2++;
            } catch (NumberFormatException e2) {
                if (f49206a) {
                    throw e2;
                }
                return 0L;
            }
        }
        if (f49206a) {
            Log.d("SwanAppSwanCoreUtils", "getVersion version: " + str + " ,versionCode: " + j);
        }
        return j;
    }

    public static String d(long j) {
        if (j < 0) {
            d.a.m0.a.e0.d.h("SwanAppSwanCoreUtils", "versionCode < 0, versionCode = " + j);
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        long j2 = j;
        for (int i2 = 2; i2 >= 0; i2--) {
            if (i2 > 0) {
                long pow = (long) Math.pow(1000.0d, i2);
                sb.append(j2 / pow);
                sb.append(".");
                j2 %= pow;
            } else {
                sb.append(j2);
            }
        }
        String sb2 = sb.toString();
        d.a.m0.a.e0.d.a("SwanAppSwanCoreUtils", "getVersionName version code: ", Long.valueOf(j), " ,version name: ", sb2);
        return sb2;
    }

    public static boolean e(String str) {
        String[] list;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }

    public static boolean f(String str) {
        long b2 = b(str);
        SwanCoreVersion V = d.a.m0.a.h0.u.g.N().V();
        long b3 = V != null ? b(V.swanCoreVersionName) : 0L;
        d.a.m0.a.e0.d.g("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + b2 + ";curSwanVersionCode: " + b3);
        return b3 < b2;
    }

    public static String[] g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        if (split.length != 3) {
            return null;
        }
        return split;
    }
}

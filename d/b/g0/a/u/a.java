package d.b.g0.a.u;

import android.text.TextUtils;
import d.b.g0.a.y0.e.b;
/* loaded from: classes2.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("_dev");
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf("_trial");
        return indexOf2 > 0 ? str.substring(0, indexOf2) : str;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains("_dev")) {
            return 1;
        }
        if (str.endsWith("_trial")) {
            return 3;
        }
        return str.contains("_trial") ? 2 : 0;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("_dev");
        if (lastIndexOf >= 0 && lastIndexOf < str.length()) {
            return str.substring(lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf("_trial");
        return (lastIndexOf2 < 0 || lastIndexOf2 >= str.length()) ? "" : str.substring(lastIndexOf2);
    }

    public static boolean d(b bVar) {
        return bVar != null && bVar.m1() == 1;
    }

    public static boolean e(b bVar) {
        return bVar != null && bVar.m1() == 0;
    }

    @Deprecated
    public static boolean f(String str) {
        return (TextUtils.isEmpty(str) || str.contains("_")) ? false : true;
    }

    public static boolean g(b bVar) {
        return bVar != null && bVar.m1() == 2;
    }
}

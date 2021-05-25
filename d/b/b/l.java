package d.b.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
/* loaded from: classes6.dex */
public class l {
    public static String a(String str) {
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("getprop " + str);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader2.readLine();
                exec.destroy();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return str2;
            } catch (Throwable unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return str2;
            }
        } catch (Throwable unused4) {
        }
    }

    public static boolean b() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        return k().toUpperCase().contains("HUAWEI");
    }

    public static boolean d() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(RomUtils.MANUFACTURER_OPPO);
    }

    public static boolean e() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean f() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean g() {
        return ManufacturerUtils.SAMSUNG.equalsIgnoreCase(Build.BRAND) || ManufacturerUtils.SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean h() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String a2 = a(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
        return !TextUtils.isEmpty(a2) && a2.contains("VIBEUI_V2");
    }

    public static boolean i() {
        return k().toUpperCase().contains(RomUtils.ROM_NUBIA);
    }

    public static boolean j() {
        return k().toUpperCase().contains("ASUS");
    }

    public static String k() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }
}

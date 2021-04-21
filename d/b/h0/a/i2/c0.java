package d.b.h0.a.i2;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45394a = d.b.h0.a.k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45395b;

    /* renamed from: c  reason: collision with root package name */
    public static String f45396c;

    public static boolean a(String str) {
        String str2 = f45395b;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f45396c = d2;
        if (!TextUtils.isEmpty(d2)) {
            f45395b = "MIUI";
        } else {
            String d3 = d("ro.build.version.emui");
            f45396c = d3;
            if (!TextUtils.isEmpty(d3)) {
                f45395b = "EMUI";
            } else {
                String d4 = d("ro.build.version.opporom");
                f45396c = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f45395b = "OPPO";
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f45396c = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f45395b = "VIVO";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f45396c = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f45395b = "SMARTISAN";
                        } else {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f45396c = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f45395b = "SMARTISAN";
                            } else {
                                String d8 = d(RomUtils.KEY_VERSION_NUBIA);
                                f45396c = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f45395b = RomUtils.ROM_NUBIA;
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f45396c = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f45395b = "FLYME";
                                    } else {
                                        f45396c = "unknown";
                                        f45395b = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f45395b.equals(str);
    }

    public static int b(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return 0;
        }
        if (i >= 28) {
            return c();
        }
        if (e(context)) {
            if (k()) {
                Resources resources = context.getResources();
                try {
                    int identifier = resources.getIdentifier("notch_height", "dimen", "android");
                    if (identifier > 0) {
                        return resources.getDimensionPixelSize(identifier);
                    }
                } catch (Exception unused) {
                    return 0;
                }
            }
            if (j()) {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]))[1];
                } catch (Exception unused2) {
                    return 0;
                }
            } else if (l()) {
                return 80;
            } else {
                if (m()) {
                    return h0.f(32.0f);
                }
                return 0;
            }
        }
        return 0;
    }

    @RequiresApi(28)
    public static int c() {
        DisplayCutout displayCutout;
        int i = 0;
        if (d.b.h0.a.r1.e.y() != null && d.b.h0.a.r1.e.y().A() != null) {
            try {
                WindowInsets rootWindowInsets = d.b.h0.a.r1.e.y().A().getWindow().getDecorView().getRootWindowInsets();
                if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                    return 0;
                }
                i = displayCutout.getSafeInsetTop();
                if (f45394a) {
                    Log.d("SwanAppRomUtils", "刘海屏高度:" + i);
                }
            } catch (Exception e2) {
                if (f45394a) {
                    Log.w("SwanAppRomUtils", e2);
                }
            }
        }
        return i;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0058: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:20:0x0058 */
    public static String d(String str) {
        BufferedReader bufferedReader;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    d.b.h0.p.d.a(bufferedReader);
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    if (f45394a) {
                        Log.e("SwanAppRomUtils", "Unable to read prop " + str, e);
                    }
                    d.b.h0.p.d.a(bufferedReader);
                    d.b.h0.p.d.a(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                d.b.h0.p.d.a(closeable2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.h0.p.d.a(closeable2);
            throw th;
        }
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        if (j()) {
            return f(context);
        }
        if (m()) {
            return i(context);
        }
        if (l()) {
            return h(context);
        }
        if (k()) {
            return g(context);
        }
        return false;
    }

    public static boolean f(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception e2) {
            if (f45394a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static boolean g(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception e2) {
            if (f45394a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static boolean h(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean i(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception e2) {
            if (f45394a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static boolean j() {
        return a("EMUI");
    }

    public static boolean k() {
        return a("MIUI");
    }

    public static boolean l() {
        return a("OPPO");
    }

    public static boolean m() {
        return a("VIVO");
    }
}

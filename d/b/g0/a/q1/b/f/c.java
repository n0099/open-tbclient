package d.b.g0.a.q1.b.f;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StyleRes;
import com.baidu.android.util.devices.RomUtils;
import d.b.g0.a.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f46056a;

    /* renamed from: b  reason: collision with root package name */
    public static String f46057b;

    /* renamed from: c  reason: collision with root package name */
    public static String f46058c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f46059d = k.f45443a;

    public static boolean a() {
        return Build.FINGERPRINT.contains("Flyme") || Pattern.compile("Flyme", 2).matcher(Build.DISPLAY).find();
    }

    public static boolean b() {
        if (f46056a == null) {
            f46056a = g("ro.miui.ui.version.name");
        }
        if (f46059d) {
            Log.d("ToastUtils", "OsName = " + f46056a);
        }
        return !TextUtils.isEmpty(f46056a);
    }

    public static boolean c() {
        if (f46058c == null) {
            f46058c = g("ro.build.version.opporom");
        }
        if (f46059d) {
            Log.d("ToastUtils", "OsName = " + f46058c);
        }
        return !TextUtils.isEmpty(f46058c);
    }

    public static boolean d() {
        String[] split;
        if (f46057b == null) {
            f46057b = g(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
        }
        if (f46059d) {
            Log.d("ToastUtils", "sMiuiVersion = " + f46057b);
        }
        if (!TextUtils.isEmpty(f46057b) && (split = f46057b.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
            String substring = split[0].substring(1);
            if (!TextUtils.isEmpty(substring)) {
                try {
                    if (Integer.parseInt(substring) < 9) {
                        return true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static Object f(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField;
        if (obj == null || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static String g(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            d.b.g0.p.d.a(bufferedReader);
            return readLine == null ? "" : readLine;
        } catch (IOException unused2) {
            bufferedReader2 = bufferedReader;
            d.b.g0.p.d.a(bufferedReader2);
            d.b.g0.p.d.a(bufferedReader2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            d.b.g0.p.d.a(bufferedReader2);
            throw th;
        }
    }

    public static boolean h(Context context) {
        Method method;
        if (context != null && Build.VERSION.SDK_INT >= 19) {
            try {
                Object systemService = context.getSystemService("appops");
                if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                    return false;
                }
                return ((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void i(Toast toast, @StyleRes int i) {
        Object f2;
        try {
            Object f3 = f(toast, "mTN");
            if (f3 == null || (f2 = f(f3, "mParams")) == null || !(f2 instanceof WindowManager.LayoutParams)) {
                return;
            }
            ((WindowManager.LayoutParams) f2).windowAnimations = i;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean j(Context context) {
        return a() && !h(context) && Build.VERSION.SDK_INT >= 23;
    }

    public static boolean k(Context context) {
        if (b()) {
            return (d() && h(context)) ? false : true;
        }
        return false;
    }

    public static boolean l(Context context) {
        return (k(context) || e()) || j(context);
    }
}

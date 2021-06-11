package d.a.l0.a.z1.b.f;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StyleRes;
import com.baidu.android.util.devices.RomUtils;
import d.a.l0.a.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49873a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static String f49874b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f49875c = null;

    /* loaded from: classes3.dex */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.2f);
                return false;
            } else if (action != 2) {
                view.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
    }

    public static boolean a() {
        return Build.FINGERPRINT.contains("Flyme") || Pattern.compile("Flyme", 2).matcher(Build.DISPLAY).find();
    }

    public static boolean b() {
        if (f49874b == null) {
            f49874b = f("ro.miui.ui.version.name");
        }
        if (f49873a) {
            Log.d("ToastUtils", "OsName = " + f49874b);
        }
        return !TextUtils.isEmpty(f49874b);
    }

    public static boolean c() {
        String[] split;
        if (f49875c == null) {
            f49875c = f(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
        }
        if (f49873a) {
            Log.d("ToastUtils", "sMiuiVersion = " + f49875c);
        }
        if (!TextUtils.isEmpty(f49875c) && (split = f49875c.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
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

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static Object e(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField;
        if (obj == null || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static String f(String str) {
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
            d.a.l0.t.d.d(bufferedReader);
            return readLine == null ? "" : readLine;
        } catch (IOException unused2) {
            bufferedReader2 = bufferedReader;
            d.a.l0.t.d.d(bufferedReader2);
            d.a.l0.t.d.d(bufferedReader2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            d.a.l0.t.d.d(bufferedReader2);
            throw th;
        }
    }

    public static boolean g(Context context) {
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

    public static void h(String str) {
        if (f49873a) {
            Log.d("ToastUtils", Log.getStackTraceString(new Throwable(str)));
        }
    }

    public static void i(View view) {
        if (view != null) {
            view.setOnTouchListener(new a());
        }
    }

    public static void j(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setColorFilter(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.a.c.aiapps_ui_cover_layer_color), PorterDuff.Mode.SRC_ATOP);
    }

    public static void k(Toast toast, @StyleRes int i2) {
        Object e2;
        try {
            Object e3 = e(toast, "mTN");
            if (e3 == null || (e2 = e(e3, "mParams")) == null || !(e2 instanceof WindowManager.LayoutParams)) {
                return;
            }
            ((WindowManager.LayoutParams) e2).windowAnimations = i2;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static boolean l(Context context) {
        return a() && !g(context) && Build.VERSION.SDK_INT >= 23;
    }

    public static boolean m(Context context) {
        if (b()) {
            return (c() && g(context)) ? false : true;
        }
        return false;
    }

    public static boolean n(Context context) {
        return (m(context) || d()) || l(context);
    }
}

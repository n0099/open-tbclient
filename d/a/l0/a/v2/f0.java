package d.a.l0.a.v2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49080a = d.a.l0.a.k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f49081b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f49082c;

    /* renamed from: d  reason: collision with root package name */
    public static String f49083d;

    public static boolean a(String str) {
        String str2 = f49082c;
        if (str2 != null) {
            return str2.equals(str);
        }
        String g2 = g("ro.miui.ui.version.name");
        f49083d = g2;
        if (!TextUtils.isEmpty(g2)) {
            f49082c = "MIUI";
        } else {
            String g3 = g("ro.build.version.emui");
            f49083d = g3;
            if (!TextUtils.isEmpty(g3)) {
                f49082c = "EMUI";
            } else {
                String g4 = g("ro.build.version.opporom");
                f49083d = g4;
                if (!TextUtils.isEmpty(g4)) {
                    f49082c = "OPPO";
                } else {
                    String g5 = g("ro.vivo.os.version");
                    f49083d = g5;
                    if (!TextUtils.isEmpty(g5)) {
                        f49082c = "VIVO";
                    } else {
                        String g6 = g("ro.smartisan.version");
                        f49083d = g6;
                        if (!TextUtils.isEmpty(g6)) {
                            f49082c = "SMARTISAN";
                        } else {
                            String g7 = g(RomUtils.KEY_VERSION_GIONEE);
                            f49083d = g7;
                            if (!TextUtils.isEmpty(g7)) {
                                f49082c = "SMARTISAN";
                            } else {
                                String g8 = g(RomUtils.KEY_VERSION_NUBIA);
                                f49083d = g8;
                                if (!TextUtils.isEmpty(g8)) {
                                    f49082c = RomUtils.ROM_NUBIA;
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f49083d = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f49082c = "FLYME";
                                    } else {
                                        f49083d = "unknown";
                                        f49082c = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f49082c.equals(str);
    }

    public static int b(Activity activity) {
        DisplayCutout c2 = c(activity);
        if (c2 == null || Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        List<Rect> boundingRects = c2.getBoundingRects();
        return boundingRects.get(0).right - boundingRects.get(0).left;
    }

    public static DisplayCutout c(Activity activity) {
        View decorView;
        WindowInsets rootWindowInsets;
        if (activity == null || activity.getWindow() == null || Build.VERSION.SDK_INT < 28 || (decorView = activity.getWindow().getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    public static boolean d() {
        return f49081b;
    }

    public static int e(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return 0;
        }
        if (i2 >= 28) {
            return f();
        }
        if (h(context)) {
            if (n()) {
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
            if (m()) {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]))[1];
                } catch (Exception unused2) {
                    return 0;
                }
            } else if (o()) {
                return 80;
            } else {
                if (r()) {
                    return n0.g(32.0f);
                }
                return 0;
            }
        }
        return 0;
    }

    @RequiresApi(28)
    public static int f() {
        DisplayCutout displayCutout;
        int i2 = 0;
        if (d.a.l0.a.a2.e.i() != null && d.a.l0.a.a2.e.i().k() != null) {
            try {
                WindowInsets rootWindowInsets = d.a.l0.a.a2.e.i().k().getWindow().getDecorView().getRootWindowInsets();
                if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                    return 0;
                }
                i2 = displayCutout.getSafeInsetTop();
                if (f49080a) {
                    Log.d("SwanAppRomUtils", "刘海屏高度:" + i2);
                }
            } catch (Exception e2) {
                if (f49080a) {
                    Log.w("SwanAppRomUtils", e2);
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0058: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:20:0x0058 */
    public static String g(String str) {
        BufferedReader bufferedReader;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    d.a.l0.t.d.d(bufferedReader);
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    if (f49080a) {
                        Log.e("SwanAppRomUtils", "Unable to read prop " + str, e);
                    }
                    d.a.l0.t.d.d(bufferedReader);
                    d.a.l0.t.d.d(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                d.a.l0.t.d.d(closeable2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.l0.t.d.d(closeable2);
            throw th;
        }
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        if (m()) {
            return i(context);
        }
        if (r()) {
            return l(context);
        }
        if (o()) {
            return k(context);
        }
        if (n()) {
            return j(context);
        }
        return false;
    }

    public static boolean i(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception e2) {
            if (f49080a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static boolean j(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception e2) {
            if (f49080a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static boolean k(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    @SuppressLint({"PrivateApi"})
    public static boolean l(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception e2) {
            if (f49080a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static boolean m() {
        return a("EMUI");
    }

    public static boolean n() {
        return a("MIUI");
    }

    public static boolean o() {
        return a("OPPO");
    }

    public static boolean p(Activity activity) {
        return c(activity) != null;
    }

    public static boolean q(Activity activity, View view) {
        DisplayCutout c2 = c(activity);
        if (c2 != null && Build.VERSION.SDK_INT >= 28) {
            List<Rect> boundingRects = c2.getBoundingRects();
            int i2 = boundingRects.get(0).left;
            int i3 = boundingRects.get(0).right;
            int i4 = boundingRects.get(0).top;
            int i5 = boundingRects.get(0).bottom;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            int i6 = iArr[0];
            int i7 = iArr[0] + width;
            int i8 = iArr[1];
            int i9 = iArr[1] + height;
            if (((i9 <= i5 && i9 > i4) || (i8 < i5 && i8 >= i4)) && ((i7 > i2 && i7 <= i3) || ((i6 >= i2 && i7 <= i3) || ((i6 >= i2 && i6 < i3) || (i6 < i2 && i7 > i3))))) {
                f49081b = true;
                return true;
            } else if (((i6 >= i2 && i6 < i3) || (i7 > i2 && i7 <= i3)) && ((i9 > i4 && i9 <= i5) || ((i8 >= i4 && i9 <= i5) || ((i8 >= i4 && i8 < i5) || (i8 < i4 && i9 > i5))))) {
                f49081b = true;
                return true;
            } else if (i6 <= i2 && i7 >= i3 && i8 <= i4 && i9 >= i5) {
                f49081b = true;
                return true;
            }
        }
        return false;
    }

    public static boolean r() {
        return a("VIVO");
    }

    public static void s(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            activity.getWindow().setAttributes(attributes);
        }
    }
}

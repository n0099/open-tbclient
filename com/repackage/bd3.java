package com.repackage;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes5.dex */
public class bd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String b;
    public static final String c;
    public static boolean d;
    public static String e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755830880, "Lcom/repackage/bd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755830880, "Lcom/repackage/bd3;");
                return;
            }
        }
        a = cg1.a;
        b = ae3.b;
        c = ae3.c;
        d = false;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String str2 = e;
            if (str2 != null) {
                return str2.equals(str);
            }
            String g = g("ro.miui.ui.version.name");
            f = g;
            if (!TextUtils.isEmpty(g)) {
                e = "MIUI";
            } else {
                String g2 = g("ro.build.version.emui");
                f = g2;
                if (!TextUtils.isEmpty(g2)) {
                    e = "EMUI";
                } else {
                    String g3 = g(c);
                    f = g3;
                    if (!TextUtils.isEmpty(g3)) {
                        e = b;
                    } else {
                        String g4 = g("ro.vivo.os.version");
                        f = g4;
                        if (!TextUtils.isEmpty(g4)) {
                            e = "VIVO";
                        } else {
                            String g5 = g("ro.smartisan.version");
                            f = g5;
                            if (!TextUtils.isEmpty(g5)) {
                                e = "SMARTISAN";
                            } else {
                                String g6 = g(RomUtils.KEY_VERSION_GIONEE);
                                f = g6;
                                if (!TextUtils.isEmpty(g6)) {
                                    e = "SMARTISAN";
                                } else {
                                    String g7 = g(RomUtils.KEY_VERSION_NUBIA);
                                    f = g7;
                                    if (!TextUtils.isEmpty(g7)) {
                                        e = RomUtils.ROM_NUBIA;
                                    } else {
                                        String str3 = Build.DISPLAY;
                                        f = str3;
                                        if (str3.toUpperCase().contains("FLYME")) {
                                            e = "FLYME";
                                        } else {
                                            f = "unknown";
                                            e = Build.MANUFACTURER.toUpperCase();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return e.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static int b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            DisplayCutout c2 = c(activity);
            if (c2 == null || Build.VERSION.SDK_INT < 28) {
                return 0;
            }
            List<Rect> boundingRects = c2.getBoundingRects();
            return boundingRects.get(0).right - boundingRects.get(0).left;
        }
        return invokeL.intValue;
    }

    public static DisplayCutout c(Activity activity) {
        InterceptResult invokeL;
        View decorView;
        WindowInsets rootWindowInsets;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            if (activity == null || activity.getWindow() == null || Build.VERSION.SDK_INT < 28 || (decorView = activity.getWindow().getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
                return null;
            }
            return rootWindowInsets.getDisplayCutout();
        }
        return (DisplayCutout) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d : invokeV.booleanValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i < 26) {
                return 0;
            }
            if (i >= 28) {
                return f();
            }
            if (h(context)) {
                if (n()) {
                    Resources resources = context.getResources();
                    try {
                        int identifier = resources.getIdentifier("notch_height", EMABTest.TYPE_DIMEN, "android");
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
                        return jd3.g(32.0f);
                    }
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @RequiresApi(28)
    public static int f() {
        InterceptResult invokeV;
        DisplayCutout displayCutout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int i = 0;
            if (sz2.M() != null && sz2.M().getActivity() != null) {
                try {
                    WindowInsets rootWindowInsets = sz2.M().getActivity().getWindow().getDecorView().getRootWindowInsets();
                    if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                        return 0;
                    }
                    i = displayCutout.getSafeInsetTop();
                    if (a) {
                        Log.d("SwanAppRomUtils", "刘海屏高度:" + i);
                    }
                } catch (Exception e2) {
                    if (a) {
                        Log.w("SwanAppRomUtils", e2);
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    uf4.d(bufferedReader);
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    if (a) {
                        Log.e("SwanAppRomUtils", "Unable to read prop " + str, e);
                    }
                    uf4.d(bufferedReader);
                    uf4.d(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                uf4.d(bufferedReader2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            uf4.d(bufferedReader2);
            throw th;
        }
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean i(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean j(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod(SharedPreferenceManager.OPERATION_GET_INT, String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean k(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context.getPackageManager().hasSystemFeature(ae3.d) : invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean l(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a("EMUI") : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a("MIUI") : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a(b) : invokeV.booleanValue;
    }

    public static boolean p(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, activity)) == null) ? c(activity) != null : invokeL.booleanValue;
    }

    public static boolean q(Activity activity, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, activity, view2)) == null) {
            DisplayCutout c2 = c(activity);
            if (c2 != null && Build.VERSION.SDK_INT >= 28) {
                List<Rect> boundingRects = c2.getBoundingRects();
                int i = boundingRects.get(0).left;
                int i2 = boundingRects.get(0).right;
                int i3 = boundingRects.get(0).top;
                int i4 = boundingRects.get(0).bottom;
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                int width = view2.getWidth();
                int height = view2.getHeight();
                int i5 = iArr[0];
                int i6 = iArr[0] + width;
                int i7 = iArr[1];
                int i8 = iArr[1] + height;
                if (((i8 <= i4 && i8 > i3) || (i7 < i4 && i7 >= i3)) && ((i6 > i && i6 <= i2) || ((i5 >= i && i6 <= i2) || ((i5 >= i && i5 < i2) || (i5 < i && i6 > i2))))) {
                    d = true;
                    return true;
                } else if (((i5 >= i && i5 < i2) || (i6 > i && i6 <= i2)) && ((i8 > i3 && i8 <= i4) || ((i7 >= i3 && i8 <= i4) || ((i7 >= i3 && i7 < i4) || (i7 < i3 && i8 > i4))))) {
                    d = true;
                    return true;
                } else if (i5 <= i && i6 >= i2 && i7 <= i3 && i8 >= i4) {
                    d = true;
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a("VIVO") : invokeV.booleanValue;
    }

    public static void s(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, activity) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        activity.getWindow().setAttributes(attributes);
    }
}

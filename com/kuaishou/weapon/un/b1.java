package com.kuaishou.weapon.un;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                String str = Build.VERSION.RELEASE;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static float a(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, displayMetrics)) == null) {
            if (displayMetrics == null) {
                return 0.0f;
            }
            try {
                return displayMetrics.xdpi;
            } catch (Throwable th) {
                l1.a(th);
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (Throwable th) {
                x0.a(th);
                return -2;
            }
        }
        return invokeV.intValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            DisplayMetrics c2 = c(context);
            if (c2 != null) {
                return Integer.toString(c2.densityDpi);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static float b(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, displayMetrics)) == null) {
            if (displayMetrics == null) {
                return 0.0f;
            }
            try {
                return displayMetrics.ydpi;
            } catch (Throwable th) {
                l1.a(th);
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                String b2 = x0.b("persist.service.bdroid.bdaddr");
                return TextUtils.isEmpty(b2) ? y0.f56911c : b2;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, IF, INVOKE, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, IF, INVOKE, MOVE_EXCEPTION] complete} */
    public static String b(Context context) {
        InterceptResult invokeL;
        InputStream inputStream;
        Throwable th;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        String str = null;
        try {
            process = Runtime.getRuntime().exec("cat /proc/version");
            try {
                inputStream = process.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    int read = inputStream.read(bArr);
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    String str2 = new String(bArr2, "utf-8");
                    int indexOf = str2.indexOf("version");
                    if (indexOf != -1) {
                        String[] split = str2.substring(indexOf).split(" ");
                        if (1 < split.length) {
                            str = split[1];
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            x0.a(th2);
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return str;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        x0.a(th);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th4) {
                                x0.a(th4);
                            }
                        }
                        if (process != null) {
                            process.destroy();
                            return y0.f56912d;
                        }
                        return y0.f56912d;
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th5) {
                                x0.a(th5);
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                    }
                }
            } catch (Throwable th6) {
                inputStream = null;
                th = th6;
            }
        } catch (Throwable th7) {
            inputStream = null;
            th = th7;
            process = null;
        }
    }

    public static DisplayMetrics c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                return displayMetrics;
            } catch (Throwable th) {
                x0.a(th);
                return null;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                String str = Build.BOARD;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return -1;
                }
                return telephonyManager.getPhoneType();
            } catch (Throwable th) {
                x0.a(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                String str = Build.BOOTLOADER;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                String str = Build.BRAND;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[Catch: all -> 0x0094, TRY_ENTER, TryCatch #0 {all -> 0x0094, blocks: (B:4:0x0004, B:6:0x001f, B:21:0x006e, B:23:0x0081, B:7:0x002d, B:9:0x0031, B:13:0x003b, B:15:0x0045), top: B:32:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:4:0x0004, B:6:0x001f, B:21:0x006e, B:23:0x0081, B:7:0x002d, B:9:0x0031, B:13:0x003b, B:15:0x0045), top: B:32:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context) {
        int i2;
        int intValue;
        int i3;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65549, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            int i4 = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i3 = point.x;
                intValue = point.y;
            } else if (Build.VERSION.SDK_INT >= 17 || Build.VERSION.SDK_INT < 14) {
                i2 = 0;
                if (i4 <= i2) {
                    return i2 + ProxyConfig.MATCH_ALL_SCHEMES + i4;
                }
                return i4 + ProxyConfig.MATCH_ALL_SCHEMES + i2;
            } else {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                int intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                i3 = intValue2;
            }
            int i5 = intValue;
            i4 = i3;
            i2 = i5;
            if (i4 <= i2) {
            }
        } catch (Throwable th) {
            l1.a(th);
            return "";
        }
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return -1;
                }
                return telephonyManager.isNetworkRoaming() ? 1 : 0;
            } catch (Throwable th) {
                x0.a(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                String str = Build.ID;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            try {
                String str = Build.VERSION.CODENAME;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[Catch: all -> 0x00d0, TRY_ENTER, TryCatch #0 {all -> 0x00d0, blocks: (B:5:0x0006, B:7:0x0021, B:19:0x006c, B:24:0x0086, B:27:0x00a3, B:29:0x00b9, B:8:0x002f, B:10:0x0033, B:14:0x003d, B:16:0x0047), top: B:39:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9 A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:5:0x0006, B:7:0x0021, B:19:0x006c, B:24:0x0086, B:27:0x00a3, B:29:0x00b9, B:8:0x002f, B:10:0x0033, B:14:0x003d, B:16:0x0047), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Context context) {
        InterceptResult invokeL;
        int i2;
        int intValue;
        int i3;
        float a;
        float b2;
        int round;
        int round2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                defaultDisplay.getMetrics(new DisplayMetrics());
                int i4 = 0;
                if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    i3 = point.x;
                    intValue = point.y;
                } else if (Build.VERSION.SDK_INT >= 17 || Build.VERSION.SDK_INT < 14) {
                    i2 = 0;
                    a = a(c(context));
                    b2 = b(c(context));
                    if (a != 0.0f && b2 != 0.0f) {
                        round = Math.round((i4 / a) * 2.54f) * 10;
                        round2 = Math.round((i2 / b2) * 2.54f) * 10;
                        if (round <= round2) {
                            return round2 + "mm * " + round + "mm";
                        }
                        return round + "mm * " + round2 + "mm";
                    }
                    return "";
                } else {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    int intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    intValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                    i3 = intValue2;
                }
                int i5 = intValue;
                i4 = i3;
                i2 = i5;
                a = a(c(context));
                b2 = b(c(context));
                if (a != 0.0f) {
                    round = Math.round((i4 / a) * 2.54f) * 10;
                    round2 = Math.round((i2 / b2) * 2.54f) * 10;
                    if (round <= round2) {
                    }
                }
                return "";
            } catch (Throwable th) {
                l1.a(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            try {
                String b2 = x0.b("ro.build.description");
                return TextUtils.isEmpty(b2) ? y0.f56911c : b2;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        return WebSettings.getDefaultUserAgent(context);
                    } catch (Throwable unused) {
                    }
                }
                return System.getProperty("http.agent");
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                String str = Build.DEVICE;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            try {
                String str = Build.DISPLAY;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            try {
                String str = Build.FINGERPRINT;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                String str = Build.HARDWARE;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                String b2 = x0.b("dalvik.vm.heapgrowthlimit");
                return TextUtils.isEmpty(b2) ? y0.f56911c : b2;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                String str = Build.HOST;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                String str = Build.VERSION.INCREMENTAL;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                String b2 = x0.b("rild.libpath");
                return TextUtils.isEmpty(b2) ? y0.f56911c : b2;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            try {
                String str = Build.MANUFACTURER;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                String str = Build.MODEL;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            try {
                String b2 = x0.b("ro.product.name");
                return TextUtils.isEmpty(b2) ? y0.f56911c : b2;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                String str = Build.PRODUCT;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            try {
                String str = Build.RADIO;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            try {
                String property = System.getProperty("http.agent");
                return TextUtils.isEmpty(property) ? y0.f56911c : property;
            } catch (Throwable unused) {
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                String str = Build.TAGS;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                String str = Build.TYPE;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                String str = Build.USER;
                return TextUtils.isEmpty(str) ? y0.f56911c : str;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f56912d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0070 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String z() {
        InterceptResult invokeV;
        Process process;
        InputStream inputStream;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65573, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            process = Runtime.getRuntime().exec("uname -a");
            try {
                InputStream inputStream2 = process.waitFor() == 0 ? process.getInputStream() : process.getErrorStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream2), 512);
                    try {
                        String readLine = bufferedReader.readLine();
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            x0.a(th2);
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable th3) {
                                x0.a(th3);
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        return readLine;
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            x0.a(th);
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th5) {
                                    x0.a(th5);
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th6) {
                                    x0.a(th6);
                                }
                            }
                            if (process != null) {
                                process.destroy();
                            }
                        }
                    }
                } catch (Throwable th7) {
                    inputStream = inputStream2;
                    th = th7;
                    InputStream inputStream3 = inputStream;
                    bufferedReader = null;
                    th = th;
                    inputStream2 = inputStream3;
                    x0.a(th);
                }
            } catch (Throwable th8) {
                th = th8;
                inputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
            process = null;
            inputStream = null;
        }
    }
}

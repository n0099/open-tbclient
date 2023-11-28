package com.kuaishou.weapon.p0;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
/* loaded from: classes10.dex */
public class bl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                String a = bh.a("persist.service.bdroid.bdaddr");
                if (TextUtils.isEmpty(a)) {
                    return bi.c;
                }
                return a;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v2 int)] */
    public static String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                int numberOfCameras = Camera.getNumberOfCameras();
                StringBuilder sb = new StringBuilder();
                sb.append(numberOfCameras);
                return sb.toString();
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                return f.a(new File("/system/bin/app_process"));
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                File file = new File("/system/bin/servicemanager");
                if (file.exists() && file.canRead()) {
                    return f.a(file);
                }
                return bi.d;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                File file = new File("/system/framework/framework.jar");
                if (file.exists() && file.canRead()) {
                    return f.a(file);
                }
                return bi.d;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                return Build.getRadioVersion();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                String str = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            try {
                String str = Build.BRAND;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            try {
                String str = Build.MODEL;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            try {
                String str = Build.HARDWARE;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                String str = Build.PRODUCT;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                String str = Build.DEVICE;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            try {
                String str = Build.BOARD;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            try {
                String str = Build.HOST;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            try {
                String str = Build.USER;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                String str = Build.TYPE;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                String str = Build.TAGS;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                String str = Build.BOOTLOADER;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                String str = Build.ID;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            try {
                String str = Build.DISPLAY;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                String str = Build.VERSION.CODENAME;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            try {
                String a = bh.a("rild.libpath");
                if (TextUtils.isEmpty(a)) {
                    return bi.c;
                }
                return a;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            try {
                String str = Build.VERSION.RELEASE;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeV.intValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            try {
                String str = Build.FINGERPRINT;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            try {
                String property = System.getProperty("http.agent");
                if (TextUtils.isEmpty(property)) {
                    return bi.c;
                }
                return property;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            try {
                String str = Build.RADIO;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            try {
                String a = bh.a("ro.build.description");
                if (TextUtils.isEmpty(a)) {
                    return bi.c;
                }
                return a;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            try {
                String str = Build.VERSION.INCREMENTAL;
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                String a = bh.a("ro.product.name");
                if (TextUtils.isEmpty(a)) {
                    return bi.c;
                }
                return a;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            try {
                String a = bh.a("dalvik.vm.heapgrowthlimit");
                if (TextUtils.isEmpty(a)) {
                    return bi.c;
                }
                return a;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str = (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, "gsm.version.baseband");
                if (TextUtils.isEmpty(str)) {
                    return bi.c;
                }
                return str;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String F() {
        File externalStorageDirectory;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                    return BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
                }
                return bi.a;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String G() {
        File externalStorageDirectory;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                    return BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
                }
                return bi.a;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static long H() {
        BufferedReader bufferedReader;
        String readLine;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                    }
                } catch (Throwable unused2) {
                    if (bufferedReader == null) {
                        return 0L;
                    }
                    bufferedReader.close();
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                    return 0L;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
            try {
                bufferedReader.close();
            } catch (IOException unused4) {
            }
            return longValue;
        }
        return invokeV.longValue;
    }

    public static float a(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, displayMetrics)) == null) {
            if (displayMetrics == null) {
                return 0.0f;
            }
            try {
                return displayMetrics.xdpi;
            } catch (Throwable unused) {
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }

    public static float b(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, displayMetrics)) == null) {
            if (displayMetrics == null) {
                return 0.0f;
            }
            try {
                return displayMetrics.ydpi;
            } catch (Throwable unused) {
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            DisplayMetrics j = j(context);
            if (j != null) {
                return Integer.toString(j.densityDpi);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
            } catch (Exception unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                return ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Exception unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static DisplayMetrics j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                return displayMetrics;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return -1;
                }
                return telephonyManager.getPhoneType();
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        String defaultUserAgent;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    } catch (Throwable unused) {
                    }
                    if (!TextUtils.isEmpty(defaultUserAgent)) {
                        return bi.c;
                    }
                    return defaultUserAgent;
                }
                defaultUserAgent = System.getProperty("http.agent");
                if (!TextUtils.isEmpty(defaultUserAgent)) {
                }
            } catch (Throwable unused2) {
                return bi.d;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                defaultDisplay.getMetrics(new DisplayMetrics());
                int i2 = 0;
                if (Build.VERSION.SDK_INT >= 31) {
                    WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                    i2 = maximumWindowMetrics.getBounds().width();
                    i = maximumWindowMetrics.getBounds().height();
                } else if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    i2 = point.x;
                    i = point.y;
                } else if (Build.VERSION.SDK_INT < 17 && Build.VERSION.SDK_INT >= 14) {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    int intValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                    i2 = intValue;
                } else {
                    i = 0;
                }
                float a = a(j(context));
                float b = b(j(context));
                if (a != 0.0f && b != 0.0f) {
                    int round = Math.round((i2 / a) * 2.54f) * 10;
                    int round2 = Math.round((i / b) * 2.54f) * 10;
                    if (round > round2) {
                        return round2 + "mm * " + round + FunAdSdk.PLATFORM_MM;
                    }
                    return round + "mm * " + round2 + FunAdSdk.PLATFORM_MM;
                }
            } catch (Throwable unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                defaultDisplay.getMetrics(new DisplayMetrics());
                int i2 = 0;
                if (Build.VERSION.SDK_INT >= 31) {
                    WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                    i2 = maximumWindowMetrics.getBounds().width();
                    i = maximumWindowMetrics.getBounds().height();
                } else if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    i2 = point.x;
                    i = point.y;
                } else if (Build.VERSION.SDK_INT < 17 && Build.VERSION.SDK_INT >= 14) {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    int intValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                    i2 = intValue;
                } else {
                    i = 0;
                }
                if (i2 > i) {
                    return i + "*" + i2;
                }
                return i2 + "*" + i;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            InputStream inputStream = null;
            r7 = null;
            String str = null;
            inputStream = null;
            try {
                process = Runtime.getRuntime().exec("cat /proc/version");
                try {
                    InputStream inputStream2 = process.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int read = inputStream2.read(bArr);
                        if (read <= 0) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (process != null) {
                                process.destroy();
                            }
                            return bi.c;
                        }
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
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (process != null) {
                                process.destroy();
                            }
                            return bi.c;
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        return str;
                    } catch (Throwable unused4) {
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        if (process != null) {
                            process.destroy();
                            return bi.d;
                        }
                        return bi.d;
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                process = null;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            try {
                Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                declaredMethod.setAccessible(true);
                if (((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), new Object[0])).booleanValue()) {
                    return 0;
                }
                return 1;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String u() {
        InterceptResult invokeV;
        Process process;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            BufferedReader bufferedReader = null;
            try {
                process = Runtime.getRuntime().exec("uname -a");
                try {
                    if (process.waitFor() == 0) {
                        inputStream = process.getInputStream();
                    } else {
                        inputStream = process.getErrorStream();
                    }
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream), 512);
                        try {
                            String readLine = bufferedReader2.readLine();
                            try {
                                bufferedReader2.close();
                            } catch (Throwable unused) {
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (process != null) {
                                process.destroy();
                            }
                            return readLine;
                        } catch (Throwable unused3) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused5) {
                                }
                            }
                            if (process != null) {
                                process.destroy();
                                return bi.d;
                            }
                            return bi.d;
                        }
                    } catch (Throwable unused6) {
                    }
                } catch (Throwable unused7) {
                    inputStream = null;
                }
            } catch (Throwable unused8) {
                process = null;
                inputStream = null;
            }
        } else {
            return (String) invokeV.objValue;
        }
    }
}

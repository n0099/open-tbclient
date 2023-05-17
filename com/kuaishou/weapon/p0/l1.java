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
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
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
/* loaded from: classes9.dex */
public class l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l1() {
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
            if (Build.VERSION.SDK_INT >= 14) {
                return Build.getRadioVersion();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static long B() {
        BufferedReader bufferedReader;
        String readLine;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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
                    return 0L;
                }
                try {
                    bufferedReader.close();
                    return 0L;
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

    public static String C() {
        InterceptResult invokeV;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? i1.a : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String D() {
        InterceptResult invokeV;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? i1.a : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                File file = new File("/system/bin/servicemanager");
                return (file.exists() && file.canRead()) ? g.a(file) : i1.d;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                String property = System.getProperty("http.agent");
                return TextUtils.isEmpty(property) ? i1.c : property;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                String str = Build.TAGS;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                String str = Build.TYPE;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                String str = Build.USER;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String K() {
        InterceptResult invokeV;
        Process process;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65547, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader = null;
        try {
            process = Runtime.getRuntime().exec("uname -a");
            try {
                inputStream = process.waitFor() == 0 ? process.getInputStream() : process.getErrorStream();
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
                            return i1.d;
                        }
                        return i1.d;
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
    }

    public static String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                String str = Build.VERSION.RELEASE;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
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

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeV.intValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            DisplayMetrics c = c(context);
            if (c != null) {
                return Integer.toString(c.densityDpi);
            }
            return null;
        }
        return (String) invokeL.objValue;
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

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            try {
                return g.a(new File("/system/bin/app_process"));
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65554, null, context)) != null) {
            return (String) invokeL.objValue;
        }
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
                        return i1.c;
                    }
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    String str2 = new String(bArr2, IMAudioTransRequest.CHARSET);
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
                        return i1.c;
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
                        return i1.d;
                    }
                    return i1.d;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            process = null;
        }
    }

    public static DisplayMetrics c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                return displayMetrics;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
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

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            try {
                String a = h1.a("persist.service.bdroid.bdaddr");
                return TextUtils.isEmpty(a) ? i1.c : a;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str = (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, "gsm.version.baseband");
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088 A[Catch: all -> 0x00ae, TRY_ENTER, TryCatch #0 {all -> 0x00ae, blocks: (B:4:0x0004, B:6:0x001f, B:25:0x0088, B:27:0x009b, B:8:0x0035, B:10:0x003b, B:11:0x0048, B:13:0x004c, B:17:0x0056, B:19:0x0060), top: B:35:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #0 {all -> 0x00ae, blocks: (B:4:0x0004, B:6:0x001f, B:25:0x0088, B:27:0x009b, B:8:0x0035, B:10:0x003b, B:11:0x0048, B:13:0x004c, B:17:0x0056, B:19:0x0060), top: B:35:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context) {
        int i;
        int intValue;
        int i2;
        int i3;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65560, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            int i4 = 0;
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i2 = maximumWindowMetrics.getBounds().width();
                i3 = maximumWindowMetrics.getBounds().height();
            } else if (Build.VERSION.SDK_INT >= 17) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i2 = point.x;
                i3 = point.y;
            } else if (Build.VERSION.SDK_INT >= 17 || Build.VERSION.SDK_INT < 14) {
                i = 0;
                if (i4 > i) {
                    return i + "*" + i4;
                }
                return i4 + "*" + i;
            } else {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                int intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                i2 = intValue2;
                i = intValue;
                i4 = i2;
                if (i4 > i) {
                }
            }
            intValue = i3;
            i = intValue;
            i4 = i2;
            if (i4 > i) {
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            try {
                return ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Exception unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                String str = Build.BOARD;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
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

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            try {
                String str = Build.BOOTLOADER;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                String str = Build.BRAND;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bc A[Catch: all -> 0x00e8, TRY_ENTER, TryCatch #0 {all -> 0x00e8, blocks: (B:5:0x0006, B:7:0x0021, B:23:0x0086, B:27:0x009f, B:30:0x00bc, B:32:0x00d2, B:9:0x0037, B:11:0x003d, B:12:0x004a, B:14:0x004e, B:18:0x0058, B:20:0x0062), top: B:40:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2 A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #0 {all -> 0x00e8, blocks: (B:5:0x0006, B:7:0x0021, B:23:0x0086, B:27:0x009f, B:30:0x00bc, B:32:0x00d2, B:9:0x0037, B:11:0x003d, B:12:0x004a, B:14:0x004e, B:18:0x0058, B:20:0x0062), top: B:40:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context) {
        InterceptResult invokeL;
        WindowManager windowManager;
        Display defaultDisplay;
        int i;
        int i2;
        int intValue;
        int i3;
        int i4;
        float a;
        float b;
        int round;
        int round2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                windowManager = (WindowManager) context.getSystemService("window");
                defaultDisplay = windowManager.getDefaultDisplay();
                defaultDisplay.getMetrics(new DisplayMetrics());
                i = 0;
            } catch (Throwable unused) {
            }
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i3 = maximumWindowMetrics.getBounds().width();
                i4 = maximumWindowMetrics.getBounds().height();
            } else if (Build.VERSION.SDK_INT < 17) {
                if (Build.VERSION.SDK_INT < 17 && Build.VERSION.SDK_INT >= 14) {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    int intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    intValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                    i3 = intValue2;
                    i2 = intValue;
                    i = i3;
                    a = a(c(context));
                    b = b(c(context));
                    if (a != 0.0f) {
                        round = Math.round((i / a) * 2.54f) * 10;
                        round2 = Math.round((i2 / b) * 2.54f) * 10;
                        if (round <= round2) {
                        }
                    }
                    return "";
                }
                i2 = 0;
                a = a(c(context));
                b = b(c(context));
                if (a != 0.0f && b != 0.0f) {
                    round = Math.round((i / a) * 2.54f) * 10;
                    round2 = Math.round((i2 / b) * 2.54f) * 10;
                    if (round <= round2) {
                        return round2 + "mm * " + round + FunAdSdk.PLATFORM_MM;
                    }
                    return round + "mm * " + round2 + FunAdSdk.PLATFORM_MM;
                }
                return "";
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i3 = point.x;
                i4 = point.y;
            }
            intValue = i4;
            i2 = intValue;
            i = i3;
            a = a(c(context));
            b = b(c(context));
            if (a != 0.0f) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                String str = Build.ID;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(Context context) {
        String defaultUserAgent;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65568, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                }
                return !TextUtils.isEmpty(defaultUserAgent) ? i1.c : defaultUserAgent;
            }
            defaultUserAgent = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(defaultUserAgent)) {
            }
        } catch (Throwable unused2) {
            return i1.d;
        }
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            try {
                Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                declaredMethod.setAccessible(true);
                return !((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), new Object[0])).booleanValue();
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                String str = Build.VERSION.CODENAME;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                String a = h1.a("ro.build.description");
                return TextUtils.isEmpty(a) ? i1.c : a;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                String str = Build.DEVICE;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                String str = Build.DISPLAY;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            try {
                String str = Build.FINGERPRINT;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                File file = new File("/system/framework/framework.jar");
                return (file.exists() && file.canRead()) ? g.a(file) : i1.d;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            try {
                String str = Build.HARDWARE;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            try {
                String a = h1.a("dalvik.vm.heapgrowthlimit");
                return TextUtils.isEmpty(a) ? i1.c : a;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            try {
                String str = Build.HOST;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            try {
                String str = Build.VERSION.INCREMENTAL;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            try {
                String a = h1.a("rild.libpath");
                return TextUtils.isEmpty(a) ? i1.c : a;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            try {
                String str = Build.MANUFACTURER;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            try {
                String str = Build.MODEL;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            try {
                String a = h1.a("ro.product.name");
                return TextUtils.isEmpty(a) ? i1.c : a;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v2 int)] */
    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            try {
                int numberOfCameras = Camera.getNumberOfCameras();
                StringBuilder sb = new StringBuilder();
                sb.append(numberOfCameras);
                return sb.toString();
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                String str = Build.PRODUCT;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            try {
                String str = Build.RADIO;
                return TextUtils.isEmpty(str) ? i1.c : str;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeV.objValue;
    }
}

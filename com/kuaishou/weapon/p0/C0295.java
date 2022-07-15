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
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
/* renamed from: com.kuaishou.weapon.p0.ʻʾ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0295 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0295() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static float m91(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, displayMetrics)) == null) {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static int m92() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (Throwable unused) {
                return -2;
            }
        }
        return invokeV.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m93(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            DisplayMetrics m99 = m99(context);
            if (m99 != null) {
                return Integer.toString(m99.densityDpi);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻʻ  reason: contains not printable characters */
    public static String m94() {
        InterceptResult invokeV;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? C0453.f693 : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Exception unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static float m95(DisplayMetrics displayMetrics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, displayMetrics)) == null) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m96() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                return C0304.m173(new File("/system/bin/app_process"));
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m97(Context context) {
        InterceptResult invokeL;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, context)) != null) {
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
                        return C0453.f697;
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
                        return C0453.f697;
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
                        return C0453.f699;
                    }
                    return C0453.f699;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            process = null;
        }
    }

    /* renamed from: ʼʼ  reason: contains not printable characters */
    public static String m98() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                File file = new File("/system/bin/servicemanager");
                return (file.exists() && file.canRead()) ? C0304.m173(file) : C0453.f699;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static DisplayMetrics m99(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m100() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Exception unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʽʽ  reason: contains not printable characters */
    public static String m101() {
        InterceptResult invokeV;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? C0453.f693 : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Exception unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static int m102(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
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

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String m103() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            try {
                String m854 = C0433.m854("persist.service.bdroid.bdaddr");
                return TextUtils.isEmpty(m854) ? C0453.f697 : m854;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʾʾ  reason: contains not printable characters */
    public static String m104() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            try {
                String str = Build.TAGS;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public static String m105() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(cls, "gsm.version.baseband");
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088 A[Catch: all -> 0x00ae, TRY_ENTER, TryCatch #0 {all -> 0x00ae, blocks: (B:4:0x0004, B:6:0x001f, B:25:0x0088, B:27:0x009b, B:8:0x0035, B:10:0x003b, B:11:0x0048, B:13:0x004c, B:17:0x0056, B:19:0x0060), top: B:35:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #0 {all -> 0x00ae, blocks: (B:4:0x0004, B:6:0x001f, B:25:0x0088, B:27:0x009b, B:8:0x0035, B:10:0x003b, B:11:0x0048, B:13:0x004c, B:17:0x0056, B:19:0x0060), top: B:35:0x0004 }] */
    /* renamed from: ʿ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m106(Context context) {
        int i;
        int intValue;
        int i2;
        int i3;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65552, null, context)) != null) {
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

    /* renamed from: ʿʿ  reason: contains not printable characters */
    public static String m107() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            try {
                String property = System.getProperty("http.agent");
                return TextUtils.isEmpty(property) ? C0453.f697 : property;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public static int m108(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                return ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Exception unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public static String m109() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            try {
                String str = Build.BOARD;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˆˆ  reason: contains not printable characters */
    public static String m110() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                String str = Build.TYPE;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public static int m111(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
            } catch (Exception unused) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public static String m112() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            try {
                String str = Build.BOOTLOADER;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˈˈ  reason: contains not printable characters */
    public static String m113() {
        InterceptResult invokeV;
        Process process;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65559, null)) != null) {
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
                            return C0453.f699;
                        }
                        return C0453.f699;
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

    /* renamed from: ˉ  reason: contains not printable characters */
    public static String m114() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                String str = Build.BRAND;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bc A[Catch: all -> 0x00e8, TRY_ENTER, TryCatch #0 {all -> 0x00e8, blocks: (B:5:0x0006, B:7:0x0021, B:23:0x0086, B:27:0x009f, B:30:0x00bc, B:32:0x00d2, B:9:0x0037, B:11:0x003d, B:12:0x004a, B:14:0x004e, B:18:0x0058, B:20:0x0062), top: B:40:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2 A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #0 {all -> 0x00e8, blocks: (B:5:0x0006, B:7:0x0021, B:23:0x0086, B:27:0x009f, B:30:0x00bc, B:32:0x00d2, B:9:0x0037, B:11:0x003d, B:12:0x004a, B:14:0x004e, B:18:0x0058, B:20:0x0062), top: B:40:0x0006 }] */
    /* renamed from: ˉ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m115(Context context) {
        InterceptResult invokeL;
        WindowManager windowManager;
        Display defaultDisplay;
        int i;
        int i2;
        int intValue;
        int i3;
        int i4;
        float m91;
        float m95;
        int round;
        int round2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
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
                    m91 = m91(m99(context));
                    m95 = m95(m99(context));
                    if (m91 != 0.0f) {
                        round = Math.round((i / m91) * 2.54f) * 10;
                        round2 = Math.round((i2 / m95) * 2.54f) * 10;
                        if (round <= round2) {
                        }
                    }
                    return "";
                }
                i2 = 0;
                m91 = m91(m99(context));
                m95 = m95(m99(context));
                if (m91 != 0.0f && m95 != 0.0f) {
                    round = Math.round((i / m91) * 2.54f) * 10;
                    round2 = Math.round((i2 / m95) * 2.54f) * 10;
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
            m91 = m91(m99(context));
            m95 = m95(m99(context));
            if (m91 != 0.0f) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ˉˉ  reason: contains not printable characters */
    public static String m116() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                String str = Build.USER;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m117() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                String str = Build.ID;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: ˊ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m118(Context context) {
        String defaultUserAgent;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65564, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                }
                return !TextUtils.isEmpty(defaultUserAgent) ? C0453.f697 : defaultUserAgent;
            }
            defaultUserAgent = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(defaultUserAgent)) {
            }
        } catch (Throwable unused2) {
            return C0453.f699;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m119(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
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

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m120() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            try {
                String str = Build.VERSION.CODENAME;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public static String m121() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                String str = Build.VERSION.RELEASE;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m122() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            try {
                String m854 = C0433.m854("ro.build.description");
                return TextUtils.isEmpty(m854) ? C0453.f697 : m854;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m123() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            try {
                String str = Build.DEVICE;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public static String m124() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                String str = Build.DISPLAY;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: י  reason: contains not printable characters */
    public static String m125() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                String str = Build.FINGERPRINT;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ـ  reason: contains not printable characters */
    public static String m126() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                File file = new File("/system/framework/framework.jar");
                return (file.exists() && file.canRead()) ? C0304.m173(file) : C0453.f699;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ــ  reason: contains not printable characters */
    public static String m127() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
            } catch (Exception unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ٴ  reason: contains not printable characters */
    public static String m128() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            try {
                String str = Build.HARDWARE;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static String m129() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                String m854 = C0433.m854("dalvik.vm.heapgrowthlimit");
                return TextUtils.isEmpty(m854) ? C0453.f697 : m854;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ᐧᐧ  reason: contains not printable characters */
    public static String m130() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                return Build.getRadioVersion();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static String m131() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            try {
                String str = Build.HOST;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ᴵᴵ  reason: contains not printable characters */
    public static long m132() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            do {
                try {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                        }
                    } catch (Exception unused2) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 == null) {
                            return 0L;
                        }
                        bufferedReader = bufferedReader2;
                        bufferedReader.close();
                        return 0L;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                    bufferedReader.close();
                    return 0L;
                } catch (IOException unused4) {
                    return 0L;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return longValue;
        }
        return invokeV.longValue;
    }

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static String m133() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            try {
                String str = Build.VERSION.INCREMENTAL;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static String m134() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            try {
                String m854 = C0433.m854("rild.libpath");
                return TextUtils.isEmpty(m854) ? C0453.f697 : m854;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ᵢ  reason: contains not printable characters */
    public static String m135() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            try {
                String str = Build.MANUFACTURER;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ⁱ  reason: contains not printable characters */
    public static String m136() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            try {
                String str = Build.MODEL;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ﹳ  reason: contains not printable characters */
    public static String m137() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            try {
                String m854 = C0433.m854("ro.product.name");
                return TextUtils.isEmpty(m854) ? C0453.f697 : m854;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v2 int)] */
    /* renamed from: ﹶ  reason: contains not printable characters */
    public static String m138() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            try {
                int numberOfCameras = Camera.getNumberOfCameras();
                StringBuilder sb = new StringBuilder();
                sb.append(numberOfCameras);
                return sb.toString();
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static String m139() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                String str = Build.PRODUCT;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ﾞﾞ  reason: contains not printable characters */
    public static String m140() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            try {
                String str = Build.RADIO;
                return TextUtils.isEmpty(str) ? C0453.f697 : str;
            } catch (Throwable unused) {
                return C0453.f699;
            }
        }
        return (String) invokeV.objValue;
    }
}

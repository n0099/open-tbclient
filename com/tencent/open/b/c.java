package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f38925a;

    /* renamed from: b  reason: collision with root package name */
    public static String f38926b;

    /* renamed from: c  reason: collision with root package name */
    public static String f38927c;

    /* renamed from: d  reason: collision with root package name */
    public static String f38928d;

    /* renamed from: e  reason: collision with root package name */
    public static String f38929e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2039309702, "Lcom/tencent/open/b/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2039309702, "Lcom/tencent/open/b/c;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Context a2 = com.tencent.open.utils.e.a();
                return (a2 == null || (wifiManager = (WifiManager) a2.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
            } catch (SecurityException e2) {
                com.tencent.open.a.f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Locale.getDefault().getLanguage() : (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            String str = f38926b;
            if (str == null || str.length() <= 0) {
                if (context == null) {
                    return "";
                }
                try {
                    String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                    f38926b = simSerialNumber;
                    return simSerialNumber;
                } catch (Exception unused) {
                    return "";
                }
            }
            return f38926b;
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String str = f38927c;
            if (str == null || str.length() <= 0) {
                if (context == null) {
                    return "";
                }
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    f38927c = string;
                    return string;
                } catch (Exception unused) {
                    return "";
                }
            }
            return f38927c;
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                if (f38929e == null) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    StringBuilder sb = new StringBuilder();
                    sb.append("imei=");
                    sb.append(b(context));
                    sb.append(Typography.amp);
                    sb.append("model=");
                    sb.append(Build.MODEL);
                    sb.append(Typography.amp);
                    sb.append("os=");
                    sb.append(Build.VERSION.RELEASE);
                    sb.append(Typography.amp);
                    sb.append("apilevel=");
                    sb.append(Build.VERSION.SDK_INT);
                    sb.append(Typography.amp);
                    String b2 = a.b(context);
                    if (b2 == null) {
                        b2 = "";
                    }
                    sb.append("network=");
                    sb.append(b2);
                    sb.append(Typography.amp);
                    sb.append("sdcard=");
                    sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                    sb.append(Typography.amp);
                    sb.append("display=");
                    sb.append(displayMetrics.widthPixels);
                    sb.append('*');
                    sb.append(displayMetrics.heightPixels);
                    sb.append(Typography.amp);
                    sb.append("manu=");
                    sb.append(Build.MANUFACTURER);
                    sb.append("&");
                    sb.append("wifi=");
                    sb.append(a.e(context));
                    f38929e = sb.toString();
                }
                return f38929e;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str = f38925a;
            if (str == null || str.length() <= 0) {
                if (context == null) {
                    return "";
                }
                try {
                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    f38925a = deviceId;
                    return deviceId;
                } catch (Exception unused) {
                    return "";
                }
            }
            return f38925a;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f38928d)) {
                if (context == null) {
                    return "";
                }
                f38928d = "";
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (windowManager != null) {
                    int width = windowManager.getDefaultDisplay().getWidth();
                    int height = windowManager.getDefaultDisplay().getHeight();
                    f38928d = width + "x" + height;
                }
                return f38928d;
            }
            return f38928d;
        }
        return (String) invokeL.objValue;
    }
}

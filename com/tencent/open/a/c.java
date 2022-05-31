package com.tencent.open.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2039279911, "Lcom/tencent/open/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2039279911, "Lcom/tencent/open/a/c;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(a)) {
                if (context == null) {
                    return "";
                }
                a = "";
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (windowManager != null) {
                    int width = windowManager.getDefaultDisplay().getWidth();
                    int height = windowManager.getDefaultDisplay().getHeight();
                    a = width + "x" + height;
                }
                return a;
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Locale.getDefault().getLanguage() : (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                if (b == null) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    StringBuilder sb = new StringBuilder();
                    sb.append("imei=");
                    sb.append(b(context));
                    sb.append('&');
                    sb.append("model=");
                    sb.append(Build.MODEL);
                    sb.append('&');
                    sb.append("os=");
                    sb.append(Build.VERSION.RELEASE);
                    sb.append('&');
                    sb.append("apilevel=");
                    sb.append(Build.VERSION.SDK_INT);
                    sb.append('&');
                    String b2 = a.b(context);
                    if (b2 == null) {
                        b2 = "";
                    }
                    sb.append("network=");
                    sb.append(b2);
                    sb.append('&');
                    sb.append("sdcard=");
                    sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                    sb.append('&');
                    sb.append("display=");
                    sb.append(displayMetrics.widthPixels);
                    sb.append('*');
                    sb.append(displayMetrics.heightPixels);
                    sb.append('&');
                    sb.append("manu=");
                    sb.append(Build.MANUFACTURER);
                    sb.append("&");
                    sb.append("wifi=");
                    sb.append(a.e(context));
                    b = sb.toString();
                }
                return b;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}

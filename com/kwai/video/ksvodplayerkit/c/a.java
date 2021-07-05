package com.kwai.video.ksvodplayerkit.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String trim = str.trim();
            if (trim.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
                String[] split = trim.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                return Integer.parseInt(split[0]) < 255 && Integer.parseInt(split[1]) < 255 && Integer.parseInt(split[2]) < 255 && Integer.parseInt(split[3]) < 255;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return Uri.parse(str).getHost().toLowerCase(Locale.US);
            } catch (Exception e2) {
                throw new RuntimeException("Illegal url:" + str, e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnected()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3g";
                case 13:
                    return "4g";
                default:
                    return "Notfound";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (b(context)) {
                return 1;
            }
            String c2 = c(context);
            char c3 = 65535;
            int hashCode = c2.hashCode();
            if (hashCode != 1653) {
                if (hashCode != 1684) {
                    if (hashCode == 1715 && c2.equals("4g")) {
                        c3 = 2;
                    }
                } else if (c2.equals("3g")) {
                    c3 = 1;
                }
            } else if (c2.equals("2g")) {
                c3 = 0;
            }
            if (c3 != 0) {
                if (c3 != 1) {
                    return c3 != 2 ? 0 : 2;
                }
                return 3;
            }
            return 4;
        }
        return invokeL.intValue;
    }
}

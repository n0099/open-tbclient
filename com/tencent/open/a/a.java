package com.tencent.open.a;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ConectivityUtils;
import com.tencent.open.log.SLog;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f70012a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039279849, "Lcom/tencent/open/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039279849, "Lcom/tencent/open/a/a;");
                return;
            }
        }
        f70012a = Uri.parse("content://telephony/carriers/preferapn");
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            int d2 = d(context);
            if (d2 == 2) {
                return "wifi";
            }
            if (d2 == 1) {
                return ConectivityUtils.APN_CMWAP;
            }
            if (d2 == 4) {
                return ConectivityUtils.APN_CMNET;
            }
            if (d2 == 16) {
                return ConectivityUtils.APN_UNIWAP;
            }
            if (d2 == 8) {
                return ConectivityUtils.APN_UNINET;
            }
            if (d2 == 64) {
                return "wap";
            }
            if (d2 == 32) {
                return "net";
            }
            if (d2 == 512) {
                return ConectivityUtils.APN_CTWAP;
            }
            if (d2 == 256) {
                return ConectivityUtils.APN_CTNET;
            }
            if (d2 == 2048) {
                return ConectivityUtils.APN_3GNET;
            }
            if (d2 == 1024) {
                return ConectivityUtils.APN_3GWAP;
            }
            String b2 = b(context);
            return (b2 == null || b2.length() == 0) ? "none" : b2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                Cursor query = context.getContentResolver().query(f70012a, null, null, null, null);
                if (query == null) {
                    return null;
                }
                query.moveToFirst();
                if (query.isAfterLast()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                String string = query.getString(query.getColumnIndex("proxy"));
                if (query != null) {
                    query.close();
                }
                return string;
            } catch (SecurityException e2) {
                SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e2.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e2.getMessage());
            }
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 128;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING)) {
                return 2;
            }
            String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP)) {
                return 1;
            }
            if (!lowerCase.startsWith(ConectivityUtils.APN_CMNET) && !lowerCase.startsWith("epc.tmobile.com")) {
                if (lowerCase.startsWith(ConectivityUtils.APN_UNIWAP)) {
                    return 16;
                }
                if (lowerCase.startsWith(ConectivityUtils.APN_UNINET)) {
                    return 8;
                }
                if (lowerCase.startsWith("wap")) {
                    return 64;
                }
                if (lowerCase.startsWith("net")) {
                    return 32;
                }
                if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                    return 512;
                }
                if (lowerCase.startsWith(ConectivityUtils.APN_CTNET)) {
                    return 256;
                }
                if (lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                    return 1024;
                }
                if (lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                    return 2048;
                }
                if (lowerCase.startsWith("#777")) {
                    String c2 = c(context);
                    if (c2 != null) {
                        if (c2.length() > 0) {
                            return 512;
                        }
                    }
                    return 256;
                }
                return 128;
            }
            return 4;
        }
        return invokeL.intValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "MOBILE" : activeNetworkInfo.getTypeName();
        }
        return (String) invokeL.objValue;
    }
}

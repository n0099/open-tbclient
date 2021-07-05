package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo == null || (state = networkInfo.getState()) == null || !(state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return "2G";
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return com.baidu.apollon.statistics.g.f3983b;
                            case 13:
                                return "4G";
                        }
                    }
                    return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
                }
                return "unknow";
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "getNetworkState:", th);
                return StringUtil.NULL_STRING;
            }
        }
        return (String) invokeL.objValue;
    }
}

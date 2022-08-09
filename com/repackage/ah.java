package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ah {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (oi.H()) {
                return "WIFI";
            }
            if (oi.x()) {
                int f = oi.f();
                StringBuilder sb = new StringBuilder();
                if (f == 1) {
                    sb.append('M');
                } else if (f == 2) {
                    sb.append('U');
                } else if (f != 3) {
                    sb.append('N');
                } else {
                    sb.append('T');
                }
                if (oi.E()) {
                    sb.append("_WAP_");
                } else {
                    sb.append("_NET_");
                }
                if (oi.u()) {
                    sb.append("3G");
                } else if (oi.v()) {
                    sb.append("4G");
                } else if (oi.t()) {
                    sb.append("2G");
                } else {
                    sb.append('N');
                }
                return sb.toString();
            }
            return "unknown";
        }
        return (String) invokeL.objValue;
    }
}

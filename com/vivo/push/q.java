package com.vivo.push;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public static final Uri a;
    public static final Uri b;
    public static final Uri c;
    public static final Uri d;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case 2002:
                    return "method_alias_bind";
                case 2003:
                    return "method_alias_unbind";
                case 2004:
                    return "method_tag_bind";
                case 2005:
                    return "method_tag_unbind";
                case 2006:
                    return "method_sdk_bind";
                case 2007:
                    return "method_sdk_unbind";
                case 2008:
                    return "method_stop";
                default:
                    return null;
            }
        }
        return (String) invokeI.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1612095306, "Lcom/vivo/push/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1612095306, "Lcom/vivo/push/q;");
                return;
            }
        }
        a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
        b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");
        c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
        d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");
    }
}

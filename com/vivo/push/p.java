package com.vivo.push;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;
    public static final Uri a;

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f60722b;

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f60723c;

    /* renamed from: d  reason: collision with root package name */
    public static final Uri f60724d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1612095337, "Lcom/vivo/push/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1612095337, "Lcom/vivo/push/p;");
                return;
            }
        }
        a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
        f60722b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");
        f60723c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
        f60724d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
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
}

package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static n a(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, kVar)) == null) {
            n nVar = n.a;
            if (kVar.w() >= 0 && kVar.w() < n.values().length) {
                return n.values()[kVar.w()];
            }
            return nVar;
        }
        return (n) invokeL.objValue;
    }

    public static void a(Notification.Builder builder, String str, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, builder, str, kVar) == null) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            if (!TextUtils.isEmpty(kVar.h())) {
                bigTextStyle.setBigContentTitle(kVar.h());
            }
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                bigTextStyle.bigText(str);
            }
            builder.setStyle(bigTextStyle);
        }
    }
}

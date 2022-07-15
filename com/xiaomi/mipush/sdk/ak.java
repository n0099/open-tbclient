package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bk;
/* loaded from: classes8.dex */
public class ak {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static AbstractPushManager a(Context context, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, eVar)) == null) ? b(context, eVar) : (AbstractPushManager) invokeLL.objValue;
    }

    public static AbstractPushManager b(Context context, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, eVar)) == null) {
            l.a m1095a = l.m1095a(eVar);
            if (m1095a == null || TextUtils.isEmpty(m1095a.a) || TextUtils.isEmpty(m1095a.b)) {
                return null;
            }
            return (AbstractPushManager) bk.a(m1095a.a, m1095a.b, context);
        }
        return (AbstractPushManager) invokeLL.objValue;
    }
}

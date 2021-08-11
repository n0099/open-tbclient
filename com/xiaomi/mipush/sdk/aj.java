package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bh;
/* loaded from: classes10.dex */
public class aj {
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
            l.a m137a = l.m137a(eVar);
            if (m137a == null || TextUtils.isEmpty(m137a.f76935a) || TextUtils.isEmpty(m137a.f76936b)) {
                return null;
            }
            return (AbstractPushManager) bh.a(m137a.f76935a, m137a.f76936b, context);
        }
        return (AbstractPushManager) invokeLL.objValue;
    }
}

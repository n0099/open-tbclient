package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.ii;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static a a;

    /* renamed from: a  reason: collision with other field name */
    public static b f1700a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        boolean a(ii iiVar);
    }

    /* loaded from: classes8.dex */
    public interface b {
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            f1700a = bVar;
        }
    }

    public static boolean a(ii iiVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iiVar)) == null) {
            if (a == null || iiVar == null) {
                str = "rc params is null, not cpra";
            } else if (com.xiaomi.push.m.m1499a(com.xiaomi.push.v.m1625a())) {
                return a.a(iiVar);
            } else {
                str = "rc app not permission to cpra";
            }
            com.xiaomi.channel.commonutils.logger.b.m1027a(str);
            return false;
        }
        return invokeL.booleanValue;
    }
}

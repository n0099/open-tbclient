package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.ie;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static a a;

    /* renamed from: a  reason: collision with other field name */
    public static b f954a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        boolean a(ie ieVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            f954a = bVar;
        }
    }

    public static boolean a(ie ieVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ieVar)) == null) {
            if (a == null || ieVar == null) {
                str = "rc params is null, not cpra";
            } else if (com.xiaomi.push.l.m600a(com.xiaomi.push.t.m700a())) {
                return a.a(ieVar);
            } else {
                str = "rc app not permission to cpra";
            }
            com.xiaomi.channel.commonutils.logger.b.m134a(str);
            return false;
        }
        return invokeL.booleanValue;
    }
}

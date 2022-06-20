package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
/* loaded from: classes8.dex */
public class ce {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static iu a(Context context, Cif cif) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, cif)) == null) {
            if (cif.m468b()) {
                return null;
            }
            byte[] m466a = cif.m466a();
            iu a = a(cif.a(), cif.f626b);
            if (a != null) {
                it.a(a, m466a);
            }
            return a;
        }
        return (iu) invokeLL.objValue;
    }

    public static iu a(hj hjVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, hjVar, z)) == null) {
            switch (cf.a[hjVar.ordinal()]) {
                case 1:
                    return new ik();
                case 2:
                    return new iq();
                case 3:
                    return new io();
                case 4:
                    return new is();
                case 5:
                    return new im();
                case 6:
                    return new hz();
                case 7:
                    return new ie();
                case 8:
                    return new il();
                case 9:
                    if (z) {
                        return new ii();
                    }
                    ia iaVar = new ia();
                    iaVar.a(true);
                    return iaVar;
                case 10:
                    return new ie();
                default:
                    return null;
            }
        }
        return (iu) invokeLZ.objValue;
    }
}

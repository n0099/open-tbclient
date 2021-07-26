package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hf;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
/* loaded from: classes6.dex */
public class bp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static iq a(Context context, ib ibVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, ibVar)) == null) {
            if (ibVar.m458b()) {
                return null;
            }
            byte[] m456a = ibVar.m456a();
            iq a2 = a(ibVar.a(), ibVar.f639b);
            if (a2 != null) {
                ip.a(a2, m456a);
            }
            return a2;
        }
        return (iq) invokeLL.objValue;
    }

    public static iq a(hf hfVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, hfVar, z)) == null) {
            switch (bq.f40926a[hfVar.ordinal()]) {
                case 1:
                    return new ig();
                case 2:
                    return new im();
                case 3:
                    return new ik();
                case 4:
                    return new io();
                case 5:
                    return new ii();
                case 6:
                    return new hv();
                case 7:
                    return new ia();
                case 8:
                    return new ih();
                case 9:
                    if (z) {
                        return new ie();
                    }
                    hw hwVar = new hw();
                    hwVar.a(true);
                    return hwVar;
                case 10:
                    return new ia();
                default:
                    return null;
            }
        }
        return (iq) invokeLZ.objValue;
    }
}

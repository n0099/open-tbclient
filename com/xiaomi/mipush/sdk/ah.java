package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.bj;
import com.xiaomi.push.hf;
import com.xiaomi.push.hu;
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
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class ah {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T extends iq<T, ?>> ib a(Context context, T t, hf hfVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, t, hfVar)) == null) ? a(context, t, hfVar, !hfVar.equals(hf.a), context.getPackageName(), b.m150a(context).m151a()) : (ib) invokeLLL.objValue;
    }

    public static <T extends iq<T, ?>> ib a(Context context, T t, hf hfVar, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, t, hfVar, Boolean.valueOf(z), str, str2})) == null) ? a(context, t, hfVar, z, str, str2, true) : (ib) invokeCommon.objValue;
    }

    public static <T extends iq<T, ?>> ib a(Context context, T t, hf hfVar, boolean z, String str, String str2, boolean z2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, t, hfVar, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2)})) == null) {
            byte[] a = ip.a(t);
            if (a != null) {
                ib ibVar = new ib();
                if (z) {
                    String d = b.m150a(context).d();
                    if (TextUtils.isEmpty(d)) {
                        str3 = "regSecret is empty, return null";
                    } else {
                        try {
                            a = com.xiaomi.push.h.b(bj.m219a(d), a);
                        } catch (Exception unused) {
                            com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
                        }
                    }
                }
                hu huVar = new hu();
                huVar.f538a = 5L;
                huVar.f539a = "fakeid";
                ibVar.a(huVar);
                ibVar.a(ByteBuffer.wrap(a));
                ibVar.a(hfVar);
                ibVar.b(z2);
                ibVar.b(str);
                ibVar.a(z);
                ibVar.a(str2);
                return ibVar;
            }
            str3 = "invoke convertThriftObjectToBytes method, return null.";
            com.xiaomi.channel.commonutils.logger.b.m109a(str3);
            return null;
        }
        return (ib) invokeCommon.objValue;
    }

    public static iq a(Context context, ib ibVar) {
        InterceptResult invokeLL;
        byte[] m495a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, ibVar)) == null) {
            if (ibVar.m497b()) {
                try {
                    m495a = com.xiaomi.push.h.a(bj.m219a(b.m150a(context).d()), ibVar.m495a());
                } catch (Exception e) {
                    throw new t("the aes decrypt failed.", e);
                }
            } else {
                m495a = ibVar.m495a();
            }
            iq a = a(ibVar.a(), ibVar.f620b);
            if (a != null) {
                ip.a(a, m495a);
            }
            return a;
        }
        return (iq) invokeLL.objValue;
    }

    public static iq a(hf hfVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, hfVar, z)) == null) {
            switch (ai.a[hfVar.ordinal()]) {
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

    public static <T extends iq<T, ?>> ib b(Context context, T t, hf hfVar, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, t, hfVar, Boolean.valueOf(z), str, str2})) == null) ? a(context, t, hfVar, z, str, str2, false) : (ib) invokeCommon.objValue;
    }
}

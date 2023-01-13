package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bm;
import com.xiaomi.push.hj;
import com.xiaomi.push.hy;
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
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class ai {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, t, hjVar)) == null) ? a(context, t, hjVar, !hjVar.equals(hj.a), context.getPackageName(), b.m145a(context).m146a()) : (Cif) invokeLLL.objValue;
    }

    public static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, t, hjVar, Boolean.valueOf(z), str, str2})) == null) ? a(context, t, hjVar, z, str, str2, true) : (Cif) invokeCommon.objValue;
    }

    public static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar, boolean z, String str, String str2, boolean z2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, t, hjVar, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2)})) == null) {
            byte[] a = it.a(t);
            if (a != null) {
                Cif cif = new Cif();
                if (z) {
                    String d = b.m145a(context).d();
                    if (TextUtils.isEmpty(d)) {
                        str3 = "regSecret is empty, return null";
                    } else {
                        try {
                            a = com.xiaomi.push.i.b(bm.m217a(d), a);
                        } catch (Exception unused) {
                            com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
                        }
                    }
                }
                hy hyVar = new hy();
                hyVar.f577a = 5L;
                hyVar.f578a = "fakeid";
                cif.a(hyVar);
                cif.a(ByteBuffer.wrap(a));
                cif.a(hjVar);
                cif.b(z2);
                cif.b(str);
                cif.a(z);
                cif.a(str2);
                return cif;
            }
            str3 = "invoke convertThriftObjectToBytes method, return null.";
            com.xiaomi.channel.commonutils.logger.b.m103a(str3);
            return null;
        }
        return (Cif) invokeCommon.objValue;
    }

    public static iu a(Context context, Cif cif) {
        InterceptResult invokeLL;
        byte[] m544a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, cif)) == null) {
            if (cif.m546b()) {
                byte[] a = i.a(context, cif, e.b);
                if (a == null) {
                    a = bm.m217a(b.m145a(context).d());
                }
                try {
                    m544a = com.xiaomi.push.i.a(a, cif.m544a());
                } catch (Exception e) {
                    throw new u("the aes decrypt failed.", e);
                }
            } else {
                m544a = cif.m544a();
            }
            iu a2 = a(cif.a(), cif.f657b);
            if (a2 != null) {
                it.a(a2, m544a);
            }
            return a2;
        }
        return (iu) invokeLL.objValue;
    }

    public static iu a(hj hjVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, hjVar, z)) == null) {
            switch (aj.a[hjVar.ordinal()]) {
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

    public static <T extends iu<T, ?>> Cif b(Context context, T t, hj hjVar, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, t, hjVar, Boolean.valueOf(z), str, str2})) == null) ? a(context, t, hjVar, z, str, str2, false) : (Cif) invokeCommon.objValue;
    }
}

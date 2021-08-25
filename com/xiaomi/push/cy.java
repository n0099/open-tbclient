package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class cy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i2)) == null) {
            int a2 = gq.a(context);
            if (-1 == a2) {
                return -1;
            }
            return (i2 * (a2 == 0 ? 13 : 11)) / 10;
        }
        return invokeLI.intValue;
    }

    public static int a(hf hfVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hfVar)) == null) ? ek.a(hfVar.a()) : invokeL.intValue;
    }

    public static int a(iq iqVar, hf hfVar) {
        InterceptResult invokeLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, iqVar, hfVar)) == null) {
            switch (cz.f77283a[hfVar.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return ek.a(hfVar.a());
                case 11:
                    a2 = ek.a(hfVar.a());
                    if (iqVar != null) {
                        try {
                            if (iqVar instanceof hw) {
                                String str = ((hw) iqVar).f598d;
                                if (!TextUtils.isEmpty(str) && ek.a(ek.m288a(str)) != -1) {
                                    a2 = ek.a(ek.m288a(str));
                                    break;
                                }
                            } else if (iqVar instanceof ie) {
                                String str2 = ((ie) iqVar).f659d;
                                if (!TextUtils.isEmpty(str2)) {
                                    if (ek.a(ek.m288a(str2)) != -1) {
                                        a2 = ek.a(ek.m288a(str2));
                                    }
                                    if (hp.B.equals(ek.m288a(str2))) {
                                        return -1;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                            return a2;
                        }
                    }
                    break;
                case 12:
                    a2 = ek.a(hfVar.a());
                    if (iqVar != null) {
                        try {
                            if (iqVar instanceof ia) {
                                String b2 = ((ia) iqVar).b();
                                if (!TextUtils.isEmpty(b2) && ev.a(b2) != -1) {
                                    a2 = ev.a(b2);
                                    break;
                                }
                            } else if (iqVar instanceof hz) {
                                String a3 = ((hz) iqVar).a();
                                if (!TextUtils.isEmpty(a3) && ev.a(a3) != -1) {
                                    return ev.a(a3);
                                }
                            }
                        } catch (Exception unused2) {
                            com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                            break;
                        }
                    }
                    break;
                default:
                    return -1;
            }
            return a2;
        }
        return invokeLL.intValue;
    }

    public static void a(String str, Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, str, context, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        int a2 = a(context, i3);
        if (i2 != ek.a(hp.B)) {
            el.a(context.getApplicationContext()).a(str, i2, 1L, a2);
        }
    }

    public static void a(String str, Context context, ib ibVar, int i2) {
        hf a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context, ibVar, i2) == null) || context == null || ibVar == null || (a2 = ibVar.a()) == null) {
            return;
        }
        int a3 = a(a2);
        if (i2 <= 0) {
            byte[] a4 = ip.a(ibVar);
            i2 = a4 != null ? a4.length : 0;
        }
        a(str, context, a3, i2);
    }

    public static void a(String str, Context context, iq iqVar, hf hfVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, context, iqVar, hfVar, Integer.valueOf(i2)}) == null) {
            a(str, context, a(iqVar, hfVar), i2);
        }
    }

    public static void a(String str, Context context, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, context, bArr) == null) || context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        ib ibVar = new ib();
        try {
            ip.a(ibVar, bArr);
            a(str, context, ibVar, bArr.length);
        } catch (iv unused) {
            com.xiaomi.channel.commonutils.logger.b.m73a("fail to convert bytes to container");
        }
    }
}

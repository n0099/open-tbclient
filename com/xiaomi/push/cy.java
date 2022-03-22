package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class cy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i)) == null) {
            int a = gq.a(context);
            if (-1 == a) {
                return -1;
            }
            return (i * (a == 0 ? 13 : 11)) / 10;
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
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, iqVar, hfVar)) == null) {
            switch (cz.a[hfVar.ordinal()]) {
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
                    a = ek.a(hfVar.a());
                    if (iqVar != null) {
                        try {
                            if (iqVar instanceof hw) {
                                String str = ((hw) iqVar).f575d;
                                if (!TextUtils.isEmpty(str) && ek.a(ek.m327a(str)) != -1) {
                                    a = ek.a(ek.m327a(str));
                                    break;
                                }
                            } else if (iqVar instanceof ie) {
                                String str2 = ((ie) iqVar).f636d;
                                if (!TextUtils.isEmpty(str2)) {
                                    if (ek.a(ek.m327a(str2)) != -1) {
                                        a = ek.a(ek.m327a(str2));
                                    }
                                    if (hp.B.equals(ek.m327a(str2))) {
                                        return -1;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                            return a;
                        }
                    }
                    break;
                case 12:
                    a = ek.a(hfVar.a());
                    if (iqVar != null) {
                        try {
                            if (iqVar instanceof ia) {
                                String b2 = ((ia) iqVar).b();
                                if (!TextUtils.isEmpty(b2) && ev.a(b2) != -1) {
                                    a = ev.a(b2);
                                    break;
                                }
                            } else if (iqVar instanceof hz) {
                                String a2 = ((hz) iqVar).a();
                                if (!TextUtils.isEmpty(a2) && ev.a(a2) != -1) {
                                    return ev.a(a2);
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
            return a;
        }
        return invokeLL.intValue;
    }

    public static void a(String str, Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, str, context, i, i2) == null) || i <= 0 || i2 <= 0) {
            return;
        }
        int a = a(context, i2);
        if (i != ek.a(hp.B)) {
            el.a(context.getApplicationContext()).a(str, i, 1L, a);
        }
    }

    public static void a(String str, Context context, ib ibVar, int i) {
        hf a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context, ibVar, i) == null) || context == null || ibVar == null || (a = ibVar.a()) == null) {
            return;
        }
        int a2 = a(a);
        if (i <= 0) {
            byte[] a3 = ip.a(ibVar);
            i = a3 != null ? a3.length : 0;
        }
        a(str, context, a2, i);
    }

    public static void a(String str, Context context, iq iqVar, hf hfVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, context, iqVar, hfVar, Integer.valueOf(i)}) == null) {
            a(str, context, a(iqVar, hfVar), i);
        }
    }

    public static void a(String str, Context context, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, str, context, bArr) == null) || context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        ib ibVar = new ib();
        try {
            ip.a(ibVar, bArr);
            a(str, context, ibVar, bArr.length);
        } catch (iv unused) {
            com.xiaomi.channel.commonutils.logger.b.m112a("fail to convert bytes to container");
        }
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final Context f109a;

    public s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f109a = context.getApplicationContext();
    }

    public static s a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (s.class) {
                    if (a == null) {
                        a = new s(context);
                    }
                }
            }
            return a;
        }
        return (s) invokeL.objValue;
    }

    public static void a(Context context, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, cif) == null) {
            a(context).a(cif, 0, true);
        }
    }

    public static void a(Context context, Cif cif, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, context, cif, z) == null) {
            a(context).a(cif, 1, z);
        }
    }

    private void a(Cif cif, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{cif, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && !com.xiaomi.push.m.m637a(this.f109a) && com.xiaomi.push.m.m636a() && cif != null && cif.f649a == hj.e && cif.m540a() != null && z) {
            com.xiaomi.channel.commonutils.logger.b.m105a("click to start activity result:" + String.valueOf(i));
            ii iiVar = new ii(cif.m540a().m506a(), false);
            iiVar.c(ht.ae.f529a);
            iiVar.b(cif.m541a());
            iiVar.d(cif.f656b);
            HashMap hashMap = new HashMap();
            iiVar.f668a = hashMap;
            hashMap.put("result", String.valueOf(i));
            ao.a(this.f109a).a(iiVar, hj.i, false, false, null, true, cif.f656b, cif.f652a, true, false);
        }
    }

    public static void b(Context context, Cif cif, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, context, cif, z) == null) {
            a(context).a(cif, 2, z);
        }
    }

    public static void c(Context context, Cif cif, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, context, cif, z) == null) {
            a(context).a(cif, 3, z);
        }
    }

    public static void d(Context context, Cif cif, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, null, context, cif, z) == null) {
            a(context).a(cif, 4, z);
        }
    }

    public static void e(Context context, Cif cif, boolean z) {
        s a2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, context, cif, z) == null) {
            b m147a = b.m147a(context);
            if (TextUtils.isEmpty(m147a.m155c()) || TextUtils.isEmpty(m147a.d())) {
                a2 = a(context);
                i = 6;
            } else {
                boolean m159f = m147a.m159f();
                a2 = a(context);
                i = m159f ? 7 : 5;
            }
            a2.a(cif, i, z);
        }
    }
}

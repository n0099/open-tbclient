package com.xiaomi.push.service;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hq;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(aq aqVar, hl hlVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aqVar, hlVar)) == null) {
            return aqVar.f903a.getInt(a(hlVar), as.a[hlVar.ordinal()] != 1 ? 0 : 1);
        }
        return invokeLL.intValue;
    }

    public static String a(hl hlVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hlVar)) == null) {
            return "oc_version_" + hlVar.a();
        }
        return (String) invokeL.objValue;
    }

    public static List<Pair<Integer, Object>> a(List<hq> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, list, z)) == null) {
            if (com.xiaomi.push.ad.a(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (hq hqVar : list) {
                int a = hqVar.a();
                hm a2 = hm.a(hqVar.b());
                if (a2 != null) {
                    if (z && hqVar.f520a) {
                        arrayList.add(new Pair(Integer.valueOf(a), null));
                    } else {
                        int i2 = as.f63820b[a2.ordinal()];
                        arrayList.add(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(hqVar.g())) : new Pair(Integer.valueOf(a), hqVar.m445a()) : new Pair(Integer.valueOf(a), Long.valueOf(hqVar.m444a())) : new Pair(Integer.valueOf(a), Integer.valueOf(hqVar.c())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public static void a(aq aqVar, hl hlVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, aqVar, hlVar, i2) == null) {
            aqVar.f903a.edit().putInt(a(hlVar), i2).commit();
        }
    }

    public static void a(aq aqVar, ic icVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aqVar, icVar) == null) {
            aqVar.b(a(icVar.a(), true));
            aqVar.b();
        }
    }

    public static void a(aq aqVar, id idVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aqVar, idVar) == null) {
            for (ho hoVar : idVar.a()) {
                if (hoVar.a() > a(aqVar, hoVar.m440a())) {
                    a(aqVar, hoVar.m440a(), hoVar.a());
                    aqVar.a(a(hoVar.f512a, false));
                }
            }
            aqVar.b();
        }
    }
}

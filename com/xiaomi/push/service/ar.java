package com.xiaomi.push.service;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
public class ar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(aq aqVar, hl hlVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aqVar, hlVar)) == null) {
            return aqVar.f902a.getInt(a(hlVar), as.f77945a[hlVar.ordinal()] != 1 ? 0 : 1);
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
                int a2 = hqVar.a();
                hm a3 = hm.a(hqVar.b());
                if (a3 != null) {
                    if (z && hqVar.f519a) {
                        arrayList.add(new Pair(Integer.valueOf(a2), null));
                    } else {
                        int i2 = as.f77946b[a3.ordinal()];
                        arrayList.add(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : new Pair(Integer.valueOf(a2), Boolean.valueOf(hqVar.g())) : new Pair(Integer.valueOf(a2), hqVar.m396a()) : new Pair(Integer.valueOf(a2), Long.valueOf(hqVar.m395a())) : new Pair(Integer.valueOf(a2), Integer.valueOf(hqVar.c())));
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
            aqVar.f902a.edit().putInt(a(hlVar), i2).commit();
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
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aqVar, idVar) == null) {
            for (ho hoVar : idVar.a()) {
                if (hoVar.a() > a(aqVar, hoVar.m391a())) {
                    a(aqVar, hoVar.m391a(), hoVar.a());
                    aqVar.a(a(hoVar.f511a, false));
                }
            }
            aqVar.b();
        }
    }
}

package com.xiaomi.push.service;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class bb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(ba baVar, hp hpVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, baVar, hpVar)) == null) {
            return baVar.a(hpVar, bc.a[hpVar.ordinal()] != 1 ? 0 : 1);
        }
        return invokeLL.intValue;
    }

    public static List<Pair<Integer, Object>> a(List<hu> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, list, z)) == null) {
            if (com.xiaomi.push.ag.a(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (hu huVar : list) {
                int a = huVar.a();
                hq a2 = hq.a(huVar.b());
                if (a2 != null) {
                    if (z && huVar.f535a) {
                        arrayList.add(new Pair(Integer.valueOf(a), null));
                    } else {
                        int i = bc.b[a2.ordinal()];
                        arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(huVar.g())) : new Pair(Integer.valueOf(a), huVar.m490a()) : new Pair(Integer.valueOf(a), Long.valueOf(huVar.m489a())) : new Pair(Integer.valueOf(a), Integer.valueOf(huVar.c())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public static void a(ba baVar, ig igVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, baVar, igVar) == null) {
            baVar.a(a(igVar.a(), true));
            baVar.b();
        }
    }

    public static void a(ba baVar, ih ihVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, baVar, ihVar) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (hs hsVar : ihVar.a()) {
                arrayList.add(new Pair<>(hsVar.m485a(), Integer.valueOf(hsVar.a())));
                List<Pair<Integer, Object>> a = a(hsVar.f527a, false);
                if (!com.xiaomi.push.ag.a(a)) {
                    arrayList2.addAll(a);
                }
            }
            baVar.a(arrayList, arrayList2);
            baVar.b();
        }
    }
}

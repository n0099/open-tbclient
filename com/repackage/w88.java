package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tbclient.App;
/* loaded from: classes7.dex */
public class w88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Comparator<bp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(bp4 bp4Var, bp4 bp4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bp4Var, bp4Var2)) == null) {
                if (bp4Var.f() && bp4Var2.f()) {
                    return bp4Var.j() - bp4Var2.j();
                }
                if (bp4Var.f() || bp4Var2.f()) {
                    return bp4Var.f() ? -1 : 1;
                }
                return (bp4Var.q() == null ? -1 : w88.g(bp4Var.q())) - (bp4Var2.q() != null ? w88.g(bp4Var2.q()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<nn> a(List<nn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo q;
        AdvertAppInfo q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (gd7.e(list)) {
                return hashSet;
            }
            Set<nn> a2 = cb8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (nn nnVar : list) {
                if (nnVar != null) {
                    for (nn nnVar2 : a2) {
                        if ((nnVar instanceof bp4) && (q2 = ((bp4) nnVar).q()) != null && nnVar2.hashCode() == q2.hashCode()) {
                            q2.i = ((AdvertAppInfo) nnVar2).i;
                        }
                    }
                    if ((nnVar instanceof bp4) && (q = ((bp4) nnVar).q()) != null && q.i == null) {
                        sn4 sn4Var = new sn4();
                        q.i = sn4Var;
                        sn4Var.a = str;
                        sn4Var.b = i;
                        sn4Var.g = q.g;
                        sn4Var.h = false;
                        hashSet.add(q);
                    }
                }
            }
            a2.addAll(hashSet);
            cb8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<nn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (gd7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = gd7.i(list) - 1; i3 >= 0 && !(gd7.d(list, i3) instanceof bp4); i3--) {
                if (gd7.d(list, i3) instanceof qq4) {
                    int i4 = ((qq4) gd7.d(list, i3)).position;
                    if (i4 != i2) {
                        i++;
                        i2 = i4;
                    }
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void c(List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || gd7.e(list)) {
            return;
        }
        Iterator<nn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof bp4) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || gd7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof bp4;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = x88.a((App) next);
                } else {
                    if (z) {
                        bp4 bp4Var = (bp4) next;
                        if (bp4Var.q() != null) {
                            str2 = bp4Var.q().a;
                        }
                    }
                    str2 = "";
                }
                if (TextUtils.equals(str, str2)) {
                    it.remove();
                }
            }
        }
    }

    public static String e(List<nn> list, boolean z) {
        InterceptResult invokeLZ;
        bp4 bp4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !gd7.e(list)) {
                int i = 0;
                for (int i2 = gd7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((gd7.d(list, i2) instanceof bp4) && (bp4Var = (bp4) gd7.d(list, i2)) != null && !l(bp4Var.q())) {
                        sb.append(bp4Var.j() + 1);
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.length() <= 1) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static String f(@NonNull AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, advertAppInfo)) == null) {
            return "#Nad=" + advertAppInfo.g;
        }
        return (String) invokeL.objValue;
    }

    public static int g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return 0;
            }
            if (TextUtils.isEmpty(advertAppInfo.f)) {
                return -1;
            }
            return ng.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static List<bp4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gd7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    eb8.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<bp4> i(List<bp4> list, List<nn> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gd7.e(list)) {
                return arrayList;
            }
            o(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                bp4 bp4Var = (bp4) gd7.d(list, i3);
                if (bp4Var != null && bp4Var.q() != null) {
                    int i4 = gd7.i(list2);
                    int g = g(bp4Var.q()) - 1;
                    if (g < 0) {
                        n(bp4Var.q());
                    } else {
                        int j = bp4Var.f() ? bp4Var.j() : g + i;
                        if (j > i4) {
                            n(bp4Var.q());
                        } else {
                            bp4Var.setPosition(j);
                            gd7.b(list2, bp4Var, j);
                            arrayList.add(bp4Var);
                        }
                    }
                }
            }
            while (i < gd7.i(list2)) {
                nn nnVar = list2.get(i);
                if (nnVar instanceof bp4) {
                    i2++;
                } else if (nnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) nnVar).position += i2;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static boolean j(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("#Nad=");
        }
        return invokeL.booleanValue;
    }

    public static int k(@Nullable AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, advertAppInfo)) == null) {
            int m = advertAppInfo.m();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return m;
        }
        return invokeL.intValue;
    }

    public static boolean l(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, advertAppInfo)) == null) ? advertAppInfo.b() : invokeL.booleanValue;
    }

    public static void m(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, advertAppInfo, i) == null) {
            eb8.h(advertAppInfo, 1, i);
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<bp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < gd7.i(list); i++) {
                if (gd7.d(list, i) instanceof bp4) {
                    ((bp4) gd7.d(list, i)).setPosition(i);
                }
            }
        }
    }
}

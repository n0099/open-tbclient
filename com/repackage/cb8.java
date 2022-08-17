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
/* loaded from: classes5.dex */
public class cb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Comparator<tp4> {
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
        public int compare(tp4 tp4Var, tp4 tp4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tp4Var, tp4Var2)) == null) {
                if (tp4Var.e() && tp4Var2.e()) {
                    return tp4Var.i() - tp4Var2.i();
                }
                if (tp4Var.e() || tp4Var2.e()) {
                    return tp4Var.e() ? -1 : 1;
                }
                return (tp4Var.p() == null ? -1 : cb8.g(tp4Var.p())) - (tp4Var2.p() != null ? cb8.g(tp4Var2.p()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<on> a(List<on> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo p;
        AdvertAppInfo p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (af7.e(list)) {
                return hashSet;
            }
            Set<on> a2 = jd8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (on onVar : list) {
                if (onVar != null) {
                    for (on onVar2 : a2) {
                        if ((onVar instanceof tp4) && (p2 = ((tp4) onVar).p()) != null && onVar2.hashCode() == p2.hashCode()) {
                            p2.i = ((AdvertAppInfo) onVar2).i;
                        }
                    }
                    if ((onVar instanceof tp4) && (p = ((tp4) onVar).p()) != null && p.i == null) {
                        ko4 ko4Var = new ko4();
                        p.i = ko4Var;
                        ko4Var.a = str;
                        ko4Var.b = i;
                        ko4Var.g = p.g;
                        ko4Var.h = false;
                        hashSet.add(p);
                    }
                }
            }
            a2.addAll(hashSet);
            jd8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<on> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (af7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = af7.i(list) - 1; i3 >= 0 && !(af7.d(list, i3) instanceof tp4); i3--) {
                if (af7.d(list, i3) instanceof ir4) {
                    int i4 = ((ir4) af7.d(list, i3)).position;
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

    public static void c(List<on> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || af7.e(list)) {
            return;
        }
        Iterator<on> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof tp4) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || af7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof tp4;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = db8.a((App) next);
                } else {
                    if (z) {
                        tp4 tp4Var = (tp4) next;
                        if (tp4Var.p() != null) {
                            str2 = tp4Var.p().a;
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

    public static String e(List<on> list, boolean z) {
        InterceptResult invokeLZ;
        tp4 tp4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !af7.e(list)) {
                int i = 0;
                for (int i2 = af7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((af7.d(list, i2) instanceof tp4) && (tp4Var = (tp4) af7.d(list, i2)) != null && !l(tp4Var.p())) {
                        sb.append(tp4Var.i() + 1);
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
            return og.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static List<tp4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (af7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    ld8.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<tp4> i(List<tp4> list, List<on> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (af7.e(list)) {
                return arrayList;
            }
            o(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                tp4 tp4Var = (tp4) af7.d(list, i3);
                if (tp4Var != null && tp4Var.p() != null) {
                    int i4 = af7.i(list2);
                    int g = g(tp4Var.p()) - 1;
                    if (g < 0) {
                        n(tp4Var.p());
                    } else {
                        int i5 = tp4Var.e() ? tp4Var.i() : g + i;
                        if (i5 > i4) {
                            n(tp4Var.p());
                        } else {
                            tp4Var.setPosition(i5);
                            af7.b(list2, tp4Var, i5);
                            arrayList.add(tp4Var);
                        }
                    }
                }
            }
            while (i < af7.i(list2)) {
                on onVar = list2.get(i);
                if (onVar instanceof tp4) {
                    i2++;
                } else if (onVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) onVar).position += i2;
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
            int n = advertAppInfo.n();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return n;
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
            ld8.h(advertAppInfo, 1, i);
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<tp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < af7.i(list); i++) {
                if (af7.d(list, i) instanceof tp4) {
                    ((tp4) af7.d(list, i)).setPosition(i);
                }
            }
        }
    }
}

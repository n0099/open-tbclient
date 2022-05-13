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
/* loaded from: classes6.dex */
public class n98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<np4> {
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
        public int compare(np4 np4Var, np4 np4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, np4Var, np4Var2)) == null) {
                if (np4Var.d() && np4Var2.d()) {
                    return np4Var.h() - np4Var2.h();
                }
                if (np4Var.d() || np4Var2.d()) {
                    return np4Var.d() ? -1 : 1;
                }
                return (np4Var.o() == null ? -1 : n98.g(np4Var.o())) - (np4Var2.o() != null ? n98.g(np4Var2.o()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<ro> a(List<ro> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo o;
        AdvertAppInfo o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (pd7.e(list)) {
                return hashSet;
            }
            Set<ro> a2 = tb8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (ro roVar : list) {
                if (roVar != null) {
                    for (ro roVar2 : a2) {
                        if ((roVar instanceof np4) && (o2 = ((np4) roVar).o()) != null && roVar2.hashCode() == o2.hashCode()) {
                            o2.i = ((AdvertAppInfo) roVar2).i;
                        }
                    }
                    if ((roVar instanceof np4) && (o = ((np4) roVar).o()) != null && o.i == null) {
                        eo4 eo4Var = new eo4();
                        o.i = eo4Var;
                        eo4Var.a = str;
                        eo4Var.b = i;
                        eo4Var.g = o.g;
                        eo4Var.h = false;
                        hashSet.add(o);
                    }
                }
            }
            a2.addAll(hashSet);
            tb8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<ro> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (pd7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = pd7.i(list) - 1; i3 >= 0 && !(pd7.d(list, i3) instanceof np4); i3--) {
                if (pd7.d(list, i3) instanceof br4) {
                    int i4 = ((br4) pd7.d(list, i3)).position;
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

    public static void c(List<ro> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || pd7.e(list)) {
            return;
        }
        Iterator<ro> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof np4) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || pd7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof np4;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = o98.a((App) next);
                } else {
                    if (z) {
                        np4 np4Var = (np4) next;
                        if (np4Var.o() != null) {
                            str2 = np4Var.o().a;
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

    public static String e(List<ro> list, boolean z) {
        InterceptResult invokeLZ;
        np4 np4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !pd7.e(list)) {
                int i = 0;
                for (int i2 = pd7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((pd7.d(list, i2) instanceof np4) && (np4Var = (np4) pd7.d(list, i2)) != null && !l(np4Var.o())) {
                        sb.append(np4Var.h() + 1);
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
            return kg.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static List<np4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (pd7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    vb8.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<np4> i(List<np4> list, List<ro> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (pd7.e(list)) {
                return arrayList;
            }
            o(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                np4 np4Var = (np4) pd7.d(list, i3);
                if (np4Var != null && np4Var.o() != null) {
                    int i4 = pd7.i(list2);
                    int g = g(np4Var.o()) - 1;
                    if (g < 0) {
                        n(np4Var.o());
                    } else {
                        int h = np4Var.d() ? np4Var.h() : g + i;
                        if (h > i4) {
                            n(np4Var.o());
                        } else {
                            np4Var.setPosition(h);
                            pd7.b(list2, np4Var, h);
                            arrayList.add(np4Var);
                        }
                    }
                }
            }
            while (i < pd7.i(list2)) {
                ro roVar = list2.get(i);
                if (roVar instanceof np4) {
                    i2++;
                } else if (roVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) roVar).position += i2;
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
            int q = advertAppInfo.q();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return q;
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
            vb8.h(advertAppInfo, 1, i);
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<np4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < pd7.i(list); i++) {
                if (pd7.d(list, i) instanceof np4) {
                    ((np4) pd7.d(list, i)).setPosition(i);
                }
            }
        }
    }
}

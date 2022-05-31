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
public class u68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Comparator<co4> {
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
        public int compare(co4 co4Var, co4 co4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, co4Var, co4Var2)) == null) {
                if (co4Var.d() && co4Var2.d()) {
                    return co4Var.h() - co4Var2.h();
                }
                if (co4Var.d() || co4Var2.d()) {
                    return co4Var.d() ? -1 : 1;
                }
                return (co4Var.o() == null ? -1 : u68.g(co4Var.o())) - (co4Var2.o() != null ? u68.g(co4Var2.o()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<jn> a(List<jn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo o;
        AdvertAppInfo o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (db7.e(list)) {
                return hashSet;
            }
            Set<jn> a2 = a98.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (jn jnVar : list) {
                if (jnVar != null) {
                    for (jn jnVar2 : a2) {
                        if ((jnVar instanceof co4) && (o2 = ((co4) jnVar).o()) != null && jnVar2.hashCode() == o2.hashCode()) {
                            o2.i = ((AdvertAppInfo) jnVar2).i;
                        }
                    }
                    if ((jnVar instanceof co4) && (o = ((co4) jnVar).o()) != null && o.i == null) {
                        tm4 tm4Var = new tm4();
                        o.i = tm4Var;
                        tm4Var.a = str;
                        tm4Var.b = i;
                        tm4Var.g = o.g;
                        tm4Var.h = false;
                        hashSet.add(o);
                    }
                }
            }
            a2.addAll(hashSet);
            a98.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<jn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (db7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = db7.i(list) - 1; i3 >= 0 && !(db7.d(list, i3) instanceof co4); i3--) {
                if (db7.d(list, i3) instanceof rp4) {
                    int i4 = ((rp4) db7.d(list, i3)).position;
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

    public static void c(List<jn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || db7.e(list)) {
            return;
        }
        Iterator<jn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof co4) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || db7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof co4;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = v68.a((App) next);
                } else {
                    if (z) {
                        co4 co4Var = (co4) next;
                        if (co4Var.o() != null) {
                            str2 = co4Var.o().a;
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

    public static String e(List<jn> list, boolean z) {
        InterceptResult invokeLZ;
        co4 co4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !db7.e(list)) {
                int i = 0;
                for (int i2 = db7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((db7.d(list, i2) instanceof co4) && (co4Var = (co4) db7.d(list, i2)) != null && !l(co4Var.o())) {
                        sb.append(co4Var.h() + 1);
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
            return jg.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static List<co4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (db7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    c98.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<co4> i(List<co4> list, List<jn> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (db7.e(list)) {
                return arrayList;
            }
            o(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                co4 co4Var = (co4) db7.d(list, i3);
                if (co4Var != null && co4Var.o() != null) {
                    int i4 = db7.i(list2);
                    int g = g(co4Var.o()) - 1;
                    if (g < 0) {
                        n(co4Var.o());
                    } else {
                        int h = co4Var.d() ? co4Var.h() : g + i;
                        if (h > i4) {
                            n(co4Var.o());
                        } else {
                            co4Var.setPosition(h);
                            db7.b(list2, co4Var, h);
                            arrayList.add(co4Var);
                        }
                    }
                }
            }
            while (i < db7.i(list2)) {
                jn jnVar = list2.get(i);
                if (jnVar instanceof co4) {
                    i2++;
                } else if (jnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) jnVar).position += i2;
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
            c98.h(advertAppInfo, 1, i);
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<co4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < db7.i(list); i++) {
                if (db7.d(list, i) instanceof co4) {
                    ((co4) db7.d(list, i)).setPosition(i);
                }
            }
        }
    }
}

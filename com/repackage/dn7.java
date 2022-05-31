package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class dn7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755761564, "Lcom/repackage/dn7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755761564, "Lcom/repackage/dn7;");
        }
    }

    public dn7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(int i, ym7 ym7Var, int i2, List<jn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<wm7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ym7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || ym7Var == null || (list2 = ym7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<wm7> list3 = ym7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (wm7 wm7Var : list3) {
            if (wm7Var != null && i == wm7Var.b.intValue()) {
                List<cn7> list4 = wm7Var.a;
                if (list4 == null || list4.size() <= 0) {
                    return;
                }
                for (int i4 = 0; i4 < list4.size(); i4++) {
                    if (list4.get(i4) != null) {
                        if (arrayList.size() >= 20) {
                            d(list.get(i2));
                            bdTypeRecyclerView.setData(list);
                            return;
                        } else if (i3 >= 4) {
                            bdTypeRecyclerView.setData(list);
                            return;
                        } else {
                            if (i4 == list4.size() - 1) {
                                d(list.get(i2));
                            }
                            RecommendForumInfo recommendForumInfo = list4.get(i4).a;
                            if (!arrayList.contains(recommendForumInfo.forum_id)) {
                                zm7 zm7Var = new zm7();
                                zm7Var.n(wm7Var.b.intValue());
                                zm7Var.m(recommendForumInfo.avatar);
                                zm7Var.q(recommendForumInfo.forum_id.longValue());
                                zm7Var.r(recommendForumInfo.forum_name);
                                zm7Var.s(recommendForumInfo.member_count.intValue());
                                zm7Var.w(recommendForumInfo.thread_count.intValue());
                                zm7Var.v(recommendForumInfo.slogan);
                                zm7Var.u(false);
                                list.add(i2, zm7Var);
                                arrayList.add(recommendForumInfo.forum_id);
                                i2++;
                                i3++;
                            }
                        }
                    }
                }
                bdTypeRecyclerView.setData(list);
            }
        }
    }

    public List<jn> b(List<wm7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (wm7 wm7Var : list) {
                if (wm7Var != null) {
                    bn7 bn7Var = new bn7();
                    bn7Var.f(wm7Var.b.intValue());
                    bn7Var.e(wm7Var.d);
                    bn7Var.g(wm7Var.c);
                    arrayList.add(bn7Var);
                    List<cn7> list2 = wm7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (cn7 cn7Var : list2) {
                            if (cn7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                zm7 zm7Var = new zm7();
                                RecommendForumInfo recommendForumInfo = cn7Var.a;
                                zm7Var.n(wm7Var.b.intValue());
                                zm7Var.p(wm7Var.c);
                                zm7Var.m(recommendForumInfo.avatar);
                                zm7Var.q(recommendForumInfo.forum_id.longValue());
                                zm7Var.r(recommendForumInfo.forum_name);
                                zm7Var.s(recommendForumInfo.member_count.intValue());
                                zm7Var.w(recommendForumInfo.thread_count.intValue());
                                zm7Var.v(recommendForumInfo.slogan);
                                arrayList.add(zm7Var);
                                a++;
                            }
                        }
                        an7 an7Var = new an7();
                        an7Var.f(wm7Var.b.intValue());
                        an7Var.g(wm7Var.c);
                        arrayList.add(an7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<jn> list2) {
        zm7 zm7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (jn jnVar : list2) {
                if ((jnVar instanceof zm7) && (zm7Var = (zm7) jnVar) != null && zm7Var.b() == i) {
                    list.add(Long.valueOf(zm7Var.e()));
                }
            }
        }
    }

    public final void d(jn jnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jnVar) == null) && (jnVar instanceof an7)) {
            ((an7) jnVar).i(false);
        }
    }
}

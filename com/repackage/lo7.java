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
/* loaded from: classes6.dex */
public class lo7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755522275, "Lcom/repackage/lo7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755522275, "Lcom/repackage/lo7;");
        }
    }

    public lo7() {
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

    public void a(int i, go7 go7Var, int i2, List<nn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<eo7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), go7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || go7Var == null || (list2 = go7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<eo7> list3 = go7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (eo7 eo7Var : list3) {
            if (eo7Var != null && i == eo7Var.b.intValue()) {
                List<ko7> list4 = eo7Var.a;
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
                                ho7 ho7Var = new ho7();
                                ho7Var.n(eo7Var.b.intValue());
                                ho7Var.l(recommendForumInfo.avatar);
                                ho7Var.q(recommendForumInfo.forum_id.longValue());
                                ho7Var.r(recommendForumInfo.forum_name);
                                ho7Var.s(recommendForumInfo.member_count.intValue());
                                ho7Var.w(recommendForumInfo.thread_count.intValue());
                                ho7Var.v(recommendForumInfo.slogan);
                                ho7Var.t(false);
                                list.add(i2, ho7Var);
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

    public List<nn> b(List<eo7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (eo7 eo7Var : list) {
                if (eo7Var != null) {
                    jo7 jo7Var = new jo7();
                    jo7Var.f(eo7Var.b.intValue());
                    jo7Var.c(eo7Var.d);
                    jo7Var.g(eo7Var.c);
                    arrayList.add(jo7Var);
                    List<ko7> list2 = eo7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (ko7 ko7Var : list2) {
                            if (ko7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                ho7 ho7Var = new ho7();
                                RecommendForumInfo recommendForumInfo = ko7Var.a;
                                ho7Var.n(eo7Var.b.intValue());
                                ho7Var.o(eo7Var.c);
                                ho7Var.l(recommendForumInfo.avatar);
                                ho7Var.q(recommendForumInfo.forum_id.longValue());
                                ho7Var.r(recommendForumInfo.forum_name);
                                ho7Var.s(recommendForumInfo.member_count.intValue());
                                ho7Var.w(recommendForumInfo.thread_count.intValue());
                                ho7Var.v(recommendForumInfo.slogan);
                                arrayList.add(ho7Var);
                                a++;
                            }
                        }
                        io7 io7Var = new io7();
                        io7Var.f(eo7Var.b.intValue());
                        io7Var.g(eo7Var.c);
                        arrayList.add(io7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<nn> list2) {
        ho7 ho7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (nn nnVar : list2) {
                if ((nnVar instanceof ho7) && (ho7Var = (ho7) nnVar) != null && ho7Var.b() == i) {
                    list.add(Long.valueOf(ho7Var.c()));
                }
            }
        }
    }

    public final void d(nn nnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nnVar) == null) && (nnVar instanceof io7)) {
            ((io7) nnVar).h(false);
        }
    }
}

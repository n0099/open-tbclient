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
/* loaded from: classes7.dex */
public class up7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755253195, "Lcom/repackage/up7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755253195, "Lcom/repackage/up7;");
        }
    }

    public up7() {
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

    public void a(int i, pp7 pp7Var, int i2, List<ro> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<np7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), pp7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || pp7Var == null || (list2 = pp7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<np7> list3 = pp7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (np7 np7Var : list3) {
            if (np7Var != null && i == np7Var.b.intValue()) {
                List<tp7> list4 = np7Var.a;
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
                                qp7 qp7Var = new qp7();
                                qp7Var.n(np7Var.b.intValue());
                                qp7Var.m(recommendForumInfo.avatar);
                                qp7Var.q(recommendForumInfo.forum_id.longValue());
                                qp7Var.r(recommendForumInfo.forum_name);
                                qp7Var.s(recommendForumInfo.member_count.intValue());
                                qp7Var.w(recommendForumInfo.thread_count.intValue());
                                qp7Var.v(recommendForumInfo.slogan);
                                qp7Var.u(false);
                                list.add(i2, qp7Var);
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

    public List<ro> b(List<np7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (np7 np7Var : list) {
                if (np7Var != null) {
                    sp7 sp7Var = new sp7();
                    sp7Var.f(np7Var.b.intValue());
                    sp7Var.e(np7Var.d);
                    sp7Var.g(np7Var.c);
                    arrayList.add(sp7Var);
                    List<tp7> list2 = np7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (tp7 tp7Var : list2) {
                            if (tp7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                qp7 qp7Var = new qp7();
                                RecommendForumInfo recommendForumInfo = tp7Var.a;
                                qp7Var.n(np7Var.b.intValue());
                                qp7Var.p(np7Var.c);
                                qp7Var.m(recommendForumInfo.avatar);
                                qp7Var.q(recommendForumInfo.forum_id.longValue());
                                qp7Var.r(recommendForumInfo.forum_name);
                                qp7Var.s(recommendForumInfo.member_count.intValue());
                                qp7Var.w(recommendForumInfo.thread_count.intValue());
                                qp7Var.v(recommendForumInfo.slogan);
                                arrayList.add(qp7Var);
                                a++;
                            }
                        }
                        rp7 rp7Var = new rp7();
                        rp7Var.f(np7Var.b.intValue());
                        rp7Var.g(np7Var.c);
                        arrayList.add(rp7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<ro> list2) {
        qp7 qp7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (ro roVar : list2) {
                if ((roVar instanceof qp7) && (qp7Var = (qp7) roVar) != null && qp7Var.b() == i) {
                    list.add(Long.valueOf(qp7Var.e()));
                }
            }
        }
    }

    public final void d(ro roVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, roVar) == null) && (roVar instanceof rp7)) {
            ((rp7) roVar).i(false);
        }
    }
}

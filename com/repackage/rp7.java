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
public class rp7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755342568, "Lcom/repackage/rp7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755342568, "Lcom/repackage/rp7;");
        }
    }

    public rp7() {
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

    public void a(int i, mp7 mp7Var, int i2, List<uo> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<kp7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), mp7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || mp7Var == null || (list2 = mp7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<kp7> list3 = mp7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (kp7 kp7Var : list3) {
            if (kp7Var != null && i == kp7Var.b.intValue()) {
                List<qp7> list4 = kp7Var.a;
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
                                np7 np7Var = new np7();
                                np7Var.n(kp7Var.b.intValue());
                                np7Var.m(recommendForumInfo.avatar);
                                np7Var.q(recommendForumInfo.forum_id.longValue());
                                np7Var.r(recommendForumInfo.forum_name);
                                np7Var.s(recommendForumInfo.member_count.intValue());
                                np7Var.w(recommendForumInfo.thread_count.intValue());
                                np7Var.v(recommendForumInfo.slogan);
                                np7Var.u(false);
                                list.add(i2, np7Var);
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

    public List<uo> b(List<kp7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (kp7 kp7Var : list) {
                if (kp7Var != null) {
                    pp7 pp7Var = new pp7();
                    pp7Var.f(kp7Var.b.intValue());
                    pp7Var.e(kp7Var.d);
                    pp7Var.g(kp7Var.c);
                    arrayList.add(pp7Var);
                    List<qp7> list2 = kp7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (qp7 qp7Var : list2) {
                            if (qp7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                np7 np7Var = new np7();
                                RecommendForumInfo recommendForumInfo = qp7Var.a;
                                np7Var.n(kp7Var.b.intValue());
                                np7Var.p(kp7Var.c);
                                np7Var.m(recommendForumInfo.avatar);
                                np7Var.q(recommendForumInfo.forum_id.longValue());
                                np7Var.r(recommendForumInfo.forum_name);
                                np7Var.s(recommendForumInfo.member_count.intValue());
                                np7Var.w(recommendForumInfo.thread_count.intValue());
                                np7Var.v(recommendForumInfo.slogan);
                                arrayList.add(np7Var);
                                a++;
                            }
                        }
                        op7 op7Var = new op7();
                        op7Var.f(kp7Var.b.intValue());
                        op7Var.g(kp7Var.c);
                        arrayList.add(op7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<uo> list2) {
        np7 np7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (uo uoVar : list2) {
                if ((uoVar instanceof np7) && (np7Var = (np7) uoVar) != null && np7Var.b() == i) {
                    list.add(Long.valueOf(np7Var.e()));
                }
            }
        }
    }

    public final void d(uo uoVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, uoVar) == null) && (uoVar instanceof op7)) {
            ((op7) uoVar).i(false);
        }
    }
}

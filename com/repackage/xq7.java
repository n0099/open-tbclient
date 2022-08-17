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
public class xq7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755162861, "Lcom/repackage/xq7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755162861, "Lcom/repackage/xq7;");
        }
    }

    public xq7() {
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

    public void a(int i, sq7 sq7Var, int i2, List<on> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<qq7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), sq7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || sq7Var == null || (list2 = sq7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<qq7> list3 = sq7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (qq7 qq7Var : list3) {
            if (qq7Var != null && i == qq7Var.b.intValue()) {
                List<wq7> list4 = qq7Var.a;
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
                                tq7 tq7Var = new tq7();
                                tq7Var.n(qq7Var.b.intValue());
                                tq7Var.l(recommendForumInfo.avatar);
                                tq7Var.q(recommendForumInfo.forum_id.longValue());
                                tq7Var.r(recommendForumInfo.forum_name);
                                tq7Var.s(recommendForumInfo.member_count.intValue());
                                tq7Var.w(recommendForumInfo.thread_count.intValue());
                                tq7Var.v(recommendForumInfo.slogan);
                                tq7Var.t(false);
                                list.add(i2, tq7Var);
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

    public List<on> b(List<qq7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (qq7 qq7Var : list) {
                if (qq7Var != null) {
                    vq7 vq7Var = new vq7();
                    vq7Var.f(qq7Var.b.intValue());
                    vq7Var.c(qq7Var.d);
                    vq7Var.g(qq7Var.c);
                    arrayList.add(vq7Var);
                    List<wq7> list2 = qq7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (wq7 wq7Var : list2) {
                            if (wq7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                tq7 tq7Var = new tq7();
                                RecommendForumInfo recommendForumInfo = wq7Var.a;
                                tq7Var.n(qq7Var.b.intValue());
                                tq7Var.o(qq7Var.c);
                                tq7Var.l(recommendForumInfo.avatar);
                                tq7Var.q(recommendForumInfo.forum_id.longValue());
                                tq7Var.r(recommendForumInfo.forum_name);
                                tq7Var.s(recommendForumInfo.member_count.intValue());
                                tq7Var.w(recommendForumInfo.thread_count.intValue());
                                tq7Var.v(recommendForumInfo.slogan);
                                arrayList.add(tq7Var);
                                a++;
                            }
                        }
                        uq7 uq7Var = new uq7();
                        uq7Var.f(qq7Var.b.intValue());
                        uq7Var.g(qq7Var.c);
                        arrayList.add(uq7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<on> list2) {
        tq7 tq7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (on onVar : list2) {
                if ((onVar instanceof tq7) && (tq7Var = (tq7) onVar) != null && tq7Var.b() == i) {
                    list.add(Long.valueOf(tq7Var.c()));
                }
            }
        }
    }

    public final void d(on onVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onVar) == null) && (onVar instanceof uq7)) {
            ((uq7) onVar).h(false);
        }
    }
}

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
public class dp7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755759642, "Lcom/repackage/dp7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755759642, "Lcom/repackage/dp7;");
        }
    }

    public dp7() {
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

    public void a(int i, yo7 yo7Var, int i2, List<nn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<wo7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), yo7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || yo7Var == null || (list2 = yo7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<wo7> list3 = yo7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (wo7 wo7Var : list3) {
            if (wo7Var != null && i == wo7Var.b.intValue()) {
                List<cp7> list4 = wo7Var.a;
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
                                zo7 zo7Var = new zo7();
                                zo7Var.m(wo7Var.b.intValue());
                                zo7Var.l(recommendForumInfo.avatar);
                                zo7Var.p(recommendForumInfo.forum_id.longValue());
                                zo7Var.r(recommendForumInfo.forum_name);
                                zo7Var.s(recommendForumInfo.member_count.intValue());
                                zo7Var.w(recommendForumInfo.thread_count.intValue());
                                zo7Var.u(recommendForumInfo.slogan);
                                zo7Var.t(false);
                                list.add(i2, zo7Var);
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

    public List<nn> b(List<wo7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (wo7 wo7Var : list) {
                if (wo7Var != null) {
                    bp7 bp7Var = new bp7();
                    bp7Var.d(wo7Var.b.intValue());
                    bp7Var.c(wo7Var.d);
                    bp7Var.g(wo7Var.c);
                    arrayList.add(bp7Var);
                    List<cp7> list2 = wo7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (cp7 cp7Var : list2) {
                            if (cp7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                zo7 zo7Var = new zo7();
                                RecommendForumInfo recommendForumInfo = cp7Var.a;
                                zo7Var.m(wo7Var.b.intValue());
                                zo7Var.o(wo7Var.c);
                                zo7Var.l(recommendForumInfo.avatar);
                                zo7Var.p(recommendForumInfo.forum_id.longValue());
                                zo7Var.r(recommendForumInfo.forum_name);
                                zo7Var.s(recommendForumInfo.member_count.intValue());
                                zo7Var.w(recommendForumInfo.thread_count.intValue());
                                zo7Var.u(recommendForumInfo.slogan);
                                arrayList.add(zo7Var);
                                a++;
                            }
                        }
                        ap7 ap7Var = new ap7();
                        ap7Var.d(wo7Var.b.intValue());
                        ap7Var.g(wo7Var.c);
                        arrayList.add(ap7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<nn> list2) {
        zo7 zo7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (nn nnVar : list2) {
                if ((nnVar instanceof zo7) && (zo7Var = (zo7) nnVar) != null && zo7Var.b() == i) {
                    list.add(Long.valueOf(zo7Var.c()));
                }
            }
        }
    }

    public final void d(nn nnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nnVar) == null) && (nnVar instanceof ap7)) {
            ((ap7) nnVar).h(false);
        }
    }
}

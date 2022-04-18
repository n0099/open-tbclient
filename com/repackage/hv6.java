package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class hv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xz6 a;

    public hv6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new xz6();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public xz6 b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                a(builder);
                a(builder2);
                d(z, builder, builder2, i);
                LinkedList linkedList = new LinkedList();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (ConcernData concernData : builder.thread_info) {
                    if (concernData != null) {
                        if (fv6.q(builder.hot_recomforum, i2)) {
                            fv6 fv6Var = new fv6();
                            if (fv6Var.k(builder.hot_recomforum.tab_list)) {
                                fv6Var.position = i2;
                                linkedList.add(fv6Var);
                                i2++;
                            }
                        }
                        if (dv6.k(concernData)) {
                            dv6 dv6Var = new dv6();
                            if (concernData.recom_user_list.size() >= 4) {
                                dv6Var.g(concernData.recom_user_list);
                                dv6Var.position = i2;
                                dv6Var.m(builder.thread_info.size() > 1);
                                linkedList.add(dv6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b = yc8.b(concernData.thread_list);
                            if (b != null) {
                                arrayList.add(b);
                            }
                            linkedList.addAll(e(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                yc8.f().h("CONCERN", arrayList);
                xz6 xz6Var = this.a;
                xz6Var.a = linkedList;
                return xz6Var;
            }
            return null;
        }
        return (xz6) invokeCommon.objValue;
    }

    public final void c(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) || list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i == 1) {
            for (ConcernData concernData : list2) {
                if (dv6.k(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!bu6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && dv6.k(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.a.b = ListUtils.getCount(list) - count;
    }

    public final void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || (list = builder.thread_info) == null || (list2 = builder2.thread_info) == null) {
            return;
        }
        c(z, list, list2, i);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<uo> e(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        xx5 fy5Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((fy5.W(threadData) || gy5.R(threadData) || hy5.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (hy5.W(threadData)) {
                    fy5Var = new hy5(threadData);
                } else if (gy5.R(threadData)) {
                    fy5Var = new gy5(threadData);
                } else {
                    fy5Var = new fy5();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    fy5Var.a = threadData;
                }
                fy5Var.g = threadData.getTid();
                if (fy5.W(threadData)) {
                    fy5Var.L("1");
                } else if (gy5.R(threadData)) {
                    fy5Var.L("2");
                }
                fy5Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && fy5Var.getThreadData() != null && fy5Var.getThreadData().getAuthor() != null) {
                    if (!fy5Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        yz6.r(fy5Var);
                        yz6.o(threadData);
                    } else {
                        yz6.t(fy5Var);
                    }
                } else if (fy5Var instanceof hy5) {
                    yz6.t(fy5Var);
                } else {
                    yz6.t(fy5Var);
                }
                fy5Var.a.insertItemToTitleOrAbstractText();
                if (fy5Var instanceof fy5) {
                    if (threadData.isBJHNormalThreadType()) {
                        yz6.u(fy5Var);
                    } else if (threadData.picCount() == 1) {
                        yz6.w(fy5Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        fy5Var.j = imageWidthAndHeight[0];
                        fy5Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        yz6.v(fy5Var);
                    } else {
                        yz6.x(fy5Var);
                    }
                } else if (fy5Var instanceof gy5) {
                    yz6.y(fy5Var);
                }
                if (fy5Var instanceof hy5) {
                    yz6.z(fy5Var);
                }
                if (threadData.getItem() != null) {
                    yz6.A(fy5Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        yz6.D(fy5Var);
                    } else {
                        yz6.B(fy5Var);
                    }
                }
                yz6.q(fy5Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    yz6.s(fy5Var);
                }
                yz6.p(fy5Var);
                fy5Var.setSupportType(BaseCardInfo.SupportType.TOP);
                fy5Var.position = i;
                arrayList.add(fy5Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    yz6.o(threadData);
                }
                if (threadData.isShareThread) {
                    fy5 fy5Var2 = new fy5();
                    fy5Var2.a = threadData;
                    fy5Var2.position = i;
                    arrayList.add(fy5Var2);
                } else if (gy5.R(threadData)) {
                    gy5 gy5Var = new gy5(threadData);
                    gy5Var.g = threadData.getTid();
                    if (concernData != null) {
                        gy5Var.K(concernData.source.intValue());
                    }
                    if (gy5Var.isValid()) {
                        arrayList.add(gy5Var);
                    }
                } else if (ey5.W(threadData)) {
                    ey5 ey5Var = new ey5(threadData);
                    ey5Var.g = threadData.getTid();
                    ey5Var.L("3");
                    if (ey5Var.isValid()) {
                        arrayList.add(ey5Var);
                    }
                } else if (ay5.W(threadData) && threadData.isBJHArticleThreadType()) {
                    ay5 ay5Var = new ay5(threadData);
                    ay5Var.position = i;
                    arrayList.add(ay5Var);
                } else {
                    fy5 fy5Var3 = new fy5();
                    fy5Var3.a = threadData;
                    fy5Var3.L(threadData.isLinkThread() ? "4" : "1");
                    fy5Var3.position = i;
                    if (concernData != null) {
                        fy5Var3.K(concernData.source.intValue());
                    }
                    if (fy5Var3.a != null && fy5Var3.isValid() && !StringUtils.isNull(fy5Var3.a.getId()) && !"0".equals(fy5Var3.a.getTid())) {
                        arrayList.add(fy5Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}

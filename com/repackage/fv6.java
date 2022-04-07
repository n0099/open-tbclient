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
public class fv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vz6 a;

    public fv6() {
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
        this.a = new vz6();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public vz6 b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                        if (dv6.q(builder.hot_recomforum, i2)) {
                            dv6 dv6Var = new dv6();
                            if (dv6Var.k(builder.hot_recomforum.tab_list)) {
                                dv6Var.position = i2;
                                linkedList.add(dv6Var);
                                i2++;
                            }
                        }
                        if (bv6.k(concernData)) {
                            bv6 bv6Var = new bv6();
                            if (concernData.recom_user_list.size() >= 4) {
                                bv6Var.g(concernData.recom_user_list);
                                bv6Var.position = i2;
                                bv6Var.m(builder.thread_info.size() > 1);
                                linkedList.add(bv6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b = rc8.b(concernData.thread_list);
                            if (b != null) {
                                arrayList.add(b);
                            }
                            linkedList.addAll(e(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                rc8.f().h("CONCERN", arrayList);
                vz6 vz6Var = this.a;
                vz6Var.a = linkedList;
                return vz6Var;
            }
            return null;
        }
        return (vz6) invokeCommon.objValue;
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
                if (bv6.k(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!zt6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && bv6.k(concernData2)) {
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
        vx5 dy5Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((dy5.W(threadData) || ey5.R(threadData) || fy5.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (fy5.W(threadData)) {
                    dy5Var = new fy5(threadData);
                } else if (ey5.R(threadData)) {
                    dy5Var = new ey5(threadData);
                } else {
                    dy5Var = new dy5();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    dy5Var.a = threadData;
                }
                dy5Var.g = threadData.getTid();
                if (dy5.W(threadData)) {
                    dy5Var.L("1");
                } else if (ey5.R(threadData)) {
                    dy5Var.L("2");
                }
                dy5Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && dy5Var.getThreadData() != null && dy5Var.getThreadData().getAuthor() != null) {
                    if (!dy5Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        wz6.r(dy5Var);
                        wz6.o(threadData);
                    } else {
                        wz6.t(dy5Var);
                    }
                } else if (dy5Var instanceof fy5) {
                    wz6.t(dy5Var);
                } else {
                    wz6.t(dy5Var);
                }
                dy5Var.a.insertItemToTitleOrAbstractText();
                if (dy5Var instanceof dy5) {
                    if (threadData.isBJHNormalThreadType()) {
                        wz6.u(dy5Var);
                    } else if (threadData.picCount() == 1) {
                        wz6.w(dy5Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        dy5Var.j = imageWidthAndHeight[0];
                        dy5Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        wz6.v(dy5Var);
                    } else {
                        wz6.x(dy5Var);
                    }
                } else if (dy5Var instanceof ey5) {
                    wz6.y(dy5Var);
                }
                if (dy5Var instanceof fy5) {
                    wz6.z(dy5Var);
                }
                if (threadData.getItem() != null) {
                    wz6.A(dy5Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        wz6.D(dy5Var);
                    } else {
                        wz6.B(dy5Var);
                    }
                }
                wz6.q(dy5Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    wz6.s(dy5Var);
                }
                wz6.p(dy5Var);
                dy5Var.setSupportType(BaseCardInfo.SupportType.TOP);
                dy5Var.position = i;
                arrayList.add(dy5Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    wz6.o(threadData);
                }
                if (threadData.isShareThread) {
                    dy5 dy5Var2 = new dy5();
                    dy5Var2.a = threadData;
                    dy5Var2.position = i;
                    arrayList.add(dy5Var2);
                } else if (ey5.R(threadData)) {
                    ey5 ey5Var = new ey5(threadData);
                    ey5Var.g = threadData.getTid();
                    if (concernData != null) {
                        ey5Var.K(concernData.source.intValue());
                    }
                    if (ey5Var.isValid()) {
                        arrayList.add(ey5Var);
                    }
                } else if (cy5.W(threadData)) {
                    cy5 cy5Var = new cy5(threadData);
                    cy5Var.g = threadData.getTid();
                    cy5Var.L("3");
                    if (cy5Var.isValid()) {
                        arrayList.add(cy5Var);
                    }
                } else if (yx5.W(threadData) && threadData.isBJHArticleThreadType()) {
                    yx5 yx5Var = new yx5(threadData);
                    yx5Var.position = i;
                    arrayList.add(yx5Var);
                } else {
                    dy5 dy5Var3 = new dy5();
                    dy5Var3.a = threadData;
                    dy5Var3.L(threadData.isLinkThread() ? "4" : "1");
                    dy5Var3.position = i;
                    if (concernData != null) {
                        dy5Var3.K(concernData.source.intValue());
                    }
                    if (dy5Var3.a != null && dy5Var3.isValid() && !StringUtils.isNull(dy5Var3.a.getId()) && !"0".equals(dy5Var3.a.getTid())) {
                        arrayList.add(dy5Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}

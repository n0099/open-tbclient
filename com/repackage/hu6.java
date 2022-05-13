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
public class hu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xy6 a;

    public hu6() {
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
        this.a = new xy6();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public xy6 b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                        if (fu6.q(builder.hot_recomforum, i2)) {
                            fu6 fu6Var = new fu6();
                            if (fu6Var.k(builder.hot_recomforum.tab_list)) {
                                fu6Var.position = i2;
                                linkedList.add(fu6Var);
                                i2++;
                            }
                        }
                        if (du6.k(concernData)) {
                            du6 du6Var = new du6();
                            if (concernData.recom_user_list.size() >= 4) {
                                du6Var.g(concernData.recom_user_list);
                                du6Var.position = i2;
                                du6Var.m(builder.thread_info.size() > 1);
                                linkedList.add(du6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b = ub8.b(concernData.thread_list);
                            if (b != null) {
                                arrayList.add(b);
                            }
                            linkedList.addAll(e(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                ub8.f().h("CONCERN", arrayList);
                xy6 xy6Var = this.a;
                xy6Var.a = linkedList;
                return xy6Var;
            }
            return null;
        }
        return (xy6) invokeCommon.objValue;
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
                if (du6.k(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!bt6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && du6.k(concernData2)) {
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

    public List<ro> e(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        yx5 gy5Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((gy5.W(threadData) || hy5.R(threadData) || iy5.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (iy5.W(threadData)) {
                    gy5Var = new iy5(threadData);
                } else if (hy5.R(threadData)) {
                    gy5Var = new hy5(threadData);
                } else {
                    gy5Var = new gy5();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    gy5Var.a = threadData;
                }
                gy5Var.g = threadData.getTid();
                if (gy5.W(threadData)) {
                    gy5Var.L("1");
                } else if (hy5.R(threadData)) {
                    gy5Var.L("2");
                }
                gy5Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && gy5Var.getThreadData() != null && gy5Var.getThreadData().getAuthor() != null) {
                    if (!gy5Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        yy6.r(gy5Var);
                        yy6.o(threadData);
                    } else {
                        yy6.t(gy5Var);
                    }
                } else if (gy5Var instanceof iy5) {
                    yy6.t(gy5Var);
                } else {
                    yy6.t(gy5Var);
                }
                gy5Var.a.insertItemToTitleOrAbstractText();
                if (gy5Var instanceof gy5) {
                    if (threadData.isBJHNormalThreadType()) {
                        yy6.u(gy5Var);
                    } else if (threadData.picCount() == 1) {
                        yy6.w(gy5Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        gy5Var.j = imageWidthAndHeight[0];
                        gy5Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        yy6.v(gy5Var);
                    } else {
                        yy6.x(gy5Var);
                    }
                } else if (gy5Var instanceof hy5) {
                    yy6.y(gy5Var);
                }
                if (gy5Var instanceof iy5) {
                    yy6.z(gy5Var);
                }
                if (threadData.getItem() != null) {
                    yy6.A(gy5Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        yy6.D(gy5Var);
                    } else {
                        yy6.B(gy5Var);
                    }
                }
                yy6.q(gy5Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    yy6.s(gy5Var);
                }
                yy6.p(gy5Var);
                gy5Var.setSupportType(BaseCardInfo.SupportType.TOP);
                gy5Var.position = i;
                arrayList.add(gy5Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    yy6.o(threadData);
                }
                if (threadData.isShareThread) {
                    gy5 gy5Var2 = new gy5();
                    gy5Var2.a = threadData;
                    gy5Var2.position = i;
                    arrayList.add(gy5Var2);
                } else if (hy5.R(threadData)) {
                    hy5 hy5Var = new hy5(threadData);
                    hy5Var.g = threadData.getTid();
                    if (concernData != null) {
                        hy5Var.K(concernData.source.intValue());
                    }
                    if (hy5Var.isValid()) {
                        arrayList.add(hy5Var);
                    }
                } else if (fy5.W(threadData)) {
                    fy5 fy5Var = new fy5(threadData);
                    fy5Var.g = threadData.getTid();
                    fy5Var.L("3");
                    if (fy5Var.isValid()) {
                        arrayList.add(fy5Var);
                    }
                } else if (by5.W(threadData) && threadData.isBJHArticleThreadType()) {
                    by5 by5Var = new by5(threadData);
                    by5Var.position = i;
                    arrayList.add(by5Var);
                } else {
                    gy5 gy5Var3 = new gy5();
                    gy5Var3.a = threadData;
                    gy5Var3.L(threadData.isLinkThread() ? "4" : "1");
                    gy5Var3.position = i;
                    if (concernData != null) {
                        gy5Var3.K(concernData.source.intValue());
                    }
                    if (gy5Var3.a != null && gy5Var3.isValid() && !StringUtils.isNull(gy5Var3.a.getId()) && !"0".equals(gy5Var3.a.getTid())) {
                        arrayList.add(gy5Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}

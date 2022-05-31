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
public class ls6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bx6 a;

    public ls6() {
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
        this.a = new bx6();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public bx6 b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                        if (js6.q(builder.hot_recomforum, i2)) {
                            js6 js6Var = new js6();
                            if (js6Var.k(builder.hot_recomforum.tab_list)) {
                                js6Var.position = i2;
                                linkedList.add(js6Var);
                                i2++;
                            }
                        }
                        if (hs6.k(concernData)) {
                            hs6 hs6Var = new hs6();
                            if (concernData.recom_user_list.size() >= 4) {
                                hs6Var.g(concernData.recom_user_list);
                                hs6Var.position = i2;
                                hs6Var.m(builder.thread_info.size() > 1);
                                linkedList.add(hs6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b = b98.b(concernData.thread_list);
                            if (b != null) {
                                arrayList.add(b);
                            }
                            linkedList.addAll(e(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                b98.f().h("CONCERN", arrayList);
                bx6 bx6Var = this.a;
                bx6Var.a = linkedList;
                return bx6Var;
            }
            return null;
        }
        return (bx6) invokeCommon.objValue;
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
                if (hs6.k(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!fr6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && hs6.k(concernData2)) {
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

    public List<jn> e(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        rw5 zw5Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((zw5.W(threadData) || ax5.R(threadData) || bx5.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (bx5.W(threadData)) {
                    zw5Var = new bx5(threadData);
                } else if (ax5.R(threadData)) {
                    zw5Var = new ax5(threadData);
                } else {
                    zw5Var = new zw5();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    zw5Var.a = threadData;
                }
                zw5Var.g = threadData.getTid();
                if (zw5.W(threadData)) {
                    zw5Var.L("1");
                } else if (ax5.R(threadData)) {
                    zw5Var.L("2");
                }
                zw5Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && zw5Var.getThreadData() != null && zw5Var.getThreadData().getAuthor() != null) {
                    if (!zw5Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        cx6.r(zw5Var);
                        cx6.o(threadData);
                    } else {
                        cx6.t(zw5Var);
                    }
                } else if (zw5Var instanceof bx5) {
                    cx6.t(zw5Var);
                } else {
                    cx6.t(zw5Var);
                }
                zw5Var.a.insertItemToTitleOrAbstractText();
                if (zw5Var instanceof zw5) {
                    if (threadData.isBJHNormalThreadType()) {
                        cx6.u(zw5Var);
                    } else if (threadData.picCount() == 1) {
                        cx6.w(zw5Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        zw5Var.j = imageWidthAndHeight[0];
                        zw5Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        cx6.v(zw5Var);
                    } else {
                        cx6.x(zw5Var);
                    }
                } else if (zw5Var instanceof ax5) {
                    cx6.y(zw5Var);
                }
                if (zw5Var instanceof bx5) {
                    cx6.z(zw5Var);
                }
                if (threadData.getItem() != null) {
                    cx6.A(zw5Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        cx6.D(zw5Var);
                    } else {
                        cx6.B(zw5Var);
                    }
                }
                cx6.q(zw5Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    cx6.s(zw5Var);
                }
                cx6.p(zw5Var);
                zw5Var.setSupportType(BaseCardInfo.SupportType.TOP);
                zw5Var.position = i;
                arrayList.add(zw5Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    cx6.o(threadData);
                }
                if (threadData.isShareThread) {
                    zw5 zw5Var2 = new zw5();
                    zw5Var2.a = threadData;
                    zw5Var2.position = i;
                    arrayList.add(zw5Var2);
                } else if (ax5.R(threadData)) {
                    ax5 ax5Var = new ax5(threadData);
                    ax5Var.g = threadData.getTid();
                    if (concernData != null) {
                        ax5Var.K(concernData.source.intValue());
                    }
                    if (ax5Var.isValid()) {
                        arrayList.add(ax5Var);
                    }
                } else if (yw5.W(threadData)) {
                    yw5 yw5Var = new yw5(threadData);
                    yw5Var.g = threadData.getTid();
                    yw5Var.L("3");
                    if (yw5Var.isValid()) {
                        arrayList.add(yw5Var);
                    }
                } else if (uw5.W(threadData) && threadData.isBJHArticleThreadType()) {
                    uw5 uw5Var = new uw5(threadData);
                    uw5Var.position = i;
                    arrayList.add(uw5Var);
                } else {
                    zw5 zw5Var3 = new zw5();
                    zw5Var3.a = threadData;
                    zw5Var3.L(threadData.isLinkThread() ? "4" : "1");
                    zw5Var3.position = i;
                    if (concernData != null) {
                        zw5Var3.K(concernData.source.intValue());
                    }
                    if (zw5Var3.a != null && zw5Var3.isValid() && !StringUtils.isNull(zw5Var3.a.getId()) && !"0".equals(zw5Var3.a.getTid())) {
                        arrayList.add(zw5Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}

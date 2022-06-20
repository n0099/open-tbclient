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
import tbclient.Userlike.UserFollowLive;
/* loaded from: classes7.dex */
public class qt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jy6 a;
    public boolean b;

    public qt6() {
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
        this.b = false;
        this.a = new jy6();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final mt6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jy6 jy6Var = this.a;
            if (jy6Var != null && !ListUtils.isEmpty(jy6Var.a)) {
                for (nn nnVar : this.a.a) {
                    if (nnVar instanceof mt6) {
                        return (mt6) nnVar;
                    }
                }
            }
            return null;
        }
        return (mt6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public jy6 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        mt6 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                a(builder);
                a(builder2);
                e(z, builder, builder2, i);
                LinkedList linkedList = new LinkedList();
                ArrayList arrayList = new ArrayList();
                UserFollowLive userFollowLive = builder2.user_follow_live;
                if (i == 0 && userFollowLive != null && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    mt6 mt6Var = new mt6();
                    mt6Var.f(userFollowLive);
                    linkedList.add(0, mt6Var);
                    mt6Var.position = -1;
                    this.b = true;
                } else if (i == 1 && (b = b()) != null) {
                    linkedList.add(0, b);
                    b.position = -1;
                    this.b = true;
                } else {
                    i2 = 0;
                    for (ConcernData concernData : builder.thread_info) {
                        if (concernData != null) {
                            if (ot6.n(builder.hot_recomforum, i2)) {
                                ot6 ot6Var = new ot6();
                                if (ot6Var.j(builder.hot_recomforum.tab_list)) {
                                    ot6Var.position = i2;
                                    linkedList.add(ot6Var);
                                    i2++;
                                }
                            }
                            if (lt6.j(concernData)) {
                                lt6 lt6Var = new lt6();
                                if (concernData.recom_user_list.size() >= 4) {
                                    lt6Var.f(concernData.recom_user_list);
                                    lt6Var.position = i2;
                                    lt6Var.l(builder.thread_info.size() > 1);
                                    linkedList.add(lt6Var);
                                }
                            } else {
                                ThreadData threadData = new ThreadData();
                                threadData.setFromConcern(true);
                                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                                threadData.parserProtobuf(concernData.thread_list);
                                JSONObject b2 = ia8.b(concernData.thread_list);
                                if (b2 != null) {
                                    arrayList.add(b2);
                                }
                                linkedList.addAll(f(threadData, i2, concernData));
                            }
                            i2++;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    ia8.f().h("CONCERN", arrayList);
                    jy6 jy6Var = this.a;
                    jy6Var.a = linkedList;
                    return jy6Var;
                }
                i2 = 1;
                while (r11.hasNext()) {
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                ia8.f().h("CONCERN", arrayList);
                jy6 jy6Var2 = this.a;
                jy6Var2.a = linkedList;
                return jy6Var2;
            }
            return null;
        }
        return (jy6) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) || list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i == 1) {
            for (ConcernData concernData : list2) {
                if (lt6.j(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!is6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && lt6.j(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.a.b = ListUtils.getCount(list) - count;
    }

    public final void e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || (list = builder.thread_info) == null || (list2 = builder2.thread_info) == null) {
            return;
        }
        d(z, list, list2, i);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<nn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        qx5 yx5Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((yx5.W(threadData) || zx5.R(threadData) || ay5.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (ay5.W(threadData)) {
                    yx5Var = new ay5(threadData);
                } else if (zx5.R(threadData)) {
                    yx5Var = new zx5(threadData);
                } else {
                    yx5Var = new yx5();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    yx5Var.a = threadData;
                }
                yx5Var.g = threadData.getTid();
                if (yx5.W(threadData)) {
                    yx5Var.L("1");
                } else if (zx5.R(threadData)) {
                    yx5Var.L("2");
                }
                yx5Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && yx5Var.getThreadData() != null && yx5Var.getThreadData().getAuthor() != null) {
                    if (!yx5Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        ky6.r(yx5Var);
                        ky6.o(threadData);
                    } else {
                        ky6.t(yx5Var);
                    }
                } else if (yx5Var instanceof ay5) {
                    ky6.t(yx5Var);
                } else {
                    ky6.t(yx5Var);
                }
                yx5Var.a.insertItemToTitleOrAbstractText();
                if (yx5Var instanceof yx5) {
                    if (threadData.isBJHNormalThreadType()) {
                        ky6.u(yx5Var);
                    } else if (threadData.picCount() == 1) {
                        ky6.w(yx5Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        yx5Var.j = imageWidthAndHeight[0];
                        yx5Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        ky6.v(yx5Var);
                    } else {
                        ky6.x(yx5Var);
                    }
                } else if (yx5Var instanceof zx5) {
                    ky6.y(yx5Var);
                }
                if (yx5Var instanceof ay5) {
                    ky6.z(yx5Var);
                }
                if (threadData.getItem() != null) {
                    ky6.A(yx5Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        ky6.D(yx5Var);
                    } else {
                        ky6.B(yx5Var);
                    }
                }
                ky6.q(yx5Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    ky6.s(yx5Var);
                }
                ky6.p(yx5Var);
                yx5Var.setSupportType(BaseCardInfo.SupportType.TOP);
                yx5Var.position = i;
                arrayList.add(yx5Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    ky6.o(threadData);
                }
                if (threadData.isShareThread) {
                    yx5 yx5Var2 = new yx5();
                    yx5Var2.a = threadData;
                    yx5Var2.position = i;
                    arrayList.add(yx5Var2);
                } else if (zx5.R(threadData)) {
                    zx5 zx5Var = new zx5(threadData);
                    zx5Var.g = threadData.getTid();
                    if (concernData != null) {
                        zx5Var.K(concernData.source.intValue());
                    }
                    if (zx5Var.isValid()) {
                        arrayList.add(zx5Var);
                    }
                } else if (xx5.W(threadData)) {
                    xx5 xx5Var = new xx5(threadData);
                    xx5Var.g = threadData.getTid();
                    xx5Var.L("3");
                    if (xx5Var.isValid()) {
                        arrayList.add(xx5Var);
                    }
                } else if (tx5.W(threadData) && threadData.isBJHArticleThreadType()) {
                    tx5 tx5Var = new tx5(threadData);
                    tx5Var.position = i;
                    arrayList.add(tx5Var);
                } else {
                    yx5 yx5Var3 = new yx5();
                    yx5Var3.a = threadData;
                    yx5Var3.L(threadData.isLinkThread() ? "4" : "1");
                    yx5Var3.position = i;
                    if (concernData != null) {
                        yx5Var3.K(concernData.source.intValue());
                    }
                    if (yx5Var3.a != null && yx5Var3.isValid() && !StringUtils.isNull(yx5Var3.a.getId()) && !"0".equals(yx5Var3.a.getTid())) {
                        arrayList.add(yx5Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}

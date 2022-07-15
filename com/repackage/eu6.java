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
/* loaded from: classes6.dex */
public class eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zy6 a;
    public boolean b;

    public eu6() {
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
        this.a = new zy6();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final au6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zy6 zy6Var = this.a;
            if (zy6Var != null && !ListUtils.isEmpty(zy6Var.a)) {
                for (nn nnVar : this.a.a) {
                    if (nnVar instanceof au6) {
                        return (au6) nnVar;
                    }
                }
            }
            return null;
        }
        return (au6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zy6 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
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
                    au6 au6Var = new au6();
                    au6Var.d(userFollowLive);
                    linkedList.add(0, au6Var);
                    au6Var.position = -1;
                    this.b = true;
                } else {
                    if (i == 1) {
                        au6 b = b();
                        if (b != null) {
                            linkedList.add(0, b);
                            b.position = -1;
                            this.b = true;
                        }
                    } else {
                        this.b = false;
                    }
                    i2 = 0;
                    for (ConcernData concernData : builder.thread_info) {
                        if (concernData != null) {
                            if (cu6.m(builder.hot_recomforum, i2)) {
                                cu6 cu6Var = new cu6();
                                if (cu6Var.i(builder.hot_recomforum.tab_list)) {
                                    cu6Var.position = i2;
                                    linkedList.add(cu6Var);
                                    i2++;
                                }
                            }
                            if (zt6.i(concernData)) {
                                zt6 zt6Var = new zt6();
                                if (concernData.recom_user_list.size() >= 4) {
                                    zt6Var.d(concernData.recom_user_list);
                                    zt6Var.position = i2;
                                    zt6Var.k(builder.thread_info.size() > 1);
                                    linkedList.add(zt6Var);
                                }
                            } else {
                                ThreadData threadData = new ThreadData();
                                threadData.setFromConcern(true);
                                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                                threadData.parserProtobuf(concernData.thread_list);
                                JSONObject b2 = db8.b(concernData.thread_list);
                                if (b2 != null) {
                                    arrayList.add(b2);
                                }
                                linkedList.addAll(f(threadData, i2, concernData));
                            }
                            i2++;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    db8.f().h("CONCERN", arrayList);
                    zy6 zy6Var = this.a;
                    zy6Var.a = linkedList;
                    return zy6Var;
                }
                i2 = 1;
                while (r11.hasNext()) {
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                db8.f().h("CONCERN", arrayList);
                zy6 zy6Var2 = this.a;
                zy6Var2.a = linkedList;
                return zy6Var2;
            }
            return null;
        }
        return (zy6) invokeCommon.objValue;
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
                if (zt6.i(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!ws6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && zt6.i(concernData2)) {
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
        ny5 vy5Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((vy5.W(threadData) || wy5.R(threadData) || xy5.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (xy5.W(threadData)) {
                    vy5Var = new xy5(threadData);
                } else if (wy5.R(threadData)) {
                    vy5Var = new wy5(threadData);
                } else {
                    vy5Var = new vy5();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    vy5Var.a = threadData;
                }
                vy5Var.g = threadData.getTid();
                if (vy5.W(threadData)) {
                    vy5Var.L("1");
                } else if (wy5.R(threadData)) {
                    vy5Var.L("2");
                }
                vy5Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && vy5Var.getThreadData() != null && vy5Var.getThreadData().getAuthor() != null) {
                    if (!vy5Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        az6.r(vy5Var);
                        az6.o(threadData);
                    } else {
                        az6.t(vy5Var);
                    }
                } else if (vy5Var instanceof xy5) {
                    az6.t(vy5Var);
                } else {
                    az6.t(vy5Var);
                }
                vy5Var.a.insertItemToTitleOrAbstractText();
                if (vy5Var instanceof vy5) {
                    if (threadData.isBJHNormalThreadType()) {
                        az6.u(vy5Var);
                    } else if (threadData.picCount() == 1) {
                        az6.w(vy5Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        vy5Var.j = imageWidthAndHeight[0];
                        vy5Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        az6.v(vy5Var);
                    } else {
                        az6.x(vy5Var);
                    }
                } else if (vy5Var instanceof wy5) {
                    az6.y(vy5Var);
                }
                if (vy5Var instanceof xy5) {
                    az6.z(vy5Var);
                }
                if (threadData.getItem() != null) {
                    az6.A(vy5Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        az6.D(vy5Var);
                    } else {
                        az6.B(vy5Var);
                    }
                }
                az6.q(vy5Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    az6.s(vy5Var);
                }
                az6.p(vy5Var);
                vy5Var.setSupportType(BaseCardInfo.SupportType.TOP);
                vy5Var.position = i;
                arrayList.add(vy5Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    az6.o(threadData);
                }
                if (threadData.isShareThread) {
                    vy5 vy5Var2 = new vy5();
                    vy5Var2.a = threadData;
                    vy5Var2.position = i;
                    arrayList.add(vy5Var2);
                } else if (wy5.R(threadData)) {
                    wy5 wy5Var = new wy5(threadData);
                    wy5Var.g = threadData.getTid();
                    if (concernData != null) {
                        wy5Var.K(concernData.source.intValue());
                    }
                    if (wy5Var.isValid()) {
                        arrayList.add(wy5Var);
                    }
                } else if (uy5.W(threadData)) {
                    uy5 uy5Var = new uy5(threadData);
                    uy5Var.g = threadData.getTid();
                    uy5Var.L("3");
                    if (uy5Var.isValid()) {
                        arrayList.add(uy5Var);
                    }
                } else if (qy5.W(threadData) && threadData.isBJHArticleThreadType()) {
                    qy5 qy5Var = new qy5(threadData);
                    qy5Var.position = i;
                    arrayList.add(qy5Var);
                } else {
                    vy5 vy5Var3 = new vy5();
                    vy5Var3.a = threadData;
                    vy5Var3.L(threadData.isLinkThread() ? "4" : "1");
                    vy5Var3.position = i;
                    if (concernData != null) {
                        vy5Var3.K(concernData.source.intValue());
                    }
                    if (vy5Var3.a != null && vy5Var3.isValid() && !StringUtils.isNull(vy5Var3.a.getId()) && !"0".equals(vy5Var3.a.getTid())) {
                        arrayList.add(vy5Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}

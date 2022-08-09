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
public class xv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t07 a;
    public boolean b;

    public xv6() {
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
        this.a = new t07();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final tv6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            t07 t07Var = this.a;
            if (t07Var != null && !ListUtils.isEmpty(t07Var.a)) {
                for (on onVar : this.a.a) {
                    if (onVar instanceof tv6) {
                        return (tv6) onVar;
                    }
                }
            }
            return null;
        }
        return (tv6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public t07 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                    tv6 tv6Var = new tv6();
                    tv6Var.f(userFollowLive);
                    linkedList.add(0, tv6Var);
                    tv6Var.position = -1;
                    this.b = true;
                } else {
                    if (i == 1) {
                        tv6 b = b();
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
                            if (vv6.n(builder.hot_recomforum, i2)) {
                                vv6 vv6Var = new vv6();
                                if (vv6Var.j(builder.hot_recomforum.tab_list)) {
                                    vv6Var.position = i2;
                                    linkedList.add(vv6Var);
                                    i2++;
                                }
                            }
                            if (sv6.j(concernData)) {
                                sv6 sv6Var = new sv6();
                                if (concernData.recom_user_list.size() >= 4) {
                                    sv6Var.f(concernData.recom_user_list);
                                    sv6Var.position = i2;
                                    sv6Var.l(builder.thread_info.size() > 1);
                                    linkedList.add(sv6Var);
                                }
                            } else {
                                ThreadData threadData = new ThreadData();
                                threadData.setFromConcern(true);
                                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                                threadData.parserProtobuf(concernData.thread_list);
                                JSONObject b2 = ld8.b(concernData.thread_list);
                                if (b2 != null) {
                                    arrayList.add(b2);
                                }
                                linkedList.addAll(f(threadData, i2, concernData));
                            }
                            i2++;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    ld8.f().h("CONCERN", arrayList);
                    t07 t07Var = this.a;
                    t07Var.a = linkedList;
                    return t07Var;
                }
                i2 = 1;
                while (r11.hasNext()) {
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                ld8.f().h("CONCERN", arrayList);
                t07 t07Var2 = this.a;
                t07Var2.a = linkedList;
                return t07Var2;
            }
            return null;
        }
        return (t07) invokeCommon.objValue;
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
                if (sv6.j(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!pu6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && sv6.j(concernData2)) {
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

    public List<on> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        f06 n06Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((n06.W(threadData) || o06.R(threadData) || p06.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (p06.W(threadData)) {
                    n06Var = new p06(threadData);
                } else if (o06.R(threadData)) {
                    n06Var = new o06(threadData);
                } else {
                    n06Var = new n06();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    n06Var.a = threadData;
                }
                n06Var.g = threadData.getTid();
                if (n06.W(threadData)) {
                    n06Var.L("1");
                } else if (o06.R(threadData)) {
                    n06Var.L("2");
                }
                n06Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && n06Var.getThreadData() != null && n06Var.getThreadData().getAuthor() != null) {
                    if (!n06Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        u07.r(n06Var);
                        u07.o(threadData);
                    } else {
                        u07.t(n06Var);
                    }
                } else if (n06Var instanceof p06) {
                    u07.t(n06Var);
                } else {
                    u07.t(n06Var);
                }
                n06Var.a.insertItemToTitleOrAbstractText();
                if (n06Var instanceof n06) {
                    if (threadData.isBJHNormalThreadType()) {
                        u07.u(n06Var);
                    } else if (threadData.picCount() == 1) {
                        u07.w(n06Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        n06Var.j = imageWidthAndHeight[0];
                        n06Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        u07.v(n06Var);
                    } else {
                        u07.x(n06Var);
                    }
                } else if (n06Var instanceof o06) {
                    u07.y(n06Var);
                }
                if (n06Var instanceof p06) {
                    u07.z(n06Var);
                }
                if (threadData.getItem() != null) {
                    u07.A(n06Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        u07.D(n06Var);
                    } else {
                        u07.B(n06Var);
                    }
                }
                u07.q(n06Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    u07.s(n06Var);
                }
                u07.p(n06Var);
                n06Var.setSupportType(BaseCardInfo.SupportType.TOP);
                n06Var.position = i;
                arrayList.add(n06Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    u07.o(threadData);
                }
                if (threadData.isShareThread) {
                    n06 n06Var2 = new n06();
                    n06Var2.a = threadData;
                    n06Var2.position = i;
                    arrayList.add(n06Var2);
                } else if (o06.R(threadData)) {
                    o06 o06Var = new o06(threadData);
                    o06Var.g = threadData.getTid();
                    if (concernData != null) {
                        o06Var.K(concernData.source.intValue());
                    }
                    if (o06Var.isValid()) {
                        arrayList.add(o06Var);
                    }
                } else if (m06.W(threadData)) {
                    m06 m06Var = new m06(threadData);
                    m06Var.g = threadData.getTid();
                    m06Var.L("3");
                    if (m06Var.isValid()) {
                        arrayList.add(m06Var);
                    }
                } else if (i06.W(threadData) && threadData.isBJHArticleThreadType()) {
                    i06 i06Var = new i06(threadData);
                    i06Var.position = i;
                    arrayList.add(i06Var);
                } else {
                    n06 n06Var3 = new n06();
                    n06Var3.a = threadData;
                    n06Var3.L(threadData.isLinkThread() ? "4" : "1");
                    n06Var3.position = i;
                    if (concernData != null) {
                        n06Var3.K(concernData.source.intValue());
                    }
                    if (n06Var3.a != null && n06Var3.isValid() && !StringUtils.isNull(n06Var3.a.getId()) && !"0".equals(n06Var3.a.getTid())) {
                        arrayList.add(n06Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}

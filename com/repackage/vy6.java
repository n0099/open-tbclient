package com.repackage;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class vy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xy6 a;
    public final int b;
    public int c;
    public ez6 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<ro> k;

    /* loaded from: classes7.dex */
    public class a implements Comparator<my5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(vy6 vy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(my5 my5Var, my5 my5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, my5Var, my5Var2)) == null) {
                if (my5Var != null && my5Var2 != null) {
                    if (my5Var.getPosition() > my5Var2.getPosition()) {
                        return 1;
                    }
                    if (my5Var.getPosition() < my5Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends yf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vy6 vy6Var, int i, String str, yx5 yx5Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy6Var, Integer.valueOf(i), str, yx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = yx5Var;
        }

        @Override // com.repackage.yf5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                yx5 yx5Var = this.h;
                if (yx5Var instanceof gy5) {
                    statisticItem = ((gy5) yx5Var).S();
                } else if (yx5Var instanceof hy5) {
                    statisticItem = ((hy5) yx5Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public vy6() {
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
        this.c = 0;
        this.d = new ez6();
        this.e = 0;
        this.j = 0L;
        this.a = new xy6();
        this.b = iu4.k().l("home_page_max_thread_count", 300);
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final py6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xy6 xy6Var = this.a;
            if (xy6Var != null && !ListUtils.isEmpty(xy6Var.a)) {
                for (ro roVar : this.a.a) {
                    if (roVar instanceof py6) {
                        return (py6) roVar;
                    }
                }
            }
            return null;
        }
        return (py6) invokeV.objValue;
    }

    public final qy6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xy6 xy6Var = this.a;
            if (xy6Var != null && !ListUtils.isEmpty(xy6Var.a)) {
                for (ro roVar : this.a.a) {
                    if (roVar instanceof qy6) {
                        return (qy6) roVar;
                    }
                }
            }
            return null;
        }
        return (qy6) invokeV.objValue;
    }

    public xy6 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                yy6.c(builder);
                yy6.c(builder2);
                p(z, builder, builder2, i);
                List<ThreadInfo> q = q(builder, i, this.b);
                yy6.n(builder);
                List<my5> d = yy6.d(builder);
                s(d);
                List<ro> f = f(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2);
                List<ro> f2 = f(q, new ArrayList(), builder2.user_follow_live, i, 1, null);
                this.d.a(f);
                wy6.c(builder, f);
                xy6 xy6Var = this.a;
                xy6Var.a = f;
                xy6Var.c = f2 == null ? 0 : f2.size();
                return this.a;
            }
            return null;
        }
        return (xy6) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ro> f(List<ThreadInfo> list, List<my5> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        InterceptResult invokeCommon;
        py6 a2;
        qy6 qy6Var;
        boolean z;
        yx5 e;
        gy5 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        gy5 g2;
        gy5 g3;
        gy5 g4;
        gy5 g5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && nj4.g().o()) {
                    this.j = threadInfo.id;
                }
            }
            List<ro> arrayList = new ArrayList<>(ListUtils.getCount(list));
            for (ThreadInfo threadInfo2 : list) {
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(threadInfo2);
                arrayList.add(threadData);
            }
            if (builder != null && fu6.q(builder.hot_recomforum, -1)) {
                fu6 fu6Var = new fu6();
                fu6Var.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
                if (fu6Var.k(builder.hot_recomforum.tab_list)) {
                    g(fu6Var, fu6Var.floorPosition, arrayList);
                }
            }
            if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int f = vw4.f();
                int e2 = vw4.e();
                if (i == 0) {
                    e2 = vw4.a();
                    this.k.clear();
                }
                h(e2, f, arrayList);
            }
            LinkedList<ro> linkedList = new LinkedList();
            int i3 = 0;
            for (ro roVar : arrayList) {
                boolean z2 = roVar instanceof ThreadData;
                if (z2 && ((ThreadData) roVar).isFunAdPlaceHolder()) {
                    linkedList.add(roVar);
                } else if (z2) {
                    ThreadData threadData2 = (ThreadData) roVar;
                    if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                        pp4 pp4Var = new pp4();
                        pp4Var.i(threadData2.getLegoCard());
                        pp4Var.position = i3;
                        linkedList.add(pp4Var);
                    } else if (t17.N(threadData2)) {
                        if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                            t17 t17Var = new t17();
                            t17Var.P(threadData2.getTopicModule());
                            t17Var.Z = 1;
                            t17Var.position = i3;
                            t17Var.Q(threadData2);
                            t17Var.setSupportType(BaseCardInfo.SupportType.FULL);
                            linkedList.add(t17Var);
                        }
                    } else if (!gy5.W(threadData2) && !hy5.R(threadData2) && !iy5.W(threadData2)) {
                        if (by5.W(threadData2) && threadData2.isBJHArticleThreadType()) {
                            by5 by5Var = new by5(threadData2);
                            by5Var.position = i3;
                            linkedList.add(by5Var);
                        } else {
                            yx5 e3 = yy6.e(threadData2);
                            if (e3 != null) {
                                e3.g = threadData2.getTid();
                                e3.position = i3;
                            }
                            if (e3 != null && e3.isValid()) {
                                linkedList.add(e3);
                            }
                        }
                    } else {
                        gy5 g6 = yy6.g(threadData2);
                        if (g6 != null) {
                            if (threadData2.showCardEnterFourm()) {
                                if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i3;
                                    yy6.t(g6);
                                    linkedList.add(g6);
                                }
                            } else {
                                ThreadData threadData3 = g6.a;
                                if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i3;
                                    yy6.r(g6);
                                    linkedList.add(g6);
                                    z = true;
                                    e = yy6.e(threadData2);
                                    if (e != null) {
                                        e.g = threadData2.getTid();
                                        e.position = i3;
                                        if (e instanceof gy5) {
                                            if (threadData2.isBJHNormalThreadType()) {
                                                yy6.u(e);
                                            } else if (threadData2.picCount() == 1) {
                                                yy6.w(e);
                                                int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                e.j = imageWidthAndHeight[0];
                                                e.k = imageWidthAndHeight[1];
                                            } else if (threadData2.picCount() >= 2) {
                                                yy6.v(e);
                                            } else {
                                                yy6.x(e);
                                            }
                                        } else if (e instanceof hy5) {
                                            yy6.y(e);
                                        }
                                    }
                                    if (e instanceof iy5) {
                                        yy6.z(e);
                                    }
                                    if (e != null && e.isValid()) {
                                        e.a.insertItemToTitleOrAbstractText();
                                        if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z) {
                                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029d), threadData2.getAuthor().getName_show());
                                            SpannableString spannableString = new SpannableString(format);
                                            spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format.length() - 1, 33);
                                            e.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                        }
                                        linkedList.add(e);
                                    }
                                    if (threadData2.getItem() != null && (g5 = yy6.g(threadData2)) != null) {
                                        g5.g = threadData2.getTid();
                                        g5.position = i3;
                                        yy6.A(g5);
                                        if (!gy5.W(threadData2)) {
                                            g5.L("1");
                                        } else if (hy5.R(threadData2)) {
                                            g5.L("2");
                                        }
                                        linkedList.add(g5);
                                    }
                                    if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = yy6.g(threadData2)) != null) {
                                        g.g = threadData2.getTid();
                                        g.position = i3;
                                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                            yy6.D(g);
                                        } else {
                                            yy6.B(g);
                                        }
                                        linkedList.add(g);
                                    }
                                    threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                    if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = yy6.g(threadData2)) != null) {
                                        g4.g = threadData2.getTid();
                                        g4.position = i3;
                                        yy6.C(g4);
                                        if (g4.isValid()) {
                                            linkedList.add(g4);
                                        }
                                    }
                                    if (threadData2.showCardEnterFourm() && (g3 = yy6.g(threadData2)) != null) {
                                        g3.g = threadData2.getTid();
                                        g3.position = i3;
                                        yy6.q(g3);
                                        if (!gy5.W(threadData2)) {
                                            g3.L("1");
                                        } else if (hy5.R(threadData2)) {
                                            g3.L("2");
                                        }
                                        if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        }
                                    }
                                    if (threadData2.getTopAgreePost() != null) {
                                        gy5 g7 = yy6.g(threadData2);
                                        if (g7 != null) {
                                            g7.g = threadData2.getTid();
                                            g7.position = i3;
                                            yy6.s(g7);
                                        }
                                        if (g7 != null && g7.isValid()) {
                                            linkedList.add(g7);
                                        }
                                    }
                                    g2 = yy6.g(threadData2);
                                    if (g2 != null) {
                                        g2.g = threadData2.getTid();
                                        g2.position = i3;
                                        yy6.p(g2);
                                    }
                                    if (g2 != null && g2.isValid()) {
                                        linkedList.add(g2);
                                    }
                                } else if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i3;
                                    yy6.t(g6);
                                    linkedList.add(g6);
                                }
                            }
                        }
                        z = false;
                        e = yy6.e(threadData2);
                        if (e != null) {
                        }
                        if (e instanceof iy5) {
                        }
                        if (e != null) {
                            e.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType()) {
                                String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029d), threadData2.getAuthor().getName_show());
                                SpannableString spannableString2 = new SpannableString(format2);
                                spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format2.length() - 1, 33);
                                e.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                            }
                            linkedList.add(e);
                        }
                        if (threadData2.getItem() != null) {
                            g5.g = threadData2.getTid();
                            g5.position = i3;
                            yy6.A(g5);
                            if (!gy5.W(threadData2)) {
                            }
                            linkedList.add(g5);
                        }
                        if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                        }
                        g.g = threadData2.getTid();
                        g.position = i3;
                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                        }
                        linkedList.add(g);
                        threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                        if (threadRecommendInfoData != null) {
                            g4.g = threadData2.getTid();
                            g4.position = i3;
                            yy6.C(g4);
                            if (g4.isValid()) {
                            }
                        }
                        if (threadData2.showCardEnterFourm()) {
                            g3.g = threadData2.getTid();
                            g3.position = i3;
                            yy6.q(g3);
                            if (!gy5.W(threadData2)) {
                            }
                            if (!threadData2.showCardEnterFourm()) {
                            }
                            if (!StringUtils.isNull(threadData2.getForum_name())) {
                            }
                        }
                        if (threadData2.getTopAgreePost() != null) {
                        }
                        g2 = yy6.g(threadData2);
                        if (g2 != null) {
                        }
                        if (g2 != null) {
                            linkedList.add(g2);
                        }
                    }
                    long g8 = kg.g(threadData2.getId(), 0L);
                    if (g8 != 0 && g8 == this.j.longValue()) {
                        if (builder.active_center != null) {
                            qy6Var = new qy6();
                            qy6Var.N(builder.active_center);
                        } else {
                            qy6Var = null;
                        }
                        if (qy6Var == null) {
                            qy6Var = b();
                        }
                        if (qy6Var != null) {
                            i3++;
                            qy6Var.R = i3;
                            linkedList.add(qy6Var);
                        }
                    }
                    i3++;
                } else if (roVar instanceof BaseCardInfo) {
                    linkedList.add(roVar);
                } else {
                    linkedList.add(roVar);
                }
                i3++;
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < ListUtils.getCount(list2); i6++) {
                    my5 my5Var = (my5) ListUtils.getItem(list2, i6);
                    if (my5Var != null && i4 < linkedList.size()) {
                        while (i4 < linkedList.size() && (!(linkedList.get(i4) instanceof yx5) || ((yx5) linkedList.get(i4)).position + i5 != my5Var.getPosition() - 1)) {
                            i4++;
                        }
                        if (linkedList.size() > i4 && i4 > 0) {
                            linkedList.add(i4, my5Var);
                            i5++;
                        }
                    }
                }
                int i7 = 0;
                int i8 = 0;
                for (ro roVar2 : linkedList) {
                    if (roVar2 instanceof np4) {
                        ((np4) roVar2).setPosition(i7 + 1);
                        i8++;
                    } else if (roVar2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo = (BaseCardInfo) roVar2;
                        i7 = baseCardInfo.position + i8;
                        baseCardInfo.position = i7;
                    }
                }
            }
            if (i2 == 0) {
                if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    py6 py6Var = new py6();
                    py6Var.i(userFollowLive);
                    linkedList.add(0, py6Var);
                    py6Var.position = -1;
                } else if (i == 1 && (a2 = a()) != null) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void g(zn4 zn4Var, int i, List<ro> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048582, this, zn4Var, i, list) == null) || zn4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    zn4Var.floorPosition = i;
                    ListUtils.add(list, i3, zn4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void h(int i, int i2, List<ro> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, list) == null) || ListUtils.isEmpty(list) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<ro> listIterator = list.listIterator();
        int i3 = 0;
        int i4 = 0;
        while (listIterator.hasNext()) {
            if (i3 == i || (i3 > i && (i3 - i) % i2 == 0)) {
                if (i4 < this.k.size()) {
                    listIterator.add(this.k.get(i4));
                } else {
                    ThreadData threadData = new ThreadData();
                    yj8 yj8Var = new yj8();
                    yj8Var.k(true);
                    threadData.funAdData = yj8Var;
                    listIterator.add(threadData);
                    this.k.add(threadData);
                }
                i4++;
            }
            listIterator.next();
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r5.size() <= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r5.add(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r5.add(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(List<ro> list, fu6 fu6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, fu6Var, i) == null) || fu6Var == null || ListUtils.isEmpty(fu6Var.g())) {
            return;
        }
        int i2 = 0;
        if (list.size() > 0) {
            int i3 = 0;
            while (i3 < list.size() && ((!(list.get(i3) instanceof yx5) || ((yx5) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof np4) || ((np4) list.get(i3)).h() + 1 != i))) {
                i3++;
            }
        }
        int i4 = 0;
        for (ro roVar : list) {
            if (roVar instanceof fu6) {
                ((fu6) roVar).position = i2 + 1;
                i4++;
            } else if (roVar instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) roVar;
                int i5 = baseCardInfo.position + i4;
                baseCardInfo.position = i5;
                i2 = i5;
            }
        }
    }

    public void j(List<ro> list, pc8 pc8Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, list, pc8Var, i) == null) || ListUtils.isEmpty(list) || pc8Var == null || i < 0) {
            return;
        }
        r(list);
        if (i == 0) {
            i(list, fu6.e(pc8Var), pc8Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof yx5) && !(list.get(i) instanceof np4)) {
            i++;
        }
        if (list.get(i) instanceof yx5) {
            i(list, fu6.e(pc8Var), ((yx5) list.get(i)).position + 2);
        } else if (list.get(i) instanceof np4) {
            i(list, fu6.e(pc8Var), ((np4) list.get(i)).h() + 2);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            return (arrayList == null || ListUtils.isEmpty(arrayList)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e > 0 : invokeV.booleanValue;
    }

    public final void m(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            yy6.k(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void n(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || builder == null || builder2 == null || (list = builder.thread_list) == null || (list2 = builder2.thread_list) == null) {
            return;
        }
        this.f = ListUtils.getCount(list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null) {
            this.g = ListUtils.getCount(bannerList.app);
        } else {
            this.g = 0;
        }
        int count = ListUtils.getCount(list) + ListUtils.getCount(this.h);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                hashSet2.add(threadInfo.lego_card);
            } else if (threadInfo != null && (l5 = threadInfo.tid) != null) {
                hashSet.add(l5);
            }
        }
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        Iterator<ThreadInfo> it = this.h.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                hashSet4.add(next.lego_card);
            } else if (next != null && (l4 = next.tid) != null) {
                hashSet3.add(l4);
            }
        }
        if (i == 1) {
            if (!ListUtils.isEmpty(list2)) {
                this.d.b((ThreadInfo) ListUtils.getItem(list2, 0));
            }
            for (ThreadInfo threadInfo2 : list2) {
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                        list.add(threadInfo2);
                    }
                } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                    list.add(threadInfo2);
                    JSONObject b2 = ub8.b(threadInfo2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
        } else {
            this.d.c(z, list);
            if (l()) {
                BannerList bannerList2 = builder.banner_list;
                if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                    this.i.addAll(0, builder.banner_list.app);
                    BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                    builder3.app = new LinkedList();
                    builder.banner_list = builder3.build(false);
                }
                this.h.addAll(0, list);
                list.clear();
                hashSet.clear();
                hashSet2.clear();
                if (ListUtils.getCount(this.h) > this.b) {
                    for (int size = this.h.size() - 1; size >= this.b; size--) {
                        this.h.remove(size);
                    }
                }
                hashSet3.clear();
                hashSet4.clear();
                Iterator<ThreadInfo> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    ThreadInfo next2 = it2.next();
                    if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                        hashSet4.add(next2.lego_card);
                    } else if (next2 != null && (l2 = next2.tid) != null) {
                        hashSet3.add(l2);
                    }
                }
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ThreadInfo threadInfo3 = (ThreadInfo) ListUtils.getItem(list2, count2);
                if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                    if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                        list.add(0, threadInfo3);
                    }
                } else if (threadInfo3 != null && (l = threadInfo3.tid) != null && !hashSet.contains(l) && !hashSet3.contains(threadInfo3.tid)) {
                    list.add(0, threadInfo3);
                    JSONObject b3 = ub8.b(threadInfo3);
                    if (b3 != null) {
                        arrayList.add(0, b3);
                    }
                }
            }
        }
        if (l()) {
            if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    App app = this.i.get(i2);
                    if (app != null) {
                        App.Builder builder4 = new App.Builder(app);
                        o98.c(builder4, count3);
                        App build = builder4.build(false);
                        this.i.remove(i2);
                        this.i.add(i2, build);
                    }
                }
            }
            if (ListUtils.getCount(list) >= this.e) {
                list.addAll(this.h);
                this.h.clear();
                BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                if (builder5.app == null) {
                    builder5.app = new LinkedList();
                }
                builder5.app.addAll(this.i);
                builder.banner_list = builder5.build(false);
                this.i.clear();
            }
        }
        int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.h)) - count;
        this.a.b = count4;
        this.c = count4;
        ub8.f().h("HOME", arrayList);
    }

    public final void o(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public final void p(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || builder == null || builder2 == null) {
            return;
        }
        Integer num = builder2.fresh_ctrl_num;
        int intValue = (num == null || num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
        this.e = intValue;
        int i2 = this.b;
        if (intValue > i2) {
            intValue = i2;
        }
        this.e = intValue;
        n(z, builder, builder2, i);
        m(z, builder, builder2, i);
        o(builder.thread_personalized, builder2.thread_personalized);
    }

    public final List<ThreadInfo> q(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, builder, i, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (builder != null && (list = builder.thread_list) != null) {
                if (i == 1) {
                    for (int count = ((ListUtils.getCount(list) - i2) + 30) - 1; count >= 30; count--) {
                        if (list.size() > count) {
                            arrayList.add(list.remove(count));
                        }
                    }
                } else {
                    for (int count2 = ListUtils.getCount(list) - 1; count2 >= i2; count2--) {
                        list.remove(count2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }

    public final void r(List<ro> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            Iterator<ro> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                ro next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if (next instanceof fu6) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final void s(List<my5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}

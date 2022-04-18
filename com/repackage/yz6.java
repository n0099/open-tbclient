package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.DiscoverHotForum;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
import tbclient.Personalized.TagStruct;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class yz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, xx5Var) == null) {
            xx5Var.u = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void B(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, xx5Var) == null) {
            if (xx5Var instanceof fy5) {
                ((fy5) xx5Var).w = true;
            } else if (xx5Var instanceof gy5) {
                ((gy5) xx5Var).w = true;
            } else if (xx5Var instanceof ey5) {
                ((ey5) xx5Var).w = true;
            }
            xx5Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void C(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, xx5Var) == null) {
            xx5Var.z = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xx5Var) == null) {
            if (xx5Var instanceof fy5) {
                ((fy5) xx5Var).v = true;
            } else if (xx5Var instanceof gy5) {
                ((gy5) xx5Var).v = true;
            } else if (xx5Var instanceof ey5) {
                ((ey5) xx5Var).v = true;
            }
            xx5Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void E(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder) == null) || builder == null || ListUtils.isEmpty(builder.app)) {
            return;
        }
        for (int i = 0; i < builder.app.size(); i++) {
            App app = builder.app.get(i);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                builder2.pos = Integer.valueOf(p98.b(app));
                App build = builder2.build(false);
                builder.app.remove(i);
                builder.app.add(i, build);
            }
        }
    }

    public static void a(List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null || list.size() <= 1) {
            return;
        }
        int size = list.size() - 1;
        while (true) {
            int i = size - 1;
            if (i <= 0) {
                return;
            }
            int f = f(list.get(size));
            int f2 = f(list.get(i));
            if (f <= 0 || f - f2 < 3) {
                ListUtils.remove(list, size);
            }
            size--;
        }
    }

    public static void b(int i, List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65542, null, i, list) == null) || list == null) {
            return;
        }
        int i2 = 0;
        Iterator<App> it = list.iterator();
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b = p98.b(next);
                if (b <= 0) {
                    it.remove();
                    ad8.i(l(next), 1, 23);
                } else {
                    int i3 = i + i2 + 1;
                    if (b <= i3) {
                        i2++;
                    } else {
                        it.remove();
                        ad8.j(l(next), 1, 2, b, i3);
                    }
                }
            } else {
                it.remove();
            }
        }
    }

    public static void c(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, builder) == null) || builder == null) {
            return;
        }
        if (builder.thread_list == null) {
            builder.thread_list = new LinkedList();
        }
        if (builder.card_forum == null) {
            builder.card_forum = new LinkedList();
        }
        if (builder.card_topic == null) {
            builder.card_topic = new LinkedList();
        }
        if (builder.resource_list == null) {
            builder.resource_list = new LinkedList();
        }
        if (builder.thread_personalized == null) {
            builder.thread_personalized = new LinkedList();
        }
        if (builder.interestion == null) {
            builder.interestion = new LinkedList();
        }
        if (builder.card_god == null) {
            builder.card_god = new LinkedList();
        }
    }

    public static List<ly5> d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, builder)) == null) {
            nz6 nz6Var = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    mz6 mz6Var = new mz6();
                    mz6Var.e(resource);
                    linkedList.add(mz6Var);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && lz6.q(cardForum.card_type.intValue()) && nz6Var == null) {
                        nz6Var = new nz6();
                        nz6Var.s(cardForum);
                        if (nz6Var.r()) {
                            linkedList.add(nz6Var);
                        }
                    }
                }
            }
            List<AdvertAppInfo> h = ma8.q().h();
            if (h != null) {
                h.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    kz6 kz6Var = new kz6();
                    kz6Var.g(app);
                    if (h != null && (advertAppInfo = kz6Var.a) != null) {
                        advertAppInfo.isFromHomPage = true;
                        h.add(advertAppInfo);
                    }
                    AdvertAppInfo e = kz6Var.e();
                    if (e == null) {
                        ad8.i(kz6Var.e(), 1, 100);
                    } else {
                        int q = e.q();
                        if (q != 0) {
                            ad8.i(kz6Var.e(), 1, q);
                            if (q != 28 && q != 31) {
                                e.c = -1001;
                            }
                        }
                        if (kz6Var.getPosition() <= 0) {
                            ad8.i(kz6Var.e(), 1, 23);
                            e.c = -1001;
                        }
                        if (e.i()) {
                            try {
                                if (TextUtils.isEmpty(e.s)) {
                                    ad8.i(kz6Var.e(), 1, 26);
                                } else if (gk8.b(TbadkCoreApplication.getInst().getContext(), e.s) && rg5.h().F()) {
                                    ad8.i(kz6Var.e(), 1, 3);
                                }
                            } catch (Exception unused) {
                                ad8.i(kz6Var.e(), 1, 100);
                            }
                        }
                        linkedList.add(kz6Var);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static xx5 e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.isShareThread) {
                fy5 fy5Var = new fy5();
                fy5Var.a = threadData;
                return fy5Var;
            } else if (hy5.W(threadData)) {
                return new hy5(threadData);
            } else {
                if (ey5.W(threadData)) {
                    return new ey5(threadData);
                }
                if (!fy5.W(threadData) && !fy5.X(threadData)) {
                    if (gy5.R(threadData)) {
                        return new gy5(threadData);
                    }
                    return null;
                }
                fy5 fy5Var2 = new fy5();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                fy5Var2.a = threadData;
                return fy5Var2;
            }
        }
        return (xx5) invokeL.objValue;
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return p98.b(app);
        }
        return invokeL.intValue;
    }

    public static fy5 g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            fy5 fy5Var = new fy5();
            fy5Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return fy5Var;
        }
        return (fy5) invokeL.objValue;
    }

    public static void h(BannerList.Builder builder, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65548, null, builder, i) == null) || builder == null || builder.app == null) {
            return;
        }
        for (int i2 = 0; i2 < builder.app.size(); i2++) {
            App app = builder.app.get(i2);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                p98.c(builder2, i);
                App build = builder2.build(false);
                builder.app.remove(i2);
                builder.app.add(i2, build);
            }
        }
    }

    public static BannerList i(boolean z, BannerList bannerList, BannerList bannerList2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (bannerList2 != null && bannerList2.app != null) {
                if (builder.app == null) {
                    builder.app = new LinkedList();
                }
                b(i, builder.app);
                int i5 = i2 + i3;
                BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
                if (builder2.app == null) {
                    builder2.app = new LinkedList();
                }
                if (z) {
                    E(builder2);
                }
                List<App> list = builder2.app;
                if (list != null) {
                    Iterator<App> it = list.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        App next = it.next();
                        if (next != null) {
                            int b = p98.b(next);
                            if (b <= 0) {
                                it.remove();
                                ad8.i(l(next), 1, 23);
                            } else {
                                int i7 = i4 + i6 + 1;
                                if (b <= i7) {
                                    i6++;
                                } else {
                                    it.remove();
                                    ad8.j(l(next), 1, 2, b, i7);
                                }
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
                h(builder2, i5);
                List<App> list2 = builder2.app;
                if (list2 != null) {
                    builder.app.addAll(list2);
                }
                return builder.build(false);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static BannerList j(boolean z, BannerList bannerList, BannerList bannerList2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i)})) == null) {
            if (i <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (z) {
                E(builder2);
            }
            List<App> list = builder2.app;
            if (list != null) {
                Iterator<App> it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int b = p98.b(next);
                        if (b <= 0) {
                            it.remove();
                            ad8.i(l(next), 1, 23);
                        } else {
                            int i3 = i + i2 + 1;
                            if (b <= i3) {
                                i2++;
                            } else {
                                it.remove();
                                ad8.j(l(next), 1, 2, b, i3);
                            }
                        }
                    } else {
                        it.remove();
                    }
                }
            } else {
                i2 = 0;
            }
            int i4 = i2 + i;
            if (i4 <= 0) {
                return builder.build(false);
            }
            h(builder, i4);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                builder.app.addAll(0, list2);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2, int i3, int i4) {
        List<TagStruct> list;
        List<Resource> list2;
        List<CardTopic> list3;
        List<CardForum> list4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || builder2 == null || builder == null) {
            return;
        }
        List<CardForum> list5 = builder2.card_forum;
        if (list5 != null && (list4 = builder.card_forum) != null) {
            list4.addAll(list5);
        }
        List<CardTopic> list6 = builder2.card_topic;
        if (list6 != null && (list3 = builder.card_topic) != null) {
            list3.addAll(list6);
        }
        List<Resource> list7 = builder2.resource_list;
        if (list7 != null && (list2 = builder.resource_list) != null) {
            list2.addAll(list7);
        }
        if (i == 0) {
            builder.banner_list = j(z, builder.banner_list, builder2.banner_list, i2);
        } else {
            List<ThreadInfo> list8 = builder.thread_list;
            builder.banner_list = i(z, builder.banner_list, builder2.banner_list, list8 != null ? list8.size() : 0, i3, i4, i2);
        }
        if (builder.age_sex == null) {
            builder.age_sex = builder2.age_sex;
            if (builder2.age_sex != null) {
                vt4.k().u("has_requested_new_user_guide", true);
            }
        }
        if (builder2.interestion != null && builder != null && (list = builder.interestion) != null && list.size() == 0) {
            builder.interestion.addAll(builder2.interestion);
        }
        List<CardGod> list9 = builder2.card_god;
        if (list9 != null) {
            builder.card_god.addAll(list9);
        }
        DiscoverHotForum discoverHotForum = builder2.hot_recomforum;
        if (discoverHotForum != null) {
            builder.hot_recomforum = discoverHotForum;
        }
    }

    public static AdvertAppInfo l(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            kz6 kz6Var = new kz6();
            kz6Var.g(app);
            return kz6Var.e();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void m(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, builder) == null) || builder == null) {
            return;
        }
        int count = ListUtils.getCount(builder.thread_list);
        BannerList bannerList = builder.banner_list;
        if (bannerList == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        a(list);
        for (int size = builder2.app.size() - 1; size >= 0; size--) {
            App app = builder2.app.get(size);
            kz6 kz6Var = new kz6();
            kz6Var.g(app);
            int b = app != null ? p98.b(app) : -1;
            if (b < 0) {
                ad8.i(kz6Var.e(), 1, 33);
                builder2.app.remove(size);
            } else {
                int i = count + size;
                if (b > i) {
                    ad8.j(kz6Var.o(), 1, 2, b, i);
                    builder2.app.remove(size);
                } else {
                    AdvertAppInfo e = kz6Var.e();
                    if (e == null) {
                        ad8.i(kz6Var.e(), 1, 100);
                        builder2.app.remove(size);
                    } else {
                        int q = e.q();
                        if (q != 0) {
                            ad8.i(kz6Var.e(), 1, q);
                            builder2.app.remove(size);
                        }
                    }
                }
            }
        }
        if (builder2.app.size() != builder.banner_list.app.size()) {
            builder.banner_list = builder2.build(false);
        }
    }

    public static void n(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, builder) == null) {
            m(builder);
            if (builder == null || builder.card_forum == null || builder.card_topic == null || builder.resource_list == null || ListUtils.getCount(builder.thread_list) == 0) {
                return;
            }
            int count = ListUtils.getCount(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > count) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > count) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > count) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > count) {
                    builder.card_god.remove(size4);
                }
            }
        }
    }

    public static void o(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10e8) + "   " + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f8d) + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }

    public static void p(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, xx5Var) == null) {
            if (xx5Var instanceof hy5) {
                ((hy5) xx5Var).A = true;
            } else if (xx5Var instanceof fy5) {
                ((fy5) xx5Var).A = true;
            } else if (xx5Var instanceof gy5) {
                ((gy5) xx5Var).A = true;
            } else if (xx5Var instanceof ey5) {
                ((ey5) xx5Var).A = true;
            }
            xx5Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void q(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, xx5Var) == null) {
            if (xx5Var == null || xx5Var.getThreadData() == null || !xx5Var.getThreadData().isFromHomPage || !xx5Var.getThreadData().isWorksInfo()) {
                if (xx5Var instanceof fy5) {
                    ((fy5) xx5Var).x = true;
                } else if (xx5Var instanceof gy5) {
                    ((gy5) xx5Var).x = true;
                } else if (xx5Var instanceof ey5) {
                    ((ey5) xx5Var).x = true;
                }
                xx5Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            }
        }
    }

    public static void r(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, xx5Var) == null) {
            xx5Var.n = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void s(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, xx5Var) == null) || xx5Var == null || xx5Var.getThreadData() == null || xx5Var.getThreadData().getTopAgreePost() == null || xx5Var.getThreadData().getTopAgreePost().s() == null || xx5Var.getThreadData().getTopAgreePost().s().getUserId() == null) {
            return;
        }
        if (xx5Var instanceof fy5) {
            ((fy5) xx5Var).y = true;
        } else if (xx5Var instanceof gy5) {
            ((gy5) xx5Var).y = true;
        } else if (xx5Var instanceof ey5) {
            ((ey5) xx5Var).y = true;
        }
        xx5Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }

    public static void t(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, xx5Var) == null) {
            if (xx5Var instanceof hy5) {
                ((hy5) xx5Var).m = true;
            } else if (xx5Var instanceof fy5) {
                ((fy5) xx5Var).m = true;
            } else if (xx5Var instanceof gy5) {
                ((gy5) xx5Var).m = true;
            } else if (xx5Var instanceof ey5) {
                ((ey5) xx5Var).m = true;
            }
            xx5Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void u(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, xx5Var) == null) {
            ((fy5) xx5Var).o = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void v(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, xx5Var) == null) {
            ((fy5) xx5Var).q = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, xx5Var) == null) {
            ((fy5) xx5Var).p = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, xx5Var) == null) {
            ((fy5) xx5Var).r = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, xx5Var) == null) {
            ((gy5) xx5Var).s = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(xx5 xx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, xx5Var) == null) {
            ((hy5) xx5Var).t = true;
            xx5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}

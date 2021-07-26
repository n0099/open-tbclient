package d.a.q0.e1.h.k;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.s.q.b2;
import d.a.q0.a0.e0.j;
import d.a.q0.a0.e0.k;
import d.a.q0.a0.e0.l;
import d.a.q0.a0.e0.p;
import d.a.q0.h3.z;
import d.a.q0.w2.w;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).A = true;
            } else if (bVar instanceof l) {
                ((l) bVar).A = true;
            } else if (bVar instanceof j) {
                ((j) bVar).A = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void B(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bVar) == null) {
            bVar.D = true;
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void C(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).z = true;
            } else if (bVar instanceof l) {
                ((l) bVar).z = true;
            } else if (bVar instanceof j) {
                ((j) bVar).z = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, builder) == null) || builder == null || ListUtils.isEmpty(builder.app)) {
            return;
        }
        for (int i2 = 0; i2 < builder.app.size(); i2++) {
            App app = builder.app.get(i2);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                builder2.pos = Integer.valueOf(d.a.q0.w2.c.b(app));
                App build = builder2.build(false);
                builder.app.remove(i2);
                builder.app.add(i2, build);
            }
        }
    }

    public static void a(List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) || list == null || list.size() <= 1) {
            return;
        }
        int size = list.size() - 1;
        while (true) {
            int i2 = size - 1;
            if (i2 <= 0) {
                return;
            }
            int f2 = f(list.get(size));
            int f3 = f(list.get(i2));
            if (f2 <= 0 || f2 - f3 < 3) {
                ListUtils.remove(list, size);
            }
            size--;
        }
    }

    public static void b(int i2, List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, list) == null) || list == null) {
            return;
        }
        int i3 = 0;
        Iterator<App> it = list.iterator();
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = d.a.q0.w2.c.b(next);
                if (b2 <= 0) {
                    it.remove();
                    d.a.q0.w2.i0.d.h(l(next), 1, 23);
                } else {
                    int i4 = i2 + i3 + 1;
                    if (b2 <= i4) {
                        i3++;
                    } else {
                        it.remove();
                        d.a.q0.w2.i0.d.i(l(next), 1, 2, b2, i4);
                    }
                }
            } else {
                it.remove();
            }
        }
    }

    public static void c(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, builder) == null) || builder == null) {
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

    public static List<p> d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, builder)) == null) {
            d.a.q0.e1.h.j.d dVar = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    d.a.q0.e1.h.j.c cVar = new d.a.q0.e1.h.j.c();
                    cVar.c(resource);
                    linkedList.add(cVar);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && d.a.q0.e1.h.j.b.o(cardForum.card_type.intValue()) && dVar == null) {
                        dVar = new d.a.q0.e1.h.j.d();
                        dVar.q(cardForum);
                        if (dVar.p()) {
                            linkedList.add(dVar);
                        }
                    }
                }
            }
            List<AdvertAppInfo> h2 = w.o().h();
            if (h2 != null) {
                h2.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    d.a.q0.e1.h.j.a aVar = new d.a.q0.e1.h.j.a();
                    aVar.d(app);
                    if (h2 != null && (advertAppInfo = aVar.f54343e) != null) {
                        advertAppInfo.W1 = true;
                        h2.add(advertAppInfo);
                    }
                    AdvertAppInfo c2 = aVar.c();
                    if (c2 == null) {
                        d.a.q0.w2.i0.d.h(aVar.c(), 1, 100);
                    } else {
                        int z4 = c2.z4();
                        if (z4 != 0) {
                            d.a.q0.w2.i0.d.h(aVar.c(), 1, z4);
                            if (z4 != 28 && z4 != 31) {
                                c2.T3 = -1001;
                            }
                        }
                        if (aVar.getPosition() <= 0) {
                            d.a.q0.w2.i0.d.h(aVar.c(), 1, 23);
                            c2.T3 = -1001;
                        }
                        if (c2.w4()) {
                            try {
                                if (TextUtils.isEmpty(c2.j4)) {
                                    d.a.q0.w2.i0.d.h(aVar.c(), 1, 26);
                                } else if (z.b(TbadkCoreApplication.getInst().getContext(), c2.j4) && d.a.q0.a.h().A()) {
                                    d.a.q0.w2.i0.d.h(aVar.c(), 1, 3);
                                }
                            } catch (Exception unused) {
                                d.a.q0.w2.i0.d.h(aVar.c(), 1, 100);
                            }
                        }
                        linkedList.add(aVar);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static d.a.q0.a0.e0.b e(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            if (b2Var.v1) {
                k kVar = new k();
                kVar.f54338e = b2Var;
                return kVar;
            } else if (j.W(b2Var)) {
                return new j(b2Var);
            } else {
                if (!k.W(b2Var) && !k.X(b2Var)) {
                    if (l.R(b2Var)) {
                        return new l(b2Var);
                    }
                    return null;
                }
                k kVar2 = new k();
                b2Var.W1();
                b2Var.k2();
                if (!b2Var.W1() && !b2Var.k2()) {
                    b2Var.R1();
                }
                kVar2.f54338e = b2Var;
                return kVar2;
            }
        }
        return (d.a.q0.a0.e0.b) invokeL.objValue;
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return d.a.q0.w2.c.b(app);
        }
        return invokeL.intValue;
    }

    public static k g(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, b2Var)) == null) {
            k kVar = new k();
            kVar.f54338e = b2Var;
            b2Var.W1();
            if (!b2Var.W1()) {
                b2Var.R1();
            }
            return kVar;
        }
        return (k) invokeL.objValue;
    }

    public static void h(BannerList.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65547, null, builder, i2) == null) || builder == null || builder.app == null) {
            return;
        }
        for (int i3 = 0; i3 < builder.app.size(); i3++) {
            App app = builder.app.get(i3);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                d.a.q0.w2.c.c(builder2, i2);
                App build = builder2.build(false);
                builder.app.remove(i3);
                builder.app.add(i3, build);
            }
        }
    }

    public static BannerList i(boolean z, BannerList bannerList, BannerList bannerList2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (bannerList2 != null && bannerList2.app != null) {
                if (builder.app == null) {
                    builder.app = new LinkedList();
                }
                b(i2, builder.app);
                int i6 = i3 + i4;
                BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
                if (builder2.app == null) {
                    builder2.app = new LinkedList();
                }
                if (z) {
                    D(builder2);
                }
                List<App> list = builder2.app;
                if (list != null) {
                    Iterator<App> it = list.iterator();
                    int i7 = 0;
                    while (it.hasNext()) {
                        App next = it.next();
                        if (next != null) {
                            int b2 = d.a.q0.w2.c.b(next);
                            if (b2 <= 0) {
                                it.remove();
                                d.a.q0.w2.i0.d.h(l(next), 1, 23);
                            } else {
                                int i8 = i5 + i7 + 1;
                                if (b2 <= i8) {
                                    i7++;
                                } else {
                                    it.remove();
                                    d.a.q0.w2.i0.d.i(l(next), 1, 2, b2, i8);
                                }
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
                h(builder2, i6);
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

    public static BannerList j(boolean z, BannerList bannerList, BannerList bannerList2, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i2)})) == null) {
            if (i2 <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (z) {
                D(builder2);
            }
            List<App> list = builder2.app;
            if (list != null) {
                Iterator<App> it = list.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int b2 = d.a.q0.w2.c.b(next);
                        if (b2 <= 0) {
                            it.remove();
                            d.a.q0.w2.i0.d.h(l(next), 1, 23);
                        } else {
                            int i4 = i2 + i3 + 1;
                            if (b2 <= i4) {
                                i3++;
                            } else {
                                it.remove();
                                d.a.q0.w2.i0.d.i(l(next), 1, 2, b2, i4);
                            }
                        }
                    } else {
                        it.remove();
                    }
                }
            } else {
                i3 = 0;
            }
            int i5 = i3 + i2;
            if (i5 <= 0) {
                return builder.build(false);
            }
            h(builder, i5);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                builder.app.addAll(0, list2);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2, int i3, int i4, int i5) {
        List<TagStruct> list;
        List<Resource> list2;
        List<CardTopic> list3;
        List<CardForum> list4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || builder2 == null || builder == null) {
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
        if (i2 == 0) {
            builder.banner_list = j(z, builder.banner_list, builder2.banner_list, i3);
        } else {
            List<ThreadInfo> list8 = builder.thread_list;
            builder.banner_list = i(z, builder.banner_list, builder2.banner_list, list8 != null ? list8.size() : 0, i4, i5, i3);
        }
        if (builder.age_sex == null) {
            builder.age_sex = builder2.age_sex;
            if (builder2.age_sex != null) {
                d.a.p0.s.d0.b.j().t("has_requested_new_user_guide", true);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, app)) == null) {
            d.a.q0.e1.h.j.a aVar = new d.a.q0.e1.h.j.a();
            aVar.d(app);
            return aVar.c();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void m(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, builder) == null) || builder == null) {
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
            d.a.q0.e1.h.j.a aVar = new d.a.q0.e1.h.j.a();
            aVar.d(app);
            int b2 = app != null ? d.a.q0.w2.c.b(app) : -1;
            if (b2 < 0) {
                d.a.q0.w2.i0.d.h(aVar.c(), 1, 33);
                builder2.app.remove(size);
            } else {
                int i2 = count + size;
                if (b2 > i2) {
                    d.a.q0.w2.i0.d.i(aVar.m(), 1, 2, b2, i2);
                    builder2.app.remove(size);
                } else {
                    AdvertAppInfo c2 = aVar.c();
                    if (c2 == null) {
                        d.a.q0.w2.i0.d.h(aVar.c(), 1, 100);
                        builder2.app.remove(size);
                    } else {
                        int z4 = c2.z4();
                        if (z4 != 0) {
                            d.a.q0.w2.i0.d.h(aVar.c(), 1, z4);
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
        if (interceptable == null || interceptable.invokeL(65553, null, builder) == null) {
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

    public static void o(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, b2Var) == null) {
            String v0 = b2Var.v0();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(b2Var.r0() * 1000);
            if (!TextUtils.isEmpty(v0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                v0 = v0 + TbadkCoreApplication.getInst().getString(R.string.send_post) + "   " + TbadkCoreApplication.getInst().getString(R.string.repley_when) + formatTimeForHomeC;
            }
            b2Var.f4(v0);
        }
    }

    public static void p(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).E = true;
            } else if (bVar instanceof l) {
                ((l) bVar).E = true;
            } else if (bVar instanceof j) {
                ((j) bVar).E = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void q(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).B = true;
            } else if (bVar instanceof l) {
                ((l) bVar).B = true;
            } else if (bVar instanceof j) {
                ((j) bVar).B = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void r(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void s(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).C = true;
            } else if (bVar instanceof l) {
                ((l) bVar).C = true;
            } else if (bVar instanceof j) {
                ((j) bVar).C = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void t(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).r = true;
            } else if (bVar instanceof l) {
                ((l) bVar).r = true;
            } else if (bVar instanceof j) {
                ((j) bVar).r = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void u(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, bVar) == null) {
            ((k) bVar).t = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void v(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, bVar) == null) {
            ((k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, bVar) == null) {
            ((k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, bVar) == null) {
            ((k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, bVar) == null) {
            ((l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, bVar) == null) {
            bVar.y = true;
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }
}

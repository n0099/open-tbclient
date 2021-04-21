package d.b.j0.a1.g.k;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.r.q.a2;
import d.b.j0.d3.z;
import d.b.j0.s2.v;
import d.b.j0.x.e0.j;
import d.b.j0.x.e0.k;
import d.b.j0.x.e0.l;
import d.b.j0.x.e0.p;
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
/* loaded from: classes4.dex */
public class d {
    public static void A(d.b.j0.x.e0.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).A = true;
        } else if (bVar instanceof l) {
            ((l) bVar).A = true;
        } else if (bVar instanceof j) {
            ((j) bVar).A = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }

    public static void B(d.b.j0.x.e0.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).z = true;
        } else if (bVar instanceof l) {
            ((l) bVar).z = true;
        } else if (bVar instanceof j) {
            ((j) bVar).z = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }

    public static void C(BannerList.Builder builder) {
        if (builder == null || ListUtils.isEmpty(builder.app)) {
            return;
        }
        for (int i = 0; i < builder.app.size(); i++) {
            App app = builder.app.get(i);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                builder2.pos = Integer.valueOf(d.b.c.e.m.b.d(app.pos_name, 0));
                App build = builder2.build(false);
                builder.app.remove(i);
                builder.app.add(i, build);
            }
        }
    }

    public static void a(List<App> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        int size = list.size() - 1;
        while (true) {
            int i = size - 1;
            if (i <= 0) {
                return;
            }
            int f2 = f(list.get(size));
            int f3 = f(list.get(i));
            if (f2 <= 0 || f2 - f3 < 3) {
                ListUtils.remove(list, size);
            }
            size--;
        }
    }

    public static void b(int i, List<App> list) {
        if (list != null) {
            int i2 = 0;
            Iterator<App> it = list.iterator();
            while (it.hasNext()) {
                App next = it.next();
                if (next != null) {
                    int d2 = d.b.c.e.m.b.d(next.pos_name, -1);
                    if (d2 <= 0) {
                        it.remove();
                        d.b.j0.s2.f0.d.g(l(next), 1, 23);
                    } else {
                        int i3 = i + i2 + 1;
                        if (d2 <= i3) {
                            i2++;
                        } else {
                            it.remove();
                            d.b.j0.s2.f0.d.h(l(next), 1, 2, d2, i3);
                        }
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    public static void c(DataRes.Builder builder) {
        if (builder == null) {
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
        List<App> list;
        AdvertAppInfo advertAppInfo;
        d.b.j0.a1.g.j.d dVar = null;
        if (builder == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        List<Resource> list2 = builder.resource_list;
        if (list2 != null) {
            for (Resource resource : list2) {
                d.b.j0.a1.g.j.c cVar = new d.b.j0.a1.g.j.c();
                cVar.g(resource);
                linkedList.add(cVar);
            }
        }
        List<CardForum> list3 = builder.card_forum;
        if (list3 != null) {
            for (CardForum cardForum : list3) {
                if (cardForum != null && d.b.j0.a1.g.j.b.t(cardForum.card_type.intValue()) && dVar == null) {
                    dVar = new d.b.j0.a1.g.j.d();
                    dVar.v(cardForum);
                    if (dVar.u()) {
                        linkedList.add(dVar);
                    }
                }
            }
        }
        List<AppData> o = v.p().o();
        if (o != null) {
            o.clear();
        }
        BannerList bannerList = builder.banner_list;
        if (bannerList != null && (list = bannerList.app) != null) {
            for (App app : list) {
                d.b.j0.a1.g.j.a aVar = new d.b.j0.a1.g.j.a();
                aVar.j(app);
                if (o != null && (advertAppInfo = aVar.f64197e) != null) {
                    advertAppInfo.T1 = true;
                    o.add(advertAppInfo.e4);
                }
                AdvertAppInfo g2 = aVar.g();
                if (g2 == null) {
                    d.b.j0.s2.f0.d.g(aVar.g(), 1, 100);
                } else {
                    int E4 = g2.E4();
                    if (E4 != 0) {
                        d.b.j0.s2.f0.d.g(aVar.g(), 1, E4);
                        if (E4 != 28 && E4 != 31) {
                            AdvertAppInfo.a aVar2 = g2.U3;
                            if (aVar2 != null) {
                                aVar2.f12879h = -1001;
                            }
                        }
                    }
                    if (aVar.getPosition() <= 0) {
                        d.b.j0.s2.f0.d.g(aVar.g(), 1, 23);
                        AdvertAppInfo.a aVar3 = g2.U3;
                        if (aVar3 != null) {
                            aVar3.f12879h = -1001;
                        }
                    }
                    if (g2.B4()) {
                        try {
                            if (TextUtils.isEmpty(g2.J3)) {
                                d.b.j0.s2.f0.d.g(aVar.g(), 1, 26);
                            } else if (z.b(TbadkCoreApplication.getInst().getContext(), g2.J3) && d.b.j0.a.e().u()) {
                                d.b.j0.s2.f0.d.g(aVar.g(), 1, 3);
                            }
                        } catch (Exception unused) {
                            d.b.j0.s2.f0.d.g(aVar.g(), 1, 100);
                        }
                    }
                    linkedList.add(aVar);
                }
            }
        }
        return linkedList;
    }

    public static d.b.j0.x.e0.b e(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        if (a2Var.s1) {
            k kVar = new k();
            kVar.f64193e = a2Var;
            return kVar;
        } else if (j.i0(a2Var)) {
            return new j(a2Var);
        } else {
            if (!k.i0(a2Var) && !k.j0(a2Var)) {
                if (l.d0(a2Var)) {
                    return new l(a2Var);
                }
                return null;
            }
            k kVar2 = new k();
            a2Var.f2();
            a2Var.s2();
            if (!a2Var.f2() && !a2Var.s2()) {
                a2Var.a2();
            }
            kVar2.f64193e = a2Var;
            return kVar2;
        }
    }

    public static int f(App app) {
        if (app == null) {
            return 0;
        }
        return d.b.c.e.m.b.d(app.pos_name, -1);
    }

    public static k g(a2 a2Var) {
        k kVar = new k();
        kVar.f64193e = a2Var;
        a2Var.f2();
        if (!a2Var.f2()) {
            a2Var.a2();
        }
        return kVar;
    }

    public static void h(BannerList.Builder builder, int i) {
        if (builder == null || builder.app == null) {
            return;
        }
        for (int i2 = 0; i2 < builder.app.size(); i2++) {
            App app = builder.app.get(i2);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                builder2.pos_name = String.valueOf(d.b.c.e.m.b.d(app.pos_name, 0) + i);
                App build = builder2.build(false);
                builder.app.remove(i2);
                builder.app.add(i2, build);
            }
        }
    }

    public static BannerList i(boolean z, BannerList bannerList, BannerList bannerList2, int i, int i2, int i3, int i4) {
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
                C(builder2);
            }
            List<App> list = builder2.app;
            if (list != null) {
                Iterator<App> it = list.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int d2 = d.b.c.e.m.b.d(next.pos_name, -1);
                        if (d2 <= 0) {
                            it.remove();
                            d.b.j0.s2.f0.d.g(l(next), 1, 23);
                        } else {
                            int i7 = i4 + i6 + 1;
                            if (d2 <= i7) {
                                i6++;
                            } else {
                                it.remove();
                                d.b.j0.s2.f0.d.h(l(next), 1, 2, d2, i7);
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

    public static BannerList j(boolean z, BannerList bannerList, BannerList bannerList2, int i) {
        int i2;
        if (i <= 0) {
            return bannerList;
        }
        BannerList.Builder builder = new BannerList.Builder(bannerList);
        if (builder.app == null) {
            builder.app = new LinkedList();
        }
        BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
        if (z) {
            C(builder2);
        }
        List<App> list = builder2.app;
        if (list != null) {
            Iterator<App> it = list.iterator();
            i2 = 0;
            while (it.hasNext()) {
                App next = it.next();
                if (next != null) {
                    int d2 = d.b.c.e.m.b.d(next.pos_name, -1);
                    if (d2 <= 0) {
                        it.remove();
                        d.b.j0.s2.f0.d.g(l(next), 1, 23);
                    } else {
                        int i3 = i + i2 + 1;
                        if (d2 <= i3) {
                            i2++;
                        } else {
                            it.remove();
                            d.b.j0.s2.f0.d.h(l(next), 1, 2, d2, i3);
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

    public static void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2, int i3, int i4) {
        List<TagStruct> list;
        List<Resource> list2;
        List<CardTopic> list3;
        List<CardForum> list4;
        if (builder2 == null || builder == null) {
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
                d.b.i0.r.d0.b.j().t("has_requested_new_user_guide", true);
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
        d.b.j0.a1.g.j.a aVar = new d.b.j0.a1.g.j.a();
        aVar.j(app);
        return aVar.g();
    }

    public static void m(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List<App> list;
        if (builder == null) {
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
            d.b.j0.a1.g.j.a aVar = new d.b.j0.a1.g.j.a();
            aVar.j(app);
            int d2 = app != null ? d.b.c.e.m.b.d(app.pos_name, -1) : -1;
            if (d2 < 0) {
                d.b.j0.s2.f0.d.g(aVar.g(), 1, 33);
                builder2.app.remove(size);
            } else {
                int i = count + size;
                if (d2 > i) {
                    d.b.j0.s2.f0.d.h(aVar.d(), 1, 2, d2, i);
                    builder2.app.remove(size);
                } else {
                    AdvertAppInfo g2 = aVar.g();
                    if (g2 == null) {
                        d.b.j0.s2.f0.d.g(aVar.g(), 1, 100);
                        builder2.app.remove(size);
                    } else {
                        int E4 = g2.E4();
                        if (E4 != 0) {
                            d.b.j0.s2.f0.d.g(aVar.g(), 1, E4);
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

    public static void o(a2 a2Var) {
        String F0 = a2Var.F0();
        String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(a2Var.B0() * 1000);
        if (!TextUtils.isEmpty(F0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
            F0 = F0 + "   " + TbadkCoreApplication.getInst().getString(R.string.repley_when) + formatTimeForHomeC;
        }
        a2Var.k4(F0);
    }

    public static void p(d.b.j0.x.e0.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).D = true;
        } else if (bVar instanceof l) {
            ((l) bVar).D = true;
        } else if (bVar instanceof j) {
            ((j) bVar).D = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
    }

    public static void q(d.b.j0.x.e0.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).B = true;
        } else if (bVar instanceof l) {
            ((l) bVar).B = true;
        } else if (bVar instanceof j) {
            ((j) bVar).B = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }

    public static void r(d.b.j0.x.e0.b bVar) {
        bVar.s = true;
        bVar.setSupportType(BaseCardInfo.SupportType.TOP);
    }

    public static void s(d.b.j0.x.e0.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).C = true;
        } else if (bVar instanceof l) {
            ((l) bVar).C = true;
        } else if (bVar instanceof j) {
            ((j) bVar).C = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }

    public static void t(d.b.j0.x.e0.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).r = true;
        } else if (bVar instanceof l) {
            ((l) bVar).r = true;
        } else if (bVar instanceof j) {
            ((j) bVar).r = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.TOP);
    }

    public static void u(d.b.j0.x.e0.b bVar) {
        ((k) bVar).t = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public static void v(d.b.j0.x.e0.b bVar) {
        ((k) bVar).v = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public static void w(d.b.j0.x.e0.b bVar) {
        ((k) bVar).u = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public static void x(d.b.j0.x.e0.b bVar) {
        ((k) bVar).w = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public static void y(d.b.j0.x.e0.b bVar) {
        ((l) bVar).x = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public static void z(d.b.j0.x.e0.b bVar) {
        bVar.y = true;
        bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }
}

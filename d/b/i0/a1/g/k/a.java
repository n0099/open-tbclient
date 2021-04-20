package d.b.i0.a1.g.k;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.h0.a.q;
import d.b.h0.b1.m.f;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.m0;
import d.b.h0.r.q.n0;
import d.b.i0.a1.g.j.g;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import d.b.i0.x.e0.p;
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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public int f52827f;

    /* renamed from: g  reason: collision with root package name */
    public int f52828g;

    /* renamed from: c  reason: collision with root package name */
    public int f52824c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.a1.g.l.c f52825d = new d.b.i0.a1.g.l.c();

    /* renamed from: e  reason: collision with root package name */
    public int f52826e = 0;
    public Long j = 0L;

    /* renamed from: a  reason: collision with root package name */
    public final c f52822a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final int f52823b = d.b.h0.r.d0.b.j().k("home_page_max_thread_count", 300);

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ThreadInfo> f52829h = new ArrayList<>();
    public ArrayList<App> i = new ArrayList<>();
    public List<n> k = new ArrayList();

    /* renamed from: d.b.i0.a1.g.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1155a implements Comparator<p> {
        public C1155a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(p pVar, p pVar2) {
            if (pVar != null && pVar2 != null) {
                if (pVar.getPosition() > pVar2.getPosition()) {
                    return 1;
                }
                if (pVar.getPosition() < pVar2.getPosition()) {
                    return -1;
                }
            }
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f {
        public final /* synthetic */ d.b.i0.x.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i, String str, d.b.i0.x.e0.b bVar) {
            super(i, str);
            this.l = bVar;
        }

        @Override // d.b.h0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            StatisticItem statisticItem = null;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
            d.b.i0.x.e0.b bVar = this.l;
            if (bVar instanceof k) {
                statisticItem = ((k) bVar).e0();
            } else if (bVar instanceof l) {
                statisticItem = ((l) bVar).c0(null);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final d.b.i0.a1.g.j.f a() {
        c cVar = this.f52822a;
        if (cVar != null && !ListUtils.isEmpty(cVar.f52830a)) {
            for (n nVar : this.f52822a.f52830a) {
                if (nVar instanceof d.b.i0.a1.g.j.f) {
                    return (d.b.i0.a1.g.j.f) nVar;
                }
            }
        }
        return null;
    }

    public final g b() {
        c cVar = this.f52822a;
        if (cVar != null && !ListUtils.isEmpty(cVar.f52830a)) {
            for (n nVar : this.f52822a.f52830a) {
                if (nVar instanceof g) {
                    return (g) nVar;
                }
            }
        }
        return null;
    }

    public c c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i == 0 || i == 1) {
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            d.c(builder);
            d.c(builder2);
            n(z, builder, builder2, i);
            List<ThreadInfo> o = o(builder, i, this.f52823b);
            d.n(builder);
            List<p> d2 = d.d(builder);
            p(d2);
            List<n> f2 = f(builder.thread_list, d2, builder2.user_follow_live, i, 0, builder2);
            List<n> f3 = f(o, new ArrayList(), builder2.user_follow_live, i, 1, null);
            this.f52825d.a(f2);
            d.b.i0.a1.g.k.b.c(builder, f2);
            c cVar = this.f52822a;
            cVar.f52830a = f2;
            cVar.f52832c = f3 == null ? 0 : f3.size();
            return this.f52822a;
        }
        return null;
    }

    public List<ThreadInfo> d() {
        return this.f52829h;
    }

    public int e() {
        return this.f52823b;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<n> f(List<ThreadInfo> list, List<p> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        d.b.i0.a1.g.j.f a2;
        g gVar;
        boolean z;
        d.b.i0.x.e0.b e2;
        k g2;
        k g3;
        k g4;
        k g5;
        if (list == null) {
            return null;
        }
        if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && q.g().o()) {
                this.j = threadInfo.id;
            }
        }
        List<n> arrayList = new ArrayList<>(ListUtils.getCount(list));
        for (ThreadInfo threadInfo2 : list) {
            a2 a2Var = new a2();
            d.b.h0.b.f.a.e(a2Var);
            a2Var.T1 = true;
            a2Var.R2(threadInfo2);
            arrayList.add(a2Var);
        }
        if (builder != null && d.b.i0.a1.b.f.c.D(builder.hot_recomforum, -1)) {
            d.b.i0.a1.b.f.c cVar = new d.b.i0.a1.b.f.c();
            cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
            if (cVar.B(builder.hot_recomforum.tab_list)) {
                g(cVar, cVar.floorPosition, arrayList);
            }
        }
        if (i2 == 0 && d.b.h0.b.d.C()) {
            int c2 = d.b.h0.s.c.e.c();
            int b2 = d.b.h0.s.c.e.b();
            if (i == 0) {
                b2 = d.b.h0.s.c.e.a();
                this.k.clear();
            }
            h(b2, c2, arrayList);
        }
        LinkedList<n> linkedList = new LinkedList();
        int i3 = 0;
        for (n nVar : arrayList) {
            boolean z2 = nVar instanceof a2;
            if (z2 && ((a2) nVar).Z1()) {
                linkedList.add(nVar);
            } else if (z2) {
                a2 a2Var2 = (a2) nVar;
                if (!TextUtils.isEmpty(a2Var2.E0())) {
                    n0 n0Var = new n0();
                    n0Var.n(a2Var2.E0());
                    n0Var.position = i3;
                    linkedList.add(n0Var);
                } else if (d.b.i0.a1.j.b.c.a.Z(a2Var2)) {
                    if (!StringUtils.isNull(a2Var2.B1().topic_name)) {
                        d.b.i0.a1.j.b.c.a aVar = new d.b.i0.a1.j.b.c.a();
                        aVar.b0(a2Var2.B1());
                        aVar.a0 = 1;
                        aVar.position = i3;
                        aVar.c0(a2Var2);
                        aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        linkedList.add(aVar);
                    }
                } else if (!k.i0(a2Var2) && !l.d0(a2Var2)) {
                    if (d.b.i0.x.e0.e.i0(a2Var2) && a2Var2.O1()) {
                        d.b.i0.x.e0.e eVar = new d.b.i0.x.e0.e(a2Var2);
                        eVar.position = i3;
                        linkedList.add(eVar);
                    } else {
                        d.b.i0.x.e0.b e3 = d.e(a2Var2);
                        if (e3 != null) {
                            e3.l = a2Var2.w1();
                            e3.position = i3;
                        }
                        if (e3 != null && e3.isValid()) {
                            linkedList.add(e3);
                        }
                    }
                } else {
                    k g6 = d.g(a2Var2);
                    if (g6 != null) {
                        if (a2Var2.u()) {
                            if (g6.isValid()) {
                                g6.l = a2Var2.w1();
                                g6.position = i3;
                                d.t(g6);
                                linkedList.add(g6);
                            }
                        } else {
                            a2 a2Var3 = g6.f63772e;
                            if (a2Var3 != null && a2Var3.h0() != null && !StringUtils.isNull(a2Var3.h0().f51324b)) {
                                g6.l = a2Var2.w1();
                                g6.position = i3;
                                d.r(g6);
                                linkedList.add(g6);
                                z = true;
                                int[] p0 = a2Var2.p0();
                                e2 = d.e(a2Var2);
                                if (e2 != null) {
                                    e2.l = a2Var2.w1();
                                    e2.position = i3;
                                    if (e2 instanceof k) {
                                        if (a2Var2.P1()) {
                                            d.u(e2);
                                        } else if (a2Var2.W2() == 1) {
                                            d.w(e2);
                                            e2.o = p0[0];
                                            e2.p = p0[1];
                                        } else if (a2Var2.W2() >= 2) {
                                            d.v(e2);
                                        } else {
                                            d.x(e2);
                                        }
                                    } else if (e2 instanceof l) {
                                        d.y(e2);
                                    }
                                }
                                if (e2 != null && e2.isValid()) {
                                    e2.f63772e.J1();
                                    if (!a2Var2.y2() && a2Var2.T() != null && z) {
                                        String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), a2Var2.T().getName_show());
                                        SpannableString spannableString = new SpannableString(format);
                                        spannableString.setSpan(new b(this, 16, a2Var2.T().getUserId(), e2), 0, format.length() - 1, 33);
                                        e2.f63772e.K1(spannableString);
                                    }
                                    linkedList.add(e2);
                                }
                                if (a2Var2.y0() != null && (g5 = d.g(a2Var2)) != null) {
                                    g5.l = a2Var2.w1();
                                    g5.position = i3;
                                    d.z(g5);
                                    if (!k.i0(a2Var2)) {
                                        g5.X("1");
                                    } else if (l.d0(a2Var2)) {
                                        g5.X("2");
                                    }
                                    linkedList.add(g5);
                                }
                                if ((ListUtils.isEmpty(a2Var2.G0()) || !ListUtils.isEmpty(a2Var2.l0())) && (g2 = d.g(a2Var2)) != null) {
                                    g2.l = a2Var2.w1();
                                    g2.position = i3;
                                    if (ListUtils.getCount(a2Var2.G0()) + ListUtils.getCount(a2Var2.l0()) != 1) {
                                        d.B(g2);
                                    } else {
                                        d.A(g2);
                                    }
                                    linkedList.add(g2);
                                }
                                if (a2Var2.u() && (g4 = d.g(a2Var2)) != null) {
                                    g4.l = a2Var2.w1();
                                    g4.position = i3;
                                    d.q(g4);
                                    if (!k.i0(a2Var2)) {
                                        g4.X("1");
                                    } else if (l.d0(a2Var2)) {
                                        g4.X("2");
                                    }
                                    if (!a2Var2.u() && !StringUtils.isNull(a2Var2.i0())) {
                                        linkedList.add(g4);
                                    } else if (!StringUtils.isNull(a2Var2.i0())) {
                                        linkedList.add(g4);
                                    }
                                }
                                if (a2Var2.z1() != null) {
                                    k g7 = d.g(a2Var2);
                                    if (g7 != null) {
                                        g7.l = a2Var2.w1();
                                        g7.position = i3;
                                        d.s(g7);
                                    }
                                    if (g7 != null && g7.isValid()) {
                                        linkedList.add(g7);
                                    }
                                }
                                g3 = d.g(a2Var2);
                                if (g3 != null) {
                                    g3.l = a2Var2.w1();
                                    g3.position = i3;
                                    d.p(g3);
                                }
                                if (g3 != null && g3.isValid()) {
                                    linkedList.add(g3);
                                }
                            } else if (g6.isValid()) {
                                g6.l = a2Var2.w1();
                                g6.position = i3;
                                d.t(g6);
                                linkedList.add(g6);
                            }
                        }
                    }
                    z = false;
                    int[] p02 = a2Var2.p0();
                    e2 = d.e(a2Var2);
                    if (e2 != null) {
                    }
                    if (e2 != null) {
                        e2.f63772e.J1();
                        if (!a2Var2.y2()) {
                            String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), a2Var2.T().getName_show());
                            SpannableString spannableString2 = new SpannableString(format2);
                            spannableString2.setSpan(new b(this, 16, a2Var2.T().getUserId(), e2), 0, format2.length() - 1, 33);
                            e2.f63772e.K1(spannableString2);
                        }
                        linkedList.add(e2);
                    }
                    if (a2Var2.y0() != null) {
                        g5.l = a2Var2.w1();
                        g5.position = i3;
                        d.z(g5);
                        if (!k.i0(a2Var2)) {
                        }
                        linkedList.add(g5);
                    }
                    if (ListUtils.isEmpty(a2Var2.G0())) {
                    }
                    g2.l = a2Var2.w1();
                    g2.position = i3;
                    if (ListUtils.getCount(a2Var2.G0()) + ListUtils.getCount(a2Var2.l0()) != 1) {
                    }
                    linkedList.add(g2);
                    if (a2Var2.u()) {
                        g4.l = a2Var2.w1();
                        g4.position = i3;
                        d.q(g4);
                        if (!k.i0(a2Var2)) {
                        }
                        if (!a2Var2.u()) {
                        }
                        if (!StringUtils.isNull(a2Var2.i0())) {
                        }
                    }
                    if (a2Var2.z1() != null) {
                    }
                    g3 = d.g(a2Var2);
                    if (g3 != null) {
                    }
                    if (g3 != null) {
                        linkedList.add(g3);
                    }
                }
                long f2 = d.b.c.e.m.b.f(a2Var2.o0(), 0L);
                if (f2 != 0 && f2 == this.j.longValue()) {
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.Z(builder.active_center);
                    } else {
                        gVar = null;
                    }
                    if (gVar == null) {
                        gVar = b();
                    }
                    if (gVar != null) {
                        i3++;
                        gVar.S = i3;
                        linkedList.add(gVar);
                    }
                }
                i3++;
            } else if (nVar instanceof BaseCardInfo) {
                linkedList.add(nVar);
            } else {
                linkedList.add(nVar);
            }
            i3++;
        }
        if (!d.b.h0.b.d.C()) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < ListUtils.getCount(list2); i6++) {
                p pVar = (p) ListUtils.getItem(list2, i6);
                if (pVar != null && i4 < linkedList.size()) {
                    while (i4 < linkedList.size() && (!(linkedList.get(i4) instanceof d.b.i0.x.e0.b) || ((d.b.i0.x.e0.b) linkedList.get(i4)).position + i5 != pVar.getPosition() - 1)) {
                        i4++;
                    }
                    if (linkedList.size() > i4 && i4 > 0) {
                        linkedList.add(i4, pVar);
                        i5++;
                    }
                }
            }
            int i7 = 0;
            int i8 = 0;
            for (n nVar2 : linkedList) {
                if (nVar2 instanceof m0) {
                    ((m0) nVar2).setPosition(i7 + 1);
                    i8++;
                } else if (nVar2 instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) nVar2;
                    i7 = baseCardInfo.position + i8;
                    baseCardInfo.position = i7;
                }
            }
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                d.b.i0.a1.g.j.f fVar = new d.b.i0.a1.g.j.f();
                fVar.B(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
            } else if (i == 1 && (a2 = a()) != null) {
                linkedList.add(0, a2);
                a2.position = -1;
            }
        }
        d.b.h0.b.f.a.d(linkedList);
        return linkedList;
    }

    public void g(d.b.h0.r.q.a aVar, int i, List<n> list) {
        if (aVar == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof a2) {
                if (i == i2) {
                    aVar.floorPosition = i;
                    ListUtils.add(list, i3, aVar);
                    return;
                }
                i2++;
            }
        }
    }

    public final void h(int i, int i2, List<n> list) {
        if (ListUtils.isEmpty(list) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<n> listIterator = list.listIterator();
        int i3 = 0;
        int i4 = 0;
        while (listIterator.hasNext()) {
            if (i3 == i || (i3 > i && (i3 - i) % i2 == 0)) {
                if (i4 < this.k.size()) {
                    listIterator.add(this.k.get(i4));
                } else {
                    a2 a2Var = new a2();
                    d.b.i0.d3.h0.n nVar = new d.b.i0.d3.h0.n();
                    nVar.k(true);
                    a2Var.C2 = nVar;
                    listIterator.add(a2Var);
                    this.k.add(a2Var);
                }
                i4++;
            }
            listIterator.next();
            i3++;
        }
    }

    public boolean i() {
        ArrayList<ThreadInfo> arrayList = this.f52829h;
        return (arrayList == null || ListUtils.isEmpty(arrayList)) ? false : true;
    }

    public final boolean j() {
        return this.f52826e > 0;
    }

    public final void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.k(z, builder, builder2, i, this.f52824c, this.f52827f, this.f52828g);
    }

    public final void l(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        if (builder == null || builder2 == null || (list = builder.thread_list) == null || (list2 = builder2.thread_list) == null) {
            return;
        }
        this.f52827f = ListUtils.getCount(list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null) {
            this.f52828g = ListUtils.getCount(bannerList.app);
        } else {
            this.f52828g = 0;
        }
        int count = ListUtils.getCount(list) + ListUtils.getCount(this.f52829h);
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
        Iterator<ThreadInfo> it = this.f52829h.iterator();
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
                this.f52825d.b((ThreadInfo) ListUtils.getItem(list2, 0));
            }
            for (ThreadInfo threadInfo2 : list2) {
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                        list.add(threadInfo2);
                    }
                } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                    list.add(threadInfo2);
                    JSONObject b2 = d.b.i0.s2.f0.b.b(threadInfo2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
        } else {
            this.f52825d.c(z, list);
            if (j()) {
                BannerList bannerList2 = builder.banner_list;
                if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                    this.i.addAll(0, builder.banner_list.app);
                    BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                    builder3.app = new LinkedList();
                    builder.banner_list = builder3.build(false);
                }
                this.f52829h.addAll(0, list);
                list.clear();
                hashSet.clear();
                hashSet2.clear();
                if (ListUtils.getCount(this.f52829h) > this.f52823b) {
                    for (int size = this.f52829h.size() - 1; size >= this.f52823b; size--) {
                        this.f52829h.remove(size);
                    }
                }
                hashSet3.clear();
                hashSet4.clear();
                Iterator<ThreadInfo> it2 = this.f52829h.iterator();
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
                    JSONObject b3 = d.b.i0.s2.f0.b.b(threadInfo3);
                    if (b3 != null) {
                        arrayList.add(0, b3);
                    }
                }
            }
        }
        if (j()) {
            if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    App app = this.i.get(i2);
                    if (app != null) {
                        App.Builder builder4 = new App.Builder(app);
                        builder4.pos_name = String.valueOf(d.b.c.e.m.b.d(app.pos_name, 0) + count3);
                        App build = builder4.build(false);
                        this.i.remove(i2);
                        this.i.add(i2, build);
                    }
                }
            }
            if (ListUtils.getCount(list) >= this.f52826e) {
                list.addAll(this.f52829h);
                this.f52829h.clear();
                BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                if (builder5.app == null) {
                    builder5.app = new LinkedList();
                }
                builder5.app.addAll(this.i);
                builder.banner_list = builder5.build(false);
                this.i.clear();
            }
        }
        int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.f52829h)) - count;
        this.f52822a.f52831b = count4;
        this.f52824c = count4;
        d.b.i0.s2.f0.b.f().h("NEWINDEX", arrayList);
    }

    public final void m(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public final void n(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder == null || builder2 == null) {
            return;
        }
        Integer num = builder2.fresh_ctrl_num;
        int intValue = (num == null || num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
        this.f52826e = intValue;
        int i2 = this.f52823b;
        if (intValue > i2) {
            intValue = i2;
        }
        this.f52826e = intValue;
        l(z, builder, builder2, i);
        k(z, builder, builder2, i);
        m(builder.thread_personalized, builder2.thread_personalized);
    }

    public final List<ThreadInfo> o(DataRes.Builder builder, int i, int i2) {
        List<ThreadInfo> list;
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

    public final void p(List<p> list) {
        if (list == null) {
            return;
        }
        Collections.sort(list, new C1155a(this));
    }
}

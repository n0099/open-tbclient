package d.a.k0.a1.g.k;

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
import d.a.c.j.e.n;
import d.a.j0.a.r;
import d.a.j0.b1.m.f;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.m0;
import d.a.j0.r.q.n0;
import d.a.k0.a1.g.j.g;
import d.a.k0.x.e0.k;
import d.a.k0.x.e0.l;
import d.a.k0.x.e0.p;
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
    public int f51664f;

    /* renamed from: g  reason: collision with root package name */
    public int f51665g;

    /* renamed from: c  reason: collision with root package name */
    public int f51661c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.a1.g.l.c f51662d = new d.a.k0.a1.g.l.c();

    /* renamed from: e  reason: collision with root package name */
    public int f51663e = 0;
    public Long j = 0L;

    /* renamed from: a  reason: collision with root package name */
    public final c f51659a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final int f51660b = d.a.j0.r.d0.b.j().k("home_page_max_thread_count", 300);

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ThreadInfo> f51666h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<App> f51667i = new ArrayList<>();
    public List<n> k = new ArrayList();

    /* renamed from: d.a.k0.a1.g.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1189a implements Comparator<p> {
        public C1189a(a aVar) {
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
        public final /* synthetic */ d.a.k0.x.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2, String str, d.a.k0.x.e0.b bVar) {
            super(i2, str);
            this.l = bVar;
        }

        @Override // d.a.j0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            StatisticItem statisticItem = null;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
            d.a.k0.x.e0.b bVar = this.l;
            if (bVar instanceof k) {
                statisticItem = ((k) bVar).e0();
            } else if (bVar instanceof l) {
                statisticItem = ((l) bVar).c0(null);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final d.a.k0.a1.g.j.f a() {
        c cVar = this.f51659a;
        if (cVar != null && !ListUtils.isEmpty(cVar.f51668a)) {
            for (n nVar : this.f51659a.f51668a) {
                if (nVar instanceof d.a.k0.a1.g.j.f) {
                    return (d.a.k0.a1.g.j.f) nVar;
                }
            }
        }
        return null;
    }

    public final g b() {
        c cVar = this.f51659a;
        if (cVar != null && !ListUtils.isEmpty(cVar.f51668a)) {
            for (n nVar : this.f51659a.f51668a) {
                if (nVar instanceof g) {
                    return (g) nVar;
                }
            }
        }
        return null;
    }

    public c c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        if (i2 == 0 || i2 == 1) {
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            d.c(builder);
            d.c(builder2);
            n(z, builder, builder2, i2);
            List<ThreadInfo> o = o(builder, i2, this.f51660b);
            d.n(builder);
            List<p> d2 = d.d(builder);
            p(d2);
            List<n> f2 = f(builder.thread_list, d2, builder2.user_follow_live, i2, 0, builder2);
            List<n> f3 = f(o, new ArrayList(), builder2.user_follow_live, i2, 1, null);
            this.f51662d.a(f2);
            d.a.k0.a1.g.k.b.c(builder, f2);
            c cVar = this.f51659a;
            cVar.f51668a = f2;
            cVar.f51670c = f3 == null ? 0 : f3.size();
            return this.f51659a;
        }
        return null;
    }

    public List<ThreadInfo> d() {
        return this.f51666h;
    }

    public int e() {
        return this.f51660b;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<n> f(List<ThreadInfo> list, List<p> list2, UserFollowLive userFollowLive, int i2, int i3, DataRes.Builder builder) {
        d.a.k0.a1.g.j.f a2;
        g gVar;
        boolean z;
        d.a.k0.x.e0.b e2;
        k g2;
        k g3;
        k g4;
        k g5;
        if (list == null) {
            return null;
        }
        if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && r.g().o()) {
                this.j = threadInfo.id;
            }
        }
        List<n> arrayList = new ArrayList<>(ListUtils.getCount(list));
        for (ThreadInfo threadInfo2 : list) {
            a2 a2Var = new a2();
            d.a.j0.b.f.a.e(a2Var);
            a2Var.T1 = true;
            a2Var.T2(threadInfo2);
            arrayList.add(a2Var);
        }
        if (builder != null && d.a.k0.a1.b.f.c.D(builder.hot_recomforum, -1)) {
            d.a.k0.a1.b.f.c cVar = new d.a.k0.a1.b.f.c();
            cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
            if (cVar.B(builder.hot_recomforum.tab_list)) {
                g(cVar, cVar.floorPosition, arrayList);
            }
        }
        if (i3 == 0 && d.a.j0.b.d.C()) {
            int c2 = d.a.j0.s.c.e.c();
            int b2 = d.a.j0.s.c.e.b();
            if (i2 == 0) {
                b2 = d.a.j0.s.c.e.a();
                this.k.clear();
            }
            h(b2, c2, arrayList);
        }
        LinkedList<n> linkedList = new LinkedList();
        int i4 = 0;
        for (n nVar : arrayList) {
            boolean z2 = nVar instanceof a2;
            if (z2 && ((a2) nVar).a2()) {
                linkedList.add(nVar);
            } else if (z2) {
                a2 a2Var2 = (a2) nVar;
                if (!TextUtils.isEmpty(a2Var2.E0())) {
                    n0 n0Var = new n0();
                    n0Var.m(a2Var2.E0());
                    n0Var.position = i4;
                    linkedList.add(n0Var);
                } else if (d.a.k0.a1.j.b.c.a.Z(a2Var2)) {
                    if (!StringUtils.isNull(a2Var2.C1().topic_name)) {
                        d.a.k0.a1.j.b.c.a aVar = new d.a.k0.a1.j.b.c.a();
                        aVar.b0(a2Var2.C1());
                        aVar.b0 = 1;
                        aVar.position = i4;
                        aVar.c0(a2Var2);
                        aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        linkedList.add(aVar);
                    }
                } else if (!k.i0(a2Var2) && !l.d0(a2Var2)) {
                    if (d.a.k0.x.e0.e.i0(a2Var2) && a2Var2.P1()) {
                        d.a.k0.x.e0.e eVar = new d.a.k0.x.e0.e(a2Var2);
                        eVar.position = i4;
                        linkedList.add(eVar);
                    } else {
                        d.a.k0.x.e0.b e3 = d.e(a2Var2);
                        if (e3 != null) {
                            e3.l = a2Var2.x1();
                            e3.position = i4;
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
                                g6.l = a2Var2.x1();
                                g6.position = i4;
                                d.t(g6);
                                linkedList.add(g6);
                            }
                        } else {
                            a2 a2Var3 = g6.f63179e;
                            if (a2Var3 != null && a2Var3.h0() != null && !StringUtils.isNull(a2Var3.h0().f50114b)) {
                                g6.l = a2Var2.x1();
                                g6.position = i4;
                                d.r(g6);
                                linkedList.add(g6);
                                z = true;
                                int[] p0 = a2Var2.p0();
                                e2 = d.e(a2Var2);
                                if (e2 != null) {
                                    e2.l = a2Var2.x1();
                                    e2.position = i4;
                                    if (e2 instanceof k) {
                                        if (a2Var2.Q1()) {
                                            d.u(e2);
                                        } else if (a2Var2.Y2() == 1) {
                                            d.w(e2);
                                            e2.o = p0[0];
                                            e2.p = p0[1];
                                        } else if (a2Var2.Y2() >= 2) {
                                            d.v(e2);
                                        } else {
                                            d.x(e2);
                                        }
                                    } else if (e2 instanceof l) {
                                        d.y(e2);
                                    }
                                }
                                if (e2 != null && e2.isValid()) {
                                    e2.f63179e.K1();
                                    if (!a2Var2.A2() && a2Var2.T() != null && z) {
                                        String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), a2Var2.T().getName_show());
                                        SpannableString spannableString = new SpannableString(format);
                                        spannableString.setSpan(new b(this, 16, a2Var2.T().getUserId(), e2), 0, format.length() - 1, 33);
                                        e2.f63179e.L1(spannableString);
                                    }
                                    linkedList.add(e2);
                                }
                                if (a2Var2.y0() != null && (g5 = d.g(a2Var2)) != null) {
                                    g5.l = a2Var2.x1();
                                    g5.position = i4;
                                    d.z(g5);
                                    if (!k.i0(a2Var2)) {
                                        g5.X("1");
                                    } else if (l.d0(a2Var2)) {
                                        g5.X("2");
                                    }
                                    linkedList.add(g5);
                                }
                                if ((ListUtils.isEmpty(a2Var2.G0()) || !ListUtils.isEmpty(a2Var2.l0())) && (g2 = d.g(a2Var2)) != null) {
                                    g2.l = a2Var2.x1();
                                    g2.position = i4;
                                    if (ListUtils.getCount(a2Var2.G0()) + ListUtils.getCount(a2Var2.l0()) != 1) {
                                        d.C(g2);
                                    } else {
                                        d.A(g2);
                                    }
                                    linkedList.add(g2);
                                }
                                if (!ListUtils.isEmpty(a2Var2.s1())) {
                                    k g7 = d.g(a2Var2);
                                    g7.l = a2Var2.x1();
                                    g7.position = i4;
                                    d.B(g7);
                                    if (g7.isValid()) {
                                        linkedList.add(g7);
                                    }
                                }
                                if (a2Var2.u() && (g4 = d.g(a2Var2)) != null) {
                                    g4.l = a2Var2.x1();
                                    g4.position = i4;
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
                                if (a2Var2.A1() != null) {
                                    k g8 = d.g(a2Var2);
                                    if (g8 != null) {
                                        g8.l = a2Var2.x1();
                                        g8.position = i4;
                                        d.s(g8);
                                    }
                                    if (g8 != null && g8.isValid()) {
                                        linkedList.add(g8);
                                    }
                                }
                                g3 = d.g(a2Var2);
                                if (g3 != null) {
                                    g3.l = a2Var2.x1();
                                    g3.position = i4;
                                    d.p(g3);
                                }
                                if (g3 != null && g3.isValid()) {
                                    linkedList.add(g3);
                                }
                            } else if (g6.isValid()) {
                                g6.l = a2Var2.x1();
                                g6.position = i4;
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
                        e2.f63179e.K1();
                        if (!a2Var2.A2()) {
                            String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), a2Var2.T().getName_show());
                            SpannableString spannableString2 = new SpannableString(format2);
                            spannableString2.setSpan(new b(this, 16, a2Var2.T().getUserId(), e2), 0, format2.length() - 1, 33);
                            e2.f63179e.L1(spannableString2);
                        }
                        linkedList.add(e2);
                    }
                    if (a2Var2.y0() != null) {
                        g5.l = a2Var2.x1();
                        g5.position = i4;
                        d.z(g5);
                        if (!k.i0(a2Var2)) {
                        }
                        linkedList.add(g5);
                    }
                    if (ListUtils.isEmpty(a2Var2.G0())) {
                    }
                    g2.l = a2Var2.x1();
                    g2.position = i4;
                    if (ListUtils.getCount(a2Var2.G0()) + ListUtils.getCount(a2Var2.l0()) != 1) {
                    }
                    linkedList.add(g2);
                    if (!ListUtils.isEmpty(a2Var2.s1())) {
                    }
                    if (a2Var2.u()) {
                        g4.l = a2Var2.x1();
                        g4.position = i4;
                        d.q(g4);
                        if (!k.i0(a2Var2)) {
                        }
                        if (!a2Var2.u()) {
                        }
                        if (!StringUtils.isNull(a2Var2.i0())) {
                        }
                    }
                    if (a2Var2.A1() != null) {
                    }
                    g3 = d.g(a2Var2);
                    if (g3 != null) {
                    }
                    if (g3 != null) {
                        linkedList.add(g3);
                    }
                }
                long f2 = d.a.c.e.m.b.f(a2Var2.o0(), 0L);
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
                        i4++;
                        gVar.T = i4;
                        linkedList.add(gVar);
                    }
                }
                i4++;
            } else if (nVar instanceof BaseCardInfo) {
                linkedList.add(nVar);
            } else {
                linkedList.add(nVar);
            }
            i4++;
        }
        if (!d.a.j0.b.d.C()) {
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < ListUtils.getCount(list2); i7++) {
                p pVar = (p) ListUtils.getItem(list2, i7);
                if (pVar != null && i5 < linkedList.size()) {
                    while (i5 < linkedList.size() && (!(linkedList.get(i5) instanceof d.a.k0.x.e0.b) || ((d.a.k0.x.e0.b) linkedList.get(i5)).position + i6 != pVar.getPosition() - 1)) {
                        i5++;
                    }
                    if (linkedList.size() > i5 && i5 > 0) {
                        linkedList.add(i5, pVar);
                        i6++;
                    }
                }
            }
            int i8 = 0;
            int i9 = 0;
            for (n nVar2 : linkedList) {
                if (nVar2 instanceof m0) {
                    ((m0) nVar2).setPosition(i8 + 1);
                    i9++;
                } else if (nVar2 instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) nVar2;
                    i8 = baseCardInfo.position + i9;
                    baseCardInfo.position = i8;
                }
            }
        }
        if (i3 == 0) {
            if (i2 == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                d.a.k0.a1.g.j.f fVar = new d.a.k0.a1.g.j.f();
                fVar.B(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
            } else if (i2 == 1 && (a2 = a()) != null) {
                linkedList.add(0, a2);
                a2.position = -1;
            }
        }
        d.a.j0.b.f.a.d(linkedList);
        return linkedList;
    }

    public void g(d.a.j0.r.q.a aVar, int i2, List<n> list) {
        if (aVar == null || list == null || i2 <= 0) {
            return;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (list.get(i4) instanceof a2) {
                if (i2 == i3) {
                    aVar.floorPosition = i2;
                    ListUtils.add(list, i4, aVar);
                    return;
                }
                i3++;
            }
        }
    }

    public final void h(int i2, int i3, List<n> list) {
        if (ListUtils.isEmpty(list) || i2 < 0 || i3 < 1) {
            return;
        }
        ListIterator<n> listIterator = list.listIterator();
        int i4 = 0;
        int i5 = 0;
        while (listIterator.hasNext()) {
            if (i4 == i2 || (i4 > i2 && (i4 - i2) % i3 == 0)) {
                if (i5 < this.k.size()) {
                    listIterator.add(this.k.get(i5));
                } else {
                    a2 a2Var = new a2();
                    d.a.k0.d3.h0.n nVar = new d.a.k0.d3.h0.n();
                    nVar.k(true);
                    a2Var.C2 = nVar;
                    listIterator.add(a2Var);
                    this.k.add(a2Var);
                }
                i5++;
            }
            listIterator.next();
            i4++;
        }
    }

    public boolean i() {
        ArrayList<ThreadInfo> arrayList = this.f51666h;
        return (arrayList == null || ListUtils.isEmpty(arrayList)) ? false : true;
    }

    public final boolean j() {
        return this.f51663e > 0;
    }

    public final void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        d.k(z, builder, builder2, i2, this.f51661c, this.f51664f, this.f51665g);
    }

    public final void l(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
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
        this.f51664f = ListUtils.getCount(list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null) {
            this.f51665g = ListUtils.getCount(bannerList.app);
        } else {
            this.f51665g = 0;
        }
        int count = ListUtils.getCount(list) + ListUtils.getCount(this.f51666h);
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
        Iterator<ThreadInfo> it = this.f51666h.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                hashSet4.add(next.lego_card);
            } else if (next != null && (l4 = next.tid) != null) {
                hashSet3.add(l4);
            }
        }
        if (i2 == 1) {
            if (!ListUtils.isEmpty(list2)) {
                this.f51662d.b((ThreadInfo) ListUtils.getItem(list2, 0));
            }
            for (ThreadInfo threadInfo2 : list2) {
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                        list.add(threadInfo2);
                    }
                } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                    list.add(threadInfo2);
                    JSONObject b2 = d.a.k0.s2.i0.b.b(threadInfo2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
        } else {
            this.f51662d.c(z, list);
            if (j()) {
                BannerList bannerList2 = builder.banner_list;
                if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                    this.f51667i.addAll(0, builder.banner_list.app);
                    BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                    builder3.app = new LinkedList();
                    builder.banner_list = builder3.build(false);
                }
                this.f51666h.addAll(0, list);
                list.clear();
                hashSet.clear();
                hashSet2.clear();
                if (ListUtils.getCount(this.f51666h) > this.f51660b) {
                    for (int size = this.f51666h.size() - 1; size >= this.f51660b; size--) {
                        this.f51666h.remove(size);
                    }
                }
                hashSet3.clear();
                hashSet4.clear();
                Iterator<ThreadInfo> it2 = this.f51666h.iterator();
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
                    JSONObject b3 = d.a.k0.s2.i0.b.b(threadInfo3);
                    if (b3 != null) {
                        arrayList.add(0, b3);
                    }
                }
            }
        }
        if (j()) {
            if (!ListUtils.isEmpty(this.f51667i) && builder2.banner_list != null) {
                int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                for (int i3 = 0; i3 < this.f51667i.size(); i3++) {
                    App app = this.f51667i.get(i3);
                    if (app != null) {
                        App.Builder builder4 = new App.Builder(app);
                        d.a.k0.s2.c.c(builder4, count3);
                        App build = builder4.build(false);
                        this.f51667i.remove(i3);
                        this.f51667i.add(i3, build);
                    }
                }
            }
            if (ListUtils.getCount(list) >= this.f51663e) {
                list.addAll(this.f51666h);
                this.f51666h.clear();
                BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                if (builder5.app == null) {
                    builder5.app = new LinkedList();
                }
                builder5.app.addAll(this.f51667i);
                builder.banner_list = builder5.build(false);
                this.f51667i.clear();
            }
        }
        int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.f51666h)) - count;
        this.f51659a.f51669b = count4;
        this.f51661c = count4;
        d.a.k0.s2.i0.b.f().h("NEWINDEX", arrayList);
    }

    public final void m(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public final void n(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        if (builder == null || builder2 == null) {
            return;
        }
        Integer num = builder2.fresh_ctrl_num;
        int intValue = (num == null || num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
        this.f51663e = intValue;
        int i3 = this.f51660b;
        if (intValue > i3) {
            intValue = i3;
        }
        this.f51663e = intValue;
        l(z, builder, builder2, i2);
        k(z, builder, builder2, i2);
        m(builder.thread_personalized, builder2.thread_personalized);
    }

    public final List<ThreadInfo> o(DataRes.Builder builder, int i2, int i3) {
        List<ThreadInfo> list;
        ArrayList arrayList = new ArrayList();
        if (builder != null && (list = builder.thread_list) != null) {
            if (i2 == 1) {
                for (int count = ((ListUtils.getCount(list) - i3) + 30) - 1; count >= 30; count--) {
                    if (list.size() > count) {
                        arrayList.add(list.remove(count));
                    }
                }
            } else {
                for (int count2 = ListUtils.getCount(list) - 1; count2 >= i3; count2--) {
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
        Collections.sort(list, new C1189a(this));
    }
}

package d.a.n0.b1.b.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.b1.b.d;
import d.a.n0.b1.g.k.c;
import d.a.n0.z.e0.e;
import d.a.n0.z.e0.j;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c f51402a = new c();

    public static void a(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public c b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        if (i2 == 0 || i2 == 1) {
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            a(builder);
            a(builder2);
            d(z, builder, builder2, i2);
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (ConcernData concernData : builder.thread_info) {
                if (concernData != null) {
                    if (d.a.n0.b1.b.f.c.D(builder.hot_recomforum, i3)) {
                        d.a.n0.b1.b.f.c cVar = new d.a.n0.b1.b.f.c();
                        if (cVar.B(builder.hot_recomforum.tab_list)) {
                            cVar.position = i3;
                            linkedList.add(cVar);
                            i3++;
                        }
                    }
                    if (d.a.n0.b1.b.f.a.C(concernData)) {
                        d.a.n0.b1.b.f.a aVar = new d.a.n0.b1.b.f.a();
                        if (concernData.recom_user_list.size() >= 4) {
                            aVar.A(concernData.recom_user_list);
                            aVar.position = i3;
                            aVar.D(builder.thread_info.size() > 1);
                            linkedList.add(aVar);
                        }
                    } else {
                        a2 a2Var = new a2();
                        a2Var.C3(true);
                        d.a.m0.b.f.a.e(a2Var);
                        a2Var.U2(concernData.thread_list);
                        JSONObject b2 = d.a.n0.t2.i0.b.b(concernData.thread_list);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                        linkedList.addAll(e(a2Var, i3, concernData));
                    }
                    i3++;
                }
            }
            d.a.m0.b.f.a.d(linkedList);
            d.a.n0.t2.i0.b.f().h("CONCERN", arrayList);
            c cVar2 = this.f51402a;
            cVar2.f51835a = linkedList;
            return cVar2;
        }
        return null;
    }

    public final void c(boolean z, List<ConcernData> list, List<ConcernData> list2, int i2) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        if (list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i2 == 1) {
            for (ConcernData concernData : list2) {
                if (d.a.n0.b1.b.f.a.C(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!d.J()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && d.a.n0.b1.b.f.a.C(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.f51402a.f51836b = ListUtils.getCount(list) - count;
    }

    public final void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        List<ConcernData> list;
        List<ConcernData> list2 = builder.thread_info;
        if (list2 == null || (list = builder2.thread_info) == null) {
            return;
        }
        c(z, list2, list, i2);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<n> e(a2 a2Var, int i2, ConcernData concernData) {
        d.a.n0.z.e0.b kVar;
        ThreadInfo threadInfo;
        ArrayList arrayList = new ArrayList();
        if ((k.i0(a2Var) || l.d0(a2Var)) && a2Var.getType() != a2.l3) {
            if (l.d0(a2Var)) {
                kVar = new l(a2Var);
            } else {
                kVar = new k();
                a2Var.h2();
                a2Var.v2();
                if (!a2Var.h2() && !a2Var.v2()) {
                    a2Var.c2();
                }
                kVar.f63459e = a2Var;
            }
            kVar.l = a2Var.y1();
            if (k.i0(a2Var)) {
                kVar.X("1");
            } else if (l.d0(a2Var)) {
                kVar.X("2");
            }
            kVar.F = true;
            if (d.a.m0.b.d.h() && kVar.m() != null && kVar.m().T() != null) {
                if (!kVar.m().T().hadConcerned() && !ThreadCardUtils.isSelf(a2Var)) {
                    d.a.n0.b1.g.k.d.r(kVar);
                    d.a.n0.b1.g.k.d.o(a2Var);
                } else {
                    d.a.n0.b1.g.k.d.t(kVar);
                }
            } else {
                d.a.n0.b1.g.k.d.t(kVar);
            }
            kVar.f63459e.L1();
            if (kVar instanceof k) {
                if (a2Var.R1()) {
                    d.a.n0.b1.g.k.d.u(kVar);
                } else if (a2Var.Z2() == 1) {
                    d.a.n0.b1.g.k.d.w(kVar);
                    int[] p0 = a2Var.p0();
                    kVar.o = p0[0];
                    kVar.p = p0[1];
                } else if (a2Var.Z2() >= 2) {
                    d.a.n0.b1.g.k.d.v(kVar);
                } else {
                    d.a.n0.b1.g.k.d.x(kVar);
                }
            } else if (kVar instanceof l) {
                d.a.n0.b1.g.k.d.y(kVar);
            }
            if (a2Var.z0() != null) {
                d.a.n0.b1.g.k.d.z(kVar);
            }
            if (!ListUtils.isEmpty(a2Var.H0()) || !ListUtils.isEmpty(a2Var.l0())) {
                if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                    d.a.n0.b1.g.k.d.C(kVar);
                } else {
                    d.a.n0.b1.g.k.d.A(kVar);
                }
            }
            d.a.n0.b1.g.k.d.q(kVar);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                d.a.n0.b1.g.k.d.s(kVar);
            }
            d.a.n0.b1.g.k.d.p(kVar);
            kVar.setSupportType(BaseCardInfo.SupportType.TOP);
            kVar.position = i2;
            arrayList.add(kVar);
        } else {
            if (d.a.m0.b.d.h()) {
                a2Var.m();
                if (a2Var != null) {
                    a2Var.m();
                    if (a2Var.T() != null) {
                        a2Var.m();
                        boolean hadConcerned = a2Var.T().hadConcerned();
                        if (!hadConcerned && (hadConcerned || !ThreadCardUtils.isSelf(a2Var))) {
                            d.a.n0.b1.g.k.d.o(a2Var);
                        }
                    }
                }
            }
            if (a2Var.t1) {
                k kVar2 = new k();
                kVar2.f63459e = a2Var;
                kVar2.position = i2;
                arrayList.add(kVar2);
            } else if (l.d0(a2Var)) {
                l lVar = new l(a2Var);
                lVar.l = a2Var.y1();
                if (concernData != null) {
                    lVar.W(concernData.source.intValue());
                }
                if (lVar.isValid()) {
                    arrayList.add(lVar);
                }
            } else if (j.i0(a2Var)) {
                j jVar = new j(a2Var);
                jVar.l = a2Var.y1();
                jVar.X("3");
                if (jVar.isValid()) {
                    arrayList.add(jVar);
                }
            } else if (e.i0(a2Var) && a2Var.Q1()) {
                e eVar = new e(a2Var);
                eVar.position = i2;
                arrayList.add(eVar);
            } else {
                k kVar3 = new k();
                kVar3.f63459e = a2Var;
                kVar3.X(a2Var.h2() ? "4" : "1");
                kVar3.position = i2;
                if (concernData != null) {
                    kVar3.W(concernData.source.intValue());
                }
                if (kVar3.f63459e != null && kVar3.isValid() && !StringUtils.isNull(kVar3.f63459e.o0()) && !"0".equals(kVar3.f63459e.y1())) {
                    arrayList.add(kVar3);
                }
            }
        }
        return arrayList;
    }
}

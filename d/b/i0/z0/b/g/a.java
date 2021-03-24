package d.b.i0.z0.b.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.x.e0.e;
import d.b.i0.x.e0.j;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import d.b.i0.z0.b.d;
import d.b.i0.z0.g.k.c;
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
    public final c f62803a = new c();

    public static void a(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public c b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i == 0 || i == 1) {
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            a(builder);
            a(builder2);
            d(z, builder, builder2, i);
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (ConcernData concernData : builder.thread_info) {
                if (concernData != null) {
                    if (d.b.i0.z0.b.f.c.D(builder.hot_recomforum, i2)) {
                        d.b.i0.z0.b.f.c cVar = new d.b.i0.z0.b.f.c();
                        if (cVar.B(builder.hot_recomforum.tab_list)) {
                            cVar.position = i2;
                            linkedList.add(cVar);
                            i2++;
                        }
                    }
                    if (d.b.i0.z0.b.f.a.C(concernData)) {
                        d.b.i0.z0.b.f.a aVar = new d.b.i0.z0.b.f.a();
                        if (concernData.recom_user_list.size() >= 4) {
                            aVar.A(concernData.recom_user_list);
                            aVar.position = i2;
                            aVar.D(builder.thread_info.size() > 1);
                            linkedList.add(aVar);
                        }
                    } else {
                        a2 a2Var = new a2();
                        a2Var.y3(true);
                        d.b.h0.b.f.a.e(a2Var);
                        a2Var.Q2(concernData.thread_list);
                        JSONObject b2 = d.b.i0.r2.b0.b.b(concernData.thread_list);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                        linkedList.addAll(e(a2Var, i2, concernData));
                    }
                    i2++;
                }
            }
            d.b.h0.b.f.a.d(linkedList);
            d.b.i0.r2.b0.b.f().h("CONCERN", arrayList);
            c cVar2 = this.f62803a;
            cVar2.f63210a = linkedList;
            return cVar2;
        }
        return null;
    }

    public final void c(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        if (list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i == 1) {
            for (ConcernData concernData : list2) {
                if (d.b.i0.z0.b.f.a.C(concernData)) {
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
                if (concernData2 != null && d.b.i0.z0.b.f.a.C(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.f62803a.f63211b = ListUtils.getCount(list) - count;
    }

    public final void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2 = builder.thread_info;
        if (list2 == null || (list = builder2.thread_info) == null) {
            return;
        }
        c(z, list2, list, i);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<n> e(a2 a2Var, int i, ConcernData concernData) {
        d.b.i0.x.e0.b kVar;
        ThreadInfo threadInfo;
        ArrayList arrayList = new ArrayList();
        if ((k.i0(a2Var) || l.d0(a2Var)) && a2Var.getType() != a2.j3) {
            if (l.d0(a2Var)) {
                kVar = new l(a2Var);
            } else {
                kVar = new k();
                a2Var.e2();
                a2Var.r2();
                if (!a2Var.e2() && !a2Var.r2()) {
                    a2Var.Z1();
                }
                kVar.f62196e = a2Var;
            }
            kVar.l = a2Var.w1();
            if (k.i0(a2Var)) {
                kVar.X("1");
            } else if (l.d0(a2Var)) {
                kVar.X("2");
            }
            kVar.E = true;
            if (d.b.h0.b.d.h() && kVar.n() != null && kVar.n().T() != null) {
                if (!kVar.n().T().hadConcerned() && !ThreadCardUtils.isSelf(a2Var)) {
                    d.b.i0.z0.g.k.d.r(kVar);
                    d.b.i0.z0.g.k.d.o(a2Var);
                } else {
                    d.b.i0.z0.g.k.d.t(kVar);
                }
            } else {
                d.b.i0.z0.g.k.d.t(kVar);
            }
            kVar.f62196e.J1();
            if (kVar instanceof k) {
                if (a2Var.P1()) {
                    d.b.i0.z0.g.k.d.u(kVar);
                } else if (a2Var.V2() == 1) {
                    d.b.i0.z0.g.k.d.w(kVar);
                    int[] p0 = a2Var.p0();
                    kVar.o = p0[0];
                    kVar.p = p0[1];
                } else if (a2Var.V2() >= 2) {
                    d.b.i0.z0.g.k.d.v(kVar);
                } else {
                    d.b.i0.z0.g.k.d.x(kVar);
                }
            } else if (kVar instanceof l) {
                d.b.i0.z0.g.k.d.y(kVar);
            }
            if (a2Var.y0() != null) {
                d.b.i0.z0.g.k.d.z(kVar);
            }
            if (!ListUtils.isEmpty(a2Var.G0()) || !ListUtils.isEmpty(a2Var.l0())) {
                if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                    d.b.i0.z0.g.k.d.B(kVar);
                } else {
                    d.b.i0.z0.g.k.d.A(kVar);
                }
            }
            d.b.i0.z0.g.k.d.q(kVar);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                d.b.i0.z0.g.k.d.s(kVar);
            }
            d.b.i0.z0.g.k.d.p(kVar);
            kVar.setSupportType(BaseCardInfo.SupportType.TOP);
            kVar.position = i;
            arrayList.add(kVar);
        } else {
            if (d.b.h0.b.d.h()) {
                a2Var.n();
                if (a2Var != null) {
                    a2Var.n();
                    if (a2Var.T() != null) {
                        a2Var.n();
                        boolean hadConcerned = a2Var.T().hadConcerned();
                        if (!hadConcerned && (hadConcerned || !ThreadCardUtils.isSelf(a2Var))) {
                            d.b.i0.z0.g.k.d.o(a2Var);
                        }
                    }
                }
            }
            if (a2Var.s1) {
                k kVar2 = new k();
                kVar2.f62196e = a2Var;
                kVar2.position = i;
                arrayList.add(kVar2);
            } else if (l.d0(a2Var)) {
                l lVar = new l(a2Var);
                lVar.l = a2Var.w1();
                if (concernData != null) {
                    lVar.W(concernData.source.intValue());
                }
                if (lVar.isValid()) {
                    arrayList.add(lVar);
                }
            } else if (j.i0(a2Var)) {
                j jVar = new j(a2Var);
                jVar.l = a2Var.w1();
                jVar.X("3");
                if (jVar.isValid()) {
                    arrayList.add(jVar);
                }
            } else if (e.i0(a2Var) && a2Var.O1()) {
                e eVar = new e(a2Var);
                eVar.position = i;
                arrayList.add(eVar);
            } else {
                k kVar3 = new k();
                kVar3.f62196e = a2Var;
                kVar3.X(a2Var.e2() ? "4" : "1");
                kVar3.position = i;
                if (concernData != null) {
                    kVar3.W(concernData.source.intValue());
                }
                if (kVar3.f62196e != null && kVar3.isValid() && !StringUtils.isNull(kVar3.f62196e.o0()) && !"0".equals(kVar3.f62196e.w1())) {
                    arrayList.add(kVar3);
                }
            }
        }
        return arrayList;
    }
}

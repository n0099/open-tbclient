package d.b.i0.p0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.y1;
import d.b.h0.r.q.z1;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.p0.u0;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class f0 extends d.b.i0.p0.k<z1, AutoVideoCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d {
    public d.b.i0.x.b0<a2> A;
    public Set<String> w;
    public int x;
    public d.b.i0.p0.j2.b y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 5, f0.this.i, f0.this.y, f0.this.i0());
                } else if (view.getId() == R.id.img_interview_live) {
                    d.b.i0.p0.j2.a.b(a2Var, 3, f0.this.i, f0.this.y, f0.this.i0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.i0.p0.j2.a.b(a2Var, 15, f0.this.i, f0.this.y, f0.this.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 14, f0.this.i, f0.this.y, f0.this.i0());
                } else if (view.getId() == R.id.img_agree) {
                    d.b.i0.p0.j2.a.b(a2Var, 12, f0.this.i, f0.this.y, f0.this.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.b.i0.p0.j2.a.b(a2Var, 13, f0.this.i, f0.this.y, f0.this.i0());
                } else {
                    d.b.i0.p0.j2.a.b(a2Var, 1, f0.this.i, f0.this.y, f0.this.i0());
                }
            } else {
                d.b.i0.p0.j2.a.b(a2Var, 2, f0.this.i, f0.this.y, f0.this.i0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.b.i0.p0.j2.c.j().g(f0.this.y, a2Var, 2);
            } else if (view.getId() == R.id.thread_card_root) {
                if (a2Var.p1() == 2 && a2Var.o1() != null) {
                    String d2 = a2Var.o1().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = a2Var.o1().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(a2Var.c0());
                    String i0 = a2Var.i0();
                    String g2 = a2Var.o1().g();
                    d.b.i0.c3.j0.a.c("frs", "CLICK", valueOf, i0, g2, "tieba.baidu.com/p/" + a2Var.o1().g(), str);
                    String f2 = a2Var.o1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", a2Var.c0());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                d.b.i0.p0.j2.c.j().g(f0.this.y, a2Var, 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.b.j.e.w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (f0.this.A != null) {
                    f0.this.A.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), f0.this.x, false);
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public f0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.x = 3;
        this.y = new d.b.i0.p0.j2.b();
        this.z = false;
        this.A = new a();
        this.w = new HashSet();
    }

    public final d.b.i0.i2.o E0(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        d.b.i0.i2.o oVar = new d.b.i0.i2.o();
        oVar.f56163a = a2Var.X1() ? "3" : "2";
        oVar.f56166d = this.y.f57701c;
        oVar.f56165c = a2Var.w1();
        oVar.f56168f = a2Var.R0;
        oVar.f56169g = a2Var.V0;
        oVar.f56170h = a2Var.S0;
        oVar.l = a2Var.T0;
        if (a2Var.u1() != null) {
            oVar.m = a2Var.u1().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: F0 */
    public AutoVideoCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.b(696);
        dVar.t(this.i);
        bVar.o(dVar);
        d.b.i.r rVar = new d.b.i.r(this.o.getPageActivity());
        rVar.B(this.z);
        bVar.n(rVar);
        d.b.i.n nVar = new d.b.i.n(this.o.getPageActivity());
        nVar.x(this.z);
        nVar.w("frs");
        bVar.h(nVar);
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50762b = 2;
        eVar.f50768h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(1);
        m0Var.x(this.x);
        m0Var.b(16);
        bVar.m(m0Var);
        d.b.i.k0 i = bVar.i();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
        autoVideoCardViewHolder.k(this.i);
        i.p(this.A);
        i.r(this.x);
        c0(new b());
        autoVideoCardViewHolder.n();
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: G0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (this.y != null) {
            FrsViewData frsViewData = this.n;
            z1Var.w.M1 = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        }
        d.b.i0.p0.j2.c.j().c(this.y, z1Var.w);
        d.b.i0.p0.j2.a.i(z1Var.w, this.i, this.y, i0());
        y1 o1 = z1Var.w.o1();
        if (o1 != null) {
            String f2 = o1.f();
            String d2 = o1.d();
            if (StringUtils.isNull(d2)) {
                d2 = o1.f();
            }
            String str = d2;
            if (this.o.getOrignalPage() instanceof u0) {
                u0 u0Var = (u0) this.o.getOrignalPage();
                if (this.w.add(f2)) {
                    String h2 = u0Var.h();
                    String i2 = u0Var.i();
                    String g2 = o1.g();
                    d.b.i0.c3.j0.a.c("frs", "VIEW_TRUE", h2, i2, g2, "tieba.baidu.com/p/" + z1Var.w.w1(), str);
                }
            }
            StatisticItem statisticItem = new StatisticItem("c13324");
            statisticItem.param("fid", z1Var.w.c0());
            statisticItem.param("tid", z1Var.w.w1());
            statisticItem.param("obj_id", f2);
            statisticItem.param("thread_type", z1Var.w.s1());
            TiebaStatic.log(statisticItem);
        }
        if (z1Var != null) {
            z1Var.w.x4();
            if ((z1Var.w.u1() != null ? (char) 2 : (char) 1) == 2) {
                autoVideoCardViewHolder.w(E0(z1Var.w));
            }
            autoVideoCardViewHolder.b().e().b(32);
            autoVideoCardViewHolder.f(z1Var.w);
            autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.A);
            d.b.i0.p0.j.g(autoVideoCardViewHolder.b().e(), this.n);
        }
        return autoVideoCardViewHolder.a();
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.p0.j2.d
    public d.b.i0.p0.j2.b b() {
        return this.y;
    }

    @Override // d.b.i0.p0.k
    public void m0() {
        super.m0();
        this.w.clear();
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.x = i;
    }

    @Override // d.b.i0.p0.k
    public void setFromCDN(boolean z) {
        this.z = z;
    }
}

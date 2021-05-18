package d.a.k0.q0.n1.d;

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
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.y1;
import d.a.k0.q0.u0;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class c0 extends d.a.k0.q0.k<a2, AutoVideoCardViewHolder<a2>> implements d.a.k0.x.z, d.a.k0.q0.j2.d {
    public d.a.k0.x.b0<a2> A;
    public Set<String> w;
    public int x;
    public d.a.k0.q0.j2.b y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends d.a.k0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 5, c0.this.f39568i, c0.this.y, c0.this.f0());
                } else if (view.getId() == R.id.img_interview_live) {
                    d.a.k0.q0.j2.a.c(a2Var, 3, c0.this.f39568i, c0.this.y, c0.this.f0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.k0.q0.j2.a.c(a2Var, 15, c0.this.f39568i, c0.this.y, c0.this.f0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 14, c0.this.f39568i, c0.this.y, c0.this.f0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.k0.q0.j2.a.c(a2Var, 12, c0.this.f39568i, c0.this.y, c0.this.f0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.k0.q0.j2.a.c(a2Var, 13, c0.this.f39568i, c0.this.y, c0.this.f0());
                } else {
                    d.a.k0.q0.j2.a.c(a2Var, 1, c0.this.f39568i, c0.this.y, c0.this.f0());
                }
            } else {
                d.a.k0.q0.j2.a.c(a2Var, 2, c0.this.f39568i, c0.this.y, c0.this.f0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.k0.q0.j2.c.j().g(c0.this.y, a2Var, 2);
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
                    d.a.k0.d3.j0.a.c("frs", "CLICK", valueOf, i0, g2, "tieba.baidu.com/p/" + a2Var.o1().g(), str);
                    String f2 = a2Var.o1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", a2Var.c0());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                d.a.k0.q0.j2.c.j().g(c0.this.y, a2Var, 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = (a2) nVar;
                a2Var.objType = 1;
                if (c0.this.A != null) {
                    c0.this.A.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), c0.this.x, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public c0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.x = 3;
        this.y = new d.a.k0.q0.j2.b();
        this.z = false;
        this.A = new a();
        this.w = new HashSet();
    }

    public final d.a.k0.j2.o D0(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        d.a.k0.j2.o oVar = new d.a.k0.j2.o();
        oVar.f56718a = a2Var.Y1() ? "3" : "2";
        oVar.f56721d = this.y.f58635c;
        oVar.f56720c = a2Var.x1();
        oVar.f56723f = a2Var.R0;
        oVar.f56724g = a2Var.V0;
        oVar.f56725h = a2Var.S0;
        oVar.l = a2Var.T0;
        if (a2Var.v1() != null) {
            oVar.m = a2Var.v1().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: E0 */
    public AutoVideoCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.b(696);
        dVar.t(this.f39568i);
        bVar.o(dVar);
        d.a.i.r rVar = new d.a.i.r(this.o.getPageActivity());
        rVar.B(this.z);
        bVar.n(rVar);
        d.a.i.n nVar = new d.a.i.n(this.o.getPageActivity());
        nVar.x(this.z);
        nVar.w("frs");
        bVar.h(nVar);
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.j0.r.q.e eVar = new d.a.j0.r.q.e();
        eVar.f49950b = 2;
        eVar.f49956h = 2;
        n0Var.v(eVar);
        n0Var.w(2);
        n0Var.A(1);
        n0Var.x(this.x);
        n0Var.b(16);
        bVar.m(n0Var);
        l0 i2 = bVar.i();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i2);
        autoVideoCardViewHolder.j(this.f39568i);
        i2.p(this.A);
        i2.r(this.x);
        Z(new b());
        autoVideoCardViewHolder.m();
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: F0 */
    public View W(int i2, View view, ViewGroup viewGroup, a2 a2Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (this.y != null) {
            FrsViewData frsViewData = this.n;
            a2Var.M1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        }
        d.a.k0.q0.j2.c.j().c(this.y, a2Var);
        d.a.k0.q0.j2.a.j(a2Var, this.f39568i, this.y, f0());
        y1 o1 = a2Var.o1();
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
                    String g2 = u0Var.g();
                    String g3 = o1.g();
                    d.a.k0.d3.j0.a.c("frs", "VIEW_TRUE", h2, g2, g3, "tieba.baidu.com/p/" + a2Var.x1(), str);
                }
            }
            StatisticItem statisticItem = new StatisticItem("c13324");
            statisticItem.param("fid", a2Var.c0());
            statisticItem.param("tid", a2Var.x1());
            statisticItem.param("obj_id", f2);
            statisticItem.param("thread_type", a2Var.t1());
            TiebaStatic.log(statisticItem);
        }
        if (a2Var != null) {
            a2Var.A4();
            if ((a2Var.v1() != null ? (char) 2 : (char) 1) == 2) {
                autoVideoCardViewHolder.u(D0(a2Var));
            }
            autoVideoCardViewHolder.b().e().b(32);
            autoVideoCardViewHolder.f(a2Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.A);
            d.a.k0.q0.j.g(autoVideoCardViewHolder.b().e(), this.n);
        }
        return autoVideoCardViewHolder.a();
    }

    @Override // d.a.k0.x.z
    public void a(String str) {
    }

    @Override // d.a.k0.q0.k
    public void h0() {
        super.h0();
        this.w.clear();
    }

    @Override // d.a.k0.q0.j2.d
    public d.a.k0.q0.j2.b i() {
        return this.y;
    }

    @Override // d.a.k0.x.z
    public void q(int i2) {
        this.x = i2;
    }

    @Override // d.a.k0.q0.k
    public void setFromCDN(boolean z) {
        this.z = z;
    }
}

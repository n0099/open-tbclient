package d.a.k0.q0.n1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i.a;
import d.a.i.l0;
import d.a.i.t0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
/* loaded from: classes4.dex */
public class z extends d.a.k0.q0.k<z1, AutoVideoCardViewHolder<a2>> implements d.a.k0.x.z, d.a.k0.q0.j2.d, d.a.k0.m.f, d.a.k0.x.a0 {
    public d.a.k0.q0.j2.b A;
    public d.a.k0.x.b0<a2> B;
    public TbPageContext<?> w;
    public String x;
    public String y;
    public int z;

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
            if (z.this.u != null) {
                z.this.u.b(view, a2Var, a2.f3);
            }
            if ("c13010".equals(z.this.y)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", a2Var.c0()).param("tid", a2Var.x1()));
            }
            if (view.getId() == R.id.thread_card_root && a2Var.B2()) {
                d.a.k0.q0.j2.c.j().g(z.this.A, a2Var, 1);
                z.this.L0(a2Var);
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.k0.q0.j2.c.j().g(z.this.A, a2Var, 2);
            } else if (view.getId() == R.id.header_divider) {
                d.a.k0.q0.n2.l.a(z.this.A, a2Var.V0());
            } else if (view.getId() == R.id.operable_video_container) {
                d.a.k0.q0.j2.c.j().g(z.this.A, a2Var, 4);
                z.this.L0(a2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                z.this.L0(a2Var);
            }
            if (view.getId() == R.id.operable_video_container) {
                d.a.k0.q0.j2.a.c(a2Var, 4, z.this.f39568i, z.this.A, z.this.f0());
            } else if (view.getId() == R.id.video_play) {
                d.a.k0.q0.j2.a.c(a2Var, 4, z.this.f39568i, z.this.A, z.this.f0());
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 5, z.this.f39568i, z.this.A, z.this.f0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.k0.q0.j2.a.c(a2Var, 15, z.this.f39568i, z.this.A, z.this.f0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 14, z.this.f39568i, z.this.A, z.this.f0());
                } else {
                    d.a.k0.q0.j2.a.c(a2Var, 1, z.this.f39568i, z.this.A, z.this.f0());
                }
            } else {
                d.a.k0.q0.j2.a.c(a2Var, 2, z.this.f39568i, z.this.A, z.this.f0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0547a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f58942a;

        public b(t0 t0Var) {
            this.f58942a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0547a
        public void a(d.a.j0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f58942a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, z.this.f39564e, z.this.z, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, z.this.f39564e, z.this.z, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.j.e.w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (z.this.B != null) {
                    z.this.B.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), z.this.z, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.z = 3;
        this.A = new d.a.k0.q0.j2.b();
        this.B = new a();
        this.w = tbPageContext;
    }

    public final d.a.k0.j2.o I0(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        d.a.k0.j2.o oVar = new d.a.k0.j2.o();
        oVar.f56718a = a2Var.Y1() ? "3" : "2";
        if (this.A.f58636d == 501) {
            oVar.f56718a = "frs_tab";
        }
        oVar.f56721d = this.A.f58635c;
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
    /* renamed from: J0 */
    public AutoVideoCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.w.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.w.getPageActivity(), true);
        gVar.u("frs");
        gVar.y("2003");
        gVar.v(new b(gVar));
        if (this.z == 502) {
            gVar.w(false);
        } else {
            gVar.w(true);
        }
        bVar.n(gVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
        autoVideoCardViewHolder.j(this.f39568i);
        k.p(this.B);
        k.r(this.z);
        Z(new c());
        autoVideoCardViewHolder.n(false);
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: K0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder.b() instanceof d.a.k0.m.e) {
            autoVideoCardViewHolder.b().setPage(this.x);
        }
        super.W(i2, view, viewGroup, z1Var, autoVideoCardViewHolder);
        d.a.k0.q0.j.g(autoVideoCardViewHolder.b().e(), this.n);
        autoVideoCardViewHolder.u(I0(z1Var.w));
        autoVideoCardViewHolder.b().q(i2);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.k4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.B);
        if (this.A != null) {
            FrsViewData frsViewData2 = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.a.k0.q0.j2.c.j().c(this.A, z1Var.w);
        d.a.k0.q0.j2.c.j().b(z1Var.w);
        d.a.k0.q0.j2.c.j().e(z1Var.w, g0());
        d.a.k0.q0.j2.a.j(z1Var.w, this.f39568i, this.A, f0());
        z1Var.w.A4();
        return autoVideoCardViewHolder.a();
    }

    public final void L0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", g0() ? 2 : 1).param("obj_id", a2Var.q1() == null ? -1L : a2Var.q1().live_id).param("obj_type", 1));
    }

    @Override // d.a.k0.x.z
    public void a(String str) {
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.x = str;
    }

    @Override // d.a.k0.q0.j2.d
    public d.a.k0.q0.j2.b i() {
        return this.A;
    }

    @Override // d.a.k0.x.a0
    public void k(boolean z) {
    }

    @Override // d.a.k0.x.z
    public void q(int i2) {
        this.z = i2;
    }

    @Override // d.a.k0.q0.k, d.a.k0.x.y
    public void setFrom(String str) {
        this.y = str;
    }
}

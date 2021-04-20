package d.b.i0.q0.n1.d;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.a;
import d.b.i.k0;
import d.b.i.s0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class z extends d.b.i0.q0.k<z1, AutoVideoCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.q0.j2.d, d.b.i0.m.f, d.b.i0.x.a0 {
    public d.b.i0.q0.j2.b A;
    public d.b.i0.x.b0<a2> B;
    public TbPageContext<?> w;
    public String x;
    public String y;
    public int z;

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
            if (z.this.u != null) {
                z.this.u.b(view, a2Var, a2.e3);
            }
            if ("c13010".equals(z.this.y)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() == R.id.thread_card_root && a2Var.z2()) {
                d.b.i0.q0.j2.c.j().g(z.this.A, a2Var, 1);
                z.this.M0(a2Var);
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.b.i0.q0.j2.c.j().g(z.this.A, a2Var, 2);
            } else if (view.getId() == R.id.header_divider) {
                d.b.i0.q0.n2.l.a(z.this.A, a2Var.V0());
            } else if (view.getId() == R.id.operable_video_container) {
                d.b.i0.q0.j2.c.j().g(z.this.A, a2Var, 4);
                z.this.M0(a2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                z.this.M0(a2Var);
            }
            if (view.getId() == R.id.operable_video_container) {
                d.b.i0.q0.j2.a.b(a2Var, 4, z.this.i, z.this.A, z.this.i0());
            } else if (view.getId() == R.id.video_play) {
                d.b.i0.q0.j2.a.b(a2Var, 4, z.this.i, z.this.A, z.this.i0());
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.i0.q0.j2.a.b(a2Var, 5, z.this.i, z.this.A, z.this.i0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.i0.q0.j2.a.b(a2Var, 15, z.this.i, z.this.A, z.this.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.i0.q0.j2.a.b(a2Var, 14, z.this.i, z.this.A, z.this.i0());
                } else {
                    d.b.i0.q0.j2.a.b(a2Var, 1, z.this.i, z.this.A, z.this.i0());
                }
            } else {
                d.b.i0.q0.j2.a.b(a2Var, 2, z.this.i, z.this.A, z.this.i0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1129a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f59698a;

        public b(s0 s0Var) {
            this.f59698a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1129a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f59698a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, z.this.f42855e, z.this.z, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, z.this.f42855e, z.this.z, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.c.j.e.w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (z.this.B != null) {
                    z.this.B.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), z.this.z, false, d.b.i.e.a((d.b.c.j.e.s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.z = 3;
        this.A = new d.b.i0.q0.j2.b();
        this.B = new a();
        this.w = tbPageContext;
    }

    public final d.b.i0.j2.o J0(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        d.b.i0.j2.o oVar = new d.b.i0.j2.o();
        oVar.f57611a = a2Var.X1() ? "3" : "2";
        if (this.A.f59402d == 501) {
            oVar.f57611a = "frs_tab";
        }
        oVar.f57614d = this.A.f59401c;
        oVar.f57613c = a2Var.w1();
        oVar.f57616f = a2Var.R0;
        oVar.f57617g = a2Var.V0;
        oVar.f57618h = a2Var.S0;
        oVar.l = a2Var.T0;
        if (a2Var.u1() != null) {
            oVar.m = a2Var.u1().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: K0 */
    public AutoVideoCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.w.getPageActivity(), false);
        d.b.i.g gVar = new d.b.i.g(this.w.getPageActivity(), true);
        gVar.u("frs");
        gVar.y("2003");
        gVar.v(new b(gVar));
        if (this.z == 502) {
            gVar.w(false);
        } else {
            gVar.w(true);
        }
        bVar.n(gVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
        autoVideoCardViewHolder.k(this.i);
        k.p(this.B);
        k.r(this.z);
        c0(new c());
        autoVideoCardViewHolder.o(false);
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: L0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder.b() instanceof d.b.i0.m.e) {
            autoVideoCardViewHolder.b().setPage(this.x);
        }
        super.X(i, view, viewGroup, z1Var, autoVideoCardViewHolder);
        d.b.i0.q0.j.g(autoVideoCardViewHolder.b().e(), this.n);
        autoVideoCardViewHolder.w(J0(z1Var.w));
        autoVideoCardViewHolder.b().q(i);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.i4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.B);
        if (this.A != null) {
            FrsViewData frsViewData2 = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.b.i0.q0.j2.c.j().c(this.A, z1Var.w);
        d.b.i0.q0.j2.c.j().b(z1Var.w);
        d.b.i0.q0.j2.c.j().e(z1Var.w, l0());
        d.b.i0.q0.j2.a.i(z1Var.w, this.i, this.A, i0());
        z1Var.w.y4();
        return autoVideoCardViewHolder.a();
    }

    public final void M0(a2 a2Var) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", l0() ? 2 : 1).param("obj_id", a2Var.q1() == null ? -1L : a2Var.q1().live_id).param("obj_type", 1));
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.q0.j2.d
    public d.b.i0.q0.j2.b b() {
        return this.A;
    }

    @Override // d.b.i0.x.a0
    public void d(boolean z) {
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.x = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.z = i;
    }

    @Override // d.b.i0.q0.k, d.b.i0.x.y
    public void setFrom(String str) {
        this.y = str;
    }
}

package d.b.i0.z0.g.h;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.a;
import d.b.i.k0;
import d.b.i.s0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class y extends d.b.b.j.e.a<d.b.i0.x.e0.l, AutoVideoCardViewHolder<d.b.i0.x.e0.l>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.i0.z0.g.k.e o;
    public String p;
    public d.b.b.j.e.s q;
    public s0 r;
    public d.b.i0.x.b0<d.b.i0.x.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<d.b.i0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.l lVar) {
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (y.this.o == null || lVar == null || lVar.n() == null || StringUtils.isNull(lVar.n().w1())) {
                return;
            }
            if (lVar.n().p1 > 0) {
                TiebaStatic.log(lVar.Z(lVar.n()));
                return;
            }
            if ((view.getTag() instanceof String) && !d.b.i0.z0.g.f.b(d.b.b.e.m.b.f(lVar.n().w1(), 0L))) {
                d.b.i0.z0.g.f.a(d.b.b.e.m.b.f(lVar.n().w1(), 0L));
                y.this.o.e(d.b.b.e.m.b.f(lVar.n().w1(), 0L), lVar.O(), lVar.F(), lVar.E(), lVar.z(), d.b.b.e.m.b.d((String) view.getTag(), 1), "homepage", lVar.n().V());
            }
            y.this.o0(view, lVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1115a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f63179a;

        public b(s0 s0Var) {
            this.f63179a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1115a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f63179a.getVideoContainer());
            if (!(aVar instanceof d.b.i0.x.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, y.this.f42357e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, y.this.f42357e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.b.j.e.w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                d.b.i0.x.e0.l lVar = (d.b.i0.x.e0.l) nVar;
                lVar.k = 1;
                if (y.this.s != null) {
                    y.this.s.a(autoVideoCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) lVar, view.getContext(), 2, false, d.b.i.e.a((d.b.b.j.e.s) viewGroup, view, i));
                autoVideoCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.n = tbPageContext;
        p0();
    }

    public final d.b.i0.i2.o n0(d.b.i0.x.e0.l lVar) {
        if (lVar != null) {
            d.b.i0.i2.o oVar = new d.b.i0.i2.o();
            oVar.f56163a = "1";
            oVar.f56165c = lVar.l;
            if (lVar.n() != null) {
                oVar.f56166d = String.valueOf(lVar.n().c0());
                oVar.v = lVar.n().L0();
                if (lVar.n().u1() != null) {
                    oVar.m = lVar.n().u1().video_md5;
                    oVar.p = String.valueOf(lVar.n().u1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f56168f = lVar.F();
            oVar.l = lVar.z();
            oVar.f56170h = lVar.O();
            oVar.f56167e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            if (lVar.n() == null || lVar.n().V() == null) {
                return oVar;
            }
            oVar.t = lVar.n().V().oriUgcNid;
            oVar.u = lVar.n().V().oriUgcVid;
            return oVar;
        }
        return null;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.p = str;
    }

    public final void o0(View view, d.b.i0.x.e0.l lVar) {
        s0 s0Var = this.r;
        if (s0Var == null || s0Var.p() == null || this.r.p().C() == null) {
            return;
        }
        if (view.getId() == this.r.p().C().getId()) {
            d.b.i0.z0.g.m.a.a(lVar.f62196e, this.m, lVar.E(), 4);
            TiebaStatic.log(lVar.b0());
        } else if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.Z(lVar.f62196e));
        }
    }

    public void onPause() {
        s0 s0Var = this.r;
        if (s0Var != null) {
            s0Var.s();
        }
    }

    public void onResume() {
        s0 s0Var = this.r;
        if (s0Var != null) {
            s0Var.t();
        }
    }

    public final void p0() {
        d.b.i0.x.e0.l.W = "c10708";
        d.b.i0.x.e0.l.X = "c10735";
        d.b.i0.x.e0.l.Y = "c10709";
        d.b.i0.x.e0.l.Z = "c10734";
        d.b.i0.x.e0.l.a0 = "c11929";
        d.b.i0.x.e0.l.b0 = "c11928";
        d.b.i0.x.e0.l.c0 = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: q0 */
    public AutoVideoCardViewHolder<d.b.i0.x.e0.l> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i0.z0.g.n.b bVar2 = new d.b.i0.z0.g.n.b(this.n.getPageActivity());
        bVar2.v(new b(bVar2));
        this.r = bVar2;
        bVar2.x(this.m);
        this.r.u("index");
        this.r.y("2001");
        bVar.n(this.r);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        AutoVideoCardViewHolder<d.b.i0.x.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.m);
        k.p(this.s);
        k.r(2);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: r0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.l lVar, AutoVideoCardViewHolder<d.b.i0.x.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i);
        lVar.U = 0;
        d.b.i0.x.t.b().a(lVar.L());
        autoVideoCardViewHolder.w(n0(lVar));
        if (autoVideoCardViewHolder.b() != null) {
            autoVideoCardViewHolder.b().setPage(this.p);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        d.b.i0.z0.g.m.a.c(lVar.f62196e, this.m, lVar.E());
        return autoVideoCardViewHolder.a();
    }

    public void s0(d.b.i0.z0.g.k.e eVar) {
        this.o = eVar;
    }

    public void t0(d.b.b.j.e.s sVar) {
        this.q = sVar;
    }
}

package d.a.n0.b1.b.e;

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
import d.a.i.a;
import d.a.i.l0;
import d.a.i.t0;
import d.a.i.v0.a;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class x extends d.a.c.j.e.a<d.a.n0.z.e0.l, AutoVideoCardViewHolder<d.a.n0.z.e0.l>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.a.c.j.e.s q;
    public t0 r;
    public b0<d.a.n0.z.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.z.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.l lVar) {
            d.a.n0.z.t.b().d(true);
            d.a.n0.o.d.c().h("page_recommend", "show_");
            if (lVar == null || lVar.m() == null || StringUtils.isNull(lVar.m().y1())) {
                return;
            }
            if (lVar.m().q1 <= 0) {
                x.this.j0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.m()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0542a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f51379a;

        public b(t0 t0Var) {
            this.f51379a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f51379a.getVideoContainer());
            if (!(aVar instanceof d.a.n0.z.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, x.this.f39228e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, x.this.f39228e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.j.e.w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.c.j.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.c.j.e.g gVar = (d.a.c.j.e.g) nVar;
                if (gVar.h() instanceof d.a.n0.z.e0.l) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.a.n0.z.e0.l lVar = (d.a.n0.z.e0.l) gVar.h();
                    lVar.k = 1;
                    if (x.this.s != null) {
                        x.this.s.a(threadCardViewHolder.a(), lVar);
                    }
                    ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) lVar, view.getContext(), 1, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                    threadCardViewHolder.b().o(new a.C0544a(1));
                }
            }
        }
    }

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    public final d.a.n0.k2.o i0(d.a.n0.z.e0.l lVar) {
        if (lVar != null) {
            d.a.n0.k2.o oVar = new d.a.n0.k2.o();
            oVar.f56898a = "1";
            oVar.f56900c = lVar.l;
            if (lVar.m() != null) {
                oVar.f56901d = String.valueOf(lVar.m().c0());
                if (lVar.m().w1() != null) {
                    oVar.m = lVar.m().w1().video_md5;
                    oVar.p = String.valueOf(lVar.m().w1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f56903f = lVar.F();
            oVar.l = lVar.z();
            oVar.f56905h = lVar.O();
            oVar.f56902e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            return oVar;
        }
        return null;
    }

    public final void j0(View view, d.a.n0.z.e0.l lVar) {
        t0 t0Var = this.r;
        if (t0Var == null || t0Var.p() == null || this.r.p().E() == null) {
            return;
        }
        if (view.getId() == this.r.p().E().getId()) {
            d.a.n0.b1.b.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.n0.b1.b.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<d.a.n0.z.e0.l> M(ViewGroup viewGroup, d.a.n0.z.e0.l lVar) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        d.a.n0.b1.g.n.b bVar2 = new d.a.n0.b1.g.n.b(this.o.getPageActivity());
        bVar2.x(this.m);
        bVar2.u("concern_tab");
        bVar2.v(new b(bVar2));
        this.r = bVar2;
        bVar.n(bVar2);
        t0 t0Var = this.r;
        if (t0Var != null) {
            t0Var.y("2001");
        }
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        AutoVideoCardViewHolder<d.a.n0.z.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.m);
        k.p(this.s);
        k.r(1);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<d.a.n0.z.e0.l> P(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public View S(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.l lVar, AutoVideoCardViewHolder<d.a.n0.z.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.a.n0.z.t.b().a(lVar.A("c12351"));
        autoVideoCardViewHolder.b().q(i2);
        lVar.V = 0;
        autoVideoCardViewHolder.u(i0(lVar));
        if (autoVideoCardViewHolder.b() instanceof d.a.n0.o.e) {
            autoVideoCardViewHolder.b().setPage(this.p);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        return autoVideoCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.l lVar, AutoVideoCardViewHolder<d.a.n0.z.e0.l> autoVideoCardViewHolder) {
        return null;
    }

    public void s0(d.a.c.j.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId u() {
        return d.a.n0.z.e0.b.P;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId v() {
        return d.a.n0.z.e0.b.M;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId w() {
        return d.a.n0.z.e0.b.O;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId x() {
        BdUniqueId bdUniqueId = this.n;
        return bdUniqueId != null ? bdUniqueId : d.a.n0.z.e0.b.G;
    }
}

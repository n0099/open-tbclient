package d.a.j0.a1.b.e;

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
import d.a.i.k0;
import d.a.i.s0;
import d.a.i.u0.a;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class x extends d.a.c.j.e.a<d.a.j0.x.e0.l, AutoVideoCardViewHolder<d.a.j0.x.e0.l>> implements d.a.j0.m.f {
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.a.c.j.e.s q;
    public s0 r;
    public b0<d.a.j0.x.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.j0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.l lVar) {
            d.a.j0.x.t.b().d(true);
            d.a.j0.m.d.c().h("page_recommend", "show_");
            if (lVar == null || lVar.m() == null || StringUtils.isNull(lVar.m().w1())) {
                return;
            }
            if (lVar.m().p1 <= 0) {
                x.this.j0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.m()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1009a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f50517a;

        public b(s0 s0Var) {
            this.f50517a = s0Var;
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f50517a.getVideoContainer());
            if (!(aVar instanceof d.a.j0.x.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, x.this.f40319e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, x.this.f40319e, 1, false, computeViewArea);
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
                if (gVar.h() instanceof d.a.j0.x.e0.l) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.a.j0.x.e0.l lVar = (d.a.j0.x.e0.l) gVar.h();
                    lVar.k = 1;
                    if (x.this.s != null) {
                        x.this.s.a(threadCardViewHolder.a(), lVar);
                    }
                    ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) lVar, view.getContext(), 1, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                    threadCardViewHolder.b().o(new a.C1011a(1));
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

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.p = str;
    }

    public final d.a.j0.j2.o i0(d.a.j0.x.e0.l lVar) {
        if (lVar != null) {
            d.a.j0.j2.o oVar = new d.a.j0.j2.o();
            oVar.f56011a = "1";
            oVar.f56013c = lVar.l;
            if (lVar.m() != null) {
                oVar.f56014d = String.valueOf(lVar.m().c0());
                if (lVar.m().u1() != null) {
                    oVar.m = lVar.m().u1().video_md5;
                    oVar.p = String.valueOf(lVar.m().u1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f56016f = lVar.F();
            oVar.l = lVar.z();
            oVar.f56018h = lVar.O();
            oVar.f56015e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            return oVar;
        }
        return null;
    }

    public final void j0(View view, d.a.j0.x.e0.l lVar) {
        s0 s0Var = this.r;
        if (s0Var == null || s0Var.p() == null || this.r.p().E() == null) {
            return;
        }
        if (view.getId() == this.r.p().E().getId()) {
            d.a.j0.a1.b.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.j0.a1.b.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<d.a.j0.x.e0.l> M(ViewGroup viewGroup, d.a.j0.x.e0.l lVar) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        d.a.j0.a1.g.n.b bVar2 = new d.a.j0.a1.g.n.b(this.o.getPageActivity());
        bVar2.x(this.m);
        bVar2.u("concern_tab");
        bVar2.v(new b(bVar2));
        this.r = bVar2;
        bVar.n(bVar2);
        s0 s0Var = this.r;
        if (s0Var != null) {
            s0Var.y("2001");
        }
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        AutoVideoCardViewHolder<d.a.j0.x.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.m);
        k.p(this.s);
        k.r(1);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<d.a.j0.x.e0.l> P(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public View S(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.l lVar, AutoVideoCardViewHolder<d.a.j0.x.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.a.j0.x.t.b().a(lVar.A("c12351"));
        autoVideoCardViewHolder.b().q(i2);
        lVar.U = 0;
        autoVideoCardViewHolder.u(i0(lVar));
        if (autoVideoCardViewHolder.b() instanceof d.a.j0.m.e) {
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.l lVar, AutoVideoCardViewHolder<d.a.j0.x.e0.l> autoVideoCardViewHolder) {
        return null;
    }

    public void r0(d.a.c.j.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId u() {
        return d.a.j0.x.e0.b.O;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId v() {
        return d.a.j0.x.e0.b.L;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId w() {
        return d.a.j0.x.e0.b.N;
    }

    @Override // d.a.c.j.e.a
    public BdUniqueId x() {
        BdUniqueId bdUniqueId = this.n;
        return bdUniqueId != null ? bdUniqueId : d.a.j0.x.e0.b.F;
    }
}

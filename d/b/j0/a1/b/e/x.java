package d.b.j0.a1.b.e;

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
import d.b.j0.x.b0;
/* loaded from: classes4.dex */
public class x extends d.b.c.j.e.a<d.b.j0.x.e0.l, AutoVideoCardViewHolder<d.b.j0.x.e0.l>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.b.c.j.e.s q;
    public s0 r;
    public b0<d.b.j0.x.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.j0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.l lVar) {
            d.b.j0.x.t.b().d(true);
            d.b.j0.m.d.c().h("page_recommend", "show_");
            if (lVar == null || lVar.n() == null || StringUtils.isNull(lVar.n().w1())) {
                return;
            }
            if (lVar.n().p1 <= 0) {
                x.this.n0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.n()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1070a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f52823a;

        public b(s0 s0Var) {
            this.f52823a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1070a
        public void a(d.b.i0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f52823a.getVideoContainer());
            if (!(aVar instanceof d.b.j0.x.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, x.this.f43095e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, x.this.f43095e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.c.j.e.w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.c.j.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.b.c.j.e.g gVar = (d.b.c.j.e.g) nVar;
                if (gVar.g() instanceof d.b.j0.x.e0.l) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.b.j0.x.e0.l lVar = (d.b.j0.x.e0.l) gVar.g();
                    lVar.k = 1;
                    if (x.this.s != null) {
                        x.this.s.a(threadCardViewHolder.a(), lVar);
                    }
                    ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) lVar, view.getContext(), 1, false, d.b.i.e.a((d.b.c.j.e.s) viewGroup, view, i));
                    threadCardViewHolder.b().o(new a.C1072a(1));
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

    public final d.b.j0.j2.o m0(d.b.j0.x.e0.l lVar) {
        if (lVar != null) {
            d.b.j0.j2.o oVar = new d.b.j0.j2.o();
            oVar.f58032a = "1";
            oVar.f58034c = lVar.l;
            if (lVar.n() != null) {
                oVar.f58035d = String.valueOf(lVar.n().c0());
                if (lVar.n().u1() != null) {
                    oVar.m = lVar.n().u1().video_md5;
                    oVar.p = String.valueOf(lVar.n().u1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f58037f = lVar.F();
            oVar.l = lVar.z();
            oVar.f58039h = lVar.O();
            oVar.f58036e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            return oVar;
        }
        return null;
    }

    public final void n0(View view, d.b.j0.x.e0.l lVar) {
        s0 s0Var = this.r;
        if (s0Var == null || s0Var.p() == null || this.r.p().C() == null) {
            return;
        }
        if (view.getId() == this.r.p().C().getId()) {
            d.b.j0.a1.b.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.b.j0.a1.b.c.b(view, lVar, 2);
        }
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: o0 */
    public AutoVideoCardViewHolder<d.b.j0.x.e0.l> O(ViewGroup viewGroup, d.b.j0.x.e0.l lVar) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        d.b.j0.a1.g.n.b bVar2 = new d.b.j0.a1.g.n.b(this.o.getPageActivity());
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
        AutoVideoCardViewHolder<d.b.j0.x.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.m);
        k.p(this.s);
        k.r(1);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: p0 */
    public AutoVideoCardViewHolder<d.b.j0.x.e0.l> R(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: q0 */
    public View U(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.l lVar, AutoVideoCardViewHolder<d.b.j0.x.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.b.j0.x.t.b().a(lVar.A("c12351"));
        autoVideoCardViewHolder.b().q(i);
        lVar.U = 0;
        autoVideoCardViewHolder.w(m0(lVar));
        if (autoVideoCardViewHolder.b() instanceof d.b.j0.m.e) {
            autoVideoCardViewHolder.b().setPage(this.p);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        return autoVideoCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: r0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.l lVar, AutoVideoCardViewHolder<d.b.j0.x.e0.l> autoVideoCardViewHolder) {
        return null;
    }

    public void s0(d.b.c.j.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId v() {
        return d.b.j0.x.e0.b.O;
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId w() {
        return d.b.j0.x.e0.b.L;
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId x() {
        return d.b.j0.x.e0.b.N;
    }

    @Override // d.b.c.j.e.a
    public BdUniqueId y() {
        BdUniqueId bdUniqueId = this.n;
        return bdUniqueId != null ? bdUniqueId : d.b.j0.x.e0.b.F;
    }
}

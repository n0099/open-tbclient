package d.a.n0.b1.c.e;

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
public class x extends d.a.c.k.e.a<d.a.n0.z.e0.l, AutoVideoCardViewHolder<d.a.n0.z.e0.l>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.a.c.k.e.s q;
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
            if (lVar == null || lVar.i() == null || StringUtils.isNull(lVar.i().z1())) {
                return;
            }
            if (lVar.i().r1 <= 0) {
                x.this.k0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.i()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0598a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f55062a;

        public b(t0 t0Var) {
            this.f55062a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0598a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f55062a.getVideoContainer());
            if (!(aVar instanceof d.a.n0.z.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, x.this.f42909e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, x.this.f42909e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.k.e.w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.c.k.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.c.k.e.g gVar = (d.a.c.k.e.g) nVar;
                if (gVar.c() instanceof d.a.n0.z.e0.l) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.a.n0.z.e0.l lVar = (d.a.n0.z.e0.l) gVar.c();
                    lVar.k = 1;
                    if (x.this.s != null) {
                        x.this.s.a(threadCardViewHolder.a(), lVar);
                    }
                    ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) lVar, view.getContext(), 1, false, d.a.i.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                    threadCardViewHolder.b().o(new a.C0600a(1));
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

    public final d.a.n0.k2.o j0(d.a.n0.z.e0.l lVar) {
        if (lVar != null) {
            d.a.n0.k2.o oVar = new d.a.n0.k2.o();
            oVar.f60587a = "1";
            oVar.f60589c = lVar.l;
            if (lVar.i() != null) {
                oVar.f60590d = String.valueOf(lVar.i().c0());
                if (lVar.i().x1() != null) {
                    oVar.m = lVar.i().x1().video_md5;
                    oVar.p = String.valueOf(lVar.i().x1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f60592f = lVar.F();
            oVar.l = lVar.z();
            oVar.f60594h = lVar.O();
            oVar.f60591e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            return oVar;
        }
        return null;
    }

    public final void k0(View view, d.a.n0.z.e0.l lVar) {
        t0 t0Var = this.r;
        if (t0Var == null || t0Var.p() == null || this.r.p().E() == null) {
            return;
        }
        if (view.getId() == this.r.p().E().getId()) {
            d.a.n0.b1.c.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.n0.b1.c.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public AutoVideoCardViewHolder<d.a.n0.z.e0.l> N(ViewGroup viewGroup, d.a.n0.z.e0.l lVar) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        d.a.n0.b1.h.n.b bVar2 = new d.a.n0.b1.h.n.b(this.o.getPageActivity());
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
        autoVideoCardViewHolder.k(this.m);
        k.p(this.s);
        k.r(1);
        a0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<d.a.n0.z.e0.l> Q(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: p0 */
    public View T(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.l lVar, AutoVideoCardViewHolder<d.a.n0.z.e0.l> autoVideoCardViewHolder) {
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
        autoVideoCardViewHolder.v(j0(lVar));
        if (autoVideoCardViewHolder.b() instanceof d.a.n0.o.e) {
            autoVideoCardViewHolder.b().setPage(this.p);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        return autoVideoCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.l lVar, AutoVideoCardViewHolder<d.a.n0.z.e0.l> autoVideoCardViewHolder) {
        return null;
    }

    public void s0(d.a.c.k.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId v() {
        return d.a.n0.z.e0.b.P;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId w() {
        return d.a.n0.z.e0.b.M;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId x() {
        return d.a.n0.z.e0.b.O;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId y() {
        BdUniqueId bdUniqueId = this.n;
        return bdUniqueId != null ? bdUniqueId : d.a.n0.z.e0.b.G;
    }
}

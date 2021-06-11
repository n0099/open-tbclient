package d.a.n0.b1.h.h;

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
/* loaded from: classes4.dex */
public class z extends d.a.c.k.e.a<d.a.n0.z.e0.l, AutoVideoCardViewHolder<d.a.n0.z.e0.l>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.n0.b1.h.k.e o;
    public String p;
    public d.a.c.k.e.s q;
    public t0 r;
    public d.a.n0.z.b0<d.a.n0.z.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends d.a.n0.z.b0<d.a.n0.z.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.l lVar) {
            d.a.n0.z.t.b().d(true);
            d.a.n0.o.d.c().h("page_recommend", "show_");
            if (z.this.o == null || lVar == null || lVar.i() == null || StringUtils.isNull(lVar.i().z1())) {
                return;
            }
            if (lVar.i().r1 > 0) {
                TiebaStatic.log(lVar.Z(lVar.i()));
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.n0.b1.h.f.b(d.a.c.e.m.b.f(lVar.i().z1(), 0L))) {
                d.a.n0.b1.h.f.a(d.a.c.e.m.b.f(lVar.i().z1(), 0L));
                z.this.o.e(d.a.c.e.m.b.f(lVar.i().z1(), 0L), lVar.O(), lVar.F(), lVar.E(), lVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", lVar.i().V());
            }
            z.this.l0(view, lVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0598a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f55484a;

        public b(t0 t0Var) {
            this.f55484a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0598a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f55484a.getVideoContainer());
            if (!(aVar instanceof d.a.n0.z.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, z.this.f42909e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, z.this.f42909e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.k.e.w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.z.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                d.a.n0.z.e0.l lVar = (d.a.n0.z.e0.l) nVar;
                lVar.k = 1;
                if (z.this.s != null) {
                    z.this.s.a(autoVideoCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) lVar, view.getContext(), 2, false, d.a.i.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.n = tbPageContext;
        m0();
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    public final d.a.n0.k2.o k0(d.a.n0.z.e0.l lVar) {
        if (lVar != null) {
            d.a.n0.k2.o oVar = new d.a.n0.k2.o();
            oVar.f60587a = "1";
            oVar.f60589c = lVar.l;
            if (lVar.i() != null) {
                oVar.f60590d = String.valueOf(lVar.i().c0());
                oVar.v = lVar.i().M0();
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
            if (lVar.i() == null || lVar.i().V() == null) {
                return oVar;
            }
            oVar.t = lVar.i().V().oriUgcNid;
            oVar.u = lVar.i().V().oriUgcVid;
            return oVar;
        }
        return null;
    }

    public final void l0(View view, d.a.n0.z.e0.l lVar) {
        t0 t0Var = this.r;
        if (t0Var == null || t0Var.p() == null || this.r.p().E() == null) {
            return;
        }
        if (view.getId() == this.r.p().E().getId()) {
            d.a.n0.b1.h.m.a.a(lVar.f67177e, this.m, lVar.E(), 4);
            TiebaStatic.log(lVar.b0());
        } else if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.Z(lVar.f67177e));
        }
    }

    public final void m0() {
        d.a.n0.z.e0.l.X = "c10708";
        d.a.n0.z.e0.l.Y = "c10735";
        d.a.n0.z.e0.l.Z = "c10709";
        d.a.n0.z.e0.l.a0 = "c10734";
        d.a.n0.z.e0.l.b0 = "c11929";
        d.a.n0.z.e0.l.c0 = "c11928";
        d.a.n0.z.e0.l.d0 = "c10756";
    }

    public void onPause() {
        t0 t0Var = this.r;
        if (t0Var != null) {
            t0Var.s();
        }
    }

    public void onResume() {
        t0 t0Var = this.r;
        if (t0Var != null) {
            t0Var.t();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: p0 */
    public AutoVideoCardViewHolder<d.a.n0.z.e0.l> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.n0.b1.h.n.b bVar2 = new d.a.n0.b1.h.n.b(this.n.getPageActivity());
        bVar2.v(new b(bVar2));
        this.r = bVar2;
        bVar2.x(this.m);
        this.r.u("index");
        this.r.y("2001");
        bVar.n(this.r);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        AutoVideoCardViewHolder<d.a.n0.z.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.m);
        k.p(this.s);
        k.r(2);
        a0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.l lVar, AutoVideoCardViewHolder<d.a.n0.z.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i2);
        lVar.V = 0;
        d.a.n0.z.t.b().a(lVar.L());
        autoVideoCardViewHolder.v(k0(lVar));
        if (autoVideoCardViewHolder.b() != null) {
            autoVideoCardViewHolder.b().setPage(this.p);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        d.a.n0.b1.h.m.a.c(lVar.f67177e, this.m, lVar.E());
        return autoVideoCardViewHolder.a();
    }

    public void s0(d.a.n0.b1.h.k.e eVar) {
        this.o = eVar;
    }

    public void t0(d.a.c.k.e.s sVar) {
        this.q = sVar;
    }
}

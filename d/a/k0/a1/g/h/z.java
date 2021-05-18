package d.a.k0.a1.g.h;

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
public class z extends d.a.c.j.e.a<d.a.k0.x.e0.l, AutoVideoCardViewHolder<d.a.k0.x.e0.l>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.k0.a1.g.k.e o;
    public String p;
    public d.a.c.j.e.s q;
    public t0 r;
    public d.a.k0.x.b0<d.a.k0.x.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends d.a.k0.x.b0<d.a.k0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.l lVar) {
            d.a.k0.x.t.b().d(true);
            d.a.k0.m.d.c().h("page_recommend", "show_");
            if (z.this.o == null || lVar == null || lVar.m() == null || StringUtils.isNull(lVar.m().x1())) {
                return;
            }
            if (lVar.m().p1 > 0) {
                TiebaStatic.log(lVar.Z(lVar.m()));
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.k0.a1.g.f.b(d.a.c.e.m.b.f(lVar.m().x1(), 0L))) {
                d.a.k0.a1.g.f.a(d.a.c.e.m.b.f(lVar.m().x1(), 0L));
                z.this.o.e(d.a.c.e.m.b.f(lVar.m().x1(), 0L), lVar.O(), lVar.F(), lVar.E(), lVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", lVar.m().V());
            }
            z.this.m0(view, lVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0547a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f51634a;

        public b(t0 t0Var) {
            this.f51634a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0547a
        public void a(d.a.j0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f51634a.getVideoContainer());
            if (!(aVar instanceof d.a.k0.x.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, z.this.f39564e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, z.this.f39564e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.j.e.w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.k0.x.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                d.a.k0.x.e0.l lVar = (d.a.k0.x.e0.l) nVar;
                lVar.k = 1;
                if (z.this.s != null) {
                    z.this.s.a(autoVideoCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) lVar, view.getContext(), 2, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.n = tbPageContext;
        n0();
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.p = str;
    }

    public final d.a.k0.j2.o j0(d.a.k0.x.e0.l lVar) {
        if (lVar != null) {
            d.a.k0.j2.o oVar = new d.a.k0.j2.o();
            oVar.f56718a = "1";
            oVar.f56720c = lVar.l;
            if (lVar.m() != null) {
                oVar.f56721d = String.valueOf(lVar.m().c0());
                oVar.v = lVar.m().L0();
                if (lVar.m().v1() != null) {
                    oVar.m = lVar.m().v1().video_md5;
                    oVar.p = String.valueOf(lVar.m().v1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f56723f = lVar.F();
            oVar.l = lVar.z();
            oVar.f56725h = lVar.O();
            oVar.f56722e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            if (lVar.m() == null || lVar.m().V() == null) {
                return oVar;
            }
            oVar.t = lVar.m().V().oriUgcNid;
            oVar.u = lVar.m().V().oriUgcVid;
            return oVar;
        }
        return null;
    }

    public final void m0(View view, d.a.k0.x.e0.l lVar) {
        t0 t0Var = this.r;
        if (t0Var == null || t0Var.p() == null || this.r.p().E() == null) {
            return;
        }
        if (view.getId() == this.r.p().E().getId()) {
            d.a.k0.a1.g.m.a.a(lVar.f63179e, this.m, lVar.E(), 4);
            TiebaStatic.log(lVar.b0());
        } else if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.Z(lVar.f63179e));
        }
    }

    public final void n0() {
        d.a.k0.x.e0.l.X = "c10708";
        d.a.k0.x.e0.l.Y = "c10735";
        d.a.k0.x.e0.l.Z = "c10709";
        d.a.k0.x.e0.l.a0 = "c10734";
        d.a.k0.x.e0.l.b0 = "c11929";
        d.a.k0.x.e0.l.c0 = "c11928";
        d.a.k0.x.e0.l.d0 = "c10756";
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
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public AutoVideoCardViewHolder<d.a.k0.x.e0.l> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.k0.a1.g.n.b bVar2 = new d.a.k0.a1.g.n.b(this.n.getPageActivity());
        bVar2.v(new b(bVar2));
        this.r = bVar2;
        bVar2.x(this.m);
        this.r.u("index");
        this.r.y("2001");
        bVar.n(this.r);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        AutoVideoCardViewHolder<d.a.k0.x.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.m);
        k.p(this.s);
        k.r(2);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.l lVar, AutoVideoCardViewHolder<d.a.k0.x.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i2);
        lVar.V = 0;
        d.a.k0.x.t.b().a(lVar.L());
        autoVideoCardViewHolder.u(j0(lVar));
        if (autoVideoCardViewHolder.b() != null) {
            autoVideoCardViewHolder.b().setPage(this.p);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        d.a.k0.a1.g.m.a.c(lVar.f63179e, this.m, lVar.E());
        return autoVideoCardViewHolder.a();
    }

    public void s0(d.a.k0.a1.g.k.e eVar) {
        this.o = eVar;
    }

    public void t0(d.a.c.j.e.s sVar) {
        this.q = sVar;
    }
}

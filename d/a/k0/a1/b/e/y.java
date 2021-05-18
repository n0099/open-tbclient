package d.a.k0.a1.b.e;

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
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class y extends d.a.c.j.e.a<d.a.k0.x.e0.l, AutoVideoCardViewHolder<d.a.k0.x.e0.l>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.j.e.s p;
    public t0 q;
    public b0<d.a.k0.x.e0.l> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.l lVar) {
            d.a.k0.x.t.b().d(true);
            d.a.k0.m.d.c().h("page_recommend", "show_");
            if (lVar == null || lVar.m() == null || StringUtils.isNull(lVar.m().x1())) {
                return;
            }
            if (lVar.m().p1 <= 0) {
                y.this.j0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.m()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0547a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f51218a;

        public b(t0 t0Var) {
            this.f51218a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0547a
        public void a(d.a.j0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f51218a.getVideoContainer());
            if (!(aVar instanceof d.a.k0.x.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, y.this.f39564e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, y.this.f39564e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.c.j.e.w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.k0.x.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.k0.x.e0.l lVar = (d.a.k0.x.e0.l) nVar;
                lVar.k = 1;
                if (y.this.r != null) {
                    y.this.r.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) lVar, view.getContext(), 1, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.o = str;
    }

    public final d.a.k0.j2.o i0(d.a.k0.x.e0.l lVar) {
        if (lVar != null) {
            d.a.k0.j2.o oVar = new d.a.k0.j2.o();
            oVar.f56718a = "1";
            oVar.f56720c = lVar.l;
            if (lVar.m() != null) {
                oVar.f56721d = String.valueOf(lVar.m().c0());
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
            return oVar;
        }
        return null;
    }

    public final void j0(View view, d.a.k0.x.e0.l lVar) {
        t0 t0Var = this.q;
        if (t0Var == null || t0Var.p() == null || this.q.p().E() == null) {
            return;
        }
        if (view.getId() == this.q.p().E().getId()) {
            d.a.k0.a1.b.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.k0.a1.b.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<d.a.k0.x.e0.l> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.k0.a1.g.n.b bVar2 = new d.a.k0.a1.g.n.b(this.n.getPageActivity());
        bVar2.x(this.m);
        bVar2.u("concern_tab");
        bVar2.v(new b(bVar2));
        this.q = bVar2;
        bVar.n(bVar2);
        t0 t0Var = this.q;
        if (t0Var != null) {
            t0Var.y("2001");
        }
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        AutoVideoCardViewHolder<d.a.k0.x.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.m);
        k.p(this.r);
        k.r(1);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.l lVar, AutoVideoCardViewHolder<d.a.k0.x.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.a.k0.x.t.b().a(lVar.A("c12351"));
        autoVideoCardViewHolder.b().q(i2);
        lVar.V = 0;
        autoVideoCardViewHolder.u(i0(lVar));
        if (autoVideoCardViewHolder.b() instanceof d.a.k0.m.e) {
            autoVideoCardViewHolder.b().setPage(this.o);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        return autoVideoCardViewHolder.a();
    }

    public void p0(d.a.c.j.e.s sVar) {
        this.p = sVar;
    }
}

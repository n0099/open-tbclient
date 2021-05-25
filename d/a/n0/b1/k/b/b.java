package d.a.n0.b1.k.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.tencent.connect.common.Constants;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.a;
import d.a.i.l0;
import d.a.i.t0;
import d.a.i.v0.a;
import d.a.n0.k2.o;
import d.a.n0.z.b0;
import d.a.n0.z.e0.l;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<l, AutoVideoCardViewHolder<l>> {
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public t0 p;
    public d.a.n0.b1.g.k.e q;
    public b0<l> r;

    /* loaded from: classes4.dex */
    public class a extends b0<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (view == null || lVar == null || lVar.m() == null) {
                return;
            }
            b.this.m0(view, lVar);
            if (b.this.q == null || !(view.getTag() instanceof String) || d.a.n0.b1.g.f.b(d.a.c.e.m.b.f(lVar.m().y1(), 0L))) {
                return;
            }
            d.a.n0.b1.g.f.a(d.a.c.e.m.b.f(lVar.m().y1(), 0L));
            b.this.q.e(d.a.c.e.m.b.f(lVar.m().y1(), 0L), lVar.O(), lVar.F(), lVar.E(), lVar.z(), d.a.c.e.m.b.d("3", 1), "video_tab", lVar.m().V());
        }
    }

    /* renamed from: d.a.n0.b1.k.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1216b implements a.InterfaceC0542a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f52026a;

        public C1216b(t0 t0Var) {
            this.f52026a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f52026a.getVideoContainer());
            if (aVar instanceof l) {
                aVar.objType = 5;
                d.a.n0.b1.k.d.a.f((d.a.n0.z.e0.b) aVar);
                d.a.n0.b1.k.d.a.c(aVar, b.this.f39228e, 19, false, computeViewArea);
                return;
            }
            d.a.n0.b1.k.d.a.f((d.a.n0.z.e0.b) aVar);
            d.a.n0.b1.k.d.a.c(aVar, b.this.f39228e, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (b.this.r != null) {
                    b.this.r.a(threadCardViewHolder.a(), lVar);
                }
                d.a.n0.b1.k.d.a.c(lVar, view.getContext(), 19, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.m = tbPageContext;
    }

    public final o j0(l lVar) {
        if (lVar != null) {
            o oVar = new o();
            oVar.f56898a = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.f56900c = lVar.l;
            if (lVar.m() != null) {
                oVar.f56901d = String.valueOf(lVar.m().c0());
                oVar.v = lVar.m().M0();
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
            if (lVar.m() == null || lVar.m().V() == null) {
                return oVar;
            }
            oVar.t = lVar.m().V().oriUgcNid;
            oVar.u = lVar.m().V().oriUgcVid;
            return oVar;
        }
        return null;
    }

    public final void m0(View view, l lVar) {
        t0 t0Var = this.p;
        if (t0Var == null || t0Var.p() == null || this.p.p().E() == null) {
            return;
        }
        if (view.getId() == this.p.p().E().getId()) {
            d.a.n0.b1.k.d.a.h(lVar);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.n0.b1.k.d.a.f(lVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<l> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.m.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.m.getPageActivity());
        gVar.v(new C1216b(gVar));
        this.p = gVar;
        gVar.x(this.n);
        this.p.u("video_tab");
        this.p.y("2001");
        bVar.n(this.p);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.n);
        k.p(this.r);
        k.r(19);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    public void onPause() {
        t0 t0Var = this.p;
        if (t0Var != null) {
            t0Var.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public View W(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i2);
        autoVideoCardViewHolder.u(j0(lVar));
        d.a.n0.b1.k.d.a.d(lVar);
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        return autoVideoCardViewHolder.a();
    }

    public void q0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void s0(d.a.n0.b1.g.k.e eVar) {
        this.q = eVar;
    }

    public void t0(s sVar) {
        this.o = sVar;
    }
}

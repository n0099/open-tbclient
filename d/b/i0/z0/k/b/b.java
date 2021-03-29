package d.b.i0.z0.k.b;

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
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.b.j.e.w;
import d.b.i.a;
import d.b.i.k0;
import d.b.i.s0;
import d.b.i.u0.a;
import d.b.i0.i2.o;
import d.b.i0.x.b0;
import d.b.i0.x.e0.l;
/* loaded from: classes3.dex */
public class b extends d.b.b.j.e.a<l, AutoVideoCardViewHolder<l>> {
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public s0 p;
    public d.b.i0.z0.g.k.e q;
    public b0<l> r;

    /* loaded from: classes3.dex */
    public class a extends b0<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (view == null || lVar == null || lVar.n() == null) {
                return;
            }
            b.this.o0(view, lVar);
            if (b.this.q == null || !(view.getTag() instanceof String) || d.b.i0.z0.g.f.b(d.b.b.e.m.b.f(lVar.n().w1(), 0L))) {
                return;
            }
            d.b.i0.z0.g.f.a(d.b.b.e.m.b.f(lVar.n().w1(), 0L));
            b.this.q.e(d.b.b.e.m.b.f(lVar.n().w1(), 0L), lVar.O(), lVar.F(), lVar.E(), lVar.z(), d.b.b.e.m.b.d("3", 1), "video_tab", lVar.n().V());
        }
    }

    /* renamed from: d.b.i0.z0.k.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1713b implements a.InterfaceC1116a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f63393a;

        public C1713b(s0 s0Var) {
            this.f63393a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1116a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f63393a.getVideoContainer());
            if (aVar instanceof l) {
                aVar.objType = 5;
                d.b.i0.z0.k.d.a.f((d.b.i0.x.e0.b) aVar);
                d.b.i0.z0.k.d.a.c(aVar, b.this.f42358e, 19, false, computeViewArea);
                return;
            }
            d.b.i0.z0.k.d.a.f((d.b.i0.x.e0.b) aVar);
            d.b.i0.z0.k.d.a.c(aVar, b.this.f42358e, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (b.this.r != null) {
                    b.this.r.a(threadCardViewHolder.a(), lVar);
                }
                d.b.i0.z0.k.d.a.c(lVar, view.getContext(), 19, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.m = tbPageContext;
    }

    public final o n0(l lVar) {
        if (lVar != null) {
            o oVar = new o();
            oVar.f56164a = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.f56166c = lVar.l;
            if (lVar.n() != null) {
                oVar.f56167d = String.valueOf(lVar.n().c0());
                oVar.v = lVar.n().L0();
                if (lVar.n().u1() != null) {
                    oVar.m = lVar.n().u1().video_md5;
                    oVar.p = String.valueOf(lVar.n().u1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f56169f = lVar.F();
            oVar.l = lVar.z();
            oVar.f56171h = lVar.O();
            oVar.f56168e = TbadkCoreApplication.getCurrentAccount();
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

    public final void o0(View view, l lVar) {
        s0 s0Var = this.p;
        if (s0Var == null || s0Var.p() == null || this.p.p().C() == null) {
            return;
        }
        if (view.getId() == this.p.p().C().getId()) {
            d.b.i0.z0.k.d.a.h(lVar);
        } else if (view.getId() == R.id.thread_card_root) {
            d.b.i0.z0.k.d.a.f(lVar);
        }
    }

    public void onPause() {
        s0 s0Var = this.p;
        if (s0Var != null) {
            s0Var.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: p0 */
    public AutoVideoCardViewHolder<l> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.m.getPageActivity(), false);
        d.b.i.g gVar = new d.b.i.g(this.m.getPageActivity());
        gVar.v(new C1713b(gVar));
        this.p = gVar;
        gVar.x(this.n);
        this.p.u("video_tab");
        this.p.y("2001");
        bVar.n(this.p);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.n);
        k.p(this.r);
        k.r(19);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: q0 */
    public View X(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i);
        autoVideoCardViewHolder.w(n0(lVar));
        d.b.i0.z0.k.d.a.d(lVar);
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        return autoVideoCardViewHolder.a();
    }

    public void r0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void s0(d.b.i0.z0.g.k.e eVar) {
        this.q = eVar;
    }

    public void t0(s sVar) {
        this.o = sVar;
    }
}

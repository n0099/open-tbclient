package d.b.i0.z0.b.e;

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
import d.b.i0.x.b0;
/* loaded from: classes3.dex */
public class y extends d.b.b.j.e.a<d.b.i0.x.e0.l, AutoVideoCardViewHolder<d.b.i0.x.e0.l>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.b.b.j.e.s p;
    public s0 q;
    public b0<d.b.i0.x.e0.l> r;

    /* loaded from: classes3.dex */
    public class a extends b0<d.b.i0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.l lVar) {
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (lVar == null || lVar.n() == null || StringUtils.isNull(lVar.n().w1())) {
                return;
            }
            if (lVar.n().p1 <= 0) {
                y.this.n0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.n()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC1116a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f62787a;

        public b(s0 s0Var) {
            this.f62787a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1116a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f62787a.getVideoContainer());
            if (!(aVar instanceof d.b.i0.x.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, y.this.f42358e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, y.this.f42358e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.b.j.e.w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.l lVar = (d.b.i0.x.e0.l) nVar;
                lVar.k = 1;
                if (y.this.r != null) {
                    y.this.r.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) lVar, view.getContext(), 1, false, d.b.i.e.a((d.b.b.j.e.s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
    }

    public final d.b.i0.i2.o m0(d.b.i0.x.e0.l lVar) {
        if (lVar != null) {
            d.b.i0.i2.o oVar = new d.b.i0.i2.o();
            oVar.f56164a = "1";
            oVar.f56166c = lVar.l;
            if (lVar.n() != null) {
                oVar.f56167d = String.valueOf(lVar.n().c0());
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
            return oVar;
        }
        return null;
    }

    public final void n0(View view, d.b.i0.x.e0.l lVar) {
        s0 s0Var = this.q;
        if (s0Var == null || s0Var.p() == null || this.q.p().C() == null) {
            return;
        }
        if (view.getId() == this.q.p().C().getId()) {
            d.b.i0.z0.b.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.b.i0.z0.b.c.b(view, lVar, 2);
        }
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public AutoVideoCardViewHolder<d.b.i0.x.e0.l> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i0.z0.g.n.b bVar2 = new d.b.i0.z0.g.n.b(this.n.getPageActivity());
        bVar2.x(this.m);
        bVar2.u("concern_tab");
        bVar2.v(new b(bVar2));
        this.q = bVar2;
        bVar.n(bVar2);
        s0 s0Var = this.q;
        if (s0Var != null) {
            s0Var.y("2001");
        }
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        AutoVideoCardViewHolder<d.b.i0.x.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.m);
        k.p(this.r);
        k.r(1);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: p0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.l lVar, AutoVideoCardViewHolder<d.b.i0.x.e0.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.b.i0.x.t.b().a(lVar.A("c12351"));
        autoVideoCardViewHolder.b().q(i);
        lVar.U = 0;
        autoVideoCardViewHolder.w(m0(lVar));
        if (autoVideoCardViewHolder.b() instanceof d.b.i0.m.e) {
            autoVideoCardViewHolder.b().setPage(this.o);
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        return autoVideoCardViewHolder.a();
    }

    public void q0(d.b.b.j.e.s sVar) {
        this.p = sVar;
    }
}

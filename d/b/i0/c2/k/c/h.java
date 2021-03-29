package d.b.i0.c2.k.c;

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
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class h extends d.b.b.j.e.a<l, AutoVideoCardViewHolder<l>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public s0 p;
    public b0<l> q;

    /* loaded from: classes4.dex */
    public class a extends b0<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            t.b().d(true);
            if (lVar == null || lVar.n() == null || StringUtils.isNull(lVar.n().w1())) {
                return;
            }
            if (lVar.n().p1 <= 0) {
                h.this.n0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.n()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1116a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f52524a;

        public b(s0 s0Var) {
            this.f52524a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1116a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f52524a.getVideoContainer());
            if (!(aVar instanceof l)) {
                ThreadCardUtils.jumpToPB(aVar, h.this.f42358e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, h.this.f42358e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (h.this.q != null) {
                    h.this.q.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) lVar, view.getContext(), 0, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    public final o m0(l lVar) {
        if (lVar != null) {
            o oVar = new o();
            oVar.f56164a = "6";
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

    public final void n0(View view, l lVar) {
        s0 s0Var = this.p;
        if (s0Var == null || s0Var.p() == null || this.p.p().C() == null) {
            return;
        }
        if (view.getId() == this.p.p().C().getId()) {
            d.b.i0.c2.m.a.i(lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.b.i0.c2.m.a.i(lVar, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public AutoVideoCardViewHolder<l> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i.g gVar = new d.b.i.g(this.n.getPageActivity());
        gVar.x(this.m);
        gVar.u("pb");
        gVar.v(new b(gVar));
        this.p = gVar;
        bVar.n(gVar);
        s0 s0Var = this.p;
        if (s0Var != null) {
            s0Var.y("2002");
        }
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.m);
        k.p(this.q);
        k.r(0);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: p0 */
    public View X(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i);
        lVar.U = 0;
        autoVideoCardViewHolder.w(m0(lVar));
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.q);
        return autoVideoCardViewHolder.a();
    }

    public void q0(s sVar) {
        this.o = sVar;
    }
}

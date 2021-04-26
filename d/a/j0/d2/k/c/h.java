package d.a.j0.d2.k.c;

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
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.a;
import d.a.i.k0;
import d.a.i.s0;
import d.a.i.u0.a;
import d.a.j0.j2.o;
import d.a.j0.x.b0;
import d.a.j0.x.e0.l;
import d.a.j0.x.t;
/* loaded from: classes3.dex */
public class h extends d.a.c.j.e.a<l, AutoVideoCardViewHolder<l>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public s0 p;
    public b0<l> q;

    /* loaded from: classes3.dex */
    public class a extends b0<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            t.b().d(true);
            if (lVar == null || lVar.m() == null || StringUtils.isNull(lVar.m().w1())) {
                return;
            }
            if (lVar.m().p1 <= 0) {
                h.this.j0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.m()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC1009a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f52127a;

        public b(s0 s0Var) {
            this.f52127a = s0Var;
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f52127a.getVideoContainer());
            if (!(aVar instanceof l)) {
                ThreadCardUtils.jumpToPB(aVar, h.this.f40319e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, h.this.f40319e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (h.this.q != null) {
                    h.this.q.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) lVar, view.getContext(), 0, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    public final o i0(l lVar) {
        if (lVar != null) {
            o oVar = new o();
            oVar.f56011a = "6";
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

    public final void j0(View view, l lVar) {
        s0 s0Var = this.p;
        if (s0Var == null || s0Var.p() == null || this.p.p().E() == null) {
            return;
        }
        if (view.getId() == this.p.p().E().getId()) {
            d.a.j0.d2.m.a.i(lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.j0.d2.m.a.i(lVar, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<l> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.n.getPageActivity());
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
        autoVideoCardViewHolder.j(this.m);
        k.p(this.q);
        k.r(0);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public View W(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i2);
        lVar.U = 0;
        autoVideoCardViewHolder.u(i0(lVar));
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.q);
        return autoVideoCardViewHolder.a();
    }

    public void p0(s sVar) {
        this.o = sVar;
    }
}

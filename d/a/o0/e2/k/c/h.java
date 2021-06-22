package d.a.o0.e2.k.c;

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
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.a;
import d.a.i.l0;
import d.a.i.t0;
import d.a.i.v0.a;
import d.a.o0.k2.o;
import d.a.o0.z.b0;
import d.a.o0.z.e0.l;
import d.a.o0.z.t;
/* loaded from: classes5.dex */
public class h extends d.a.c.k.e.a<l, AutoVideoCardViewHolder<l>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public t0 p;
    public b0<l> q;

    /* loaded from: classes5.dex */
    public class a extends b0<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            t.b().d(true);
            if (lVar == null || lVar.i() == null || StringUtils.isNull(lVar.i().z1())) {
                return;
            }
            if (lVar.i().r1 <= 0) {
                h.this.k0(view, lVar);
            } else {
                TiebaStatic.log(lVar.Z(lVar.i()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.InterfaceC0600a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f56846a;

        public b(t0 t0Var) {
            this.f56846a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0600a
        public void a(d.a.n0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f56846a.getVideoContainer());
            if (!(aVar instanceof l)) {
                ThreadCardUtils.jumpToPB(aVar, h.this.f43012e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, h.this.f43012e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (h.this.q != null) {
                    h.this.q.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) lVar, view.getContext(), 0, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    public final o j0(l lVar) {
        if (lVar != null) {
            o oVar = new o();
            oVar.f60712a = "6";
            oVar.f60714c = lVar.l;
            if (lVar.i() != null) {
                oVar.f60715d = String.valueOf(lVar.i().c0());
                if (lVar.i().x1() != null) {
                    oVar.m = lVar.i().x1().video_md5;
                    oVar.p = String.valueOf(lVar.i().x1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f60717f = lVar.F();
            oVar.l = lVar.z();
            oVar.f60719h = lVar.O();
            oVar.f60716e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            return oVar;
        }
        return null;
    }

    public final void k0(View view, l lVar) {
        t0 t0Var = this.p;
        if (t0Var == null || t0Var.p() == null || this.p.p().E() == null) {
            return;
        }
        if (view.getId() == this.p.p().E().getId()) {
            d.a.o0.e2.m.a.i(lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.o0.e2.m.a.i(lVar, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public AutoVideoCardViewHolder<l> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.n.getPageActivity());
        gVar.x(this.m);
        gVar.u("pb");
        gVar.v(new b(gVar));
        this.p = gVar;
        bVar.n(gVar);
        t0 t0Var = this.p;
        if (t0Var != null) {
            t0Var.y("2002");
        }
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.m);
        k.p(this.q);
        k.r(0);
        a0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: m0 */
    public View X(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i2);
        lVar.V = 0;
        autoVideoCardViewHolder.v(j0(lVar));
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.q);
        return autoVideoCardViewHolder.a();
    }

    public void p0(s sVar) {
        this.o = sVar;
    }
}

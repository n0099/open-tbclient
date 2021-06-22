package d.a.o0.y1.d.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.a;
import d.a.i.l0;
import d.a.i.t0;
import d.a.i.v0.a;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.k2.o;
import d.a.o0.z.b0;
import d.a.o0.z.t;
/* loaded from: classes5.dex */
public class k extends d.a.o0.y1.d.c.a<z1, AutoVideoCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public t0 q;
    public b0<a2> r;

    /* loaded from: classes5.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            k.this.m0(view, a2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.InterfaceC0600a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f67224a;

        public b(t0 t0Var) {
            this.f67224a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0600a
        public void a(d.a.n0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f67224a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, k.this.f43012e, 17, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, k.this.f43012e, 17, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (k.this.r != null) {
                    k.this.r.a(autoVideoCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) a2Var, view.getContext(), 17, false, d.a.i.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    public final o l0(a2 a2Var) {
        if (a2Var != null) {
            o oVar = new o();
            oVar.f60712a = "20";
            oVar.f60714c = a2Var.A;
            oVar.f60717f = a2Var.T0;
            oVar.f60718g = a2Var.V0;
            oVar.f60719h = a2Var.U0;
            oVar.f60720i = "14";
            oVar.q = String.valueOf(a2Var.O1);
            if (a2Var.w1() != null) {
                oVar.k = String.valueOf(a2Var.w1().f53825a);
            }
            a2Var.i();
            if (a2Var != null) {
                a2Var.i();
                oVar.f60715d = String.valueOf(a2Var.c0());
                a2Var.i();
                oVar.v = a2Var.M0();
                a2Var.i();
                if (a2Var.x1() != null) {
                    a2Var.i();
                    oVar.m = a2Var.x1().video_md5;
                    a2Var.i();
                    oVar.p = String.valueOf(a2Var.x1().is_vertical);
                }
            }
            oVar.f60716e = TbadkCoreApplication.getCurrentAccount();
            a2Var.i();
            if (a2Var != null) {
                a2Var.i();
                if (a2Var.V() != null) {
                    a2Var.i();
                    oVar.t = a2Var.V().oriUgcNid;
                    a2Var.i();
                    oVar.u = a2Var.V().oriUgcVid;
                    return oVar;
                }
                return oVar;
            }
            return oVar;
        }
        return null;
    }

    public final void m0(View view, a2 a2Var) {
        d.a.o0.y1.c.b(this, a2Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: p0 */
    public AutoVideoCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.o.getPageActivity());
        gVar.v(new b(gVar));
        this.q = gVar;
        gVar.x(this.n);
        this.q.u("14");
        this.q.y("2001");
        bVar.n(this.q);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        AutoVideoCardViewHolder<a2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.n);
        k.p(this.r);
        k.r(17);
        a0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        z1Var.w.O1 = F(i2) + 1;
        autoVideoCardViewHolder.b().q(i2);
        autoVideoCardViewHolder.v(l0(z1Var.w));
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        d.a.o0.y1.c.c(this, z1Var);
        return autoVideoCardViewHolder.a();
    }

    public void s0(s sVar) {
        this.p = sVar;
    }
}

package d.a.n0.b1.e.a.d;

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
import com.tencent.connect.common.Constants;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.a;
import d.a.i.l0;
import d.a.i.t0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.k2.o;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class f extends d.a.n0.b1.e.a.d.a<z1, AutoVideoCardViewHolder<a2>> {
    public t0 q;
    public b0<a2> r;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            f.this.e0(view, a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0542a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f51549a;

        public b(t0 t0Var) {
            this.f51549a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f51549a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, f.this.f39228e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, f.this.f39228e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (f.this.r != null) {
                    f.this.r.a(autoVideoCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var, view.getContext(), 0, false, d.a.i.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), a2.g3);
        this.r = new a();
    }

    public final o p0(a2 a2Var) {
        if (a2Var != null) {
            o oVar = new o();
            oVar.f56898a = "20";
            oVar.f56900c = a2Var.A;
            oVar.f56903f = a2Var.S0;
            oVar.f56904g = a2Var.U0;
            oVar.f56905h = a2Var.T0;
            oVar.f56906i = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.q = String.valueOf(a2Var.N1);
            if (a2Var.v1() != null) {
                oVar.k = String.valueOf(a2Var.v1().f50042a);
            }
            a2Var.m();
            if (a2Var != null) {
                a2Var.m();
                oVar.f56901d = String.valueOf(a2Var.c0());
                a2Var.m();
                oVar.v = a2Var.M0();
                a2Var.m();
                if (a2Var.w1() != null) {
                    a2Var.m();
                    oVar.m = a2Var.w1().video_md5;
                    a2Var.m();
                    oVar.p = String.valueOf(a2Var.w1().is_vertical);
                }
            }
            oVar.f56902e = TbadkCoreApplication.getCurrentAccount();
            a2Var.m();
            if (a2Var != null) {
                a2Var.m();
                if (a2Var.V() != null) {
                    a2Var.m();
                    oVar.t = a2Var.V().oriUgcNid;
                    a2Var.m();
                    oVar.u = a2Var.V().oriUgcVid;
                    return oVar;
                }
                return oVar;
            }
            return oVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public AutoVideoCardViewHolder<a2> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.n.getPageActivity());
        gVar.v(new b(gVar));
        this.q = gVar;
        gVar.x(this.f39232i);
        this.q.u(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.q.y("2001");
        bVar.n(this.q);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<a2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.f39232i);
        k.p(this.r);
        k.r(0);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.b1.e.a.d.a, d.a.c.j.e.a
    /* renamed from: s0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        z1Var.w.N1 = B(i2) + 1;
        autoVideoCardViewHolder.b().q(i2);
        autoVideoCardViewHolder.u(p0(z1Var.w));
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        i0(autoVideoCardViewHolder.a(), z1Var.w, i2, i2);
        return autoVideoCardViewHolder.a();
    }
}

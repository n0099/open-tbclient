package d.b.j0.a1.f.d;

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
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i.a;
import d.b.i.k0;
import d.b.i.s0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.j0.j2.o;
import d.b.j0.x.b0;
/* loaded from: classes4.dex */
public class i extends d.b.j0.a1.f.d.a<z1, AutoVideoCardViewHolder<a2>> {
    public s0 q;
    public b0<a2> r;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            i.this.h0(view, a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1070a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f53048a;

        public b(s0 s0Var) {
            this.f53048a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1070a
        public void a(d.b.i0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f53048a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, i.this.f43095e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, i.this.f43095e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (i.this.r != null) {
                    i.this.r.a(autoVideoCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) a2Var, view.getContext(), 0, false, d.b.i.e.a((s) viewGroup, view, i));
                autoVideoCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), a2.e3);
        this.r = new a();
    }

    public final o q0(a2 a2Var) {
        if (a2Var != null) {
            o oVar = new o();
            oVar.f58032a = "20";
            oVar.f58034c = a2Var.A;
            oVar.f58037f = a2Var.R0;
            oVar.f58038g = a2Var.T0;
            oVar.f58039h = a2Var.S0;
            oVar.i = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.q = String.valueOf(a2Var.M1);
            if (a2Var.t1() != null) {
                oVar.k = String.valueOf(a2Var.t1().f51551a);
            }
            a2Var.n();
            if (a2Var != null) {
                a2Var.n();
                oVar.f58035d = String.valueOf(a2Var.c0());
                a2Var.n();
                oVar.v = a2Var.L0();
                a2Var.n();
                if (a2Var.u1() != null) {
                    a2Var.n();
                    oVar.m = a2Var.u1().video_md5;
                    a2Var.n();
                    oVar.p = String.valueOf(a2Var.u1().is_vertical);
                }
            }
            oVar.f58036e = TbadkCoreApplication.getCurrentAccount();
            a2Var.n();
            if (a2Var != null) {
                a2Var.n();
                if (a2Var.V() != null) {
                    a2Var.n();
                    oVar.t = a2Var.V().oriUgcNid;
                    a2Var.n();
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
    @Override // d.b.c.j.e.a
    /* renamed from: r0 */
    public AutoVideoCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i.g gVar = new d.b.i.g(this.n.getPageActivity());
        gVar.v(new b(gVar));
        this.q = gVar;
        gVar.x(this.i);
        this.q.u(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.q.y("2001");
        bVar.n(this.q);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<a2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.i);
        k.p(this.r);
        k.r(0);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.a1.f.d.a, d.b.c.j.e.a
    /* renamed from: s0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        z1Var.w.M1 = E(i) + 1;
        autoVideoCardViewHolder.b().q(i);
        autoVideoCardViewHolder.w(q0(z1Var.w));
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        m0(autoVideoCardViewHolder.a(), z1Var.w, i, i);
        return autoVideoCardViewHolder.a();
    }
}

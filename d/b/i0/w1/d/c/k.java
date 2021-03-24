package d.b.i0.w1.d.c;

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
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.b.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.a;
import d.b.i.k0;
import d.b.i.s0;
import d.b.i.u0.a;
import d.b.i0.i2.o;
import d.b.i0.x.b0;
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class k extends d.b.i0.w1.d.c.a<z1, AutoVideoCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public s0 q;
    public b0<a2> r;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            k.this.p0(view, a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1115a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f62127a;

        public b(s0 s0Var) {
            this.f62127a = s0Var;
        }

        @Override // d.b.i.a.InterfaceC1115a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f62127a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, k.this.f42357e, 17, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, k.this.f42357e, 17, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (k.this.r != null) {
                    k.this.r.a(autoVideoCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), 17, false, d.b.i.e.a((s) viewGroup, view, i));
                autoVideoCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    public final o o0(a2 a2Var) {
        if (a2Var != null) {
            o oVar = new o();
            oVar.f56163a = "20";
            oVar.f56165c = a2Var.A;
            oVar.f56168f = a2Var.R0;
            oVar.f56169g = a2Var.T0;
            oVar.f56170h = a2Var.S0;
            oVar.i = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.q = String.valueOf(a2Var.M1);
            if (a2Var.t1() != null) {
                oVar.k = String.valueOf(a2Var.t1().f50807a);
            }
            a2Var.n();
            if (a2Var != null) {
                a2Var.n();
                oVar.f56166d = String.valueOf(a2Var.c0());
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
            oVar.f56167e = TbadkCoreApplication.getCurrentAccount();
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

    public final void p0(View view, a2 a2Var) {
        d.b.i0.w1.c.b(this, a2Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: q0 */
    public AutoVideoCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        d.b.i.g gVar = new d.b.i.g(this.o.getPageActivity());
        gVar.v(new b(gVar));
        this.q = gVar;
        gVar.x(this.n);
        this.q.u(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.q.y("2001");
        bVar.n(this.q);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        AutoVideoCardViewHolder<a2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.n);
        k.p(this.r);
        k.r(17);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: r0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        z1Var.w.M1 = E(i) + 1;
        autoVideoCardViewHolder.b().q(i);
        autoVideoCardViewHolder.w(o0(z1Var.w));
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        d.b.i0.w1.c.c(this, z1Var);
        return autoVideoCardViewHolder.a();
    }

    public void s0(s sVar) {
        this.p = sVar;
    }
}

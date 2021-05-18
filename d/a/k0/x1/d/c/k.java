package d.a.k0.x1.d.c;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.k0.j2.o;
import d.a.k0.x.b0;
import d.a.k0.x.t;
/* loaded from: classes3.dex */
public class k extends d.a.k0.x1.d.c.a<z1, AutoVideoCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public t0 q;
    public b0<a2> r;

    /* loaded from: classes3.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            k.this.n0(view, a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0547a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f63337a;

        public b(t0 t0Var) {
            this.f63337a = t0Var;
        }

        @Override // d.a.i.a.InterfaceC0547a
        public void a(d.a.j0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f63337a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, k.this.f39564e, 17, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, k.this.f39564e, 17, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (k.this.r != null) {
                    k.this.r.a(autoVideoCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), 17, false, d.a.i.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    public final o m0(a2 a2Var) {
        if (a2Var != null) {
            o oVar = new o();
            oVar.f56718a = "20";
            oVar.f56720c = a2Var.A;
            oVar.f56723f = a2Var.R0;
            oVar.f56724g = a2Var.T0;
            oVar.f56725h = a2Var.S0;
            oVar.f56726i = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.q = String.valueOf(a2Var.M1);
            if (a2Var.u1() != null) {
                oVar.k = String.valueOf(a2Var.u1().f49998a);
            }
            a2Var.m();
            if (a2Var != null) {
                a2Var.m();
                oVar.f56721d = String.valueOf(a2Var.c0());
                a2Var.m();
                oVar.v = a2Var.L0();
                a2Var.m();
                if (a2Var.v1() != null) {
                    a2Var.m();
                    oVar.m = a2Var.v1().video_md5;
                    a2Var.m();
                    oVar.p = String.valueOf(a2Var.v1().is_vertical);
                }
            }
            oVar.f56722e = TbadkCoreApplication.getCurrentAccount();
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

    public final void n0(View view, a2 a2Var) {
        d.a.k0.x1.c.b(this, a2Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public AutoVideoCardViewHolder<a2> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.o.getPageActivity());
        gVar.v(new b(gVar));
        this.q = gVar;
        gVar.x(this.n);
        this.q.u(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.q.y("2001");
        bVar.n(this.q);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        AutoVideoCardViewHolder<a2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.n);
        k.p(this.r);
        k.r(17);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        z1Var.w.M1 = B(i2) + 1;
        autoVideoCardViewHolder.b().q(i2);
        autoVideoCardViewHolder.u(m0(z1Var.w));
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        d.a.k0.x1.c.c(this, z1Var);
        return autoVideoCardViewHolder.a();
    }

    public void s0(s sVar) {
        this.p = sVar;
    }
}

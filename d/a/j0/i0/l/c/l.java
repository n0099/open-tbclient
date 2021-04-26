package d.a.j0.i0.l.c;

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
import d.a.i.k0;
import d.a.i.s0;
import d.a.i.u0.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.j2.o;
import d.a.j0.x.b0;
import d.a.j0.x.t;
/* loaded from: classes4.dex */
public class l extends d.a.c.j.e.a<z1, AutoVideoCardViewHolder<a2>> {
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public s p;
    public s0 q;
    public b0<a2> r;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.a.j0.i0.a.a(view, a2Var, l.this.n);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1009a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f55173a;

        public b(s0 s0Var) {
            this.f55173a = s0Var;
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f55173a.getVideoContainer());
            if (!(aVar instanceof a2)) {
                ThreadCardUtils.jumpToPB(aVar, l.this.f40319e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, l.this.f40319e, 2, false, computeViewArea);
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
                if (l.this.r != null) {
                    l.this.r.a(autoVideoCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) a2Var, view.getContext(), 2, false, d.a.i.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    public final o i0(a2 a2Var) {
        if (a2Var != null) {
            o oVar = new o();
            oVar.f56011a = "20";
            oVar.f56013c = a2Var.A;
            oVar.f56016f = a2Var.R0;
            oVar.f56017g = a2Var.T0;
            oVar.f56018h = a2Var.S0;
            oVar.f56019i = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.s = this.n;
            oVar.q = String.valueOf(a2Var.M1);
            if (a2Var.t1() != null) {
                oVar.k = String.valueOf(a2Var.t1().f49179a);
            }
            a2Var.m();
            if (a2Var != null) {
                a2Var.m();
                oVar.f56014d = String.valueOf(a2Var.c0());
                a2Var.m();
                oVar.v = a2Var.L0();
                a2Var.m();
                if (a2Var.u1() != null) {
                    a2Var.m();
                    oVar.m = a2Var.u1().video_md5;
                    a2Var.m();
                    oVar.p = String.valueOf(a2Var.u1().is_vertical);
                }
            }
            oVar.f56015e = TbadkCoreApplication.getCurrentAccount();
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
    /* renamed from: j0 */
    public AutoVideoCardViewHolder<a2> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        d.a.i.g gVar = new d.a.i.g(this.o.getPageActivity());
        gVar.v(new b(gVar));
        this.q = gVar;
        gVar.x(this.m);
        this.q.u(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.q.y("2001");
        bVar.n(this.q);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        AutoVideoCardViewHolder<a2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.m);
        k.p(this.r);
        k.r(2);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, AutoVideoCardViewHolder<a2> autoVideoCardViewHolder) {
        if (z1Var == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        z1Var.w.M1 = B(i2) + 1;
        autoVideoCardViewHolder.b().q(i2);
        autoVideoCardViewHolder.u(i0(z1Var.w));
        autoVideoCardViewHolder.f(z1Var.w);
        autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        d.a.j0.i0.a.b(z1Var, this.n);
        return autoVideoCardViewHolder.a();
    }

    public void n0(s sVar) {
        this.p = sVar;
    }
}

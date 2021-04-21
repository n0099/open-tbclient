package d.b.j0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.j0.x.b0;
import d.b.j0.x.t;
/* loaded from: classes4.dex */
public class d extends d.b.c.j.e.a<a2, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public s p;
    public b0<a2> q;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.b.j0.a1.i.b.d(view, a2Var, d.this.n);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            d.this.j0(view, nVar);
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    public final void j0(View view, d.b.c.j.e.n nVar) {
        if ((nVar instanceof d.b.j0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.b.j0.x.e0.e eVar = (d.b.j0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) eVar, view.getContext(), 2, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1072a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.m);
        dVar.v(this.o);
        bVar.o(dVar);
        bVar.n(new d.b.i.b(this.o.getPageActivity()));
        bVar.h(new d.b.i.k(this.o.getPageActivity()));
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 1;
        eVar.f51512h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        a2Var.M1 = E(i) + 1;
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().p(this.q);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        d.b.j0.a1.i.b.e(a2Var, this.n);
        return threadCardViewHolder.a();
    }

    public void n0(s sVar) {
        this.p = sVar;
    }
}

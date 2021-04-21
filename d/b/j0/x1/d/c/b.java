package d.b.j0.x1.d.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.j0.x.b0;
import d.b.j0.x.t;
/* loaded from: classes3.dex */
public class b extends d.b.j0.x1.d.c.a<a2, ThreadCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public s q;
    public b0<a2> r;

    /* loaded from: classes3.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.b.j0.m.d.c().h("page_recommend", "show_");
            if (view == null || a2Var == null) {
                return;
            }
            a2Var.n();
            if (a2Var != null) {
                a2Var.n();
                if (StringUtils.isNull(a2Var.w1())) {
                    return;
                }
                b.this.p0(view, a2Var);
            }
        }
    }

    /* renamed from: d.b.j0.x1.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1729b implements w {
        public C1729b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            b.this.m0(view, nVar);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    public final void m0(View view, n nVar) {
        if ((nVar instanceof d.b.j0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.b.j0.x.e0.e eVar = (d.b.j0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) eVar, view.getContext(), 17, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1072a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.n);
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
        m0Var.x(17);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
        k.r(17);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        c0(new C1729b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: o0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        a2Var.M1 = E(i) + 1;
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.p(true).u(this.p);
        threadCardViewHolder.u(true, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().p(this.r);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        d.b.j0.x1.c.c(this, a2Var);
        return threadCardViewHolder.a();
    }

    public final void p0(View view, a2 a2Var) {
        d.b.j0.x1.c.b(this, a2Var);
    }

    public void q0(s sVar) {
        this.q = sVar;
    }
}

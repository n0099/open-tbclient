package d.a.j0.i0.l.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.u0.a;
import d.a.i0.r.q.a2;
import d.a.j0.x.b0;
import d.a.j0.x.t;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<a2, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public s q;
    public b0<a2> r;

    /* renamed from: d.a.j0.i0.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1291a extends b0<a2> {
        public C1291a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.a.j0.i0.a.a(view, a2Var, a.this.n);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            a.this.g0(view, nVar);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new C1291a();
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    public final void g0(View view, n nVar) {
        if ((nVar instanceof d.a.j0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.j0.x.e0.e eVar = (d.a.j0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) eVar, view.getContext(), 2, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1011a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.m);
        dVar.v(this.o);
        bVar.o(dVar);
        bVar.n(new d.a.i.b(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        m0 m0Var = new m0(this.o.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 1;
        eVar.f49137h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        a2Var.M1 = B(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.o(true).u(this.p);
        threadCardViewHolder.s(true, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().p(this.r);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        d.a.j0.i0.a.b(a2Var, this.n);
        return threadCardViewHolder.a();
    }

    public void j0(s sVar) {
        this.q = sVar;
    }
}

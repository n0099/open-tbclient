package d.a.o0.y1.d.c;

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
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.n0.r.q.a2;
import d.a.o0.z.b0;
import d.a.o0.z.t;
/* loaded from: classes5.dex */
public class b extends d.a.o0.y1.d.c.a<a2, ThreadCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public s q;
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
            d.a.o0.o.d.c().h("page_recommend", "show_");
            if (view == null || a2Var == null) {
                return;
            }
            a2Var.i();
            if (a2Var != null) {
                a2Var.i();
                if (StringUtils.isNull(a2Var.z1())) {
                    return;
                }
                b.this.m0(view, a2Var);
            }
        }
    }

    /* renamed from: d.a.o0.y1.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1808b implements w {
        public C1808b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b.this.j0(view, nVar);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    public final void j0(View view, n nVar) {
        if ((nVar instanceof d.a.o0.z.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.o0.z.e0.e eVar = (d.a.o0.z.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) eVar, view.getContext(), 17, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0602a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.v(this.o);
        bVar.o(dVar);
        bVar.n(new d.a.i.b(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 1;
        eVar.f53783h = 1;
        n0Var.v(eVar);
        n0Var.w(1);
        n0Var.A(3);
        n0Var.x(17);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
        k.r(17);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        a0(new C1808b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        a2Var.O1 = F(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.p(true).u(this.p);
        threadCardViewHolder.t(true, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().p(this.r);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        d.a.o0.y1.c.c(this, a2Var);
        return threadCardViewHolder.a();
    }

    public final void m0(View view, a2 a2Var) {
        d.a.o0.y1.c.b(this, a2Var);
    }

    public void p0(s sVar) {
        this.q = sVar;
    }
}

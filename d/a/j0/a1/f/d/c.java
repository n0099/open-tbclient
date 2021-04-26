package d.a.j0.a1.f.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.k0;
import d.a.i.m;
import d.a.i.u0.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.a.j0.a1.f.d.a<z1, ThreadCardViewHolder<a2>> {
    public b0<a2> q;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            c.this.e0(view, a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (c.this.q != null) {
                    c.this.q.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) a2Var, view.getContext(), 0, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext, a2.M2);
        this.q = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        bVar.o(new m(this.n.getPageActivity()));
        k0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.f40323i);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.a1.f.d.a, d.a.c.j.e.a
    /* renamed from: n0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = B(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }
}

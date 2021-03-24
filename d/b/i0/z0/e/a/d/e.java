package d.b.i0.z0.e.a.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i.z;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class e extends d.b.i0.z0.e.a.d.a<z1, ThreadCardViewHolder<a2>> {
    public b0<a2> q;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            e.this.h0(view, a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (e.this.q != null) {
                    e.this.q.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), 0, false);
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext, a2.O2);
        this.q = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        z zVar = new z(this.n.getPageActivity());
        zVar.r("index");
        zVar.s(i0());
        bVar.n(zVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        k.r(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.i);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.z0.e.a.d.a, d.b.b.j.e.a
    /* renamed from: p0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = E(i) + 1;
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        m0(threadCardViewHolder.a(), z1Var.w, i, i);
        return threadCardViewHolder.a();
    }
}

package d.a.j0.x1.d.c;

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
import d.a.i.u0.a;
import d.a.i.z;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.x.b0;
import d.a.j0.x.t;
/* loaded from: classes3.dex */
public class f extends d.a.j0.x1.d.c.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public boolean p;
    public s q;
    public b0<a2> r;

    /* loaded from: classes3.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            f.this.m0(view, a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (f.this.r != null) {
                    f.this.r.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) a2Var, view.getContext(), 17, false);
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        z zVar = new z(this.o.getPageActivity());
        zVar.r("index");
        zVar.s(this.p);
        bVar.n(zVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(17);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.n);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = B(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.a.j0.x1.c.c(this, z1Var);
        return threadCardViewHolder.a();
    }

    public final void m0(View view, a2 a2Var) {
        d.a.j0.x1.c.b(this, a2Var);
    }

    public void n0(s sVar) {
        this.q = sVar;
    }
}

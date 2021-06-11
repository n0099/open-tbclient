package d.a.n0.y1.d.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.v;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.z.b0;
import d.a.n0.z.t;
/* loaded from: classes4.dex */
public class d extends d.a.n0.y1.d.c.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public boolean p;
    public s q;
    public b0<a2> r;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.this.l0(view, a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (d.this.r != null) {
                    d.this.r.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var, view.getContext(), 17, false);
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        v vVar = new v(this.o.getPageActivity());
        vVar.r("index");
        vVar.s(this.p);
        bVar.n(vVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(17);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.n);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.O1 = F(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.a.n0.y1.c.c(this, z1Var);
        return threadCardViewHolder.a();
    }

    public final void l0(View view, a2 a2Var) {
        view.getId();
        d.a.n0.y1.c.b(this, a2Var);
    }

    public void m0(s sVar) {
        this.q = sVar;
    }
}

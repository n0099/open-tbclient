package d.a.o0.b1.j.g;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.i.z;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.z.b0;
import d.a.o0.z.t;
/* loaded from: classes4.dex */
public class h extends d.a.c.k.e.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public boolean p;
    public s q;
    public b0<a2> r;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.a.o0.b1.j.c.d(view, a2Var, h.this.n);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (h.this.r != null) {
                    h.this.r.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) a2Var, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        z zVar = new z(this.o.getPageActivity());
        zVar.r("index");
        zVar.s(this.p);
        bVar.n(zVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
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
        d.a.o0.b1.j.c.e(z1Var, this.n);
        return threadCardViewHolder.a();
    }

    public void j0(s sVar) {
        this.q = sVar;
    }
}

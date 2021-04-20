package d.b.i0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class p extends d.b.c.j.e.a<z1, ThreadCardViewHolder<a2>> {
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
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.b.i0.a1.i.b.d(view, a2Var, p.this.n);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(p pVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
            if (aVar != null) {
                if (view.getId() == R.id.user_name) {
                    aVar.objType = 3;
                } else if (view.getId() == R.id.user_avatar) {
                    aVar.objType = 4;
                } else {
                    aVar.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (p.this.q != null) {
                    p.this.q.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), 2, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.s(new b(this));
        dVar.v(this.o);
        bVar.o(dVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        c0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = E(i) + 1;
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void m0(s sVar) {
        this.p = sVar;
    }
}

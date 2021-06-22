package d.a.o0.b1.h.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.h0;
import d.a.i.l0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class p extends d.a.c.k.e.a<d.a.o0.z.e0.k, ThreadCardViewHolder<d.a.o0.z.e0.k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.c.k.e.s o;
    public d.a.o0.z.b0<d.a.o0.z.e0.k> p;

    /* loaded from: classes4.dex */
    public class a extends d.a.o0.z.b0<d.a.o0.z.e0.k> {
        public a(p pVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.k kVar) {
            ThreadCardViewHolder threadCardViewHolder;
            super.a(view, kVar);
            if (kVar == null || kVar.i() == null || (threadCardViewHolder = (ThreadCardViewHolder) view.getTag()) == null) {
                return;
            }
            ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar.i(), view.getContext(), 2, false);
            threadCardViewHolder.b().o(new a.C0602a(1));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.k.e.w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.o0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                if (p.this.p != null) {
                    p.this.p.a(threadCardViewHolder.a(), kVar);
                }
            }
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<d.a.o0.z.e0.k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        bVar.h(new h0(this.n.getPageActivity()));
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void i0(d.a.c.k.e.s sVar) {
        this.o = sVar;
    }
}

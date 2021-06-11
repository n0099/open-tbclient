package d.a.n0.b1.j.g;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.s;
import d.a.i.l0;
import d.a.m0.r.q.s1;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<s1, ThreadCardViewHolder<s1>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public String p;
    public String q;
    public d.a.m0.m.f r;

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.m.f<MetaData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i2, long j) {
            if (metaData == null) {
                return;
            }
            d.a.n0.b1.j.c.b("c13758", metaData, i2 + 1, b.this.q);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i2, long j) {
            if (metaData == null) {
                return;
            }
            d.a.n0.b1.j.c.a("c13758", metaData, i2 + 1, b.this.q);
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.n0.b1.c.h.a aVar = new d.a.n0.b1.c.h.a(this.n, this.m);
        aVar.q(this.r);
        bVar.n(aVar);
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o));
        threadCardViewHolder.k(this.m);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, s1 s1Var, ThreadCardViewHolder<s1> threadCardViewHolder) {
        if (s1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.n0.o.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(s1Var);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void i0(s sVar) {
        this.o = sVar;
    }
}

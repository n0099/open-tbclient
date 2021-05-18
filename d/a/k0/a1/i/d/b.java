package d.a.k0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.s;
import d.a.i.l0;
import d.a.j0.r.q.s1;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<s1, ThreadCardViewHolder<s1>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public String p;
    public d.a.j0.m.f q;

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.m.f<MetaData> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i2, long j) {
            if (metaData == null) {
                return;
            }
            d.a.k0.a1.i.b.c("c13758", metaData, i2 + 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i2, long j) {
            if (metaData == null) {
                return;
            }
            d.a.k0.a1.i.b.a("c13758", metaData, i2 + 1);
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.k0.a1.b.h.a aVar = new d.a.k0.a1.b.h.a(this.n, this.m);
        aVar.q(this.q);
        bVar.n(aVar);
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o));
        threadCardViewHolder.j(this.m);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, s1 s1Var, ThreadCardViewHolder<s1> threadCardViewHolder) {
        if (s1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.k0.m.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(s1Var);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.p = str;
    }

    public void g0(s sVar) {
        this.o = sVar;
    }
}

package d.b.j0.a1.i.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.s;
import d.b.i.k0;
import d.b.i0.r.q.s1;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<s1, ThreadCardViewHolder<s1>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public String p;
    public d.b.i0.m.f q;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.m.f<MetaData> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i, long j) {
            if (metaData == null) {
                return;
            }
            d.b.j0.a1.i.b.c("c13758", metaData, i + 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i, long j) {
            if (metaData == null) {
                return;
            }
            d.b.j0.a1.i.b.a("c13758", metaData, i + 1);
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.j0.a1.b.h.a aVar = new d.b.j0.a1.b.h.a(this.n, this.m);
        aVar.q(this.q);
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
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, s1 s1Var, ThreadCardViewHolder<s1> threadCardViewHolder) {
        if (s1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        threadCardViewHolder.b().q(i);
        if (threadCardViewHolder.b() instanceof d.b.j0.m.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(s1Var);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void j0(s sVar) {
        this.o = sVar;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.p = str;
    }
}

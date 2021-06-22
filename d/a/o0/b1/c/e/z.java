package d.a.o0.b1.c.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
/* loaded from: classes4.dex */
public class z extends d.a.c.k.e.a<d.a.o0.b1.c.f.c, ThreadCardViewHolder<d.a.o0.b1.c.f.c>> implements d.a.o0.o.f {
    public TbPageContext<?> m;
    public BdUniqueId n;
    public d.a.c.k.e.s o;
    public String p;
    public byte q;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
        this.q = b2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<d.a.o0.b1.c.f.c> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.m.getPageActivity(), false);
        bVar.n(new d.a.o0.b1.c.h.b(this.m, this.n, this.q));
        bVar.l().a(0);
        bVar.l().c(0);
        bVar.l().b(0);
        bVar.l().d(0);
        ThreadCardViewHolder<d.a.o0.b1.c.f.c> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
        threadCardViewHolder.k(this.n);
        return threadCardViewHolder;
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.b1.c.f.c cVar, ThreadCardViewHolder<d.a.o0.b1.c.f.c> threadCardViewHolder) {
        threadCardViewHolder.f(cVar);
        if (threadCardViewHolder.b() != null) {
            threadCardViewHolder.b().q(i2);
            threadCardViewHolder.b().setPage(this.p);
            threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
        return threadCardViewHolder.a();
    }

    public void h0(d.a.c.k.e.s sVar) {
        this.o = sVar;
    }
}

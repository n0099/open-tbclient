package d.a.n0.r0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.z.g;
/* loaded from: classes4.dex */
public class e extends d.a.c.k.e.a<d.a.n0.e0.e, CardViewHolder<g>> {
    public TbPageContext<?> m;
    public g n;
    public String o;

    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.a.n0.e0.e.f56459f);
        this.m = tbPageContext;
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<g> Q(ViewGroup viewGroup) {
        g gVar = new g(this.m);
        this.n = gVar;
        gVar.v(this.o);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.e0.e eVar, CardViewHolder<g> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(eVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.b().m();
    }
}

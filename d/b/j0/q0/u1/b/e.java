package d.b.j0.q0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.x.g;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<d.b.j0.d0.e, CardViewHolder<g>> {
    public TbPageContext<?> m;
    public g n;
    public String o;

    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.b.j0.d0.e.f54092f);
        this.m = tbPageContext;
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<g> R(ViewGroup viewGroup) {
        g gVar = new g(this.m);
        this.n = gVar;
        gVar.w(this.o);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.d0.e eVar, CardViewHolder<g> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(eVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.b().m();
    }
}

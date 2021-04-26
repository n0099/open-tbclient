package d.a.j0.x.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<b, CardViewHolder<c>> {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.f62491g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder P(ViewGroup viewGroup) {
        return new CardViewHolder(new c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(bVar);
        return cardViewHolder.a();
    }
}

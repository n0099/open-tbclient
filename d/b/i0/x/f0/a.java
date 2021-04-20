package d.b.i0.x.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<b, CardViewHolder<c>> {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.f63804g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder R(ViewGroup viewGroup) {
        return new CardViewHolder(new c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(bVar);
        return cardViewHolder.a();
    }
}

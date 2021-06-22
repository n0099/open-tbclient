package d.a.o0.z.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<b, CardViewHolder<c>> {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.f67338g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder Q(ViewGroup viewGroup) {
        return new CardViewHolder(new c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(bVar);
        return cardViewHolder.a();
    }
}

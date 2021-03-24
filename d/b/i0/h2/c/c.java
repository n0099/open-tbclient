package d.b.i0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class c extends d.b.b.j.e.a<d.b.i0.h2.e.d, CardViewHolder<d.b.i0.h2.j.c>> {
    public TbPageContext<?> m;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.h2.e.d.k);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.h2.j.c> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.h2.j.c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.h2.e.d dVar, CardViewHolder<d.b.i0.h2.j.c> cardViewHolder) {
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().n(dVar);
        return cardViewHolder.a();
    }
}

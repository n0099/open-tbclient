package d.a.o0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class c extends d.a.c.k.e.a<d.a.o0.j2.e.d, CardViewHolder<d.a.o0.j2.j.c>> {
    public TbPageContext<?> m;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.j2.e.d.k);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.j2.j.c> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.j2.j.c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.j2.e.d dVar, CardViewHolder<d.a.o0.j2.j.c> cardViewHolder) {
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().n(dVar);
        return cardViewHolder.a();
    }
}

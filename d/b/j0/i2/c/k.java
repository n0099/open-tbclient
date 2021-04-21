package d.b.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class k extends d.b.c.j.e.a<d.b.j0.i2.e.k, CardViewHolder<d.b.j0.i2.j.i>> {
    public TbPageContext<?> m;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.i2.e.k.i);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.i2.j.i> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.i2.j.i(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.i2.e.k kVar, CardViewHolder<d.b.j0.i2.j.i> cardViewHolder) {
        cardViewHolder.b().n(kVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}

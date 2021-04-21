package d.b.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class m extends d.b.c.j.e.a<d.b.j0.i2.e.m, CardViewHolder<d.b.j0.i2.j.j>> {
    public TbPageContext<?> m;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.i2.e.m.f57586g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.i2.j.j> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.i2.j.j(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.i2.e.m mVar, CardViewHolder<d.b.j0.i2.j.j> cardViewHolder) {
        cardViewHolder.b().n(mVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}

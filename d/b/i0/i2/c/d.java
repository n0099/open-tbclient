package d.b.i0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class d extends d.b.c.j.e.a<d.b.i0.i2.e.e, CardViewHolder<d.b.i0.i2.j.d>> {
    public TbPageContext<?> m;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.i2.e.e.f57137h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.i2.j.d> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.i2.j.d(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.i2.e.e eVar, CardViewHolder<d.b.i0.i2.j.d> cardViewHolder) {
        cardViewHolder.b().n(eVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}

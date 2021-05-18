package d.a.k0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes5.dex */
public class a extends d.a.c.j.e.a<d.a.k0.i2.e.b, CardViewHolder<d.a.k0.i2.j.b>> {
    public TbPageContext<?> m;
    public LikeModel n;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.i2.e.b.p);
        this.m = tbPageContext;
        this.n = new LikeModel(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.k0.i2.j.b> P(ViewGroup viewGroup) {
        d.a.k0.i2.j.b bVar = new d.a.k0.i2.j.b(this.m);
        bVar.y(this.n);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.i2.e.b bVar, CardViewHolder<d.a.k0.i2.j.b> cardViewHolder) {
        cardViewHolder.b().m(bVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}

package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes5.dex */
public class a extends d.a.c.k.e.a<d.a.n0.j2.e.b, CardViewHolder<d.a.n0.j2.j.b>> {
    public TbPageContext<?> m;
    public LikeModel n;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.j2.e.b.p);
        this.m = tbPageContext;
        this.n = new LikeModel(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.b> Q(ViewGroup viewGroup) {
        d.a.n0.j2.j.b bVar = new d.a.n0.j2.j.b(this.m);
        bVar.z(this.n);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.b bVar, CardViewHolder<d.a.n0.j2.j.b> cardViewHolder) {
        cardViewHolder.b().n(bVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}

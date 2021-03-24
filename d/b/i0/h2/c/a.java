package d.b.i0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes5.dex */
public class a extends d.b.b.j.e.a<d.b.i0.h2.e.b, CardViewHolder<d.b.i0.h2.j.b>> {
    public TbPageContext<?> m;
    public LikeModel n;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.h2.e.b.p);
        this.m = tbPageContext;
        this.n = new LikeModel(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.h2.j.b> R(ViewGroup viewGroup) {
        d.b.i0.h2.j.b bVar = new d.b.i0.h2.j.b(this.m);
        bVar.A(this.n);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.h2.e.b bVar, CardViewHolder<d.b.i0.h2.j.b> cardViewHolder) {
        cardViewHolder.b().n(bVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}

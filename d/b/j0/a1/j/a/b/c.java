package d.b.j0.a1.j.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.a1.j.a.c.d;
import d.b.j0.a1.j.a.e.e;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<d, CardViewHolder<e>> {
    public TbPageContext<?> m;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.j);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<e> R(ViewGroup viewGroup) {
        e eVar = new e(this.m);
        eVar.r(this.i);
        return new CardViewHolder<>(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d dVar, CardViewHolder<e> cardViewHolder) {
        if (dVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(dVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}

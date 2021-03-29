package d.b.i0.p0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.b.a.j;
import d.b.i0.d0.g;
import d.b.i0.x.b0;
import d.b.i0.x.h;
/* loaded from: classes4.dex */
public class f extends d.b.b.j.e.a<g, CardViewHolder<h>> {
    public TbPageContext<?> m;
    public h n;
    public String o;

    /* loaded from: classes4.dex */
    public class a extends b0<g> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, g gVar) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 1).param("fid", f.this.o));
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(view.getContext()), new String[]{gVar.g().score_url}, true);
        }
    }

    public f(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), g.f53636f);
        this.m = tbPageContext;
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<h> R(ViewGroup viewGroup) {
        this.n = new h(this.m);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, g gVar, CardViewHolder<h> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(gVar);
        cardViewHolder.b().q(new a());
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.b().m();
    }
}

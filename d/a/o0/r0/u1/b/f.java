package d.a.o0.r0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.c.a.j;
import d.a.o0.e0.g;
import d.a.o0.z.b0;
import d.a.o0.z.h;
/* loaded from: classes4.dex */
public class f extends d.a.c.k.e.a<g, CardViewHolder<h>> {
    public TbPageContext<?> m;
    public h n;
    public String o;

    /* loaded from: classes4.dex */
    public class a extends b0<g> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, g gVar) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 1).param("fid", f.this.o));
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(view.getContext()), new String[]{gVar.c().score_url}, true);
        }
    }

    public f(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), g.f56588f);
        this.m = tbPageContext;
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<h> Q(ViewGroup viewGroup) {
        this.n = new h(this.m);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, g gVar, CardViewHolder<h> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(gVar);
        cardViewHolder.b().p(new a());
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.b().m();
    }
}

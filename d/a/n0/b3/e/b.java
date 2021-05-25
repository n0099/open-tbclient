package d.a.n0.b3.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.square.ForumSquareActivity;
import d.a.n0.b3.k.c;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class b extends d.a.c.j.e.a<d.a.n0.b3.f.b, CardViewHolder<c>> {
    public TbPageContext<?> m;
    public b0<d.a.n0.b3.f.b> n;

    /* loaded from: classes5.dex */
    public class a extends b0<d.a.n0.b3.f.b> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.b3.f.b bVar) {
            if (bVar != null && (b.this.m.getPageActivity() instanceof ForumSquareActivity)) {
                String f2 = ((ForumSquareActivity) b.this.m.getPageActivity()).getDelegate().f();
                if (!"推荐".equals(f2)) {
                    StatisticItem statisticItem = new StatisticItem("c13652");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", bVar.f52113e);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f2);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13643");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", bVar.f52113e);
                statisticItem2.param("obj_locate", 3);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.b3.f.b.l);
        this.n = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder<c> P(ViewGroup viewGroup) {
        c cVar = new c(this.m);
        cVar.p(this.f39232i);
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.b3.f.b bVar, CardViewHolder<c> cardViewHolder) {
        if (bVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(bVar);
        cardViewHolder.b().o(this.n);
        if (this.m.getPageActivity() instanceof ForumSquareActivity) {
            String f2 = ((ForumSquareActivity) this.m.getPageActivity()).getDelegate().f();
            if (!"推荐".equals(f2)) {
                StatisticItem statisticItem = new StatisticItem("c13651");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", bVar.f52113e);
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f2);
                TiebaStatic.log(statisticItem);
            } else {
                StatisticItem statisticItem2 = new StatisticItem("c13642");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", bVar.l());
                statisticItem2.param("obj_locate", 3);
                TiebaStatic.log(statisticItem2);
            }
        }
        return cardViewHolder.a();
    }
}

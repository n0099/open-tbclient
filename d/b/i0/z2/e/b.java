package d.b.i0.z2.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.square.ForumSquareActivity;
import d.b.i0.x.b0;
import d.b.i0.z2.k.c;
/* loaded from: classes5.dex */
public class b extends d.b.b.j.e.a<d.b.i0.z2.f.b, CardViewHolder<c>> {
    public TbPageContext<?> m;
    public b0<d.b.i0.z2.f.b> n;

    /* loaded from: classes5.dex */
    public class a extends b0<d.b.i0.z2.f.b> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.z2.f.b bVar) {
            if (bVar != null && (b.this.m.getPageActivity() instanceof ForumSquareActivity)) {
                String f2 = ((ForumSquareActivity) b.this.m.getPageActivity()).getDelegate().f();
                if (!"推荐".equals(f2)) {
                    StatisticItem statisticItem = new StatisticItem("c13652");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", bVar.f63475e);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f2);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13643");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", bVar.f63475e);
                statisticItem2.param("obj_locate", 3);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.z2.f.b.l);
        this.n = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<c> R(ViewGroup viewGroup) {
        c cVar = new c(this.m);
        cVar.r(this.i);
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.z2.f.b bVar, CardViewHolder<c> cardViewHolder) {
        if (bVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(bVar);
        cardViewHolder.b().q(this.n);
        if (this.m.getPageActivity() instanceof ForumSquareActivity) {
            String f2 = ((ForumSquareActivity) this.m.getPageActivity()).getDelegate().f();
            if (!"推荐".equals(f2)) {
                StatisticItem statisticItem = new StatisticItem("c13651");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", bVar.f63475e);
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f2);
                TiebaStatic.log(statisticItem);
            } else {
                StatisticItem statisticItem2 = new StatisticItem("c13642");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", bVar.j());
                statisticItem2.param("obj_locate", 3);
                TiebaStatic.log(statisticItem2);
            }
        }
        return cardViewHolder.a();
    }
}

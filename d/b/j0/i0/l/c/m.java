package d.b.j0.i0.l.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i0.r.q.u1;
/* loaded from: classes4.dex */
public class m extends d.b.c.j.e.a<u1, CardViewHolder<b>> {
    public TbPageContext<?> m;
    public String n;

    /* loaded from: classes4.dex */
    public class a implements w {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57244e;

        public a(b bVar) {
            this.f57244e = bVar;
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            this.f57244e.u();
            StatisticItem statisticItem = new StatisticItem("c13647");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", m.this.E(i) + 1);
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, m.this.n);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.b.j0.x.b<u1> {
        public TbPageContext<?> m;
        public TbImageView n;
        public String o;

        public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.m = tbPageContext;
            TbImageView tbImageView = (TbImageView) m().findViewById(R.id.image);
            this.n = tbImageView;
            tbImageView.setOnClickListener(this);
            this.n.setConrers(15);
            this.n.setScaleType(ImageView.ScaleType.FIT_XY);
            this.n.setRadius(d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.n.setDrawCorner(true);
            this.n.setAutoChangeStyle(true);
            this.n.setPlaceHolder(2);
        }

        @Override // d.b.j0.x.b
        public int h() {
            return R.layout.card_resources_item;
        }

        @Override // d.b.j0.x.b
        public void o(TbPageContext<?> tbPageContext, int i) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.n) {
                u();
            }
        }

        public void u() {
            if (TextUtils.isEmpty(this.o)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.m, new String[]{this.o});
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b
        /* renamed from: v */
        public void n(u1 u1Var) {
            if (u1Var != null) {
                this.o = u1Var.f51638f;
                this.n.setScaleType(ImageView.ScaleType.FIT_XY);
                this.n.setPlaceHolder(2);
                this.n.W(u1Var.f51637e, 10, false);
            }
            o(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
        this.n = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<b> R(ViewGroup viewGroup) {
        b bVar = new b(this.m, viewGroup);
        c0(new a(bVar));
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, u1 u1Var, CardViewHolder<b> cardViewHolder) {
        if (u1Var == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(u1Var);
        StatisticItem statisticItem = new StatisticItem("c13646");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_id", E(i) + 1);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.n);
        TiebaStatic.log(statisticItem);
        return cardViewHolder.b().m();
    }

    public void l0(s sVar) {
    }
}

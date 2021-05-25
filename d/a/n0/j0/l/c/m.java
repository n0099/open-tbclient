package d.a.n0.j0.l.c;

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
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.m0.r.q.u1;
/* loaded from: classes4.dex */
public class m extends d.a.c.j.e.a<u1, CardViewHolder<b>> {
    public TbPageContext<?> m;
    public String n;

    /* loaded from: classes4.dex */
    public class a implements w {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56067e;

        public a(b bVar) {
            this.f56067e = bVar;
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            this.f56067e.s();
            StatisticItem statisticItem = new StatisticItem("c13647");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", m.this.B(i2) + 1);
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, m.this.n);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.a.n0.z.b<u1> {
        public TbPageContext<?> m;
        public TbImageView n;
        public String o;

        public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.m = tbPageContext;
            TbImageView tbImageView = (TbImageView) l().findViewById(R.id.image);
            this.n = tbImageView;
            tbImageView.setOnClickListener(this);
            this.n.setConrers(15);
            this.n.setScaleType(ImageView.ScaleType.FIT_XY);
            this.n.setRadius(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.n.setDrawCorner(true);
            this.n.setAutoChangeStyle(true);
            this.n.setPlaceHolder(2);
        }

        @Override // d.a.n0.z.b
        public int g() {
            return R.layout.card_resources_item;
        }

        @Override // d.a.n0.z.b
        public void n(TbPageContext<?> tbPageContext, int i2) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.n) {
                s();
            }
        }

        public void s() {
            if (TextUtils.isEmpty(this.o)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.m, new String[]{this.o});
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b
        /* renamed from: t */
        public void m(u1 u1Var) {
            if (u1Var != null) {
                this.o = u1Var.f50134f;
                this.n.setScaleType(ImageView.ScaleType.FIT_XY);
                this.n.setPlaceHolder(2);
                this.n.V(u1Var.f50133e, 10, false);
            }
            n(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
        this.n = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder<b> P(ViewGroup viewGroup) {
        b bVar = new b(this.m, viewGroup);
        Z(new a(bVar));
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, u1 u1Var, CardViewHolder<b> cardViewHolder) {
        if (u1Var == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(u1Var);
        StatisticItem statisticItem = new StatisticItem("c13646");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_id", B(i2) + 1);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.n);
        TiebaStatic.log(statisticItem);
        return cardViewHolder.b().l();
    }

    public void h0(s sVar) {
    }
}

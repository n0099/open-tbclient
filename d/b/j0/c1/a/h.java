package d.b.j0.c1.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.b2;
import d.b.j0.c1.c.n;
import d.b.j0.x.b0;
import d.b.j0.x.v;
/* loaded from: classes4.dex */
public class h extends d.b.c.j.e.a<d.b.j0.x.e0.k, CardViewHolder<v>> {
    public TbPageContext<HotTopicActivity> m;
    public BdUniqueId n;
    public d.b.j0.x.e0.k o;
    public v p;
    public b0<b2> q;

    /* loaded from: classes4.dex */
    public class a extends b0<b2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            a2 a2Var;
            d.b.j0.x.e0.k kVar = h.this.o;
            if (kVar == null || (a2Var = kVar.f64193e) == null || StringUtils.isNull(a2Var.w1())) {
                return;
            }
            int i = 1;
            if ((h.this.p.z() == null || view.getId() != h.this.p.z().getId()) && (h.this.p.A() == null || view.getId() != h.this.p.A().getId())) {
                i = (h.this.p.q == null || view.getId() != h.this.p.q.getId()) ? 2 : 3;
            }
            String topicName = ((HotTopicActivity) h.this.m.getOrignalPage()).getTopicName();
            String hotTopicId = ((HotTopicActivity) h.this.m.getOrignalPage()).getHotTopicId();
            a2 n = kVar.n();
            TiebaStatic.log(new StatisticItem("c12941").param("obj_type", i).param("tid", n.o0()));
            if ("c10814".equals(kVar.M())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10814").param("tid", n.o0()).param("obj_name", topicName).param("topic_id", hotTopicId));
            } else if ("c10816".equals(kVar.M())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10816").param("post_id", n.w1()).param("obj_name", topicName).param("topic_id", hotTopicId));
            }
        }
    }

    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.m = tbPageContext;
        this.n = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public CardViewHolder<v> R(ViewGroup viewGroup) {
        v vVar = new v(this.m);
        this.p = vVar;
        vVar.J(this.n);
        this.p.L(false);
        v vVar2 = this.p;
        vVar2.l = 0;
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = vVar2.r;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.R = 0;
        }
        OriginalThreadCardView originalThreadCardView = this.p.q;
        if (originalThreadCardView != null) {
            originalThreadCardView.q = 0;
        }
        return new CardViewHolder<>(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.k kVar, CardViewHolder<v> cardViewHolder) {
        if (kVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        this.o = kVar;
        cardViewHolder.b().n(new b2(kVar.n()));
        cardViewHolder.b().q(this.q);
        ((v) ((CardViewHolder) this.k).b()).K(!(z(i + 1) instanceof n));
        return cardViewHolder.a();
    }
}

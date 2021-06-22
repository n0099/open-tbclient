package d.a.o0.d1.a;

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
import d.a.n0.r.q.a2;
import d.a.n0.r.q.b2;
import d.a.o0.d1.c.n;
import d.a.o0.z.b0;
import d.a.o0.z.v;
/* loaded from: classes4.dex */
public class h extends d.a.c.k.e.a<d.a.o0.z.e0.k, CardViewHolder<v>> {
    public TbPageContext<HotTopicActivity> m;
    public BdUniqueId n;
    public d.a.o0.z.e0.k o;
    public v p;
    public b0<b2> q;

    /* loaded from: classes4.dex */
    public class a extends b0<b2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            a2 a2Var;
            d.a.o0.z.e0.k kVar = h.this.o;
            if (kVar == null || (a2Var = kVar.f67302e) == null || StringUtils.isNull(a2Var.z1())) {
                return;
            }
            int i2 = 1;
            if ((h.this.p.y() == null || view.getId() != h.this.p.y().getId()) && (h.this.p.z() == null || view.getId() != h.this.p.z().getId())) {
                i2 = (h.this.p.q == null || view.getId() != h.this.p.q.getId()) ? 2 : 3;
            }
            String topicName = ((HotTopicActivity) h.this.m.getOrignalPage()).getTopicName();
            String hotTopicId = ((HotTopicActivity) h.this.m.getOrignalPage()).getHotTopicId();
            a2 i3 = kVar.i();
            TiebaStatic.log(new StatisticItem("c12941").param("obj_type", i2).param("tid", i3.o0()));
            if ("c10814".equals(kVar.M())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10814").param("tid", i3.o0()).param("obj_name", topicName).param("topic_id", hotTopicId));
            } else if ("c10816".equals(kVar.M())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10816").param("post_id", i3.z1()).param("obj_name", topicName).param("topic_id", hotTopicId));
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
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public CardViewHolder<v> Q(ViewGroup viewGroup) {
        v vVar = new v(this.m);
        this.p = vVar;
        vVar.I(this.n);
        this.p.K(false);
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
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, CardViewHolder<v> cardViewHolder) {
        if (kVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        this.o = kVar;
        cardViewHolder.b().n(new b2(kVar.i()));
        cardViewHolder.b().p(this.q);
        ((v) ((CardViewHolder) this.k).b()).J(!(z(i2 + 1) instanceof n));
        return cardViewHolder.a();
    }
}

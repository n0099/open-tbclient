package d.a.n0.b1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
/* loaded from: classes4.dex */
public class t extends d.a.c.j.e.a<d.a.n0.b1.j.b.c.a, ThreadCardViewHolder<d.a.n0.b1.j.b.c.a>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public NEGFeedBackView.b p;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.j.e.w {
        public a() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.b1.j.b.c.a) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.n0.b1.j.b.c.a aVar = (d.a.n0.b1.j.b.c.a) nVar;
                if (aVar != null && aVar.b0 != 1) {
                    TiebaStatic.log(new StatisticItem("c13351").param("topic_id", aVar.U).param("obj_locate", aVar.T));
                }
                if (aVar != null && aVar.b0 == 1) {
                    TiebaStatic.log(new StatisticItem("c13449").param("topic_id", aVar.U));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(t.this.f39228e, aVar.U)));
            }
        }
    }

    public t(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<d.a.n0.b1.j.b.c.a> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.n0.b1.g.n.d dVar = new d.a.n0.b1.g.n.d(this.f39228e, this.n);
        dVar.p(this.f39232i);
        bVar.n(dVar);
        bVar.l().a(0);
        bVar.l().b(0);
        bVar.l().c(0);
        bVar.l().e(0);
        bVar.l().d(0);
        l0 j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
        j.r(2);
        ThreadCardViewHolder<d.a.n0.b1.j.b.c.a> threadCardViewHolder = new ThreadCardViewHolder<>(j);
        threadCardViewHolder.j(this.m);
        Z(new a());
        return threadCardViewHolder;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.j.b.c.a aVar, ThreadCardViewHolder<d.a.n0.b1.j.b.c.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        TiebaStatic.log(new StatisticItem("c13448").param("topic_id", aVar.U));
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.o(false).u(this.p);
        threadCardViewHolder.f(aVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void h0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }
}

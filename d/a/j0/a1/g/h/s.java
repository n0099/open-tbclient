package d.a.j0.a1.g.h;

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
import d.a.i.k0;
/* loaded from: classes4.dex */
public class s extends d.a.c.j.e.a<d.a.j0.a1.j.b.c.a, ThreadCardViewHolder<d.a.j0.a1.j.b.c.a>> implements d.a.j0.m.f {
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
            if ((nVar instanceof d.a.j0.a1.j.b.c.a) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.j0.a1.j.b.c.a aVar = (d.a.j0.a1.j.b.c.a) nVar;
                if (aVar != null && aVar.a0 != 1) {
                    TiebaStatic.log(new StatisticItem("c13351").param("topic_id", aVar.T).param("obj_locate", aVar.S));
                }
                if (aVar != null && aVar.a0 == 1) {
                    TiebaStatic.log(new StatisticItem("c13449").param("topic_id", aVar.T));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(s.this.f40319e, aVar.T)));
            }
        }
    }

    public s(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<d.a.j0.a1.j.b.c.a> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.a.j0.a1.g.n.d dVar = new d.a.j0.a1.g.n.d(this.f40319e, this.n);
        dVar.p(this.f40323i);
        bVar.n(dVar);
        bVar.l().a(0);
        bVar.l().b(0);
        bVar.l().c(0);
        bVar.l().e(0);
        bVar.l().d(0);
        k0 j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
        j.r(2);
        ThreadCardViewHolder<d.a.j0.a1.j.b.c.a> threadCardViewHolder = new ThreadCardViewHolder<>(j);
        threadCardViewHolder.j(this.m);
        Z(new a());
        return threadCardViewHolder;
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.a1.j.b.c.a aVar, ThreadCardViewHolder<d.a.j0.a1.j.b.c.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        TiebaStatic.log(new StatisticItem("c13448").param("topic_id", aVar.T));
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

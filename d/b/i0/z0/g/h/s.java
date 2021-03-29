package d.b.i0.z0.g.h;

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
import d.b.i.k0;
/* loaded from: classes3.dex */
public class s extends d.b.b.j.e.a<d.b.i0.z0.j.b.c.a, ThreadCardViewHolder<d.b.i0.z0.j.b.c.a>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public NEGFeedBackView.b p;

    /* loaded from: classes3.dex */
    public class a implements d.b.b.j.e.w {
        public a() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.z0.j.b.c.a) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.b.i0.z0.j.b.c.a aVar = (d.b.i0.z0.j.b.c.a) nVar;
                if (aVar != null && aVar.a0 != 1) {
                    TiebaStatic.log(new StatisticItem("c13351").param("topic_id", aVar.T).param("obj_locate", aVar.S));
                }
                if (aVar != null && aVar.a0 == 1) {
                    TiebaStatic.log(new StatisticItem("c13449").param("topic_id", aVar.T));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(s.this.f42358e, aVar.T)));
            }
        }
    }

    public s(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<d.b.i0.z0.j.b.c.a> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i0.z0.g.n.d dVar = new d.b.i0.z0.g.n.d(this.f42358e, this.n);
        dVar.p(this.i);
        bVar.n(dVar);
        bVar.l().a(0);
        bVar.l().b(0);
        bVar.l().c(0);
        bVar.l().e(0);
        bVar.l().d(0);
        k0 j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
        j.r(2);
        ThreadCardViewHolder<d.b.i0.z0.j.b.c.a> threadCardViewHolder = new ThreadCardViewHolder<>(j);
        threadCardViewHolder.k(this.m);
        c0(new a());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.z0.j.b.c.a aVar, ThreadCardViewHolder<d.b.i0.z0.j.b.c.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        TiebaStatic.log(new StatisticItem("c13448").param("topic_id", aVar.T));
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.p(false).u(this.p);
        threadCardViewHolder.f(aVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public void l0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }
}

package d.b.j0.l0.z.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionEmptyViewHolder;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
/* loaded from: classes4.dex */
public class d extends d.b.c.j.e.a<d.b.j0.l0.z.b.a, ForumEmotionEmptyViewHolder> {
    public TbPageContext m;
    public a n;
    public d.b.j0.l0.z.b.b o;

    public d(TbPageContext<?> tbPageContext, d.b.j0.l0.z.b.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
        this.o = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ForumEmotionEmptyViewHolder R(ViewGroup viewGroup) {
        ForumEmotionEmptyView forumEmotionEmptyView = new ForumEmotionEmptyView(this.m);
        forumEmotionEmptyView.b(TbadkCoreApplication.getInst().getSkinType());
        return new ForumEmotionEmptyViewHolder(this.m, forumEmotionEmptyView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.l0.z.b.a aVar, ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder) {
        forumEmotionEmptyViewHolder.c(aVar, i, this.o, this.n);
        return forumEmotionEmptyViewHolder.a();
    }

    public void j0(a aVar) {
        this.n = aVar;
    }
}

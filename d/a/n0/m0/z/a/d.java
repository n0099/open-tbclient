package d.a.n0.m0.z.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionEmptyViewHolder;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<d.a.n0.m0.z.b.a, ForumEmotionEmptyViewHolder> {
    public TbPageContext m;
    public a n;
    public d.a.n0.m0.z.b.b o;

    public d(TbPageContext<?> tbPageContext, d.a.n0.m0.z.b.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
        this.o = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ForumEmotionEmptyViewHolder Q(ViewGroup viewGroup) {
        ForumEmotionEmptyView forumEmotionEmptyView = new ForumEmotionEmptyView(this.m);
        forumEmotionEmptyView.b(TbadkCoreApplication.getInst().getSkinType());
        return new ForumEmotionEmptyViewHolder(this.m, forumEmotionEmptyView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.m0.z.b.a aVar, ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder) {
        forumEmotionEmptyViewHolder.c(aVar, i2, this.o, this.n);
        return forumEmotionEmptyViewHolder.a();
    }

    public void h0(a aVar) {
        this.n = aVar;
    }
}

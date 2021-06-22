package d.a.o0.m0.z.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<d.a.o0.m0.z.b.c, ForumEmotionViewHolder> {
    public TbPageContext m;
    public d.a.o0.m0.z.b.b n;
    public a o;

    public b(TbPageContext<?> tbPageContext, d.a.o0.m0.z.b.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
        this.n = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ForumEmotionViewHolder Q(ViewGroup viewGroup) {
        ForumEmotionItemView forumEmotionItemView = new ForumEmotionItemView(this.m);
        ForumEmotionViewHolder forumEmotionViewHolder = new ForumEmotionViewHolder(this.m, forumEmotionItemView);
        forumEmotionItemView.b(TbadkCoreApplication.getInst().getSkinType());
        return forumEmotionViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.m0.z.b.c cVar, ForumEmotionViewHolder forumEmotionViewHolder) {
        forumEmotionViewHolder.m(cVar, this.n, this.o, i2);
        return forumEmotionViewHolder.a();
    }

    public void h0(a aVar) {
        this.o = aVar;
    }
}

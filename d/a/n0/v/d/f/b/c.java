package d.a.n0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabRecommendTitleView;
import d.a.n0.v.d.f.c.g;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<g, ConcernTabRecommendTitleView.ViewHolder> {
    public TbPageContext m;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), g.f65443g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ConcernTabRecommendTitleView.ViewHolder Q(ViewGroup viewGroup) {
        return new ConcernTabRecommendTitleView.ViewHolder(new ConcernTabRecommendTitleView(this.m, viewGroup).m());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, g gVar, ConcernTabRecommendTitleView.ViewHolder viewHolder) {
        if (viewHolder == null || gVar == null) {
            return null;
        }
        return viewHolder.a();
    }
}

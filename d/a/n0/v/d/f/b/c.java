package d.a.n0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabRecommendTitleView;
import d.a.n0.v.d.f.c.g;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<g, ConcernTabRecommendTitleView.ViewHolder> {
    public TbPageContext m;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), g.f61729g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ConcernTabRecommendTitleView.ViewHolder P(ViewGroup viewGroup) {
        return new ConcernTabRecommendTitleView.ViewHolder(new ConcernTabRecommendTitleView(this.m, viewGroup).l());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, g gVar, ConcernTabRecommendTitleView.ViewHolder viewHolder) {
        if (viewHolder == null || gVar == null) {
            return null;
        }
        return viewHolder.a();
    }
}

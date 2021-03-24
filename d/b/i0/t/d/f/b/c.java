package d.b.i0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabRecommendTitleView;
import d.b.i0.t.d.f.c.g;
/* loaded from: classes4.dex */
public class c extends d.b.b.j.e.a<g, ConcernTabRecommendTitleView.ViewHolder> {
    public TbPageContext m;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), g.f60543g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public ConcernTabRecommendTitleView.ViewHolder R(ViewGroup viewGroup) {
        return new ConcernTabRecommendTitleView.ViewHolder(new ConcernTabRecommendTitleView(this.m, viewGroup).m());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, g gVar, ConcernTabRecommendTitleView.ViewHolder viewHolder) {
        if (viewHolder == null || gVar == null) {
            return null;
        }
        return viewHolder.a();
    }
}

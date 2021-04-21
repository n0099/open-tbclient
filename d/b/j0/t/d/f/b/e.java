package d.b.j0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.RecommendActivityView;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<d.b.j0.t.d.f.c.c, RecommendActivityView.ViewHolder> {
    public TbPageContext m;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.t.d.f.c.c.f62519f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public RecommendActivityView.ViewHolder R(ViewGroup viewGroup) {
        return new RecommendActivityView.ViewHolder(new RecommendActivityView(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.d.f.c.c cVar, RecommendActivityView.ViewHolder viewHolder) {
        if (viewHolder == null || cVar == null) {
            return null;
        }
        viewHolder.f14598a.n(cVar);
        return viewHolder.a();
    }
}

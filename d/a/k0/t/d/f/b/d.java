package d.a.k0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.RecommendActivityView;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<d.a.k0.t.d.f.c.c, RecommendActivityView.ViewHolder> {
    public TbPageContext m;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.d.f.c.c.f61431f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public RecommendActivityView.ViewHolder P(ViewGroup viewGroup) {
        return new RecommendActivityView.ViewHolder(new RecommendActivityView(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.d.f.c.c cVar, RecommendActivityView.ViewHolder viewHolder) {
        if (viewHolder == null || cVar == null) {
            return null;
        }
        viewHolder.f13986a.m(cVar);
        return viewHolder.a();
    }
}

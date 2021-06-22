package d.a.o0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.RecommendActivityView;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<d.a.o0.v.d.f.c.c, RecommendActivityView.ViewHolder> {
    public TbPageContext m;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.d.f.c.c.f65558f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public RecommendActivityView.ViewHolder Q(ViewGroup viewGroup) {
        return new RecommendActivityView.ViewHolder(new RecommendActivityView(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.d.f.c.c cVar, RecommendActivityView.ViewHolder viewHolder) {
        if (viewHolder == null || cVar == null) {
            return null;
        }
        viewHolder.f14028a.n(cVar);
        return viewHolder.a();
    }
}

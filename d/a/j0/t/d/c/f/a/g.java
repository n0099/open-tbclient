package d.a.j0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernTitleView;
/* loaded from: classes4.dex */
public class g extends d.a.c.j.e.a<d.a.j0.t.d.f.c.g, LiveTabConcernTitleView.ViewHolder> {
    public TbPageContext m;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.t.d.f.c.g.f60717g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public LiveTabConcernTitleView.ViewHolder P(ViewGroup viewGroup) {
        return new LiveTabConcernTitleView.ViewHolder(new LiveTabConcernTitleView(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.d.f.c.g gVar, LiveTabConcernTitleView.ViewHolder viewHolder) {
        LiveTabConcernTitleView liveTabConcernTitleView;
        if (viewHolder == null || (liveTabConcernTitleView = viewHolder.f14543a) == null) {
            return null;
        }
        liveTabConcernTitleView.m(gVar);
        viewHolder.f14543a.n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return viewHolder.a();
    }
}

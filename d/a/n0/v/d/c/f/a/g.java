package d.a.n0.v.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernTitleView;
/* loaded from: classes4.dex */
public class g extends d.a.c.k.e.a<d.a.n0.v.d.f.c.g, LiveTabConcernTitleView.ViewHolder> {
    public TbPageContext m;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.d.f.c.g.f65443g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public LiveTabConcernTitleView.ViewHolder Q(ViewGroup viewGroup) {
        return new LiveTabConcernTitleView.ViewHolder(new LiveTabConcernTitleView(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.d.f.c.g gVar, LiveTabConcernTitleView.ViewHolder viewHolder) {
        LiveTabConcernTitleView liveTabConcernTitleView;
        if (viewHolder == null || (liveTabConcernTitleView = viewHolder.f13826a) == null) {
            return null;
        }
        liveTabConcernTitleView.n(gVar);
        viewHolder.f13826a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return viewHolder.a();
    }
}

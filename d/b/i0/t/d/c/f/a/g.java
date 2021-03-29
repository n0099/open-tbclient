package d.b.i0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernTitleView;
/* loaded from: classes4.dex */
public class g extends d.b.b.j.e.a<d.b.i0.t.d.f.c.g, LiveTabConcernTitleView.ViewHolder> {
    public TbPageContext m;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.f.c.g.f60544g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public LiveTabConcernTitleView.ViewHolder R(ViewGroup viewGroup) {
        return new LiveTabConcernTitleView.ViewHolder(new LiveTabConcernTitleView(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.f.c.g gVar, LiveTabConcernTitleView.ViewHolder viewHolder) {
        LiveTabConcernTitleView liveTabConcernTitleView;
        if (viewHolder == null || (liveTabConcernTitleView = viewHolder.f14801a) == null) {
            return null;
        }
        liveTabConcernTitleView.n(gVar);
        viewHolder.f14801a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return viewHolder.a();
    }
}

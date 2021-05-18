package d.a.k0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabLiveItemView;
import d.a.k0.t.d.f.c.f;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<f, ConcernTabLiveItemView.ViewHolder> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.f61437h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ConcernTabLiveItemView.ViewHolder P(ViewGroup viewGroup) {
        ConcernTabLiveItemView concernTabLiveItemView = new ConcernTabLiveItemView(this.m, viewGroup);
        concernTabLiveItemView.getClass();
        return new ConcernTabLiveItemView.ViewHolder(concernTabLiveItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, f fVar, ConcernTabLiveItemView.ViewHolder viewHolder) {
        if (viewHolder == null || fVar == null) {
            return null;
        }
        viewHolder.f13973a.m(fVar);
        return viewHolder.a();
    }
}

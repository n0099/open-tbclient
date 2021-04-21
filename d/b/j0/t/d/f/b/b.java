package d.b.j0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabLiveItemView;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.j0.t.d.f.c.f, ConcernTabLiveItemView.ViewHolder> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.t.d.f.c.f.f62525h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ConcernTabLiveItemView.ViewHolder R(ViewGroup viewGroup) {
        ConcernTabLiveItemView concernTabLiveItemView = new ConcernTabLiveItemView(this.m, viewGroup);
        concernTabLiveItemView.getClass();
        return new ConcernTabLiveItemView.ViewHolder(concernTabLiveItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.d.f.c.f fVar, ConcernTabLiveItemView.ViewHolder viewHolder) {
        if (viewHolder == null || fVar == null) {
            return null;
        }
        viewHolder.f14585a.n(fVar);
        return viewHolder.a();
    }
}

package d.a.o0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabLiveItemView;
import d.a.o0.v.d.f.c.f;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<f, ConcernTabLiveItemView.ViewHolder> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.f65564h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ConcernTabLiveItemView.ViewHolder Q(ViewGroup viewGroup) {
        ConcernTabLiveItemView concernTabLiveItemView = new ConcernTabLiveItemView(this.m, viewGroup);
        concernTabLiveItemView.getClass();
        return new ConcernTabLiveItemView.ViewHolder(concernTabLiveItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, f fVar, ConcernTabLiveItemView.ViewHolder viewHolder) {
        if (viewHolder == null || fVar == null) {
            return null;
        }
        viewHolder.f14015a.n(fVar);
        return viewHolder.a();
    }
}

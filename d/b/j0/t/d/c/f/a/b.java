package d.b.j0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernEmptyViewHolder;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.j0.t.d.f.c.e, LiveTabConcernEmptyViewHolder> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.t.d.f.c.e.f62523f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public LiveTabConcernEmptyViewHolder R(ViewGroup viewGroup) {
        return new LiveTabConcernEmptyViewHolder(new d.b.j0.t.d.c.f.d.b(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.d.f.c.e eVar, LiveTabConcernEmptyViewHolder liveTabConcernEmptyViewHolder) {
        d.b.j0.t.d.c.f.d.b bVar;
        if (liveTabConcernEmptyViewHolder == null || (bVar = liveTabConcernEmptyViewHolder.f14467a) == null) {
            return null;
        }
        bVar.n(eVar);
        return liveTabConcernEmptyViewHolder.a();
    }
}

package d.a.j0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernEmptyViewHolder;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.j0.t.d.f.c.e, LiveTabConcernEmptyViewHolder> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.t.d.f.c.e.f60711f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public LiveTabConcernEmptyViewHolder P(ViewGroup viewGroup) {
        return new LiveTabConcernEmptyViewHolder(new d.a.j0.t.d.c.f.d.b(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.d.f.c.e eVar, LiveTabConcernEmptyViewHolder liveTabConcernEmptyViewHolder) {
        d.a.j0.t.d.c.f.d.b bVar;
        if (liveTabConcernEmptyViewHolder == null || (bVar = liveTabConcernEmptyViewHolder.f14538a) == null) {
            return null;
        }
        bVar.m(eVar);
        return liveTabConcernEmptyViewHolder.a();
    }
}

package d.a.o0.v.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernEmptyViewHolder;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<d.a.o0.v.d.f.c.e, LiveTabConcernEmptyViewHolder> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.d.f.c.e.f65562f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public LiveTabConcernEmptyViewHolder Q(ViewGroup viewGroup) {
        return new LiveTabConcernEmptyViewHolder(new d.a.o0.v.d.c.f.d.b(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.d.f.c.e eVar, LiveTabConcernEmptyViewHolder liveTabConcernEmptyViewHolder) {
        d.a.o0.v.d.c.f.d.b bVar;
        if (liveTabConcernEmptyViewHolder == null || (bVar = liveTabConcernEmptyViewHolder.f13903a) == null) {
            return null;
        }
        bVar.n(eVar);
        return liveTabConcernEmptyViewHolder.a();
    }
}

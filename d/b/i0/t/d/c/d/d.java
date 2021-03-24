package d.b.i0.t.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabDoubleGameLiveViewHolder;
/* loaded from: classes4.dex */
public class d extends d.b.b.j.e.a<d.b.i0.t.d.c.e.e, TabDoubleGameLiveViewHolder> {
    public TbPageContext m;
    public d.b.i0.t.d.c.h.e n;
    public boolean o;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.c.e.e.f60327g);
        this.o = false;
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public TabDoubleGameLiveViewHolder R(ViewGroup viewGroup) {
        d.b.i0.t.d.c.h.e eVar = new d.b.i0.t.d.c.h.e(this.m, viewGroup);
        this.n = eVar;
        eVar.v(this.o);
        return new TabDoubleGameLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.c.e.e eVar, TabDoubleGameLiveViewHolder tabDoubleGameLiveViewHolder) {
        d.b.i0.t.d.c.h.e eVar2;
        if (tabDoubleGameLiveViewHolder == null || (eVar2 = tabDoubleGameLiveViewHolder.f14810a) == null) {
            return null;
        }
        eVar2.n(eVar);
        tabDoubleGameLiveViewHolder.f14810a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return tabDoubleGameLiveViewHolder.a();
    }

    public void j0(boolean z) {
        this.o = z;
    }
}

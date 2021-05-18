package d.a.k0.s2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.FrsAppEmptyHolder;
import d.a.j0.r.q.a2;
import d.a.k0.q0.k;
import d.a.k0.s2.t;
import d.a.k0.s2.u;
/* loaded from: classes5.dex */
public class c extends k<a2, FrsAppEmptyHolder> implements t {
    public c(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.o(), bdUniqueId);
    }

    @Override // d.a.k0.s2.t
    public void j(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public FrsAppEmptyHolder P(ViewGroup viewGroup) {
        View view = new View(this.o.getPageActivity());
        view.setVisibility(8);
        return new FrsAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: t0 */
    public View W(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsAppEmptyHolder frsAppEmptyHolder) {
        if (a2Var instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2Var;
            d.a.j0.r.q.d.c(advertAppInfo.O3, a2Var.position, advertAppInfo.H3 == -1001);
        }
        return frsAppEmptyHolder.a();
    }
}

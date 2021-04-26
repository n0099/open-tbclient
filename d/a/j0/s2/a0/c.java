package d.a.j0.s2.a0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.FrsAppEmptyHolder;
import d.a.i0.r.q.a2;
import d.a.j0.q0.k;
import d.a.j0.s2.s;
import d.a.j0.s2.t;
/* loaded from: classes3.dex */
public class c extends k<a2, FrsAppEmptyHolder> implements s {
    public c(t tVar, BdUniqueId bdUniqueId) {
        super(tVar.o(), bdUniqueId);
    }

    @Override // d.a.j0.s2.s
    public void j(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public FrsAppEmptyHolder P(ViewGroup viewGroup) {
        View view = new View(this.o.getPageActivity());
        view.setVisibility(8);
        return new FrsAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: u0 */
    public View W(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsAppEmptyHolder frsAppEmptyHolder) {
        if (a2Var instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2Var;
            if (g0()) {
                a2Var.position = i2 - this.n.getTopThreadSize();
            }
            d.a.i0.r.q.d.c(advertAppInfo.Y3, a2Var.position, advertAppInfo.U3.f12794h == -1001);
        }
        return frsAppEmptyHolder.a();
    }
}

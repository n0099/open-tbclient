package d.b.j0.s2.z;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.FrsAppEmptyHolder;
import d.b.i0.r.q.a2;
import d.b.j0.q0.k;
import d.b.j0.s2.s;
import d.b.j0.s2.t;
/* loaded from: classes4.dex */
public class c extends k<a2, FrsAppEmptyHolder> implements s {
    public c(t tVar, BdUniqueId bdUniqueId) {
        super(tVar.q(), bdUniqueId);
    }

    @Override // d.b.j0.s2.s
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public FrsAppEmptyHolder R(ViewGroup viewGroup) {
        View view = new View(this.o.getPageActivity());
        view.setVisibility(8);
        return new FrsAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    /* renamed from: u0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, FrsAppEmptyHolder frsAppEmptyHolder) {
        if (a2Var instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2Var;
            if (j0()) {
                a2Var.position = i - this.n.getTopThreadSize();
            }
            d.b.i0.r.q.d.c(advertAppInfo.Y3, a2Var.position, advertAppInfo.U3.f12879h == -1001);
        }
        return frsAppEmptyHolder.a();
    }
}

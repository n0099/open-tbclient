package d.a.n0.t2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.FrsAppEmptyHolder;
import d.a.m0.r.q.a2;
import d.a.n0.r0.k;
import d.a.n0.t2.t;
import d.a.n0.t2.u;
/* loaded from: classes5.dex */
public class c extends k<a2, FrsAppEmptyHolder> implements t {
    public c(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.p(), bdUniqueId);
    }

    @Override // d.a.n0.t2.t
    public void k(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public FrsAppEmptyHolder Q(ViewGroup viewGroup) {
        View view = new View(this.o.getPageActivity());
        view.setVisibility(8);
        return new FrsAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: t0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsAppEmptyHolder frsAppEmptyHolder) {
        if (a2Var instanceof AdvertAppInfo) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2Var;
            d.a.m0.r.q.d.c(advertAppInfo.S3, a2Var.position, advertAppInfo.L3 == -1001);
        }
        return frsAppEmptyHolder.a();
    }
}

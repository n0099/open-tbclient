package d.a.n0.t2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.PbAppEmptyHolder;
import d.a.n0.e3.h0.o;
import d.a.n0.t2.t;
/* loaded from: classes5.dex */
public class e extends d.a.c.j.e.a<o, PbAppEmptyHolder> implements t {
    public BaseFragmentActivity m;

    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.m = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public PbAppEmptyHolder P(ViewGroup viewGroup) {
        View view = new View(this.m.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new PbAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, o oVar, PbAppEmptyHolder pbAppEmptyHolder) {
        AdvertAppInfo advertAppInfo = oVar.getAdvertAppInfo();
        if (advertAppInfo != null) {
            d.a.m0.r.q.d.g(advertAppInfo.P3, oVar.getPosition(), advertAppInfo.I3 == -1001);
        }
        return pbAppEmptyHolder.a();
    }

    @Override // d.a.n0.t2.t
    public void j(boolean z) {
    }
}

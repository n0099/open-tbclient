package d.a.j0.s2.a0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recapp.adapter.PbAppEmptyHolder;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.a.j0.d3.h0.o;
import d.a.j0.s2.s;
/* loaded from: classes3.dex */
public class e extends d.a.c.j.e.a<o, PbAppEmptyHolder> implements s {
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
        AppData D0 = oVar.D0();
        if (D0 != null) {
            d.a.i0.r.q.d dVar = D0.advertAppContext;
            AppData.AppGoods appGoods = D0.goods;
            boolean z = false;
            if (appGoods != null && appGoods.goods_style == -1001) {
                z = true;
            }
            d.a.i0.r.q.d.g(dVar, oVar.getPosition(), z);
        }
        return pbAppEmptyHolder.a();
    }

    @Override // d.a.j0.s2.s
    public void j(boolean z) {
    }
}

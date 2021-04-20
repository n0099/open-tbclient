package d.b.i0.s2.z;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recapp.adapter.PbAppEmptyHolder;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.d3.h0.o;
import d.b.i0.s2.s;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<o, PbAppEmptyHolder> implements s {
    public BaseFragmentActivity m;

    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.m = baseFragmentActivity;
    }

    @Override // d.b.i0.s2.s
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public PbAppEmptyHolder R(ViewGroup viewGroup) {
        View view = new View(this.m.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new PbAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, o oVar, PbAppEmptyHolder pbAppEmptyHolder) {
        AppData D0 = oVar.D0();
        if (D0 != null) {
            d.b.h0.r.q.d dVar = D0.advertAppContext;
            AppData.AppGoods appGoods = D0.goods;
            boolean z = false;
            if (appGoods != null && appGoods.goods_style == -1001) {
                z = true;
            }
            d.b.h0.r.q.d.g(dVar, oVar.getPosition(), z);
        }
        return pbAppEmptyHolder.a();
    }
}

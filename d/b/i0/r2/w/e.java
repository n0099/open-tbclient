package d.b.i0.r2.w;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recapp.adapter.PbAppEmptyHolder;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.c3.h0.o;
import d.b.i0.r2.p;
/* loaded from: classes5.dex */
public class e extends d.b.b.j.e.a<o, PbAppEmptyHolder> implements p {
    public BaseFragmentActivity m;

    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.m = baseFragmentActivity;
    }

    @Override // d.b.i0.r2.p
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public PbAppEmptyHolder R(ViewGroup viewGroup) {
        View view = new View(this.m.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new PbAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, o oVar, PbAppEmptyHolder pbAppEmptyHolder) {
        AppData B0 = oVar.B0();
        if (B0 != null) {
            d.b.h0.r.q.d dVar = B0.advertAppContext;
            AppData.AppGoods appGoods = B0.goods;
            boolean z = false;
            if (appGoods != null && appGoods.goods_style == -1001) {
                z = true;
            }
            d.b.h0.r.q.d.g(dVar, oVar.getPosition(), z);
        }
        return pbAppEmptyHolder.a();
    }
}

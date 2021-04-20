package d.b.i0.s2.z;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.CardAdvertAppEmptyHolder;
import d.b.i0.s2.s;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<d.b.i0.x.e0.d, CardAdvertAppEmptyHolder> implements s {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    @Override // d.b.i0.s2.s
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardAdvertAppEmptyHolder R(ViewGroup viewGroup) {
        View view = new View(this.m.getPageActivity());
        view.setVisibility(8);
        return new CardAdvertAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.d dVar, CardAdvertAppEmptyHolder cardAdvertAppEmptyHolder) {
        AdvertAppInfo g2 = dVar.g();
        if (g2 != null) {
            d.b.h0.r.q.d.e(g2.Y3, dVar.position, g2.U3.f12871h == -1001);
        }
        return cardAdvertAppEmptyHolder.a();
    }
}

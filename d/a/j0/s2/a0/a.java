package d.a.j0.s2.a0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.CardAdvertAppEmptyHolder;
import d.a.j0.s2.s;
/* loaded from: classes3.dex */
public class a extends d.a.c.j.e.a<d.a.j0.x.e0.d, CardAdvertAppEmptyHolder> implements s {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardAdvertAppEmptyHolder P(ViewGroup viewGroup) {
        View view = new View(this.m.getPageActivity());
        view.setVisibility(8);
        return new CardAdvertAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.d dVar, CardAdvertAppEmptyHolder cardAdvertAppEmptyHolder) {
        AdvertAppInfo h2 = dVar.h();
        if (h2 != null) {
            d.a.i0.r.q.d.e(h2.Y3, dVar.position, h2.U3.f12794h == -1001);
        }
        return cardAdvertAppEmptyHolder.a();
    }

    @Override // d.a.j0.s2.s
    public void j(boolean z) {
    }
}

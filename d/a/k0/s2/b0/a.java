package d.a.k0.s2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.CardAdvertAppEmptyHolder;
import d.a.k0.s2.t;
/* loaded from: classes5.dex */
public class a extends d.a.c.j.e.a<d.a.k0.x.e0.d, CardAdvertAppEmptyHolder> implements t {
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.d dVar, CardAdvertAppEmptyHolder cardAdvertAppEmptyHolder) {
        AdvertAppInfo h2 = dVar.h();
        if (h2 != null) {
            d.a.j0.r.q.d.e(h2.O3, dVar.position, h2.H3 == -1001);
        }
        return cardAdvertAppEmptyHolder.a();
    }

    @Override // d.a.k0.s2.t
    public void j(boolean z) {
    }
}

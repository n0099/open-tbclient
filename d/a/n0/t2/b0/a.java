package d.a.n0.t2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.CardAdvertAppEmptyHolder;
import d.a.n0.t2.t;
/* loaded from: classes5.dex */
public class a extends d.a.c.k.e.a<d.a.n0.z.e0.d, CardAdvertAppEmptyHolder> implements t {
    public TbPageContext<?> m;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardAdvertAppEmptyHolder Q(ViewGroup viewGroup) {
        View view = new View(this.m.getPageActivity());
        view.setVisibility(8);
        return new CardAdvertAppEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.d dVar, CardAdvertAppEmptyHolder cardAdvertAppEmptyHolder) {
        AdvertAppInfo c2 = dVar.c();
        if (c2 != null) {
            d.a.m0.r.q.d.e(c2.S3, dVar.position, c2.L3 == -1001);
        }
        return cardAdvertAppEmptyHolder.a();
    }

    @Override // d.a.n0.t2.t
    public void k(boolean z) {
    }
}

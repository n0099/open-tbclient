package d.a.k0.t.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import d.a.k0.t.d.c.e.e;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<e, SdkDoubleLiveViewHolder> {
    public TbPageContext m;
    public d.a.k0.t.d.c.h.e n;
    public int o;
    public boolean p;

    public d(TbPageContext tbPageContext, int i2, boolean z) {
        super(tbPageContext.getPageActivity(), z ? e.f61215h : e.f61214g);
        this.m = tbPageContext;
        this.o = i2;
        this.p = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public SdkDoubleLiveViewHolder P(ViewGroup viewGroup) {
        this.n = new d.a.k0.t.d.c.h.e(this.m, viewGroup, this.o, this.p);
        return new SdkDoubleLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, e eVar, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        d.a.k0.t.d.c.h.e eVar2;
        if (sdkDoubleLiveViewHolder == null || (eVar2 = sdkDoubleLiveViewHolder.f13866a) == null) {
            return null;
        }
        eVar2.m(eVar);
        sdkDoubleLiveViewHolder.f13866a.n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return sdkDoubleLiveViewHolder.a();
    }
}

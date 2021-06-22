package d.a.o0.v.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import d.a.o0.v.d.c.e.e;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<e, SdkDoubleLiveViewHolder> {
    public TbPageContext m;
    public d.a.o0.v.d.c.h.e n;
    public int o;
    public boolean p;

    public d(TbPageContext tbPageContext, int i2, boolean z) {
        super(tbPageContext.getPageActivity(), z ? e.f65341h : e.f65340g);
        this.m = tbPageContext;
        this.o = i2;
        this.p = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public SdkDoubleLiveViewHolder Q(ViewGroup viewGroup) {
        this.n = new d.a.o0.v.d.c.h.e(this.m, viewGroup, this.o, this.p);
        return new SdkDoubleLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, e eVar, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        d.a.o0.v.d.c.h.e eVar2;
        if (sdkDoubleLiveViewHolder == null || (eVar2 = sdkDoubleLiveViewHolder.f13916a) == null) {
            return null;
        }
        eVar2.n(eVar);
        sdkDoubleLiveViewHolder.f13916a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return sdkDoubleLiveViewHolder.a();
    }
}

package d.b.j0.t.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import d.b.j0.t.d.c.h.f;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<d.b.j0.t.d.c.e.e, SdkDoubleLiveViewHolder> {
    public TbPageContext m;
    public f n;
    public int o;

    public e(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getPageActivity(), d.b.j0.t.d.c.e.e.f62313g);
        this.m = tbPageContext;
        this.o = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public SdkDoubleLiveViewHolder R(ViewGroup viewGroup) {
        this.n = new f(this.m, viewGroup, this.o);
        return new SdkDoubleLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.d.c.e.e eVar, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        f fVar;
        if (sdkDoubleLiveViewHolder == null || (fVar = sdkDoubleLiveViewHolder.f14480a) == null) {
            return null;
        }
        fVar.n(eVar);
        sdkDoubleLiveViewHolder.f14480a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return sdkDoubleLiveViewHolder.a();
    }
}

package d.a.n0.v.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.StageLiveViewHolder;
import d.a.n0.v.d.c.e.f;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<f, StageLiveViewHolder> {
    public TbPageContext m;
    public d.a.n0.v.d.c.h.c n;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.f65219f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public StageLiveViewHolder Q(ViewGroup viewGroup) {
        this.n = new d.a.n0.v.d.c.h.c(this.m, viewGroup);
        return new StageLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, f fVar, StageLiveViewHolder stageLiveViewHolder) {
        d.a.n0.v.d.c.h.c cVar;
        if (stageLiveViewHolder == null || (cVar = stageLiveViewHolder.f13835a) == null) {
            return null;
        }
        cVar.n(fVar);
        stageLiveViewHolder.f13835a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return stageLiveViewHolder.a();
    }
}

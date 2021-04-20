package d.b.i0.t.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.StageLiveViewHolder;
import d.b.i0.t.d.c.e.f;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<f, StageLiveViewHolder> {
    public TbPageContext m;
    public d.b.i0.t.d.c.h.c n;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.f61895f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public StageLiveViewHolder R(ViewGroup viewGroup) {
        this.n = new d.b.i0.t.d.c.h.c(this.m, viewGroup);
        return new StageLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, f fVar, StageLiveViewHolder stageLiveViewHolder) {
        d.b.i0.t.d.c.h.c cVar;
        if (stageLiveViewHolder == null || (cVar = stageLiveViewHolder.f14473a) == null) {
            return null;
        }
        cVar.n(fVar);
        stageLiveViewHolder.f14473a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return stageLiveViewHolder.a();
    }
}

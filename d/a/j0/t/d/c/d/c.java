package d.a.j0.t.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.StageLiveViewHolder;
import d.a.j0.t.d.c.e.f;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<f, StageLiveViewHolder> {
    public TbPageContext m;
    public d.a.j0.t.d.c.h.c n;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.f60494f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public StageLiveViewHolder P(ViewGroup viewGroup) {
        this.n = new d.a.j0.t.d.c.h.c(this.m, viewGroup);
        return new StageLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, f fVar, StageLiveViewHolder stageLiveViewHolder) {
        d.a.j0.t.d.c.h.c cVar;
        if (stageLiveViewHolder == null || (cVar = stageLiveViewHolder.f14552a) == null) {
            return null;
        }
        cVar.m(fVar);
        stageLiveViewHolder.f14552a.n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return stageLiveViewHolder.a();
    }
}

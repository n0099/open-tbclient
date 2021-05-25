package d.a.n0.v.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.StageLiveViewHolder;
import d.a.n0.v.d.c.e.f;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<f, StageLiveViewHolder> {
    public TbPageContext m;
    public d.a.n0.v.d.c.h.c n;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.f61506f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public StageLiveViewHolder P(ViewGroup viewGroup) {
        this.n = new d.a.n0.v.d.c.h.c(this.m, viewGroup);
        return new StageLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, f fVar, StageLiveViewHolder stageLiveViewHolder) {
        d.a.n0.v.d.c.h.c cVar;
        if (stageLiveViewHolder == null || (cVar = stageLiveViewHolder.f13770a) == null) {
            return null;
        }
        cVar.m(fVar);
        stageLiveViewHolder.f13770a.n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return stageLiveViewHolder.a();
    }
}

package d.a.d.l;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.adapter.FacadeEmptyViewHolder;
import com.baidu.tbadk.TbPageContext;
import d.a.d.d;
/* loaded from: classes.dex */
public class b extends d.a.c.j.e.a<d, FacadeEmptyViewHolder> {
    public TbPageContext<?> m;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public FacadeEmptyViewHolder P(ViewGroup viewGroup) {
        View view = new View(this.m.getPageActivity());
        view.setVisibility(8);
        return new FacadeEmptyViewHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d dVar, FacadeEmptyViewHolder facadeEmptyViewHolder) {
        d.a.i0.r.q.d.h(dVar);
        return facadeEmptyViewHolder.a();
    }
}

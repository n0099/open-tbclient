package d.b.d.l;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.adapter.FacadeEmptyViewHolder;
import com.baidu.tbadk.TbPageContext;
import d.b.d.d;
/* loaded from: classes.dex */
public class b extends d.b.c.j.e.a<d, FacadeEmptyViewHolder> {
    public TbPageContext<?> m;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public FacadeEmptyViewHolder R(ViewGroup viewGroup) {
        View view = new View(this.m.getPageActivity());
        view.setVisibility(8);
        return new FacadeEmptyViewHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d dVar, FacadeEmptyViewHolder facadeEmptyViewHolder) {
        d.b.i0.r.q.d.h(dVar);
        return facadeEmptyViewHolder.a();
    }
}

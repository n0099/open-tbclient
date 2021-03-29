package d.b.i0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabEmptyView;
/* loaded from: classes4.dex */
public class a extends d.b.b.j.e.a<d.b.i0.t.d.f.c.e, ConcernTabEmptyView.ViewHolder> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.f.c.e.f60538f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public ConcernTabEmptyView.ViewHolder R(ViewGroup viewGroup) {
        return new ConcernTabEmptyView.ViewHolder(new ConcernTabEmptyView(this.m, viewGroup).m());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.f.c.e eVar, ConcernTabEmptyView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        return viewHolder.a();
    }
}

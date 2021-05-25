package d.a.n0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabEmptyView;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.n0.v.d.f.c.e, ConcernTabEmptyView.ViewHolder> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.d.f.c.e.f61723f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ConcernTabEmptyView.ViewHolder P(ViewGroup viewGroup) {
        return new ConcernTabEmptyView.ViewHolder(new ConcernTabEmptyView(this.m, viewGroup).l());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.d.f.c.e eVar, ConcernTabEmptyView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        return viewHolder.a();
    }
}

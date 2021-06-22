package d.a.o0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabEmptyView;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.o0.v.d.f.c.e, ConcernTabEmptyView.ViewHolder> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.d.f.c.e.f65562f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ConcernTabEmptyView.ViewHolder Q(ViewGroup viewGroup) {
        return new ConcernTabEmptyView.ViewHolder(new ConcernTabEmptyView(this.m, viewGroup).m());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.d.f.c.e eVar, ConcernTabEmptyView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        return viewHolder.a();
    }
}

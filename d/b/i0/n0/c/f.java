package d.b.i0.n0.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.forumMember.member.FrsEmpertyItemViewHolder;
/* loaded from: classes4.dex */
public class f extends d.b.i0.p0.k<d.b.i0.p0.n, FrsEmpertyItemViewHolder> {
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i, view, viewGroup, (d.b.i0.p0.n) obj, (FrsEmpertyItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: t0 */
    public FrsEmpertyItemViewHolder R(ViewGroup viewGroup) {
        return new FrsEmpertyItemViewHolder(new View(this.f42358e));
    }

    public View u0(int i, View view, ViewGroup viewGroup, d.b.i0.p0.n nVar, FrsEmpertyItemViewHolder frsEmpertyItemViewHolder) {
        super.X(i, view, viewGroup, nVar, frsEmpertyItemViewHolder);
        frsEmpertyItemViewHolder.c(nVar.e());
        frsEmpertyItemViewHolder.b(nVar.a());
        return view;
    }
}

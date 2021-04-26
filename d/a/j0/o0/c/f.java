package d.a.j0.o0.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.forumMember.member.FrsEmpertyItemViewHolder;
/* loaded from: classes4.dex */
public class f extends d.a.j0.q0.k<d.a.j0.q0.n, FrsEmpertyItemViewHolder> {
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i2, view, viewGroup, (d.a.j0.q0.n) obj, (FrsEmpertyItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public FrsEmpertyItemViewHolder P(ViewGroup viewGroup) {
        return new FrsEmpertyItemViewHolder(new View(this.f40319e));
    }

    public View u0(int i2, View view, ViewGroup viewGroup, d.a.j0.q0.n nVar, FrsEmpertyItemViewHolder frsEmpertyItemViewHolder) {
        super.W(i2, view, viewGroup, nVar, frsEmpertyItemViewHolder);
        frsEmpertyItemViewHolder.c(nVar.e());
        frsEmpertyItemViewHolder.b(nVar.c());
        return view;
    }
}

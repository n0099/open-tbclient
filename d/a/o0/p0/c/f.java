package d.a.o0.p0.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.forumMember.member.FrsEmpertyItemViewHolder;
/* loaded from: classes4.dex */
public class f extends d.a.o0.r0.k<d.a.o0.r0.n, FrsEmpertyItemViewHolder> {
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (d.a.o0.r0.n) obj, (FrsEmpertyItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public FrsEmpertyItemViewHolder Q(ViewGroup viewGroup) {
        return new FrsEmpertyItemViewHolder(new View(this.f43012e));
    }

    public View t0(int i2, View view, ViewGroup viewGroup, d.a.o0.r0.n nVar, FrsEmpertyItemViewHolder frsEmpertyItemViewHolder) {
        super.X(i2, view, viewGroup, nVar, frsEmpertyItemViewHolder);
        frsEmpertyItemViewHolder.c(nVar.c());
        frsEmpertyItemViewHolder.b(nVar.b());
        return view;
    }
}

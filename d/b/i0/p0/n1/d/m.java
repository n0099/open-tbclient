package d.b.i0.p0.n1.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.view.ReadProgressViewHolder;
/* loaded from: classes4.dex */
public class m extends d.b.i0.p0.k<d.b.i0.p0.v, ReadProgressViewHolder> {
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i, view, viewGroup, (d.b.i0.p0.v) obj, (ReadProgressViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: t0 */
    public ReadProgressViewHolder R(ViewGroup viewGroup) {
        return new ReadProgressViewHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.frs_read_progress_item, viewGroup, false), this.o.getPageActivity());
    }

    public View u0(int i, View view, ViewGroup viewGroup, d.b.i0.p0.v vVar, ReadProgressViewHolder readProgressViewHolder) {
        if (vVar != null && readProgressViewHolder != null) {
            readProgressViewHolder.c(vVar);
        }
        return view;
    }
}

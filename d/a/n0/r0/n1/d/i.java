package d.a.n0.r0.n1.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.view.ReadProgressViewHolder;
/* loaded from: classes4.dex */
public class i extends d.a.n0.r0.k<d.a.n0.r0.v, ReadProgressViewHolder> {
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (d.a.n0.r0.v) obj, (ReadProgressViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public ReadProgressViewHolder P(ViewGroup viewGroup) {
        return new ReadProgressViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.frs_read_progress_item, viewGroup, false), this.o.getPageActivity());
    }

    public View t0(int i2, View view, ViewGroup viewGroup, d.a.n0.r0.v vVar, ReadProgressViewHolder readProgressViewHolder) {
        if (vVar != null && readProgressViewHolder != null) {
            readProgressViewHolder.c(vVar);
        }
        return view;
    }
}

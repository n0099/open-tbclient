package d.b.i0.p0.r1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.frsfeedforums.FrsFeedItemViewHolder;
import d.b.i0.c3.l;
import d.b.i0.p0.k;
/* loaded from: classes4.dex */
public class c extends k<l, FrsFeedItemViewHolder> {
    public a w;
    public boolean x;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.x = z;
    }

    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i, view, viewGroup, (l) obj, (FrsFeedItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: t0 */
    public FrsFeedItemViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42357e).inflate(R.layout.frs_feed_item_layout, (ViewGroup) null);
        this.w = new a(this.o, inflate, 2, this.x, this.i);
        return new FrsFeedItemViewHolder(inflate);
    }

    public View u0(int i, View view, ViewGroup viewGroup, l lVar, FrsFeedItemViewHolder frsFeedItemViewHolder) {
        super.X(i, view, viewGroup, lVar, frsFeedItemViewHolder);
        if (lVar != null) {
            this.w.o(lVar.e(), lVar.a());
        }
        return view;
    }
}

package d.a.n0.r0.r1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.frsfeedforums.FrsFeedItemViewHolder;
import d.a.n0.e3.l;
import d.a.n0.r0.k;
/* loaded from: classes4.dex */
public class c extends k<l, FrsFeedItemViewHolder> {
    public a w;
    public boolean x;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.x = z;
    }

    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (l) obj, (FrsFeedItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public FrsFeedItemViewHolder Q(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42909e).inflate(R.layout.frs_feed_item_layout, (ViewGroup) null);
        this.w = new a(this.o, inflate, 2, this.x, this.f42913i);
        return new FrsFeedItemViewHolder(inflate);
    }

    public View t0(int i2, View view, ViewGroup viewGroup, l lVar, FrsFeedItemViewHolder frsFeedItemViewHolder) {
        super.X(i2, view, viewGroup, lVar, frsFeedItemViewHolder);
        if (lVar != null) {
            this.w.o(lVar.c(), lVar.b());
        }
        return view;
    }
}

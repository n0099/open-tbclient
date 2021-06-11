package d.a.n0.e2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder;
/* loaded from: classes5.dex */
public class b0 extends o<d.a.n0.e2.h.j, PbLoadMoreItemViewHolder> {
    public BdUniqueId s;
    public View.OnClickListener t;

    public b0(d.a.n0.e2.o.i iVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(iVar, bdUniqueId);
        this.s = bdUniqueId2;
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (d.a.n0.e2.h.j) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbLoadMoreItemViewHolder Q(ViewGroup viewGroup) {
        return new PbLoadMoreItemViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.new_pb_list_more, viewGroup, false), this.s);
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.n0.e2.h.j jVar, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        super.X(i2, view, viewGroup, jVar, pbLoadMoreItemViewHolder);
        pbLoadMoreItemViewHolder.e(jVar.f56628e, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104));
        pbLoadMoreItemViewHolder.d(this.t);
        pbLoadMoreItemViewHolder.c();
        return view;
    }

    public void j0(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }
}

package d.a.k0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder;
/* loaded from: classes5.dex */
public class b0 extends o<d.a.k0.d2.h.j, PbLoadMoreItemViewHolder> {
    public BdUniqueId s;
    public View.OnClickListener t;

    public b0(d.a.k0.d2.o.i iVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(iVar, bdUniqueId);
        this.s = bdUniqueId2;
    }

    @Override // d.a.k0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, (d.a.k0.d2.h.j) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public PbLoadMoreItemViewHolder P(ViewGroup viewGroup) {
        return new PbLoadMoreItemViewHolder(LayoutInflater.from(this.f39564e).inflate(R.layout.new_pb_list_more, viewGroup, false), this.s);
    }

    public View h0(int i2, View view, ViewGroup viewGroup, d.a.k0.d2.h.j jVar, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        super.W(i2, view, viewGroup, jVar, pbLoadMoreItemViewHolder);
        pbLoadMoreItemViewHolder.e(jVar.f52734e, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104));
        pbLoadMoreItemViewHolder.d(this.t);
        pbLoadMoreItemViewHolder.c();
        return view;
    }

    public void i0(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }
}

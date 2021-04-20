package d.b.i0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder;
/* loaded from: classes3.dex */
public class b0 extends o<d.b.i0.d2.h.j, PbLoadMoreItemViewHolder> {
    public BdUniqueId s;
    public View.OnClickListener t;

    public b0(d.b.i0.d2.o.i iVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(iVar, bdUniqueId);
        this.s = bdUniqueId2;
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (d.b.i0.d2.h.j) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public PbLoadMoreItemViewHolder R(ViewGroup viewGroup) {
        return new PbLoadMoreItemViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.new_pb_list_more, viewGroup, false), this.s);
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.d2.h.j jVar, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        super.X(i, view, viewGroup, jVar, pbLoadMoreItemViewHolder);
        pbLoadMoreItemViewHolder.e(jVar.f53833e, d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104));
        pbLoadMoreItemViewHolder.d(this.t);
        pbLoadMoreItemViewHolder.c();
        return view;
    }

    public void m0(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }
}

package d.a.j0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
/* loaded from: classes3.dex */
public class l extends o<d.a.j0.d2.h.d, PbChildTitleViewHolder> {
    public l(d.a.j0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.a.j0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, (d.a.j0.d2.h.d) obj, (PbChildTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public PbChildTitleViewHolder P(ViewGroup viewGroup) {
        return new PbChildTitleViewHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.pb_child_title, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, d.a.j0.d2.h.d dVar, PbChildTitleViewHolder pbChildTitleViewHolder) {
        super.W(i2, view, viewGroup, dVar, pbChildTitleViewHolder);
        pbChildTitleViewHolder.b(dVar);
        pbChildTitleViewHolder.d();
        return view;
    }
}

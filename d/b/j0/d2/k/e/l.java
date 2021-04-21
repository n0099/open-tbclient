package d.b.j0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
/* loaded from: classes3.dex */
public class l extends o<d.b.j0.d2.h.d, PbChildTitleViewHolder> {
    public l(d.b.j0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.b.j0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (d.b.j0.d2.h.d) obj, (PbChildTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public PbChildTitleViewHolder R(ViewGroup viewGroup) {
        return new PbChildTitleViewHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.pb_child_title, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.j0.d2.h.d dVar, PbChildTitleViewHolder pbChildTitleViewHolder) {
        super.X(i, view, viewGroup, dVar, pbChildTitleViewHolder);
        pbChildTitleViewHolder.b(dVar);
        pbChildTitleViewHolder.d();
        return view;
    }
}

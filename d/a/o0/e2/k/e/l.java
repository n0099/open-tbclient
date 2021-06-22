package d.a.o0.e2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
/* loaded from: classes5.dex */
public class l extends o<d.a.o0.e2.h.d, PbChildTitleViewHolder> {
    public l(d.a.o0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.a.o0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (d.a.o0.e2.h.d) obj, (PbChildTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbChildTitleViewHolder Q(ViewGroup viewGroup) {
        return new PbChildTitleViewHolder(LayoutInflater.from(this.f43012e).inflate(R.layout.pb_child_title, viewGroup, false));
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.o0.e2.h.d dVar, PbChildTitleViewHolder pbChildTitleViewHolder) {
        super.X(i2, view, viewGroup, dVar, pbChildTitleViewHolder);
        pbChildTitleViewHolder.b(dVar);
        pbChildTitleViewHolder.d();
        return view;
    }
}

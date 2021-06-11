package d.a.n0.e2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
/* loaded from: classes5.dex */
public class x extends o<y, PbImageAlaRecommendVH> {
    public BdUniqueId s;
    public d.a.n0.e2.h.e t;

    public x(d.a.n0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, y.t);
        this.s = bdUniqueId;
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (y) obj, (PbImageAlaRecommendVH) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbImageAlaRecommendVH Q(ViewGroup viewGroup) {
        return new PbImageAlaRecommendVH(LayoutInflater.from(this.f42909e).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.m.getPageContext(), this.s);
    }

    public View i0(int i2, View view, ViewGroup viewGroup, y yVar, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        super.X(i2, view, viewGroup, yVar, pbImageAlaRecommendVH);
        if (pbImageAlaRecommendVH != null) {
            pbImageAlaRecommendVH.d(yVar);
            pbImageAlaRecommendVH.i(this.t);
        }
        return view;
    }

    public void j0(d.a.n0.e2.h.e eVar) {
        this.t = eVar;
    }
}

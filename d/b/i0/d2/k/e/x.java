package d.b.i0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
/* loaded from: classes3.dex */
public class x extends o<y, PbImageAlaRecommendVH> {
    public BdUniqueId s;
    public d.b.i0.d2.h.e t;

    public x(d.b.i0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, y.t);
        this.s = bdUniqueId;
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (y) obj, (PbImageAlaRecommendVH) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public PbImageAlaRecommendVH R(ViewGroup viewGroup) {
        return new PbImageAlaRecommendVH(LayoutInflater.from(this.f42855e).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.m.getPageContext(), this.s);
    }

    public View l0(int i, View view, ViewGroup viewGroup, y yVar, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        super.X(i, view, viewGroup, yVar, pbImageAlaRecommendVH);
        if (pbImageAlaRecommendVH != null) {
            pbImageAlaRecommendVH.d(yVar);
            pbImageAlaRecommendVH.i(this.t);
        }
        return view;
    }

    public void m0(d.b.i0.d2.h.e eVar) {
        this.t = eVar;
    }
}

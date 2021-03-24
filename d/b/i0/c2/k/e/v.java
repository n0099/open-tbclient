package d.b.i0.c2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
/* loaded from: classes4.dex */
public class v extends m<w, PbImageAlaRecommendVH> {
    public BdUniqueId s;
    public d.b.i0.c2.h.e t;

    public v(d.b.i0.c2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, w.t);
        this.s = bdUniqueId;
    }

    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (w) obj, (PbImageAlaRecommendVH) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public PbImageAlaRecommendVH R(ViewGroup viewGroup) {
        return new PbImageAlaRecommendVH(LayoutInflater.from(this.f42357e).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.m.getPageContext(), this.s);
    }

    public View l0(int i, View view, ViewGroup viewGroup, w wVar, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        super.X(i, view, viewGroup, wVar, pbImageAlaRecommendVH);
        if (pbImageAlaRecommendVH != null) {
            pbImageAlaRecommendVH.d(wVar);
            pbImageAlaRecommendVH.i(this.t);
        }
        return view;
    }

    public void m0(d.b.i0.c2.h.e eVar) {
        this.t = eVar;
    }
}

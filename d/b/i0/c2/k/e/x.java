package d.b.i0.c2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH;
/* loaded from: classes4.dex */
public class x extends m<y, PbListAlaRecommendVH> {
    public d.b.i0.c2.h.e s;

    public x(d.b.i0.c2.o.b bVar) {
        super(bVar, y.s);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public PbListAlaRecommendVH R(ViewGroup viewGroup) {
        return new PbListAlaRecommendVH(LayoutInflater.from(this.f42358e).inflate(R.layout.pb_list_ala_recomment_layout, (ViewGroup) null), this.m.P());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, y yVar, PbListAlaRecommendVH pbListAlaRecommendVH) {
        super.X(i, view, viewGroup, yVar, pbListAlaRecommendVH);
        if (yVar == null) {
            return null;
        }
        pbListAlaRecommendVH.c(yVar);
        pbListAlaRecommendVH.h(this.s);
        return view;
    }

    public void m0(d.b.i0.c2.h.e eVar) {
        this.s = eVar;
    }
}

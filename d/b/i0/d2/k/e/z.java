package d.b.i0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH;
/* loaded from: classes3.dex */
public class z extends o<a0, PbListAlaRecommendVH> {
    public d.b.i0.d2.h.e s;

    public z(d.b.i0.d2.o.i iVar) {
        super(iVar, a0.s);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public PbListAlaRecommendVH R(ViewGroup viewGroup) {
        return new PbListAlaRecommendVH(LayoutInflater.from(this.f42855e).inflate(R.layout.pb_list_ala_recomment_layout, (ViewGroup) null), this.m.P());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, a0 a0Var, PbListAlaRecommendVH pbListAlaRecommendVH) {
        super.X(i, view, viewGroup, a0Var, pbListAlaRecommendVH);
        if (a0Var == null) {
            return null;
        }
        pbListAlaRecommendVH.c(a0Var);
        pbListAlaRecommendVH.h(this.s);
        return view;
    }

    public void m0(d.b.i0.d2.h.e eVar) {
        this.s = eVar;
    }
}

package d.a.n0.e2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH;
/* loaded from: classes5.dex */
public class z extends o<a0, PbListAlaRecommendVH> {
    public d.a.n0.e2.h.e s;

    public z(d.a.n0.e2.o.i iVar) {
        super(iVar, a0.s);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public PbListAlaRecommendVH P(ViewGroup viewGroup) {
        return new PbListAlaRecommendVH(LayoutInflater.from(this.f39228e).inflate(R.layout.pb_list_ala_recomment_layout, (ViewGroup) null), this.m.A());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.e2.k.e.o, d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, a0 a0Var, PbListAlaRecommendVH pbListAlaRecommendVH) {
        super.W(i2, view, viewGroup, a0Var, pbListAlaRecommendVH);
        if (a0Var == null) {
            return null;
        }
        pbListAlaRecommendVH.c(a0Var);
        pbListAlaRecommendVH.h(this.s);
        return view;
    }

    public void i0(d.a.n0.e2.h.e eVar) {
        this.s = eVar;
    }
}

package d.a.n0.e2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder;
import d.a.m0.r.q.d1;
/* loaded from: classes5.dex */
public class l0 extends o<d1, PbRecommendNovelHolder> {
    public d.a.n0.e2.h.e s;
    public PbRecommendNovelHolder.b t;

    /* loaded from: classes5.dex */
    public class a implements PbRecommendNovelHolder.b {
        public a() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.b
        public void a(d1 d1Var) {
            if (d1Var != null) {
                d.a.n0.e2.m.a.a(l0.this.s, d1Var, d1Var.d0, 6);
            }
        }
    }

    public l0(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.t = new a();
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (d1) obj, (PbRecommendNovelHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public PbRecommendNovelHolder Q(ViewGroup viewGroup) {
        return new PbRecommendNovelHolder(this.n.getPageContext(), LayoutInflater.from(this.f42909e).inflate(R.layout.pb_recommend_novel, viewGroup, false), this.t);
    }

    public View j0(int i2, View view, ViewGroup viewGroup, d1 d1Var, PbRecommendNovelHolder pbRecommendNovelHolder) {
        super.X(i2, view, viewGroup, d1Var, pbRecommendNovelHolder);
        if (d1Var == null) {
            return view;
        }
        d1Var.d0 = i2 + 1;
        d.a.n0.e2.m.a.d(this.n.getUniqueId(), this.s, d1Var, d1Var.d0, 6);
        pbRecommendNovelHolder.e(d1Var);
        return view;
    }

    public void t(d.a.n0.e2.h.e eVar) {
        this.s = eVar;
    }
}

package d.b.i0.c2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder;
/* loaded from: classes4.dex */
public class i0 extends m<g0, PbPageNewsInfoHolder> {
    public d.b.i0.c2.h.e s;
    public PbPageNewsInfoHolder.b t;

    /* loaded from: classes4.dex */
    public class a implements PbPageNewsInfoHolder.b {
        public a() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.b
        public void a(g0 g0Var) {
            if (g0Var != null) {
                d.b.i0.c2.m.a.a(i0.this.s, g0Var, g0Var.d0, 5);
            }
        }
    }

    public i0(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.t = new a();
    }

    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i, view, viewGroup, (g0) obj, (PbPageNewsInfoHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public PbPageNewsInfoHolder R(ViewGroup viewGroup) {
        return new PbPageNewsInfoHolder(this.n.getPageContext(), LayoutInflater.from(this.f42358e).inflate(R.layout.pb_page_news, viewGroup, false), this.t);
    }

    public View m0(int i, View view, ViewGroup viewGroup, g0 g0Var, PbPageNewsInfoHolder pbPageNewsInfoHolder) {
        super.X(i, view, viewGroup, g0Var, pbPageNewsInfoHolder);
        if (g0Var == null) {
            return view;
        }
        g0Var.d0 = i + 1;
        d.b.i0.c2.m.a.d(this.n.getUniqueId(), this.s, g0Var, g0Var.d0, 5);
        pbPageNewsInfoHolder.h(g0Var);
        pbPageNewsInfoHolder.i(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public void s(d.b.i0.c2.h.e eVar) {
        this.s = eVar;
    }
}

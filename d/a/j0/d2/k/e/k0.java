package d.a.j0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder;
/* loaded from: classes3.dex */
public class k0 extends o<i0, PbPageNewsInfoHolder> {
    public d.a.j0.d2.h.e s;
    public PbPageNewsInfoHolder.b t;

    /* loaded from: classes3.dex */
    public class a implements PbPageNewsInfoHolder.b {
        public a() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.b
        public void a(i0 i0Var) {
            if (i0Var != null) {
                d.a.j0.d2.m.a.a(k0.this.s, i0Var, i0Var.d0, 5);
            }
        }
    }

    public k0(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.t = new a();
    }

    @Override // d.a.j0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (i0) obj, (PbPageNewsInfoHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public PbPageNewsInfoHolder P(ViewGroup viewGroup) {
        return new PbPageNewsInfoHolder(this.n.getPageContext(), LayoutInflater.from(this.f40319e).inflate(R.layout.pb_page_news, viewGroup, false), this.t);
    }

    public View i0(int i2, View view, ViewGroup viewGroup, i0 i0Var, PbPageNewsInfoHolder pbPageNewsInfoHolder) {
        super.W(i2, view, viewGroup, i0Var, pbPageNewsInfoHolder);
        if (i0Var == null) {
            return view;
        }
        i0Var.d0 = i2 + 1;
        d.a.j0.d2.m.a.d(this.n.getUniqueId(), this.s, i0Var, i0Var.d0, 5);
        pbPageNewsInfoHolder.h(i0Var);
        pbPageNewsInfoHolder.i(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public void s(d.a.j0.d2.h.e eVar) {
        this.s = eVar;
    }
}

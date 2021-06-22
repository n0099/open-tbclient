package d.a.o0.v.d.f.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.o0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class b extends d.a.o0.z.b<d.a.o0.v.d.g.b.b> {
    public a m;
    public a n;

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new a(k());
        this.n = new a(k());
        ViewGroup viewGroup2 = (ViewGroup) m();
        View view = new View(b());
        viewGroup2.addView(this.m.m());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.n.m());
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.ala_special_recommend_list_live_row;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        this.m.p(tbPageContext, i2);
        this.n.p(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(d.a.o0.v.d.g.b.b bVar) {
        if (bVar != null) {
            this.m.n(bVar.f65627e);
            this.n.n(bVar.f65628f);
        }
    }

    public void u(d.a.o0.v.d.g.b.b bVar, int i2) {
        if (bVar != null) {
            this.m.o(bVar.f65627e, i2);
            this.n.o(bVar.f65628f, i2);
        }
    }

    public void v(f fVar) {
        this.m.q(fVar);
        this.n.q(fVar);
    }
}

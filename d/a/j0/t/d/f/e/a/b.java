package d.a.j0.t.d.f.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.j0.t.d.g.d.f;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<d.a.j0.t.d.g.b.b> {
    public a m;
    public a n;

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new a(k());
        this.n = new a(k());
        ViewGroup viewGroup2 = (ViewGroup) l();
        View view = new View(b());
        viewGroup2.addView(this.m.j());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.n.j());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.ala_special_recommend_list_live_row;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        this.m.m(tbPageContext, i2);
        this.n.m(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(d.a.j0.t.d.g.b.b bVar) {
        if (bVar != null) {
            this.m.k(bVar.f60775e);
            this.n.k(bVar.f60776f);
        }
    }

    public void t(d.a.j0.t.d.g.b.b bVar, int i2) {
        if (bVar != null) {
            this.m.l(bVar.f60775e, i2);
            this.n.l(bVar.f60776f, i2);
        }
    }

    public void u(f fVar) {
        this.m.n(fVar);
        this.n.n(fVar);
    }
}

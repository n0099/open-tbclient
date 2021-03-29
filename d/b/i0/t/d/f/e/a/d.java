package d.b.i0.t.d.f.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.i0.t.d.g.d.g;
/* loaded from: classes4.dex */
public class d extends d.b.i0.x.b<d.b.i0.t.d.g.b.b> {
    public b m;
    public b n;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new b(l());
        this.n = new b(l());
        ViewGroup viewGroup2 = (ViewGroup) m();
        View view = new View(b());
        viewGroup2.addView(this.m.j());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(l().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.n.j());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_special_recommend_list_live_row;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.m.m(tbPageContext, i);
        this.n.m(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.t.d.g.b.b bVar) {
        if (bVar != null) {
            this.m.k(bVar.f60608e);
            this.n.k(bVar.f60609f);
        }
    }

    public void v(d.b.i0.t.d.g.b.b bVar, int i) {
        if (bVar != null) {
            this.m.l(bVar.f60608e, i);
            this.n.l(bVar.f60609f, i);
        }
    }

    public void w(g gVar) {
        this.m.n(gVar);
        this.n.n(gVar);
    }
}

package d.b.j0.t.d.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends d.b.j0.x.b<d.b.j0.t.d.c.e.e> {
    public h m;
    public h n;
    public ViewGroup o;

    public f(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i) {
        super(tbPageContext, viewGroup);
        this.m = new h(tbPageContext, i);
        this.n = new h(tbPageContext, i);
        this.o = (ViewGroup) m();
        View view = new View(b());
        this.o.setPadding(l().getResources().getDimensionPixelSize(R.dimen.tbds44), l().getResources().getDimensionPixelSize(R.dimen.tbds12), l().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.o.addView(this.m.l());
        this.o.addView(view, new LinearLayout.LayoutParams(l().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.o.addView(this.n.l());
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.tab_recommend_list_live_row;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.m.p(tbPageContext, i);
        this.n.p(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(d.b.j0.t.d.c.e.e eVar) {
        if (eVar != null) {
            this.m.n(eVar.f62314e);
            this.n.n(eVar.f62315f);
        }
    }
}

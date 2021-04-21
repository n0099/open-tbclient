package d.b.j0.t.d.f.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.j0.t.d.c.e.e;
import d.b.j0.t.d.g.d.f;
/* loaded from: classes4.dex */
public class c extends d.b.j0.x.b<e> {
    public a m;
    public a n;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new a(l());
        this.n = new a(l());
        ViewGroup viewGroup2 = (ViewGroup) m();
        View view = new View(b());
        viewGroup2.addView(this.m.d());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(l().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.n.d());
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.ala_special_game_list_live_row;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.m.g(tbPageContext, i);
        this.n.g(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(e eVar) {
        if (eVar != null) {
            this.m.e(eVar.f62314e);
            this.n.e(eVar.f62315f);
        }
    }

    public void v(e eVar, String str) {
        if (eVar != null) {
            this.m.f(eVar.f62314e, str);
            this.n.f(eVar.f62315f, str);
        }
    }

    public void w(f fVar) {
        this.m.h(fVar);
        this.n.h(fVar);
    }
}

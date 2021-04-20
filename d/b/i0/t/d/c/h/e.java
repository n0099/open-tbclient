package d.b.i0.t.d.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends d.b.i0.x.b<d.b.i0.t.d.c.e.e> {
    public g m;
    public g n;
    public ViewGroup o;
    public boolean p;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.p = false;
        g gVar = new g(tbPageContext);
        this.m = gVar;
        gVar.l(this.p);
        g gVar2 = new g(tbPageContext);
        this.n = gVar2;
        gVar2.l(this.p);
        this.o = (ViewGroup) m();
        View view = new View(b());
        this.o.setPadding(l().getResources().getDimensionPixelSize(R.dimen.tbds44), l().getResources().getDimensionPixelSize(R.dimen.tbds12), l().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.o.addView(this.m.i());
        this.o.addView(view, new LinearLayout.LayoutParams(l().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.o.addView(this.n.i());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.tab_recommend_list_live_row;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0201);
        this.m.k(tbPageContext, i);
        this.n.k(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.t.d.c.e.e eVar) {
        if (eVar != null) {
            this.m.j(eVar.f61893e);
            this.n.j(eVar.f61894f);
        }
    }

    public void v(boolean z) {
        this.p = z;
    }
}

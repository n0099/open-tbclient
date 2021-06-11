package d.a.n0.v.d.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends d.a.n0.z.b<d.a.n0.v.d.c.e.e> {
    public d.a.n0.v.d.c.b m;
    public d.a.n0.v.d.c.b n;
    public ViewGroup o;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i2, boolean z) {
        super(tbPageContext, viewGroup);
        if (z) {
            this.m = new g(tbPageContext, i2);
            this.n = new g(tbPageContext, i2);
            u();
            return;
        }
        this.m = new f(tbPageContext, i2);
        this.n = new f(tbPageContext, i2);
        t();
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.tab_recommend_list_live_row;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        this.m.onChangeSkinType(tbPageContext, i2);
        this.n.onChangeSkinType(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void t() {
        this.o = (ViewGroup) m();
        View view = new View(b());
        this.o.setPadding(k().getResources().getDimensionPixelSize(R.dimen.tbds44), k().getResources().getDimensionPixelSize(R.dimen.tbds12), k().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.o.addView(this.m.getView());
        this.o.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.o.addView(this.n.getView());
    }

    public final void u() {
        this.o = (ViewGroup) m();
        View view = new View(b());
        this.o.setPadding(k().getResources().getDimensionPixelSize(R.dimen.tbds34), k().getResources().getDimensionPixelSize(R.dimen.tbds21), k().getResources().getDimensionPixelSize(R.dimen.tbds34), 0);
        this.o.addView(this.m.getView());
        this.o.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.tbds20), -1));
        this.o.addView(this.n.getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: v */
    public void n(d.a.n0.v.d.c.e.e eVar) {
        if (eVar != null) {
            this.m.a(eVar.f65217e);
            this.n.a(eVar.f65218f);
        }
    }
}

package d.b.i0.t.d.g.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends d.b.i0.x.b<d.b.i0.t.d.g.b.b> {
    public e m;
    public e n;

    public d(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = new e(l(), z);
        this.n = new e(l(), z);
        ViewGroup viewGroup = (ViewGroup) m();
        View view = new View(b());
        viewGroup.addView(this.m.g());
        viewGroup.addView(view, new LinearLayout.LayoutParams(l().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.n.g());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.m.i(tbPageContext, i);
        this.n.i(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.t.d.g.b.b bVar) {
        if (bVar != null) {
            this.m.h(bVar.f62172e);
            this.n.h(bVar.f62173f);
        }
    }

    public void v(g gVar) {
        this.m.j(gVar);
        this.n.j(gVar);
    }
}

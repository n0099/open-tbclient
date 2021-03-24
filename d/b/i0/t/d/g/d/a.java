package d.b.i0.t.d.g.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends d.b.i0.x.b<d.b.i0.t.d.g.b.a> {
    public b m;
    public b n;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = new b(l(), z);
        this.n = new b(l(), z);
        ViewGroup viewGroup = (ViewGroup) m();
        View view = new View(b());
        viewGroup.addView(this.m.m());
        viewGroup.addView(view, new LinearLayout.LayoutParams(l().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.n.m());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.m.o(tbPageContext, i);
        this.n.o(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.t.d.g.b.a aVar) {
        if (aVar != null) {
            this.m.n(aVar.f60604e);
            this.n.n(aVar.f60605f);
        }
    }

    public void v(g gVar) {
        this.m.B(gVar);
        this.n.B(gVar);
    }
}

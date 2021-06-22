package d.a.o0.v.d.g.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends d.a.o0.z.b<d.a.o0.v.d.g.b.a> {
    public b m;
    public b n;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = new b(k(), z);
        this.n = new b(k(), z);
        ViewGroup viewGroup = (ViewGroup) m();
        View view = new View(b());
        viewGroup.addView(this.m.m());
        viewGroup.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.n.m());
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        this.m.o(tbPageContext, i2);
        this.n.o(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(d.a.o0.v.d.g.b.a aVar) {
        if (aVar != null) {
            this.m.n(aVar.f65624e);
            this.n.n(aVar.f65625f);
        }
    }

    public void u(f fVar) {
        this.m.A(fVar);
        this.n.A(fVar);
    }
}

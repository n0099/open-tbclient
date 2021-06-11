package d.a.n0.v.d.g.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends d.a.n0.z.b<d.a.n0.v.d.g.b.b> {
    public e m;
    public e n;

    public d(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = new e(k(), z);
        this.n = new e(k(), z);
        ViewGroup viewGroup = (ViewGroup) m();
        View view = new View(b());
        viewGroup.addView(this.m.g());
        viewGroup.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.n.g());
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        this.m.i(tbPageContext, i2);
        this.n.i(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(d.a.n0.v.d.g.b.b bVar) {
        if (bVar != null) {
            this.m.h(bVar.f65502e);
            this.n.h(bVar.f65503f);
        }
    }

    public void u(f fVar) {
        this.m.j(fVar);
        this.n.j(fVar);
    }
}

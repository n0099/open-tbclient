package d.a.n0.v.d.g.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends d.a.n0.z.b<d.a.n0.v.d.g.b.a> {
    public b m;
    public b n;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.m = new b(k(), z);
        this.n = new b(k(), z);
        ViewGroup viewGroup = (ViewGroup) l();
        View view = new View(b());
        viewGroup.addView(this.m.l());
        viewGroup.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.n.l());
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        this.m.n(tbPageContext, i2);
        this.n.n(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: s */
    public void m(d.a.n0.v.d.g.b.a aVar) {
        if (aVar != null) {
            this.m.m(aVar.f61784e);
            this.n.m(aVar.f61785f);
        }
    }

    public void t(f fVar) {
        this.m.z(fVar);
        this.n.z(fVar);
    }
}

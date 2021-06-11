package d.a.n0.v.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.v.d.c.e.k;
/* loaded from: classes4.dex */
public class d extends d.a.n0.z.b<k> {
    public c m;
    public c n;
    public LinearLayout o;
    public ViewGroup p;
    public View q;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new c(tbPageContext);
        this.n = new c(tbPageContext);
        ViewGroup viewGroup2 = (ViewGroup) m();
        this.p = viewGroup2;
        this.o = (LinearLayout) viewGroup2.findViewById(R.id.id_tab_live_sub_row);
        this.q = this.p.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(b());
        this.o.setPadding(k().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, k().getResources().getDimensionPixelSize(R.dimen.tbds44), k().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.o.addView(this.m.h());
        this.o.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.o.addView(this.n.h());
        o(this.f67159f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.tab_sub_list_live_row;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
        this.m.k(tbPageContext, i2);
        this.n.k(tbPageContext, i2);
        SkinManager.setBackgroundResource(this.q, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(k kVar) {
        if (kVar != null) {
            this.m.i(kVar.f65231e);
            this.n.i(kVar.f65232f);
            if (kVar.f65233g) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    public void u(i iVar) {
        this.m.l(iVar);
        this.n.l(iVar);
    }
}

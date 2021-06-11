package d.a.n0.v.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h extends d.a.n0.z.b<d.a.n0.v.d.c.f.b.c> {
    public g m;
    public g n;
    public g o;
    public ViewGroup p;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new g(tbPageContext);
        this.n = new g(tbPageContext);
        this.o = new g(tbPageContext);
        this.p = (ViewGroup) m();
        new View(b());
        this.p.setPadding(k().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, k().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.p.addView(this.m.e());
        this.p.addView(this.n.e());
        this.p.addView(this.o.e());
        o(this.f67159f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
        this.m.g(tbPageContext, i2);
        this.n.g(tbPageContext, i2);
        this.o.g(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(d.a.n0.v.d.c.f.b.c cVar) {
        if (cVar != null) {
            this.m.f(cVar.f65252e);
            this.n.f(cVar.f65253f);
            this.o.f(cVar.f65254g);
        }
    }

    public void u(i iVar) {
        this.m.h(iVar);
        this.n.h(iVar);
        this.o.h(iVar);
    }
}

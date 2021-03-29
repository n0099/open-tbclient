package d.b.i0.t.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h extends d.b.i0.x.b<d.b.i0.t.d.c.f.b.c> {
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
        this.p.setPadding(l().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, l().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.p.addView(this.m.e());
        this.p.addView(this.n.e());
        this.p.addView(this.o.e());
        o(this.f62181f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
        this.m.g(tbPageContext, i);
        this.n.g(tbPageContext, i);
        this.o.g(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.t.d.c.f.b.c cVar) {
        if (cVar != null) {
            this.m.f(cVar.f60363e);
            this.n.f(cVar.f60364f);
            this.o.f(cVar.f60365g);
        }
    }

    public void v(i iVar) {
        this.m.h(iVar);
        this.n.h(iVar);
        this.o.h(iVar);
    }
}

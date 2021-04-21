package d.b.j0.i0.k.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.j0.i0.k.c.e;
/* loaded from: classes4.dex */
public class d extends d.b.j0.x.b<e> {
    public int m;
    public View n;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        this.n = m().findViewById(R.id.card_recommend_list_placeholder);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.recommend_forum_placeholder_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (i == this.m) {
            return;
        }
        this.m = i;
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(e eVar) {
        if (eVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        layoutParams.height = l.g(this.f64178g, eVar.f57198e);
        this.n.setLayoutParams(layoutParams);
    }
}

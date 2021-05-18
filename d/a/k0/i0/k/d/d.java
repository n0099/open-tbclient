package d.a.k0.i0.k.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.k0.i0.k.c.e;
/* loaded from: classes4.dex */
public class d extends d.a.k0.x.b<e> {
    public int m;
    public View n;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        this.n = l().findViewById(R.id.card_recommend_list_placeholder);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.recommend_forum_placeholder_layout;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (i2 == this.m) {
            return;
        }
        this.m = i2;
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: s */
    public void m(e eVar) {
        if (eVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        layoutParams.height = l.g(this.f63162g, eVar.f55836e);
        this.n.setLayoutParams(layoutParams);
    }
}

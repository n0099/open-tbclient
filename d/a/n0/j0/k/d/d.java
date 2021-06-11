package d.a.n0.j0.k.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.j0.k.c.e;
/* loaded from: classes4.dex */
public class d extends d.a.n0.z.b<e> {
    public int m;
    public View n;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        this.n = m().findViewById(R.id.card_recommend_list_placeholder);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.recommend_forum_placeholder_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (i2 == this.m) {
            return;
        }
        this.m = i2;
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(e eVar) {
        if (eVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        layoutParams.height = l.g(this.f67160g, eVar.f59709e);
        this.n.setLayoutParams(layoutParams);
    }
}

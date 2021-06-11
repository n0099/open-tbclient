package d.a.n0.j2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class i extends d.a.n0.z.b<d.a.n0.j2.e.k> {
    public TextView m;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = (TextView) m();
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.card_person_title_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.f67158e == i2) {
            return;
        }
        this.f67158e = i2;
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(d.a.n0.j2.e.k kVar) {
        if (kVar == null) {
            return;
        }
        this.m.setPadding(kVar.f60113f, kVar.f60114g, 0, kVar.f60115h);
        this.m.setText(this.f67160g.getString(kVar.f60112e));
    }
}

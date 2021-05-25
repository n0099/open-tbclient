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
        this.m = (TextView) l();
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.card_person_title_layout;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f63440e == i2) {
            return;
        }
        this.f63440e = i2;
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: s */
    public void m(d.a.n0.j2.e.k kVar) {
        if (kVar == null) {
            return;
        }
        this.m.setPadding(kVar.f56424f, kVar.f56425g, 0, kVar.f56426h);
        this.m.setText(this.f63442g.getString(kVar.f56423e));
    }
}

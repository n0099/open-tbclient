package d.a.j0.i2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class i extends d.a.j0.x.b<d.a.j0.i2.e.k> {
    public TextView m;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = (TextView) l();
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_person_title_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e == i2) {
            return;
        }
        this.f62436e = i2;
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(d.a.j0.i2.e.k kVar) {
        if (kVar == null) {
            return;
        }
        this.m.setPadding(kVar.f55533f, kVar.f55534g, 0, kVar.f55535h);
        this.m.setText(this.f62438g.getString(kVar.f55532e));
    }
}

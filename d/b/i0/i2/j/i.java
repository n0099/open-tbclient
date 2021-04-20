package d.b.i0.i2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class i extends d.b.i0.x.b<d.b.i0.i2.e.k> {
    public TextView m;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = (TextView) m();
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_person_title_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f63755e == i) {
            return;
        }
        this.f63755e = i;
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.i2.e.k kVar) {
        if (kVar == null) {
            return;
        }
        this.m.setPadding(kVar.f57158f, kVar.f57159g, 0, kVar.f57160h);
        this.m.setText(this.f63757g.getString(kVar.f57157e));
    }
}

package d.b.j0.i2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d extends d.b.j0.x.b<d.b.j0.i2.e.e> {
    public View m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public d.b.j0.i2.e.e q;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View m = m();
        this.m = m;
        this.n = (TbImageView) m.findViewById(R.id.card_person_auth_icon);
        this.o = (TextView) this.m.findViewById(R.id.card_person_auth_bar_name);
        this.p = (TextView) this.m.findViewById(R.id.card_person_auth_des);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.card_person_auth_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f64176e == i) {
            return;
        }
        this.f64176e = i;
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
        if (this.q.f57559e == null) {
            SkinManager.setImageResource(this.n, R.drawable.icon_shen_mine);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(d.b.j0.i2.e.e eVar) {
        if (eVar == null) {
            return;
        }
        this.q = eVar;
        String str = eVar.f57559e;
        if (str != null) {
            this.n.W(str, 10, false);
        }
        this.o.setText(eVar.f57560f);
        this.p.setText(eVar.f57561g);
    }
}

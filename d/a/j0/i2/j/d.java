package d.a.j0.i2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends d.a.j0.x.b<d.a.j0.i2.e.e> {
    public View m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public d.a.j0.i2.e.e q;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View l = l();
        this.m = l;
        this.n = (TbImageView) l.findViewById(R.id.card_person_auth_icon);
        this.o = (TextView) this.m.findViewById(R.id.card_person_auth_bar_name);
        this.p = (TextView) this.m.findViewById(R.id.card_person_auth_des);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_person_auth_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e == i2) {
            return;
        }
        this.f62436e = i2;
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
        if (this.q.f55510e == null) {
            SkinManager.setImageResource(this.n, R.drawable.icon_shen_mine);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(d.a.j0.i2.e.e eVar) {
        if (eVar == null) {
            return;
        }
        this.q = eVar;
        String str = eVar.f55510e;
        if (str != null) {
            this.n.V(str, 10, false);
        }
        this.o.setText(eVar.f55511f);
        this.p.setText(eVar.f55512g);
    }
}

package d.a.o0.j2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class d extends d.a.o0.z.b<d.a.o0.j2.e.e> {
    public View m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public d.a.o0.j2.e.e q;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View m = m();
        this.m = m;
        this.n = (TbImageView) m.findViewById(R.id.card_person_auth_icon);
        this.o = (TextView) this.m.findViewById(R.id.card_person_auth_bar_name);
        this.p = (TextView) this.m.findViewById(R.id.card_person_auth_des);
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.card_person_auth_layout;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.f67283e == i2) {
            return;
        }
        this.f67283e = i2;
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
        if (this.q.f60215e == null) {
            SkinManager.setImageResource(this.n, R.drawable.icon_shen_mine);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(d.a.o0.j2.e.e eVar) {
        if (eVar == null) {
            return;
        }
        this.q = eVar;
        String str = eVar.f60215e;
        if (str != null) {
            this.n.U(str, 10, false);
        }
        this.o.setText(eVar.f60216f);
        this.p.setText(eVar.f60217g);
    }
}

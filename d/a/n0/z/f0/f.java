package d.a.n0.z.f0;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends d.a.n0.z.b<e> {
    public View m;
    public TextView n;
    public View o;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        m().setOnClickListener(this);
        this.m = m().findViewById(R.id.card_divider_top_margin);
        this.n = (TextView) m().findViewById(R.id.card_divider_tv);
        this.o = m().findViewById(R.id.bottom_line);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.card_divider_view;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext tbPageContext, int i2) {
        if (this.f67158e != i2) {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        }
        this.f67158e = i2;
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
        if (eVar.needTopMargin) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
        this.n.setText(eVar.f67217e);
        o(null, TbadkCoreApplication.getInst().getSkinType());
    }
}

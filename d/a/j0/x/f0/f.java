package d.a.j0.x.f0;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends d.a.j0.x.b<e> {
    public View m;
    public TextView n;
    public View o;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        l().setOnClickListener(this);
        this.m = l().findViewById(R.id.card_divider_top_margin);
        this.n = (TextView) l().findViewById(R.id.card_divider_tv);
        this.o = l().findViewById(R.id.bottom_line);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_divider_view;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext tbPageContext, int i2) {
        if (this.f62436e != i2) {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        }
        this.f62436e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(e eVar) {
        if (eVar == null) {
            return;
        }
        if (eVar.needTopMargin) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
        this.n.setText(eVar.f62495e);
        n(null, TbadkCoreApplication.getInst().getSkinType());
    }
}

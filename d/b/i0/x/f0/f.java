package d.b.i0.x.f0;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends d.b.i0.x.b<e> {
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

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_divider_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext tbPageContext, int i) {
        if (this.f62180e != i) {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        }
        this.f62180e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(e eVar) {
        if (eVar == null) {
            return;
        }
        if (eVar.needTopMargin) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
        this.n.setText(eVar.f62233e);
        o(null, TbadkCoreApplication.getInst().getSkinType());
    }
}

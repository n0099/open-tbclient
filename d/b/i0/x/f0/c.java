package d.b.i0.x.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends d.b.i0.x.b<b> {
    public View m;
    public int n;
    public int o;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.n = R.color.CAM_X0204;
        this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        m().setOnClickListener(this);
        this.m = m().findViewById(R.id.card_divider);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_divider_line;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext tbPageContext, int i) {
        if (this.f62180e != i) {
            SkinManager.setBackgroundColor(this.m, this.n);
        }
        this.f62180e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(b bVar) {
        if (bVar == null) {
            return;
        }
        this.m.setVisibility(0);
        this.n = bVar.f62230e;
        this.o = bVar.f62231f;
        v();
        o(this.f62181f, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void v() {
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        if (layoutParams != null) {
            int i = layoutParams.height;
            int i2 = this.o;
            if (i != i2) {
                layoutParams.height = i2;
                this.m.setLayoutParams(layoutParams);
            }
        }
    }
}

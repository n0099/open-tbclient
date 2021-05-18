package d.a.k0.x.f0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends d.a.k0.x.b<b> {
    public View m;
    public int n;
    public int o;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.n = R.color.CAM_X0204;
        this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        l().setOnClickListener(this);
        this.m = l().findViewById(R.id.card_divider);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.card_divider_line;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext tbPageContext, int i2) {
        if (this.f63160e != i2) {
            SkinManager.setBackgroundColor(this.m, this.n);
        }
        this.f63160e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: s */
    public void m(b bVar) {
        if (bVar == null) {
            return;
        }
        this.m.setVisibility(0);
        this.n = bVar.f63216e;
        this.o = bVar.f63217f;
        t();
        n(this.f63161f, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void t() {
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        if (layoutParams != null) {
            int i2 = layoutParams.height;
            int i3 = this.o;
            if (i2 != i3) {
                layoutParams.height = i3;
                this.m.setLayoutParams(layoutParams);
            }
        }
    }
}

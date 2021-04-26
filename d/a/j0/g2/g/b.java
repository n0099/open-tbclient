package d.a.j0.g2.g;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<d.a.j0.g2.e.e> {
    public int m;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.person_center_blank_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.m != i2) {
            SkinManager.setBackgroundColor(l(), R.color.CAM_X0204);
            this.m = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(d.a.j0.g2.e.e eVar) {
        n(this.f62437f, TbadkCoreApplication.getInst().getSkinType());
    }
}

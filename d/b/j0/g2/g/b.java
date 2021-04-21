package d.b.j0.g2.g;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends d.b.j0.x.b<d.b.j0.g2.e.e> {
    public int m;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.person_center_blank_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.m != i) {
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0204);
            this.m = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(d.b.j0.g2.e.e eVar) {
        o(this.f64177f, TbadkCoreApplication.getInst().getSkinType());
    }
}

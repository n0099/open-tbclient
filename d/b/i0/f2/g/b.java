package d.b.i0.f2.g;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d.b.i0.x.b<d.b.i0.f2.e.e> {
    public int m;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.person_center_blank_layout;
    }

    @Override // d.b.i0.x.b
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
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.f2.e.e eVar) {
        o(this.f62180f, TbadkCoreApplication.getInst().getSkinType());
    }
}

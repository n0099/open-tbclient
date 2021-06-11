package d.a.n0.h2.g;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d.a.n0.z.b<d.a.n0.h2.e.e> {
    public int m;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.person_center_blank_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.m != i2) {
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0204);
            this.m = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(d.a.n0.h2.e.e eVar) {
        o(this.f67159f, TbadkCoreApplication.getInst().getSkinType());
    }
}

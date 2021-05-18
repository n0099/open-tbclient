package d.a.k0.d2.n;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes5.dex */
public class d extends d.a.j0.r.f0.q.c {
    public d(TbPageContext tbPageContext, d.a.j0.r.f0.q.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // d.a.j0.r.f0.q.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.f49743e != null) {
            TiebaStatic.log(new StatisticItem("c11924").param("obj_id", this.f49743e.getUserId()));
        }
    }
}

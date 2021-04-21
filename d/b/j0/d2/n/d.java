package d.b.j0.d2.n;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class d extends d.b.i0.r.f0.q.c {
    public d(TbPageContext tbPageContext, d.b.i0.r.f0.q.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // d.b.i0.r.f0.q.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.f51300e != null) {
            TiebaStatic.log(new StatisticItem("c11924").param("obj_id", this.f51300e.getUserId()));
        }
    }
}

package d.a.n0.q0.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.q0.a.c f58250a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.n0.q0.a.a(tbPageContext, d.a.n0.q0.c.a.f58279h, tbPageContext.getUniqueId()));
        d.a.n0.q0.a.c cVar = new d.a.n0.q0.a.c(tbPageContext, d.a.n0.q0.c.b.l, tbPageContext.getUniqueId());
        this.f58250a = cVar;
        arrayList.add(cVar);
        arrayList.add(new d.a.n0.q0.a.b(tbPageContext, d.a.n0.q0.c.a.f58278g, tbPageContext.getUniqueId()));
        arrayList.add(new d.a.n0.q0.a.d(tbPageContext, d.a.n0.q0.c.a.f58280i, tbPageContext.getUniqueId()));
        bdTypeListView.a(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f58250a.g0(onClickListener);
    }
}

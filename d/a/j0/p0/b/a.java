package d.a.j0.p0.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.p0.a.c f57312a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.j0.p0.a.a(tbPageContext, d.a.j0.p0.c.a.f57341h, tbPageContext.getUniqueId()));
        d.a.j0.p0.a.c cVar = new d.a.j0.p0.a.c(tbPageContext, d.a.j0.p0.c.b.l, tbPageContext.getUniqueId());
        this.f57312a = cVar;
        arrayList.add(cVar);
        arrayList.add(new d.a.j0.p0.a.b(tbPageContext, d.a.j0.p0.c.a.f57340g, tbPageContext.getUniqueId()));
        arrayList.add(new d.a.j0.p0.a.d(tbPageContext, d.a.j0.p0.c.a.f57342i, tbPageContext.getUniqueId()));
        bdTypeListView.a(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f57312a.g0(onClickListener);
    }
}

package d.b.i0.p0.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.p0.a.c f58859a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.b.i0.p0.a.a(tbPageContext, d.b.i0.p0.c.a.f58886h, tbPageContext.getUniqueId()));
        d.b.i0.p0.a.c cVar = new d.b.i0.p0.a.c(tbPageContext, d.b.i0.p0.c.b.l, tbPageContext.getUniqueId());
        this.f58859a = cVar;
        arrayList.add(cVar);
        arrayList.add(new d.b.i0.p0.a.b(tbPageContext, d.b.i0.p0.c.a.f58885g, tbPageContext.getUniqueId()));
        arrayList.add(new d.b.i0.p0.a.d(tbPageContext, d.b.i0.p0.c.a.i, tbPageContext.getUniqueId()));
        bdTypeListView.a(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f58859a.j0(onClickListener);
    }
}

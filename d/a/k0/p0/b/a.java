package d.a.k0.p0.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.p0.a.c f58054a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.k0.p0.a.a(tbPageContext, d.a.k0.p0.c.a.f58083h, tbPageContext.getUniqueId()));
        d.a.k0.p0.a.c cVar = new d.a.k0.p0.a.c(tbPageContext, d.a.k0.p0.c.b.l, tbPageContext.getUniqueId());
        this.f58054a = cVar;
        arrayList.add(cVar);
        arrayList.add(new d.a.k0.p0.a.b(tbPageContext, d.a.k0.p0.c.a.f58082g, tbPageContext.getUniqueId()));
        arrayList.add(new d.a.k0.p0.a.d(tbPageContext, d.a.k0.p0.c.a.f58084i, tbPageContext.getUniqueId()));
        bdTypeListView.a(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f58054a.g0(onClickListener);
    }
}

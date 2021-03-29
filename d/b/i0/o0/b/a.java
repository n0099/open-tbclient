package d.b.i0.o0.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.o0.a.c f57213a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.b.i0.o0.a.a(tbPageContext, d.b.i0.o0.c.a.f57240h, tbPageContext.getUniqueId()));
        d.b.i0.o0.a.c cVar = new d.b.i0.o0.a.c(tbPageContext, d.b.i0.o0.c.b.l, tbPageContext.getUniqueId());
        this.f57213a = cVar;
        arrayList.add(cVar);
        arrayList.add(new d.b.i0.o0.a.b(tbPageContext, d.b.i0.o0.c.a.f57239g, tbPageContext.getUniqueId()));
        arrayList.add(new d.b.i0.o0.a.d(tbPageContext, d.b.i0.o0.c.a.i, tbPageContext.getUniqueId()));
        bdTypeListView.a(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f57213a.j0(onClickListener);
    }
}

package d.b.i0.b1.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.b.h0.r.q.a2;
import d.b.i0.p0.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.b.j.e.a> f52148a = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        k kVar = (k) MessageManager.getInstance().runTask(2921336, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.f52148a.add(kVar);
        }
        this.f52148a.add(new c(tbPageContext, a2.o3));
        this.f52148a.add(new a(tbPageContext, a2.p3));
        bdTypeRecyclerView.a(this.f52148a);
    }

    public void a(TbPageTag tbPageTag) {
        if (ListUtils.isEmpty(this.f52148a)) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f52148a) {
            if (aVar instanceof k) {
                ((k) aVar).r0(tbPageTag);
            }
        }
    }
}

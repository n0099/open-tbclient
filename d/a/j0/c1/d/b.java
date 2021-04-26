package d.a.j0.c1.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.a.i0.r.q.a2;
import d.a.j0.q0.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51737a = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        k kVar = (k) MessageManager.getInstance().runTask(2921336, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.f51737a.add(kVar);
        }
        this.f51737a.add(new c(tbPageContext, a2.o3));
        this.f51737a.add(new a(tbPageContext, a2.p3));
        bdTypeRecyclerView.a(this.f51737a);
    }

    public void a(TbPageTag tbPageTag) {
        if (ListUtils.isEmpty(this.f51737a)) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f51737a) {
            if (aVar instanceof k) {
                ((k) aVar).q0(tbPageTag);
            }
        }
    }
}

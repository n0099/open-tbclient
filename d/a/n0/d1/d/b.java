package d.a.n0.d1.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.a.m0.r.q.a2;
import d.a.n0.r0.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52616a = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        k kVar = (k) MessageManager.getInstance().runTask(2921336, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.f52616a.add(kVar);
        }
        this.f52616a.add(new c(tbPageContext, a2.q3));
        this.f52616a.add(new a(tbPageContext, a2.r3));
        bdTypeRecyclerView.a(this.f52616a);
    }

    public void a(TbPageTag tbPageTag) {
        if (ListUtils.isEmpty(this.f52616a)) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f52616a) {
            if (aVar instanceof k) {
                ((k) aVar).p0(tbPageTag);
            }
        }
    }
}

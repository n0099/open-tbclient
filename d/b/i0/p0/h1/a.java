package d.b.i0.p0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.i0.p0.k;
import d.b.i0.p0.s;
import d.b.i0.p0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f57559a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57560b;

    /* renamed from: c  reason: collision with root package name */
    public d f57561c;

    /* renamed from: d  reason: collision with root package name */
    public s f57562d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f57563e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57559a = frsADFragment;
        this.f57560b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f57561c = new d(this.f57559a.getPageContext(), c.l, this.f57559a.getUniqueId());
        this.f57562d = new s(this.f57559a.getPageContext(), t.f58578f);
        this.f57563e.add(this.f57561c);
        this.f57563e.add(this.f57562d);
        e();
        this.f57560b.a(this.f57563e);
    }

    public void b() {
        this.f57560b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.b.b.j.e.a aVar : this.f57563e) {
            if (aVar instanceof k) {
                ((k) aVar).m0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f57560b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f57563e) || this.f57559a == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57563e) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f57559a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.b.b.j.e.a> list = this.f57563e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f57563e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.c0(wVar);
            }
        }
    }
}

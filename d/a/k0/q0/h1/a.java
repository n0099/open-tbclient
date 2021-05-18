package d.a.k0.q0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.k0.q0.k;
import d.a.k0.q0.s;
import d.a.k0.q0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f58486a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58487b;

    /* renamed from: c  reason: collision with root package name */
    public d f58488c;

    /* renamed from: d  reason: collision with root package name */
    public s f58489d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58490e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58486a = frsADFragment;
        this.f58487b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f58488c = new d(this.f58486a.getPageContext(), c.l, this.f58486a.getUniqueId());
        this.f58489d = new s(this.f58486a.getPageContext(), t.f59517f);
        this.f58490e.add(this.f58488c);
        this.f58490e.add(this.f58489d);
        e();
        this.f58487b.a(this.f58490e);
    }

    public void b() {
        this.f58487b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.a.c.j.e.a aVar : this.f58490e) {
            if (aVar instanceof k) {
                ((k) aVar).h0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f58487b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f58490e) || this.f58486a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58490e) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f58486a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.a.c.j.e.a> list = this.f58490e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58490e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.Z(wVar);
            }
        }
    }
}

package d.a.j0.q0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.j0.q0.k;
import d.a.j0.q0.s;
import d.a.j0.q0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f57744a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57745b;

    /* renamed from: c  reason: collision with root package name */
    public d f57746c;

    /* renamed from: d  reason: collision with root package name */
    public s f57747d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57748e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57744a = frsADFragment;
        this.f57745b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f57746c = new d(this.f57744a.getPageContext(), c.l, this.f57744a.getUniqueId());
        this.f57747d = new s(this.f57744a.getPageContext(), t.f58775f);
        this.f57748e.add(this.f57746c);
        this.f57748e.add(this.f57747d);
        e();
        this.f57745b.a(this.f57748e);
    }

    public void b() {
        this.f57745b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.a.c.j.e.a aVar : this.f57748e) {
            if (aVar instanceof k) {
                ((k) aVar).i0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f57745b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f57748e) || this.f57744a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57748e) {
            if (aVar instanceof k) {
                ((k) aVar).q0(this.f57744a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.a.c.j.e.a> list = this.f57748e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57748e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.Z(wVar);
            }
        }
    }
}

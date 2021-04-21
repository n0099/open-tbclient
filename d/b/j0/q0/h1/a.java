package d.b.j0.q0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.j0.q0.k;
import d.b.j0.q0.s;
import d.b.j0.q0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f59680a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59681b;

    /* renamed from: c  reason: collision with root package name */
    public d f59682c;

    /* renamed from: d  reason: collision with root package name */
    public s f59683d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59684e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59680a = frsADFragment;
        this.f59681b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f59682c = new d(this.f59680a.getPageContext(), c.l, this.f59680a.getUniqueId());
        this.f59683d = new s(this.f59680a.getPageContext(), t.f60668f);
        this.f59684e.add(this.f59682c);
        this.f59684e.add(this.f59683d);
        e();
        this.f59681b.a(this.f59684e);
    }

    public void b() {
        this.f59681b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.b.c.j.e.a aVar : this.f59684e) {
            if (aVar instanceof k) {
                ((k) aVar).m0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f59681b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f59684e) || this.f59680a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59684e) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f59680a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.b.c.j.e.a> list = this.f59684e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59684e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.c0(wVar);
            }
        }
    }
}

package d.b.i0.q0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i0.q0.k;
import d.b.i0.q0.s;
import d.b.i0.q0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f59259a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59260b;

    /* renamed from: c  reason: collision with root package name */
    public d f59261c;

    /* renamed from: d  reason: collision with root package name */
    public s f59262d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59263e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59259a = frsADFragment;
        this.f59260b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f59261c = new d(this.f59259a.getPageContext(), c.l, this.f59259a.getUniqueId());
        this.f59262d = new s(this.f59259a.getPageContext(), t.f60247f);
        this.f59263e.add(this.f59261c);
        this.f59263e.add(this.f59262d);
        e();
        this.f59260b.a(this.f59263e);
    }

    public void b() {
        this.f59260b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.b.c.j.e.a aVar : this.f59263e) {
            if (aVar instanceof k) {
                ((k) aVar).m0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f59260b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f59263e) || this.f59259a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59263e) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f59259a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.b.c.j.e.a> list = this.f59263e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59263e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.c0(wVar);
            }
        }
    }
}

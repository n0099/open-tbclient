package d.a.n0.r0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.r0.k;
import d.a.n0.r0.s;
import d.a.n0.r0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f62318a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62319b;

    /* renamed from: c  reason: collision with root package name */
    public d f62320c;

    /* renamed from: d  reason: collision with root package name */
    public s f62321d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62322e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62318a = frsADFragment;
        this.f62319b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f62320c = new d(this.f62318a.getPageContext(), c.l, this.f62318a.getUniqueId());
        this.f62321d = new s(this.f62318a.getPageContext(), t.f63349f);
        this.f62322e.add(this.f62320c);
        this.f62322e.add(this.f62321d);
        e();
        this.f62319b.a(this.f62322e);
    }

    public void b() {
        this.f62319b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.a.c.k.e.a aVar : this.f62322e) {
            if (aVar instanceof k) {
                ((k) aVar).i0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f62319b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f62322e) || this.f62318a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62322e) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f62318a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.a.c.k.e.a> list = this.f62322e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62322e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.a0(wVar);
            }
        }
    }
}

package d.a.o0.r0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.o0.r0.k;
import d.a.o0.r0.s;
import d.a.o0.r0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f62443a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62444b;

    /* renamed from: c  reason: collision with root package name */
    public d f62445c;

    /* renamed from: d  reason: collision with root package name */
    public s f62446d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62447e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62443a = frsADFragment;
        this.f62444b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f62445c = new d(this.f62443a.getPageContext(), c.l, this.f62443a.getUniqueId());
        this.f62446d = new s(this.f62443a.getPageContext(), t.f63474f);
        this.f62447e.add(this.f62445c);
        this.f62447e.add(this.f62446d);
        e();
        this.f62444b.a(this.f62447e);
    }

    public void b() {
        this.f62444b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.a.c.k.e.a aVar : this.f62447e) {
            if (aVar instanceof k) {
                ((k) aVar).i0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f62444b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f62447e) || this.f62443a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62447e) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f62443a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.a.c.k.e.a> list = this.f62447e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62447e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.a0(wVar);
            }
        }
    }
}

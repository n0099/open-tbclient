package d.a.n0.r0.h1;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.n0.r0.k;
import d.a.n0.r0.s;
import d.a.n0.r0.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f58627a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58628b;

    /* renamed from: c  reason: collision with root package name */
    public d f58629c;

    /* renamed from: d  reason: collision with root package name */
    public s f58630d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58631e = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58627a = frsADFragment;
        this.f58628b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f58629c = new d(this.f58627a.getPageContext(), c.l, this.f58627a.getUniqueId());
        this.f58630d = new s(this.f58627a.getPageContext(), t.f59658f);
        this.f58631e.add(this.f58629c);
        this.f58631e.add(this.f58630d);
        e();
        this.f58628b.a(this.f58631e);
    }

    public void b() {
        this.f58628b.getAdapter().notifyDataSetChanged();
    }

    public void c() {
        for (d.a.c.j.e.a aVar : this.f58631e) {
            if (aVar instanceof k) {
                ((k) aVar).h0();
            }
        }
    }

    public void d(ArrayList<n> arrayList) {
        this.f58628b.setData(arrayList);
    }

    public final void e() {
        if (ListUtils.isEmpty(this.f58631e) || this.f58627a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58631e) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f58627a.getTbPageTag());
            }
        }
    }

    public void f(w wVar) {
        List<d.a.c.j.e.a> list = this.f58631e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58631e) {
            if (aVar != null && (aVar instanceof k)) {
                aVar.Z(wVar);
            }
        }
    }
}

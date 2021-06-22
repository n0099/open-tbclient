package d.a.o0.r0.i1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.o0.r0.i1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {

    /* renamed from: e  reason: collision with root package name */
    public e f62500e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f62501f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeListView f62502g;
    public boolean j;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f62503h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f62504i = new ArrayList();
    public int k = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.j = false;
        this.f62501f = tbPageContext;
        this.f62502g = bdTypeListView;
        this.j = z;
        d();
    }

    @Override // d.a.o0.r0.i1.a
    public void a(int i2) {
        this.k = i2;
        if (ListUtils.isEmpty(this.f62503h) || this.f62502g == null) {
            return;
        }
        for (n nVar : this.f62503h) {
            if (nVar instanceof g) {
                ((g) nVar).F = false;
            }
        }
        if (j.H()) {
            if (this.k < this.f62503h.size() - 1) {
                List<n> list = this.f62503h;
                int i3 = this.k + 1;
                this.k = i3;
                if (list.get(i3) instanceof g) {
                    ((g) this.f62503h.get(this.k)).F = true;
                    BdTypeListView bdTypeListView = this.f62502g;
                    bdTypeListView.smoothScrollToPositionFromTop(i2 + bdTypeListView.getHeaderViewsCount() + 1, 0);
                    g();
                }
            } else if (this.k == this.f62503h.size() - 1 && (this.f62503h.get(this.k) instanceof g)) {
                ((g) this.f62503h.get(this.k)).F = false;
            }
        }
    }

    public void b() {
        if (ListUtils.isEmpty(this.f62503h)) {
            return;
        }
        Iterator<n> it = this.f62503h.iterator();
        while (it.hasNext()) {
            ((g) it.next()).F = false;
        }
    }

    public int c() {
        return this.k;
    }

    @Override // d.a.o0.r0.i1.a
    public void cancel() {
        l();
    }

    public final void d() {
        e eVar = new e(this.f62501f, this, this.j);
        this.f62500e = eVar;
        this.f62504i.add(eVar);
        this.f62502g.a(this.f62504i);
    }

    public boolean e() {
        return this.f62500e.j0();
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f62503h) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).y) != null && str.equals(bVar.f62516a)) {
                gVar.y.f62520e = z;
                z2 = true;
            }
        }
        if (z2) {
            g();
        }
    }

    public void g() {
        BdTypeListView bdTypeListView = this.f62502g;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f62502g.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f62502g.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        this.f62500e.k0(configuration);
    }

    public void i() {
        this.f62500e.onDestroy();
    }

    public boolean j(int i2) {
        return this.f62500e.p0(i2);
    }

    public void k() {
        this.f62500e.q0();
    }

    public final void l() {
        b();
        this.k = 0;
        k();
    }

    public void m(List<g> list, boolean z) {
        if (list == null) {
            return;
        }
        if (z) {
            this.f62503h.clear();
        }
        this.f62503h.addAll(list);
        this.f62502g.setData(this.f62503h);
        if (z && list.size() > 0 && this.j && j.H()) {
            l();
            list.get(0).F = true;
        }
    }

    public void n() {
        this.f62500e.s0();
    }
}

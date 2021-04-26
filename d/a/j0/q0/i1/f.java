package d.a.j0.q0.i1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.j0.q0.i1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {

    /* renamed from: e  reason: collision with root package name */
    public e f57801e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f57802f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeListView f57803g;
    public boolean j;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f57804h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f57805i = new ArrayList();
    public int k = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.j = false;
        this.f57802f = tbPageContext;
        this.f57803g = bdTypeListView;
        this.j = z;
        d();
    }

    @Override // d.a.j0.q0.i1.a
    public void a(int i2) {
        this.k = i2;
        if (ListUtils.isEmpty(this.f57804h) || this.f57803g == null) {
            return;
        }
        for (n nVar : this.f57804h) {
            if (nVar instanceof g) {
                ((g) nVar).F = false;
            }
        }
        if (j.H()) {
            if (this.k < this.f57804h.size() - 1) {
                List<n> list = this.f57804h;
                int i3 = this.k + 1;
                this.k = i3;
                if (list.get(i3) instanceof g) {
                    ((g) this.f57804h.get(this.k)).F = true;
                    BdTypeListView bdTypeListView = this.f57803g;
                    bdTypeListView.smoothScrollToPositionFromTop(i2 + bdTypeListView.getHeaderViewsCount() + 1, 0);
                    g();
                }
            } else if (this.k == this.f57804h.size() - 1 && (this.f57804h.get(this.k) instanceof g)) {
                ((g) this.f57804h.get(this.k)).F = false;
            }
        }
    }

    public void b() {
        if (ListUtils.isEmpty(this.f57804h)) {
            return;
        }
        Iterator<n> it = this.f57804h.iterator();
        while (it.hasNext()) {
            ((g) it.next()).F = false;
        }
    }

    public int c() {
        return this.k;
    }

    @Override // d.a.j0.q0.i1.a
    public void cancel() {
        l();
    }

    public final void d() {
        e eVar = new e(this.f57802f, this, this.j);
        this.f57801e = eVar;
        this.f57805i.add(eVar);
        this.f57803g.a(this.f57805i);
    }

    public boolean e() {
        return this.f57801e.i0();
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f57804h) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).y) != null && str.equals(bVar.f57817a)) {
                gVar.y.f57821e = z;
                z2 = true;
            }
        }
        if (z2) {
            g();
        }
    }

    public void g() {
        BdTypeListView bdTypeListView = this.f57803g;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f57803g.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f57803g.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        this.f57801e.j0(configuration);
    }

    public void i() {
        this.f57801e.onDestroy();
    }

    public boolean j(int i2) {
        return this.f57801e.p0(i2);
    }

    public void k() {
        this.f57801e.q0();
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
            this.f57804h.clear();
        }
        this.f57804h.addAll(list);
        this.f57803g.setData(this.f57804h);
        if (z && list.size() > 0 && this.j && j.H()) {
            l();
            list.get(0).F = true;
        }
    }

    public void n() {
        this.f57801e.r0();
    }
}

package d.b.i0.q0.i1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.i0.q0.i1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {

    /* renamed from: e  reason: collision with root package name */
    public e f59314e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f59315f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeListView f59316g;
    public boolean j;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f59317h = new ArrayList();
    public final List<d.b.c.j.e.a> i = new ArrayList();
    public int k = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.j = false;
        this.f59315f = tbPageContext;
        this.f59316g = bdTypeListView;
        this.j = z;
        d();
    }

    @Override // d.b.i0.q0.i1.a
    public void a(int i) {
        this.k = i;
        if (ListUtils.isEmpty(this.f59317h) || this.f59316g == null) {
            return;
        }
        for (n nVar : this.f59317h) {
            if (nVar instanceof g) {
                ((g) nVar).F = false;
            }
        }
        if (j.H()) {
            if (this.k < this.f59317h.size() - 1) {
                List<n> list = this.f59317h;
                int i2 = this.k + 1;
                this.k = i2;
                if (list.get(i2) instanceof g) {
                    ((g) this.f59317h.get(this.k)).F = true;
                    BdTypeListView bdTypeListView = this.f59316g;
                    bdTypeListView.smoothScrollToPositionFromTop(i + bdTypeListView.getHeaderViewsCount() + 1, 0);
                    g();
                }
            } else if (this.k == this.f59317h.size() - 1 && (this.f59317h.get(this.k) instanceof g)) {
                ((g) this.f59317h.get(this.k)).F = false;
            }
        }
    }

    public void b() {
        if (ListUtils.isEmpty(this.f59317h)) {
            return;
        }
        Iterator<n> it = this.f59317h.iterator();
        while (it.hasNext()) {
            ((g) it.next()).F = false;
        }
    }

    public int c() {
        return this.k;
    }

    @Override // d.b.i0.q0.i1.a
    public void cancel() {
        l();
    }

    public final void d() {
        e eVar = new e(this.f59315f, this, this.j);
        this.f59314e = eVar;
        this.i.add(eVar);
        this.f59316g.a(this.i);
    }

    public boolean e() {
        return this.f59314e.m0();
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f59317h) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).y) != null && str.equals(bVar.f59328a)) {
                gVar.y.f59332e = z;
                z2 = true;
            }
        }
        if (z2) {
            g();
        }
    }

    public void g() {
        BdTypeListView bdTypeListView = this.f59316g;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f59316g.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f59316g.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        this.f59314e.n0(configuration);
    }

    public void i() {
        this.f59314e.onDestroy();
    }

    public boolean j(int i) {
        return this.f59314e.q0(i);
    }

    public void k() {
        this.f59314e.r0();
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
            this.f59317h.clear();
        }
        this.f59317h.addAll(list);
        this.f59316g.setData(this.f59317h);
        if (z && list.size() > 0 && this.j && j.H()) {
            l();
            list.get(0).F = true;
        }
    }

    public void n() {
        this.f59314e.s0();
    }
}

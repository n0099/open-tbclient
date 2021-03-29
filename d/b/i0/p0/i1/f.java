package d.b.i0.p0.i1;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.i0.p0.i1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {

    /* renamed from: e  reason: collision with root package name */
    public e f57615e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f57616f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeListView f57617g;
    public boolean j;

    /* renamed from: h  reason: collision with root package name */
    public List<n> f57618h = new ArrayList();
    public final List<d.b.b.j.e.a> i = new ArrayList();
    public int k = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.j = false;
        this.f57616f = tbPageContext;
        this.f57617g = bdTypeListView;
        this.j = z;
        d();
    }

    @Override // d.b.i0.p0.i1.a
    public void a(int i) {
        this.k = i;
        if (ListUtils.isEmpty(this.f57618h) || this.f57617g == null) {
            return;
        }
        for (n nVar : this.f57618h) {
            if (nVar instanceof g) {
                ((g) nVar).F = false;
            }
        }
        if (j.H()) {
            if (this.k < this.f57618h.size() - 1) {
                List<n> list = this.f57618h;
                int i2 = this.k + 1;
                this.k = i2;
                if (list.get(i2) instanceof g) {
                    ((g) this.f57618h.get(this.k)).F = true;
                    BdTypeListView bdTypeListView = this.f57617g;
                    bdTypeListView.smoothScrollToPositionFromTop(i + bdTypeListView.getHeaderViewsCount() + 1, 0);
                    g();
                }
            } else if (this.k == this.f57618h.size() - 1 && (this.f57618h.get(this.k) instanceof g)) {
                ((g) this.f57618h.get(this.k)).F = false;
            }
        }
    }

    public void b() {
        if (ListUtils.isEmpty(this.f57618h)) {
            return;
        }
        Iterator<n> it = this.f57618h.iterator();
        while (it.hasNext()) {
            ((g) it.next()).F = false;
        }
    }

    public int c() {
        return this.k;
    }

    @Override // d.b.i0.p0.i1.a
    public void cancel() {
        l();
    }

    public final void d() {
        e eVar = new e(this.f57616f, this, this.j);
        this.f57615e = eVar;
        this.i.add(eVar);
        this.f57617g.a(this.i);
    }

    public boolean e() {
        return this.f57615e.m0();
    }

    public void f(String str, boolean z) {
        g gVar;
        g.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        for (n nVar : this.f57618h) {
            if (nVar != null && (nVar instanceof g) && (bVar = (gVar = (g) nVar).y) != null && str.equals(bVar.f57629a)) {
                gVar.y.f57633e = z;
                z2 = true;
            }
        }
        if (z2) {
            g();
        }
    }

    public void g() {
        BdTypeListView bdTypeListView = this.f57617g;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f57617g.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f57617g.getAdapter2().notifyDataSetChanged();
    }

    public void h(Configuration configuration) {
        this.f57615e.n0(configuration);
    }

    public void i() {
        this.f57615e.onDestroy();
    }

    public boolean j(int i) {
        return this.f57615e.q0(i);
    }

    public void k() {
        this.f57615e.r0();
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
            this.f57618h.clear();
        }
        this.f57618h.addAll(list);
        this.f57617g.setData(this.f57618h);
        if (z && list.size() > 0 && this.j && j.H()) {
            l();
            list.get(0).F = true;
        }
    }

    public void n() {
        this.f57615e.s0();
    }
}

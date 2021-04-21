package d.b.j0.q0.p2;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.j0.j1.o.l.k;
import d.b.j0.q0.i1.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.b.j0.q0.i1.a, d.b.j0.j1.o.l.f, b, d.b.j0.j1.o.l.g {

    /* renamed from: e  reason: collision with root package name */
    public e f60401e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.d.l.a f60402f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.j.e.a f60403g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f60404h;
    public BdTypeRecyclerView i;
    public String l;
    public boolean m;
    public String q;
    public c r;
    public k s;
    public d.b.j0.q0.p2.a t;
    public BdUniqueId u;
    public RecyclerView.SmoothScroller v;
    public List<n> j = new ArrayList();
    public final List<d.b.c.j.e.a> k = new ArrayList();
    public boolean n = false;
    public int o = -1;
    public int p = -1;

    /* loaded from: classes4.dex */
    public class a extends LinearSmoothScroller {
        public a(f fVar, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 5)) - (i + ((i2 - i) / 5));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 0.2f;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            return -1;
        }
    }

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.m = false;
        this.f60404h = tbPageContext;
        this.u = bdUniqueId;
        this.i = bdTypeRecyclerView;
        this.m = z;
        this.r = cVar;
        this.l = str;
        this.q = str2;
        i();
    }

    public void A() {
        this.f60401e.z0();
        this.f60402f.s0();
    }

    public void B(d.b.j0.q0.i1.g gVar) {
        if (gVar == null || ListUtils.isEmpty(this.j) || this.j.get(0) == null) {
            return;
        }
        this.n = true;
        g.c cVar = ((d.b.j0.q0.i1.g) this.j.get(0)).z;
        g.c cVar2 = gVar.z;
        cVar.n = cVar2.n;
        cVar.o = cVar2.o;
    }

    @Override // d.b.j0.q0.i1.a
    public void a(int i) {
        y(i);
    }

    @Override // d.b.j0.j1.o.l.g
    public void b(d.b.j0.x.b bVar) {
        if (bVar instanceof d.b.j0.q0.p2.a) {
            this.t = (d.b.j0.q0.p2.a) bVar;
        }
    }

    @Override // d.b.j0.q0.p2.b
    public d.b.d.m.e.b c(String str) {
        List<n> list = this.j;
        if (list == null || list.isEmpty() || str == null) {
            return null;
        }
        d.b.d.m.e.b bVar = new d.b.d.m.e.b();
        int i = 0;
        int i2 = -1;
        boolean z = false;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            if (i >= this.j.size()) {
                i = -1;
                break;
            }
            if (this.j.get(i) instanceof d.b.d.d) {
                if (k(this.j.get(i))) {
                    if (z) {
                        break;
                    }
                    i4 = i;
                } else if (z) {
                    i3++;
                }
            }
            if ((this.j.get(i) instanceof d.b.j0.q0.i1.g) && str.equals(((d.b.j0.q0.i1.g) this.j.get(i)).n())) {
                z = true;
                i5 = i;
            }
            i++;
        }
        if (i == -1 || (i = i - i3) >= -1) {
            i2 = i;
        }
        bVar.h(str);
        bVar.g(i4);
        bVar.e(i5);
        bVar.f(i2);
        return bVar;
    }

    @Override // d.b.j0.q0.i1.a
    public void cancel() {
        u();
    }

    public void d(int i) {
        k kVar;
        if (this.o == i && (kVar = this.s) != null && kVar.isPlaying()) {
            return;
        }
        if (this.o == i && this.s != null && m()) {
            return;
        }
        this.o = i;
        this.p = i;
        if (ListUtils.isEmpty(this.j) || this.i == null) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.b.j0.j1.o.l.i) {
                d.b.j0.j1.o.l.i iVar = (d.b.j0.j1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
        if (this.o > this.j.size() - 1 || !(this.j.get(this.o) instanceof d.b.j0.j1.o.l.i)) {
            return;
        }
        d.b.j0.j1.o.l.i iVar2 = (d.b.j0.j1.o.l.i) this.j.get(this.o);
        iVar2.setAutoPlay(true);
        if (!j.H() && !d.b.j0.q3.f.d().e()) {
            iVar2.setWaitConfirm(true);
        } else {
            iVar2.setWaitConfirm(false);
        }
        o();
    }

    public void e() {
        if (ListUtils.isEmpty(this.j)) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.b.j0.j1.o.l.i) {
                d.b.j0.j1.o.l.i iVar = (d.b.j0.j1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
    }

    public d.b.j0.q0.p2.a f() {
        return this.t;
    }

    public int g() {
        return this.o;
    }

    public int h(int i) {
        int size = this.j.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (k(this.j.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public final void i() {
        this.f60401e = new e(this.f60404h, this, this.r, this.m, this.l, this.q, this, this.u, this, this);
        this.f60402f = new d.b.d.l.a(this.f60404h, d.b.d.b.f43233b, this, this.r, this);
        this.f60403g = new d.b.d.l.b(this.f60404h, d.b.d.b.f43232a);
        this.k.add(this.f60401e);
        this.k.add(this.f60403g);
        this.k.add(this.f60402f);
        this.i.a(this.k);
    }

    public boolean j() {
        return this.f60401e.p0() || this.f60402f.l0();
    }

    public final boolean k(n nVar) {
        d.b.d.e j;
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof d.b.j0.q0.i1.g) {
            return true;
        }
        return (!(nVar instanceof d.b.d.d) || (j = ((d.b.d.d) nVar).j()) == null || j.f43242a) ? false : true;
    }

    public boolean l(int i) {
        if (i < 0 || i >= this.j.size()) {
            return false;
        }
        return k(this.j.get(i));
    }

    public boolean m() {
        return this.f60401e.q0();
    }

    public void n(String str, boolean z) {
        d.b.j0.q0.i1.g gVar;
        g.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar != null && (nVar instanceof d.b.j0.q0.i1.g) && (bVar = (gVar = (d.b.j0.q0.i1.g) nVar).y) != null && str.equals(bVar.f59749a)) {
                gVar.y.f59753e = z;
            }
        }
    }

    public void o() {
        BdTypeRecyclerView bdTypeRecyclerView = this.i;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getListAdapter() == null) {
            return;
        }
        this.i.getListAdapter().notifyDataSetChanged();
    }

    public void p(Configuration configuration) {
        this.f60401e.r0(configuration);
    }

    @Override // d.b.j0.j1.o.l.f
    public void q(k kVar) {
        k kVar2 = this.s;
        this.s = kVar;
        if (kVar2 == null || kVar2 == kVar) {
            return;
        }
        kVar2.stopPlay();
    }

    public void r() {
        this.f60401e.onDestroy();
        this.f60402f.p0();
    }

    public boolean s(int i) {
        return this.f60401e.u0(i);
    }

    public void t() {
        this.f60401e.v0();
        this.f60402f.r0();
    }

    public final void u() {
        e();
        this.o = 0;
        this.p = -1;
        t();
    }

    public void v() {
        this.f60401e.w0();
    }

    public void w(List<BaseCardInfo> list, boolean z) {
        if (list == null) {
            return;
        }
        int size = this.j.size();
        this.j.addAll(list);
        if (this.n) {
            this.n = false;
            this.i.setData(this.j);
        } else {
            this.i.setDataWithPartChange(this.j, size, list.size());
        }
        if (list.size() > 0 && this.m && z) {
            u();
            if (list.get(0) instanceof d.b.j0.j1.o.l.i) {
                d.b.j0.j1.o.l.i iVar = (d.b.j0.j1.o.l.i) list.get(0);
                iVar.setAutoPlay(true);
                if (j.x() && !d.b.j0.q3.f.d().e()) {
                    iVar.setWaitConfirm(true);
                } else {
                    iVar.setWaitConfirm(false);
                }
            }
        }
        int i = this.o;
        if (i == -1) {
            i = this.p;
        }
        if (this.j.size() <= i || z || i == -1 || !(this.j.get(i) instanceof d.b.j0.j1.o.l.i)) {
            return;
        }
        d.b.j0.j1.o.l.i iVar2 = (d.b.j0.j1.o.l.i) this.j.get(i);
        iVar2.setAutoPlay(true);
        if (!j.H() && !d.b.j0.q3.f.d().e()) {
            iVar2.setWaitConfirm(true);
            o();
            return;
        }
        iVar2.setWaitConfirm(false);
    }

    public void x(boolean z) {
        this.f60401e.x0(z);
    }

    public void y(int i) {
        this.o = i;
        this.p = i;
        if (ListUtils.isEmpty(this.j) || this.i == null) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.b.j0.j1.o.l.i) {
                d.b.j0.j1.o.l.i iVar = (d.b.j0.j1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
        if (this.o < this.j.size() - 1) {
            int h2 = h(i);
            int i2 = this.o + h2;
            this.o = i2;
            if (this.j.get(i2) instanceof d.b.j0.j1.o.l.i) {
                d.b.j0.j1.o.l.i iVar2 = (d.b.j0.j1.o.l.i) this.j.get(i2);
                iVar2.setAutoPlay(true);
                if (!j.H() && !d.b.j0.q3.f.d().e()) {
                    iVar2.setWaitConfirm(true);
                } else {
                    iVar2.setWaitConfirm(false);
                }
                if (this.v == null) {
                    this.v = new a(this, this.f60404h.getContext());
                }
                this.v.setTargetPosition(i + this.i.getHeaderViewsCount() + h2);
                this.i.getLayoutManager().startSmoothScroll(this.v);
                o();
            }
        } else if (this.o == this.j.size() - 1 && (this.j.get(this.o) instanceof d.b.j0.j1.o.l.i)) {
            d.b.j0.j1.o.l.i iVar3 = (d.b.j0.j1.o.l.i) this.j.get(this.o);
            iVar3.setAutoPlay(true);
            if (!j.H() && !d.b.j0.q3.f.d().e()) {
                iVar3.setWaitConfirm(true);
            } else {
                iVar3.setWaitConfirm(false);
            }
            o();
        }
    }

    public void z() {
        this.f60401e.y0();
    }
}

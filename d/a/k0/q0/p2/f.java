package d.a.k0.q0.p2;

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
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.k0.j1.o.l.k;
import d.a.k0.q0.i1.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.a.k0.q0.i1.a, d.a.k0.j1.o.l.f, b, d.a.k0.j1.o.l.g {

    /* renamed from: e  reason: collision with root package name */
    public e f59235e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.l.a f59236f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.j.e.a f59237g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f59238h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f59239i;
    public String l;
    public boolean m;
    public String q;
    public c r;
    public k s;
    public d.a.k0.q0.p2.a t;
    public BdUniqueId u;
    public RecyclerView.SmoothScroller v;
    public List<n> j = new ArrayList();
    public final List<d.a.c.j.e.a> k = new ArrayList();
    public boolean n = false;
    public int o = -1;
    public int p = -1;

    /* loaded from: classes4.dex */
    public class a extends LinearSmoothScroller {
        public a(f fVar, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
            return (i4 + ((i5 - i4) / 5)) - (i2 + ((i3 - i2) / 5));
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
        this.f59238h = tbPageContext;
        this.u = bdUniqueId;
        this.f59239i = bdTypeRecyclerView;
        this.m = z;
        this.r = cVar;
        this.l = str;
        this.q = str2;
        j();
    }

    public void A() {
        this.f59235e.z0();
        this.f59236f.s0();
    }

    public void B(d.a.k0.q0.i1.g gVar) {
        if (gVar == null || ListUtils.isEmpty(this.j) || this.j.get(0) == null) {
            return;
        }
        this.n = true;
        g.c cVar = ((d.a.k0.q0.i1.g) this.j.get(0)).z;
        g.c cVar2 = gVar.z;
        cVar.n = cVar2.n;
        cVar.o = cVar2.o;
    }

    @Override // d.a.k0.q0.i1.a
    public void a(int i2) {
        y(i2);
    }

    @Override // d.a.k0.j1.o.l.g
    public void b(d.a.k0.x.b bVar) {
        if (bVar instanceof d.a.k0.q0.p2.a) {
            this.t = (d.a.k0.q0.p2.a) bVar;
        }
    }

    @Override // d.a.k0.q0.p2.b
    public d.a.d.m.e.b c(String str) {
        List<n> list = this.j;
        if (list == null || list.isEmpty() || str == null) {
            return null;
        }
        d.a.d.m.e.b bVar = new d.a.d.m.e.b();
        int i2 = 0;
        int i3 = -1;
        boolean z = false;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= this.j.size()) {
                i2 = -1;
                break;
            }
            if (this.j.get(i2) instanceof d.a.d.d) {
                if (l(this.j.get(i2))) {
                    if (z) {
                        break;
                    }
                    i5 = i2;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.j.get(i2) instanceof d.a.k0.q0.i1.g) && str.equals(((d.a.k0.q0.i1.g) this.j.get(i2)).m())) {
                z = true;
                i6 = i2;
            }
            i2++;
        }
        if (i2 == -1 || (i2 = i2 - i4) >= -1) {
            i3 = i2;
        }
        bVar.h(str);
        bVar.g(i5);
        bVar.e(i6);
        bVar.f(i3);
        return bVar;
    }

    @Override // d.a.k0.q0.i1.a
    public void cancel() {
        u();
    }

    public void d(int i2) {
        k kVar;
        if (this.o == i2 && (kVar = this.s) != null && kVar.isPlaying()) {
            return;
        }
        if (this.o == i2 && this.s != null && n()) {
            return;
        }
        this.o = i2;
        this.p = i2;
        if (ListUtils.isEmpty(this.j) || this.f59239i == null) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.a.k0.j1.o.l.i) {
                d.a.k0.j1.o.l.i iVar = (d.a.k0.j1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
        if (this.o > this.j.size() - 1 || !(this.j.get(this.o) instanceof d.a.k0.j1.o.l.i)) {
            return;
        }
        d.a.k0.j1.o.l.i iVar2 = (d.a.k0.j1.o.l.i) this.j.get(this.o);
        iVar2.setAutoPlay(true);
        if (!j.H() && !d.a.k0.q3.f.d().e()) {
            iVar2.setWaitConfirm(true);
        } else {
            iVar2.setWaitConfirm(false);
        }
        p();
    }

    public void e() {
        if (ListUtils.isEmpty(this.j)) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.a.k0.j1.o.l.i) {
                d.a.k0.j1.o.l.i iVar = (d.a.k0.j1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
    }

    public d.a.k0.q0.p2.a f() {
        return this.t;
    }

    public int g() {
        return this.o;
    }

    @Override // d.a.k0.j1.o.l.f
    public void h(k kVar) {
        k kVar2 = this.s;
        this.s = kVar;
        if (kVar2 == null || kVar2 == kVar) {
            return;
        }
        kVar2.stopPlay();
    }

    public int i(int i2) {
        int size = this.j.size();
        for (int i3 = i2 + 1; i3 < size; i3++) {
            if (l(this.j.get(i3))) {
                return i3 - i2;
            }
        }
        return 1;
    }

    public final void j() {
        this.f59235e = new e(this.f59238h, this, this.r, this.m, this.l, this.q, this, this.u, this, this);
        this.f59236f = new d.a.d.l.a(this.f59238h, d.a.d.b.f39711b, this, this.r, this);
        this.f59237g = new d.a.d.l.b(this.f59238h, d.a.d.b.f39710a);
        this.k.add(this.f59235e);
        this.k.add(this.f59237g);
        this.k.add(this.f59236f);
        this.f59239i.a(this.k);
    }

    public boolean k() {
        return this.f59235e.n0() || this.f59236f.h0();
    }

    public final boolean l(n nVar) {
        d.a.d.e l;
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof d.a.k0.q0.i1.g) {
            return true;
        }
        return (!(nVar instanceof d.a.d.d) || (l = ((d.a.d.d) nVar).l()) == null || l.f39721a) ? false : true;
    }

    public boolean m(int i2) {
        if (i2 < 0 || i2 >= this.j.size()) {
            return false;
        }
        return l(this.j.get(i2));
    }

    public boolean n() {
        return this.f59235e.p0();
    }

    public void o(String str, boolean z) {
        d.a.k0.q0.i1.g gVar;
        g.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar != null && (nVar instanceof d.a.k0.q0.i1.g) && (bVar = (gVar = (d.a.k0.q0.i1.g) nVar).y) != null && str.equals(bVar.f58559a)) {
                gVar.y.f58563e = z;
            }
        }
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59239i;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getListAdapter() == null) {
            return;
        }
        this.f59239i.getListAdapter().notifyDataSetChanged();
    }

    public void q(Configuration configuration) {
        this.f59235e.q0(configuration);
    }

    public void r() {
        this.f59235e.onDestroy();
        this.f59236f.n0();
    }

    public boolean s(int i2) {
        return this.f59235e.u0(i2);
    }

    public void t() {
        this.f59235e.v0();
        this.f59236f.q0();
    }

    public final void u() {
        e();
        this.o = 0;
        this.p = -1;
        t();
    }

    public void v() {
        this.f59235e.w0();
    }

    public void w(List<BaseCardInfo> list, boolean z) {
        if (list == null) {
            return;
        }
        int size = this.j.size();
        this.j.addAll(list);
        if (this.n) {
            this.n = false;
            this.f59239i.setData(this.j);
        } else {
            this.f59239i.setDataWithPartChange(this.j, size, list.size());
        }
        if (list.size() > 0 && this.m && z) {
            u();
            if (list.get(0) instanceof d.a.k0.j1.o.l.i) {
                d.a.k0.j1.o.l.i iVar = (d.a.k0.j1.o.l.i) list.get(0);
                iVar.setAutoPlay(true);
                if (j.x() && !d.a.k0.q3.f.d().e()) {
                    iVar.setWaitConfirm(true);
                } else {
                    iVar.setWaitConfirm(false);
                }
            }
        }
        int i2 = this.o;
        if (i2 == -1) {
            i2 = this.p;
        }
        if (this.j.size() <= i2 || z || i2 == -1 || !(this.j.get(i2) instanceof d.a.k0.j1.o.l.i)) {
            return;
        }
        d.a.k0.j1.o.l.i iVar2 = (d.a.k0.j1.o.l.i) this.j.get(i2);
        iVar2.setAutoPlay(true);
        if (!j.H() && !d.a.k0.q3.f.d().e()) {
            iVar2.setWaitConfirm(true);
            p();
            return;
        }
        iVar2.setWaitConfirm(false);
    }

    public void x(boolean z) {
        this.f59235e.x0(z);
    }

    public void y(int i2) {
        this.o = i2;
        this.p = i2;
        if (ListUtils.isEmpty(this.j) || this.f59239i == null) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.a.k0.j1.o.l.i) {
                d.a.k0.j1.o.l.i iVar = (d.a.k0.j1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
        if (this.o < this.j.size() - 1) {
            int i3 = i(i2);
            int i4 = this.o + i3;
            this.o = i4;
            if (this.j.get(i4) instanceof d.a.k0.j1.o.l.i) {
                d.a.k0.j1.o.l.i iVar2 = (d.a.k0.j1.o.l.i) this.j.get(i4);
                iVar2.setAutoPlay(true);
                if (!j.H() && !d.a.k0.q3.f.d().e()) {
                    iVar2.setWaitConfirm(true);
                } else {
                    iVar2.setWaitConfirm(false);
                }
                if (this.v == null) {
                    this.v = new a(this, this.f59238h.getContext());
                }
                this.v.setTargetPosition(i2 + this.f59239i.getHeaderViewsCount() + i3);
                this.f59239i.getLayoutManager().startSmoothScroll(this.v);
                p();
            }
        } else if (this.o == this.j.size() - 1 && (this.j.get(this.o) instanceof d.a.k0.j1.o.l.i)) {
            d.a.k0.j1.o.l.i iVar3 = (d.a.k0.j1.o.l.i) this.j.get(this.o);
            iVar3.setAutoPlay(true);
            if (!j.H() && !d.a.k0.q3.f.d().e()) {
                iVar3.setWaitConfirm(true);
            } else {
                iVar3.setWaitConfirm(false);
            }
            p();
        }
    }

    public void z() {
        this.f59235e.y0();
    }
}

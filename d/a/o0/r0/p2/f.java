package d.a.o0.r0.p2;

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
import d.a.c.k.e.n;
import d.a.o0.k1.o.l.k;
import d.a.o0.r0.i1.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d.a.o0.r0.i1.a, d.a.o0.k1.o.l.f, b, d.a.o0.k1.o.l.g {

    /* renamed from: e  reason: collision with root package name */
    public e f63192e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.l.a f63193f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.k.e.a f63194g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f63195h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f63196i;
    public String l;
    public boolean m;
    public String q;
    public c r;
    public k s;
    public d.a.o0.r0.p2.a t;
    public BdUniqueId u;
    public RecyclerView.SmoothScroller v;
    public List<n> j = new ArrayList();
    public final List<d.a.c.k.e.a> k = new ArrayList();
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
        this.f63195h = tbPageContext;
        this.u = bdUniqueId;
        this.f63196i = bdTypeRecyclerView;
        this.m = z;
        this.r = cVar;
        this.l = str;
        this.q = str2;
        j();
    }

    public void A() {
        this.f63192e.A0();
        this.f63193f.s0();
    }

    public void B(d.a.o0.r0.i1.g gVar) {
        if (gVar == null || ListUtils.isEmpty(this.j) || this.j.get(0) == null) {
            return;
        }
        this.n = true;
        g.c cVar = ((d.a.o0.r0.i1.g) this.j.get(0)).z;
        g.c cVar2 = gVar.z;
        cVar.n = cVar2.n;
        cVar.o = cVar2.o;
    }

    @Override // d.a.o0.r0.i1.a
    public void a(int i2) {
        y(i2);
    }

    @Override // d.a.o0.k1.o.l.g
    public void b(d.a.o0.z.b bVar) {
        if (bVar instanceof d.a.o0.r0.p2.a) {
            this.t = (d.a.o0.r0.p2.a) bVar;
        }
    }

    @Override // d.a.o0.r0.p2.b
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
            if ((this.j.get(i2) instanceof d.a.o0.r0.i1.g) && str.equals(((d.a.o0.r0.i1.g) this.j.get(i2)).i())) {
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

    @Override // d.a.o0.r0.i1.a
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
        if (ListUtils.isEmpty(this.j) || this.f63196i == null) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.a.o0.k1.o.l.i) {
                d.a.o0.k1.o.l.i iVar = (d.a.o0.k1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
        if (this.o > this.j.size() - 1 || !(this.j.get(this.o) instanceof d.a.o0.k1.o.l.i)) {
            return;
        }
        d.a.o0.k1.o.l.i iVar2 = (d.a.o0.k1.o.l.i) this.j.get(this.o);
        iVar2.setAutoPlay(true);
        if (!j.H() && !d.a.o0.r3.f.d().e()) {
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
            if (nVar instanceof d.a.o0.k1.o.l.i) {
                d.a.o0.k1.o.l.i iVar = (d.a.o0.k1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
    }

    public d.a.o0.r0.p2.a f() {
        return this.t;
    }

    public int g() {
        return this.o;
    }

    @Override // d.a.o0.k1.o.l.f
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
        this.f63192e = new e(this.f63195h, this, this.r, this.m, this.l, this.q, this, this.u, this, this);
        this.f63193f = new d.a.d.l.a(this.f63195h, d.a.d.b.f43311b, this, this.r, this);
        this.f63194g = new d.a.d.l.b(this.f63195h, d.a.d.b.f43310a);
        this.k.add(this.f63192e);
        this.k.add(this.f63194g);
        this.k.add(this.f63193f);
        this.f63196i.a(this.k);
    }

    public boolean k() {
        return this.f63192e.m0() || this.f63193f.i0();
    }

    public final boolean l(n nVar) {
        d.a.d.e g2;
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof d.a.o0.r0.i1.g) {
            return true;
        }
        return (!(nVar instanceof d.a.d.d) || (g2 = ((d.a.d.d) nVar).g()) == null || g2.f43321a) ? false : true;
    }

    public boolean m(int i2) {
        if (i2 < 0 || i2 >= this.j.size()) {
            return false;
        }
        return l(this.j.get(i2));
    }

    public boolean n() {
        return this.f63192e.p0();
    }

    public void o(String str, boolean z) {
        d.a.o0.r0.i1.g gVar;
        g.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar != null && (nVar instanceof d.a.o0.r0.i1.g) && (bVar = (gVar = (d.a.o0.r0.i1.g) nVar).y) != null && str.equals(bVar.f62516a)) {
                gVar.y.f62520e = z;
            }
        }
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63196i;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getListAdapter() == null) {
            return;
        }
        this.f63196i.getListAdapter().notifyDataSetChanged();
    }

    public void q(Configuration configuration) {
        this.f63192e.q0(configuration);
    }

    public void r() {
        this.f63192e.onDestroy();
        this.f63193f.m0();
    }

    public boolean s(int i2) {
        return this.f63192e.v0(i2);
    }

    public void t() {
        this.f63192e.w0();
        this.f63193f.q0();
    }

    public final void u() {
        e();
        this.o = 0;
        this.p = -1;
        t();
    }

    public void v() {
        this.f63192e.x0();
    }

    public void w(List<BaseCardInfo> list, boolean z) {
        if (list == null) {
            return;
        }
        int size = this.j.size();
        this.j.addAll(list);
        if (this.n) {
            this.n = false;
            this.f63196i.setData(this.j);
        } else {
            this.f63196i.setDataWithPartChange(this.j, size, list.size());
        }
        if (list.size() > 0 && this.m && z) {
            u();
            if (list.get(0) instanceof d.a.o0.k1.o.l.i) {
                d.a.o0.k1.o.l.i iVar = (d.a.o0.k1.o.l.i) list.get(0);
                iVar.setAutoPlay(true);
                if (j.x() && !d.a.o0.r3.f.d().e()) {
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
        if (this.j.size() <= i2 || z || i2 == -1 || !(this.j.get(i2) instanceof d.a.o0.k1.o.l.i)) {
            return;
        }
        d.a.o0.k1.o.l.i iVar2 = (d.a.o0.k1.o.l.i) this.j.get(i2);
        iVar2.setAutoPlay(true);
        if (!j.H() && !d.a.o0.r3.f.d().e()) {
            iVar2.setWaitConfirm(true);
            p();
            return;
        }
        iVar2.setWaitConfirm(false);
    }

    public void x(boolean z) {
        this.f63192e.y0(z);
    }

    public void y(int i2) {
        this.o = i2;
        this.p = i2;
        if (ListUtils.isEmpty(this.j) || this.f63196i == null) {
            return;
        }
        for (n nVar : this.j) {
            if (nVar instanceof d.a.o0.k1.o.l.i) {
                d.a.o0.k1.o.l.i iVar = (d.a.o0.k1.o.l.i) nVar;
                iVar.setAutoPlay(false);
                iVar.setWaitConfirm(false);
            }
        }
        if (this.o < this.j.size() - 1) {
            int i3 = i(i2);
            int i4 = this.o + i3;
            this.o = i4;
            if (this.j.get(i4) instanceof d.a.o0.k1.o.l.i) {
                d.a.o0.k1.o.l.i iVar2 = (d.a.o0.k1.o.l.i) this.j.get(i4);
                iVar2.setAutoPlay(true);
                if (!j.H() && !d.a.o0.r3.f.d().e()) {
                    iVar2.setWaitConfirm(true);
                } else {
                    iVar2.setWaitConfirm(false);
                }
                if (this.v == null) {
                    this.v = new a(this, this.f63195h.getContext());
                }
                this.v.setTargetPosition(i2 + this.f63196i.getHeaderViewsCount() + i3);
                this.f63196i.getLayoutManager().startSmoothScroll(this.v);
                p();
            }
        } else if (this.o == this.j.size() - 1 && (this.j.get(this.o) instanceof d.a.o0.k1.o.l.i)) {
            d.a.o0.k1.o.l.i iVar3 = (d.a.o0.k1.o.l.i) this.j.get(this.o);
            iVar3.setAutoPlay(true);
            if (!j.H() && !d.a.o0.r3.f.d().e()) {
                iVar3.setWaitConfirm(true);
            } else {
                iVar3.setWaitConfirm(false);
            }
            p();
        }
    }

    public void z() {
        this.f63192e.z0();
    }
}

package d.a.i0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes3.dex */
public class z1 extends a implements d.a.c.j.e.n {
    public a2 w;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49334e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49335f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49336g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49337h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49338i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public int x = 0;
    public int y = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
        int i2;
        a2 a2Var = this.w;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.r0()) {
            if (this.w.u1() != null) {
                return a2.e3;
            }
            return a2.H2;
        }
        int x0 = this.w.x0();
        a2 a2Var2 = this.w;
        int i3 = a2Var2.Z;
        if (i3 == 63) {
            return a2.q3;
        }
        if (i3 == 64) {
            return a2.r3;
        }
        if (i3 == 65) {
            return a2.W2;
        }
        if (a2Var2.q1() != null && this.w.Z == 60) {
            return a2.h3;
        }
        if (this.w.q1() != null && ((i2 = this.w.Z) == 49 || i2 == 69)) {
            return a2.f3;
        }
        if (this.w.q1() != null && this.w.Z == 67) {
            return a2.i3;
        }
        a2 a2Var3 = this.w;
        if (a2Var3.Z == 51) {
            return a2.g3;
        }
        if (x0 != 2 && x0 != 1) {
            if (a2Var3.u1() != null && this.w.c2() && !this.w.g2()) {
                return a2.w3;
            }
            a2 a2Var4 = this.w;
            if (a2Var4.s1 && (originalThreadInfo = a2Var4.r1) != null) {
                if (originalThreadInfo.u) {
                    if (originalThreadInfo.r != null) {
                        return a2.m3;
                    }
                    if (originalThreadInfo.d()) {
                        return a2.l3;
                    }
                    return a2.k3;
                }
                return a2.j3;
            } else if (this.w.e2()) {
                return a2.t3.get() ? a2.A3 : a2.H2;
            } else if (this.w.L1() && this.w.G() == 1) {
                return a2.t3.get() ? a2.B3 : a2.H2;
            } else if (this.w.f2()) {
                return a2.c3;
            } else {
                if (this.w.w2()) {
                    return this.w.n0() != null ? a2.p3 : a2.o3;
                }
                d.a.j0.d3.h0.n nVar = this.w.C2;
                if (nVar != null && nVar.f()) {
                    return this.w.C2.g() ? AdvertAppInfo.m4 : AdvertAppInfo.n4;
                } else if (this.v) {
                    return a2.M2;
                } else {
                    if (this.f49334e) {
                        return a2.N2;
                    }
                    if (this.f49335f) {
                        return a2.O2;
                    }
                    if (this.f49336g) {
                        return a2.P2;
                    }
                    if (this.f49337h) {
                        return a2.Q2;
                    }
                    if (this.f49338i) {
                        return a2.R2;
                    }
                    if (this.j) {
                        return a2.S2;
                    }
                    if (this.k) {
                        return a2.T2;
                    }
                    if (this.l) {
                        return a2.U2;
                    }
                    if (this.m) {
                        return a2.e3;
                    }
                    if (this.n) {
                        return a2.x3;
                    }
                    if (this.w.a2()) {
                        if (this.o) {
                            return a2.n3;
                        }
                        return a2.d3;
                    } else if (this.p) {
                        return a2.s3;
                    } else {
                        if (this.q) {
                            return a2.X2;
                        }
                        if (this.r) {
                            return a2.Y2;
                        }
                        if (this.s) {
                            return a2.Z2;
                        }
                        if (this.t) {
                            return a2.a3;
                        }
                        if (this.u) {
                            return a2.b3;
                        }
                        return a2.H2;
                    }
                }
            }
        }
        return a2.G2;
    }

    @Override // d.a.i0.r.q.a
    public v0 h() {
        SparseArray<String> sparseArray;
        a2 a2Var = this.w;
        if (a2Var == null || (sparseArray = a2Var.d1) == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.n(m().w1());
        v0Var.k(m().c0());
        v0Var.m(m().L0());
        v0Var.j(this.w.d1);
        a2 a2Var2 = this.w;
        v0Var.f49284g = a2Var2.e1;
        v0Var.o = a2Var2.T0;
        v0Var.j = a2Var2.S0;
        v0Var.l = a2Var2.U0;
        v0Var.k = a2Var2.R0;
        v0Var.p = a2Var2.M1;
        v0Var.n = a2Var2.U0();
        return v0Var;
    }

    @Override // d.a.i0.r.q.a
    public a2 m() {
        return this.w;
    }

    public String z() {
        return this.w.V0;
    }
}

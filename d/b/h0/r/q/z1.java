package d.b.h0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes3.dex */
public class z1 extends a implements d.b.c.j.e.n {
    public a2 w;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51361e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51362f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51363g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51364h = false;
    public boolean i = false;
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

    @Override // d.b.h0.r.q.a
    public v0 g() {
        SparseArray<String> sparseArray;
        a2 a2Var = this.w;
        if (a2Var == null || (sparseArray = a2Var.d1) == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.n(n().w1());
        v0Var.k(n().c0());
        v0Var.m(n().L0());
        v0Var.j(this.w.d1);
        a2 a2Var2 = this.w;
        v0Var.f51314g = a2Var2.e1;
        v0Var.o = a2Var2.T0;
        v0Var.j = a2Var2.S0;
        v0Var.l = a2Var2.U0;
        v0Var.k = a2Var2.R0;
        v0Var.p = a2Var2.M1;
        v0Var.n = a2Var2.U0();
        return v0Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
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
        int i = a2Var2.Z;
        if (i == 63) {
            return a2.q3;
        }
        if (i == 64) {
            return a2.r3;
        }
        if (i == 65) {
            return a2.W2;
        }
        if (a2Var2.q1() != null && this.w.Z == 60) {
            return a2.h3;
        }
        if (this.w.q1() != null && this.w.Z == 49) {
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
                d.b.i0.d3.h0.n nVar = this.w.C2;
                if (nVar != null && nVar.f()) {
                    return this.w.C2.g() ? AdvertAppInfo.m4 : AdvertAppInfo.n4;
                } else if (this.v) {
                    return a2.M2;
                } else {
                    if (this.f51361e) {
                        return a2.N2;
                    }
                    if (this.f51362f) {
                        return a2.O2;
                    }
                    if (this.f51363g) {
                        return a2.P2;
                    }
                    if (this.f51364h) {
                        return a2.Q2;
                    }
                    if (this.i) {
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

    @Override // d.b.h0.r.q.a
    public a2 n() {
        return this.w;
    }

    public String z() {
        return this.w.V0;
    }
}

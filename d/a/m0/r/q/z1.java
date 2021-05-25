package d.a.m0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes3.dex */
public class z1 extends a implements d.a.c.j.e.n {
    public a2 w;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50197e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50198f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50199g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50200h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50201i = false;
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
            if (this.w.w1() != null) {
                return a2.g3;
            }
            return a2.J2;
        }
        int y0 = this.w.y0();
        a2 a2Var2 = this.w;
        int i3 = a2Var2.Z;
        if (i3 == 63) {
            return a2.s3;
        }
        if (i3 == 64) {
            return a2.t3;
        }
        if (i3 == 65) {
            return a2.Y2;
        }
        if (a2Var2.r1() != null && this.w.Z == 60) {
            return a2.j3;
        }
        if (this.w.r1() != null && ((i2 = this.w.Z) == 49 || i2 == 69)) {
            return a2.h3;
        }
        if (this.w.r1() != null && this.w.Z == 67) {
            return a2.k3;
        }
        a2 a2Var3 = this.w;
        if (a2Var3.Z == 51) {
            return a2.i3;
        }
        if (y0 != 2 && y0 != 1) {
            if (a2Var3.w1() != null && this.w.e2() && !this.w.i2()) {
                return a2.y3;
            }
            a2 a2Var4 = this.w;
            if (a2Var4.t1 && (originalThreadInfo = a2Var4.s1) != null) {
                if (originalThreadInfo.u) {
                    if (originalThreadInfo.r != null) {
                        return a2.o3;
                    }
                    if (originalThreadInfo.d()) {
                        return a2.n3;
                    }
                    return a2.m3;
                }
                return a2.l3;
            } else if (this.w.g2()) {
                return a2.v3.get() ? a2.C3 : a2.J2;
            } else if (this.w.N1() && this.w.G() == 1) {
                return a2.v3.get() ? a2.D3 : a2.J2;
            } else if (this.w.h2()) {
                return a2.e3;
            } else {
                if (this.w.z2()) {
                    return this.w.n0() != null ? a2.r3 : a2.q3;
                }
                d.a.n0.e3.h0.n nVar = this.w.D2;
                if (nVar != null && nVar.f()) {
                    return this.w.D2.g() ? AdvertAppInfo.k4 : AdvertAppInfo.l4;
                } else if (this.v) {
                    return a2.O2;
                } else {
                    if (this.f50197e) {
                        return a2.P2;
                    }
                    if (this.f50198f) {
                        return a2.Q2;
                    }
                    if (this.f50199g) {
                        return a2.R2;
                    }
                    if (this.f50200h) {
                        return a2.S2;
                    }
                    if (this.f50201i) {
                        return a2.T2;
                    }
                    if (this.j) {
                        return a2.U2;
                    }
                    if (this.k) {
                        return a2.V2;
                    }
                    if (this.l) {
                        return a2.W2;
                    }
                    if (this.m) {
                        return a2.g3;
                    }
                    if (this.n) {
                        return a2.z3;
                    }
                    if (this.w.c2()) {
                        if (this.o) {
                            return a2.p3;
                        }
                        return a2.f3;
                    } else if (this.p) {
                        return a2.u3;
                    } else {
                        if (this.q) {
                            return a2.Z2;
                        }
                        if (this.r) {
                            return a2.a3;
                        }
                        if (this.s) {
                            return a2.b3;
                        }
                        if (this.t) {
                            return a2.c3;
                        }
                        if (this.u) {
                            return a2.d3;
                        }
                        return a2.J2;
                    }
                }
            }
        }
        return a2.I2;
    }

    @Override // d.a.m0.r.q.a
    public v0 h() {
        SparseArray<String> sparseArray;
        a2 a2Var = this.w;
        if (a2Var == null || (sparseArray = a2Var.e1) == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.n(m().y1());
        v0Var.k(m().c0());
        v0Var.m(m().M0());
        v0Var.j(this.w.e1);
        a2 a2Var2 = this.w;
        v0Var.f50147g = a2Var2.f1;
        v0Var.o = a2Var2.U0;
        v0Var.j = a2Var2.T0;
        v0Var.l = a2Var2.V0;
        v0Var.k = a2Var2.S0;
        v0Var.p = a2Var2.N1;
        v0Var.n = a2Var2.V0();
        return v0Var;
    }

    @Override // d.a.m0.r.q.a
    public a2 m() {
        return this.w;
    }

    public String z() {
        return this.w.W0;
    }
}

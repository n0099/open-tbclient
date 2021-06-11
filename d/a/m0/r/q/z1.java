package d.a.m0.r.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
/* loaded from: classes3.dex */
public class z1 extends a implements d.a.c.k.e.n {
    public a2 w;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53873e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53874f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53875g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53876h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53877i = false;
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

    @Override // d.a.m0.r.q.a
    public v0 c() {
        SparseArray<String> sparseArray;
        a2 a2Var = this.w;
        if (a2Var == null || (sparseArray = a2Var.f1) == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.n(i().z1());
        v0Var.k(i().c0());
        v0Var.m(i().M0());
        v0Var.j(this.w.f1);
        a2 a2Var2 = this.w;
        v0Var.f53823g = a2Var2.g1;
        v0Var.o = a2Var2.V0;
        v0Var.j = a2Var2.U0;
        v0Var.l = a2Var2.W0;
        v0Var.k = a2Var2.T0;
        v0Var.p = a2Var2.O1;
        v0Var.n = a2Var2.W0();
        return v0Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
        int i2;
        a2 a2Var = this.w;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.r0()) {
            if (this.w.x1() != null) {
                return a2.j3;
            }
            return a2.M2;
        }
        int y0 = this.w.y0();
        a2 a2Var2 = this.w;
        int i3 = a2Var2.Z;
        if (i3 == 63) {
            return a2.v3;
        }
        if (i3 == 64) {
            return a2.w3;
        }
        if (i3 == 65) {
            return a2.b3;
        }
        if (a2Var2.s1() != null && this.w.Z == 60) {
            return a2.m3;
        }
        if (this.w.s1() != null && ((i2 = this.w.Z) == 49 || i2 == 69)) {
            return a2.k3;
        }
        if (this.w.s1() != null && this.w.Z == 67) {
            return a2.n3;
        }
        a2 a2Var3 = this.w;
        if (a2Var3.Z == 51) {
            return a2.l3;
        }
        if (y0 != 2 && y0 != 1) {
            if (a2Var3.x1() != null && this.w.f2() && !this.w.j2()) {
                return a2.B3;
            }
            a2 a2Var4 = this.w;
            if (a2Var4.u1 && (originalThreadInfo = a2Var4.t1) != null) {
                if (originalThreadInfo.u) {
                    if (originalThreadInfo.r != null) {
                        return a2.r3;
                    }
                    if (originalThreadInfo.d()) {
                        return a2.q3;
                    }
                    return a2.p3;
                }
                return a2.o3;
            } else if (this.w.h2()) {
                return a2.y3.get() ? a2.F3 : a2.M2;
            } else if (this.w.O1() && this.w.G() == 1) {
                return a2.y3.get() ? a2.G3 : a2.M2;
            } else if (this.w.i2()) {
                return a2.h3;
            } else {
                if (this.w.A2()) {
                    return this.w.n0() != null ? a2.u3 : a2.t3;
                }
                d.a.n0.e3.h0.n nVar = this.w.F2;
                if (nVar != null && nVar.f()) {
                    return this.w.F2.g() ? AdvertAppInfo.n4 : AdvertAppInfo.o4;
                } else if (this.v) {
                    return a2.R2;
                } else {
                    if (this.f53873e) {
                        return a2.S2;
                    }
                    if (this.f53874f) {
                        return a2.T2;
                    }
                    if (this.f53875g) {
                        return a2.U2;
                    }
                    if (this.f53876h) {
                        return a2.V2;
                    }
                    if (this.f53877i) {
                        return a2.W2;
                    }
                    if (this.j) {
                        return a2.X2;
                    }
                    if (this.k) {
                        return a2.Y2;
                    }
                    if (this.l) {
                        return a2.Z2;
                    }
                    if (this.m) {
                        return a2.j3;
                    }
                    if (this.n) {
                        return a2.C3;
                    }
                    if (this.w.d2()) {
                        if (this.o) {
                            return a2.s3;
                        }
                        return a2.i3;
                    } else if (this.p) {
                        return a2.x3;
                    } else {
                        if (this.q) {
                            return a2.c3;
                        }
                        if (this.r) {
                            return a2.d3;
                        }
                        if (this.s) {
                            return a2.e3;
                        }
                        if (this.t) {
                            return a2.f3;
                        }
                        if (this.u) {
                            return a2.g3;
                        }
                        return a2.M2;
                    }
                }
            }
        }
        return a2.L2;
    }

    @Override // d.a.m0.r.q.a
    public a2 i() {
        return this.w;
    }

    public String z() {
        return this.w.X0;
    }
}

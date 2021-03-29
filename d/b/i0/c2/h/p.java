package d.b.i0.c2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class p implements d.b.b.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f52458e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52459f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52460g = false;

    /* renamed from: h  reason: collision with root package name */
    public a2 f52461h;
    public AntiData i;

    public p(a2 a2Var, AntiData antiData) {
        this.f52461h = a2Var;
        this.i = antiData;
    }

    public int a() {
        a2 a2Var = this.f52461h;
        if (a2Var != null) {
            return a2Var.N();
        }
        return 0;
    }

    public AntiData e() {
        return this.i;
    }

    public a2 f() {
        return this.f52461h;
    }

    public boolean g() {
        a2 a2Var = this.f52461h;
        return a2Var != null && a2Var.m0() == 1;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public boolean j() {
        return this.f52458e;
    }

    public boolean k() {
        return this.f52460g;
    }

    public void l(boolean z) {
        this.f52458e = z;
    }

    public void n(boolean z) {
        this.f52460g = z;
    }
}

package d.a.k0.d2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import d.a.j0.r.q.a2;
/* loaded from: classes4.dex */
public class p implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f52755e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52756f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52757g = false;

    /* renamed from: h  reason: collision with root package name */
    public a2 f52758h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f52759i;

    public p(a2 a2Var, AntiData antiData) {
        this.f52758h = a2Var;
        this.f52759i = antiData;
    }

    public int c() {
        a2 a2Var = this.f52758h;
        if (a2Var != null) {
            return a2Var.N();
        }
        return 0;
    }

    public AntiData e() {
        return this.f52759i;
    }

    public a2 f() {
        return this.f52758h;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public boolean h() {
        a2 a2Var = this.f52758h;
        return a2Var != null && a2Var.m0() == 1;
    }

    public boolean i() {
        return this.f52755e;
    }

    public boolean k() {
        return this.f52757g;
    }

    public void l(boolean z) {
        this.f52755e = z;
    }

    public void m(boolean z) {
        this.f52757g = z;
    }
}

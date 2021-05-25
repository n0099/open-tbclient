package d.a.n0.e2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class p implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f52960e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52961f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52962g = false;

    /* renamed from: h  reason: collision with root package name */
    public a2 f52963h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f52964i;

    public p(a2 a2Var, AntiData antiData) {
        this.f52963h = a2Var;
        this.f52964i = antiData;
    }

    public int c() {
        a2 a2Var = this.f52963h;
        if (a2Var != null) {
            return a2Var.N();
        }
        return 0;
    }

    public AntiData e() {
        return this.f52964i;
    }

    public a2 f() {
        return this.f52963h;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public boolean h() {
        a2 a2Var = this.f52963h;
        return a2Var != null && a2Var.m0() == 1;
    }

    public boolean i() {
        return this.f52960e;
    }

    public boolean k() {
        return this.f52962g;
    }

    public void l(boolean z) {
        this.f52960e = z;
    }

    public void m(boolean z) {
        this.f52962g = z;
    }
}

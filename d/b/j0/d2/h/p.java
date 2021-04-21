package d.b.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import d.b.i0.r.q.a2;
/* loaded from: classes3.dex */
public class p implements d.b.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f54274e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54275f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54276g = false;

    /* renamed from: h  reason: collision with root package name */
    public a2 f54277h;
    public AntiData i;

    public p(a2 a2Var, AntiData antiData) {
        this.f54277h = a2Var;
        this.i = antiData;
    }

    public int a() {
        a2 a2Var = this.f54277h;
        if (a2Var != null) {
            return a2Var.N();
        }
        return 0;
    }

    public AntiData e() {
        return this.i;
    }

    public a2 f() {
        return this.f54277h;
    }

    public boolean g() {
        a2 a2Var = this.f54277h;
        return a2Var != null && a2Var.m0() == 1;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public boolean j() {
        return this.f54274e;
    }

    public boolean k() {
        return this.f54276g;
    }

    public void l(boolean z) {
        this.f54274e = z;
    }

    public void n(boolean z) {
        this.f54276g = z;
    }
}

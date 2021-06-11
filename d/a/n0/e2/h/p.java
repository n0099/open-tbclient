package d.a.n0.e2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import d.a.m0.r.q.a2;
/* loaded from: classes5.dex */
public class p implements d.a.c.k.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f56649e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56650f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56651g = false;

    /* renamed from: h  reason: collision with root package name */
    public a2 f56652h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f56653i;

    public p(a2 a2Var, AntiData antiData) {
        this.f56652h = a2Var;
        this.f56653i = antiData;
    }

    public int b() {
        a2 a2Var = this.f56652h;
        if (a2Var != null) {
            return a2Var.N();
        }
        return 0;
    }

    public AntiData c() {
        return this.f56653i;
    }

    public a2 e() {
        return this.f56652h;
    }

    public boolean g() {
        a2 a2Var = this.f56652h;
        return a2Var != null && a2Var.m0() == 1;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }

    public boolean h() {
        return this.f56649e;
    }

    public boolean i() {
        return this.f56651g;
    }

    public void k(boolean z) {
        this.f56649e = z;
    }

    public void l(boolean z) {
        this.f56651g = z;
    }
}

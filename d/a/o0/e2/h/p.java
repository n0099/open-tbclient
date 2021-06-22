package d.a.o0.e2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import d.a.n0.r.q.a2;
/* loaded from: classes5.dex */
public class p implements d.a.c.k.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f56774e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56775f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56776g = false;

    /* renamed from: h  reason: collision with root package name */
    public a2 f56777h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f56778i;

    public p(a2 a2Var, AntiData antiData) {
        this.f56777h = a2Var;
        this.f56778i = antiData;
    }

    public int b() {
        a2 a2Var = this.f56777h;
        if (a2Var != null) {
            return a2Var.N();
        }
        return 0;
    }

    public AntiData c() {
        return this.f56778i;
    }

    public a2 e() {
        return this.f56777h;
    }

    public boolean g() {
        a2 a2Var = this.f56777h;
        return a2Var != null && a2Var.m0() == 1;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }

    public boolean h() {
        return this.f56774e;
    }

    public boolean i() {
        return this.f56776g;
    }

    public void k(boolean z) {
        this.f56774e = z;
    }

    public void l(boolean z) {
        this.f56776g = z;
    }
}

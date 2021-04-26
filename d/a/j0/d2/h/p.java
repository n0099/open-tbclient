package d.a.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import d.a.i0.r.q.a2;
/* loaded from: classes3.dex */
public class p implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f52056e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52057f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52058g = false;

    /* renamed from: h  reason: collision with root package name */
    public a2 f52059h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f52060i;

    public p(a2 a2Var, AntiData antiData) {
        this.f52059h = a2Var;
        this.f52060i = antiData;
    }

    public int c() {
        a2 a2Var = this.f52059h;
        if (a2Var != null) {
            return a2Var.N();
        }
        return 0;
    }

    public AntiData e() {
        return this.f52060i;
    }

    public a2 f() {
        return this.f52059h;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public boolean h() {
        a2 a2Var = this.f52059h;
        return a2Var != null && a2Var.m0() == 1;
    }

    public boolean i() {
        return this.f52056e;
    }

    public boolean k() {
        return this.f52058g;
    }

    public void l(boolean z) {
        this.f52056e = z;
    }

    public void m(boolean z) {
        this.f52058g = z;
    }
}

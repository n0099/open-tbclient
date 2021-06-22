package d.a.o0.n2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements d.a.o0.u1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f61531a;

    /* renamed from: b  reason: collision with root package name */
    public String f61532b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.a.o0.u1.e> f61533c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.a.o0.u1.g f61534a = new j();
    }

    public static d.a.o0.u1.g m() {
        return b.f61534a;
    }

    @Override // d.a.o0.u1.g
    public void a(int i2, String str) {
        n().c(this.f61531a, i2, str);
    }

    @Override // d.a.o0.u1.g
    public void b(int i2, String str) {
        n().f(this.f61531a, i2, str);
    }

    @Override // d.a.o0.u1.g
    public void c() {
        n().k(this.f61531a);
        q(this.f61531a);
    }

    @Override // d.a.o0.u1.g
    public void d() {
        this.f61532b = this.f61531a;
    }

    @Override // d.a.o0.u1.g
    public void e(String str) {
        if (StringUtils.isNull(this.f61532b)) {
            return;
        }
        if (!o(this.f61532b) && !p(this.f61532b)) {
            d.a.o0.u1.d.b(this.f61532b);
            this.f61533c.remove(this.f61531a);
        } else {
            q(this.f61532b);
        }
        g();
        n().h(this.f61532b, str);
        this.f61532b = null;
    }

    @Override // d.a.o0.u1.g
    public void f(int i2, int i3, String str) {
        n().b(this.f61531a, i2, i3, str);
    }

    @Override // d.a.o0.u1.g
    public void g() {
        this.f61531a = UUID.randomUUID().toString();
    }

    @Override // d.a.o0.u1.g
    public void h(int i2, String str) {
        n().g(this.f61531a, i2, str);
    }

    @Override // d.a.o0.u1.g
    public void i(int i2, String str) {
        n().l(this.f61531a, i2, str);
    }

    @Override // d.a.o0.u1.g
    public void j() {
        n().j(this.f61531a);
    }

    @Override // d.a.o0.u1.g
    public void k(String str) {
        n().i(this.f61531a, str);
        if (!o(this.f61531a) && !p(this.f61531a)) {
            d.a.o0.u1.d.b(this.f61531a);
            this.f61533c.remove(this.f61531a);
        } else {
            q(this.f61531a);
        }
        this.f61531a = null;
    }

    public final d.a.o0.u1.e l() {
        i iVar = new i(this.f61531a);
        this.f61533c.put(this.f61531a, iVar);
        return iVar;
    }

    public final d.a.o0.u1.e n() {
        d.a.o0.u1.e eVar = this.f61533c.get(this.f61531a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().d(str);
    }

    public boolean p(String str) {
        return n().e(str);
    }

    public void q(String str) {
        d.a.o0.u1.e eVar = this.f61533c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f61533c.remove(str);
    }

    public j() {
        this.f61533c = new HashMap<>();
    }
}

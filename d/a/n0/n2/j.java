package d.a.n0.n2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements d.a.n0.u1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f57717a;

    /* renamed from: b  reason: collision with root package name */
    public String f57718b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.a.n0.u1.e> f57719c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.a.n0.u1.g f57720a = new j();
    }

    public static d.a.n0.u1.g m() {
        return b.f57720a;
    }

    @Override // d.a.n0.u1.g
    public void a(int i2, String str) {
        n().c(this.f57717a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void b(int i2, String str) {
        n().f(this.f57717a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void c() {
        n().k(this.f57717a);
        q(this.f57717a);
    }

    @Override // d.a.n0.u1.g
    public void d() {
        this.f57718b = this.f57717a;
    }

    @Override // d.a.n0.u1.g
    public void e(String str) {
        if (StringUtils.isNull(this.f57718b)) {
            return;
        }
        if (!o(this.f57718b) && !p(this.f57718b)) {
            d.a.n0.u1.d.b(this.f57718b);
            this.f57719c.remove(this.f57717a);
        } else {
            q(this.f57718b);
        }
        g();
        n().h(this.f57718b, str);
        this.f57718b = null;
    }

    @Override // d.a.n0.u1.g
    public void f(int i2, int i3, String str) {
        n().b(this.f57717a, i2, i3, str);
    }

    @Override // d.a.n0.u1.g
    public void g() {
        this.f57717a = UUID.randomUUID().toString();
    }

    @Override // d.a.n0.u1.g
    public void h(int i2, String str) {
        n().g(this.f57717a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void i(int i2, String str) {
        n().l(this.f57717a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void j() {
        n().j(this.f57717a);
    }

    @Override // d.a.n0.u1.g
    public void k(String str) {
        n().i(this.f57717a, str);
        if (!o(this.f57717a) && !p(this.f57717a)) {
            d.a.n0.u1.d.b(this.f57717a);
            this.f57719c.remove(this.f57717a);
        } else {
            q(this.f57717a);
        }
        this.f57717a = null;
    }

    public final d.a.n0.u1.e l() {
        i iVar = new i(this.f57717a);
        this.f57719c.put(this.f57717a, iVar);
        return iVar;
    }

    public final d.a.n0.u1.e n() {
        d.a.n0.u1.e eVar = this.f57719c.get(this.f57717a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().d(str);
    }

    public boolean p(String str) {
        return n().e(str);
    }

    public void q(String str) {
        d.a.n0.u1.e eVar = this.f57719c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f57719c.remove(str);
    }

    public j() {
        this.f57719c = new HashMap<>();
    }
}

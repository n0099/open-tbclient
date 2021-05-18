package d.a.k0.m2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements d.a.k0.t1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f57537a;

    /* renamed from: b  reason: collision with root package name */
    public String f57538b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.a.k0.t1.e> f57539c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.a.k0.t1.g f57540a = new j();
    }

    public static d.a.k0.t1.g m() {
        return b.f57540a;
    }

    @Override // d.a.k0.t1.g
    public void a(int i2, String str) {
        n().c(this.f57537a, i2, str);
    }

    @Override // d.a.k0.t1.g
    public void b(int i2, String str) {
        n().f(this.f57537a, i2, str);
    }

    @Override // d.a.k0.t1.g
    public void c() {
        n().k(this.f57537a);
        q(this.f57537a);
    }

    @Override // d.a.k0.t1.g
    public void d() {
        this.f57538b = this.f57537a;
    }

    @Override // d.a.k0.t1.g
    public void e(String str) {
        if (StringUtils.isNull(this.f57538b)) {
            return;
        }
        if (!o(this.f57538b) && !p(this.f57538b)) {
            d.a.k0.t1.d.b(this.f57538b);
            this.f57539c.remove(this.f57537a);
        } else {
            q(this.f57538b);
        }
        g();
        n().h(this.f57538b, str);
        this.f57538b = null;
    }

    @Override // d.a.k0.t1.g
    public void f(int i2, int i3, String str) {
        n().b(this.f57537a, i2, i3, str);
    }

    @Override // d.a.k0.t1.g
    public void g() {
        this.f57537a = UUID.randomUUID().toString();
    }

    @Override // d.a.k0.t1.g
    public void h(int i2, String str) {
        n().g(this.f57537a, i2, str);
    }

    @Override // d.a.k0.t1.g
    public void i(int i2, String str) {
        n().l(this.f57537a, i2, str);
    }

    @Override // d.a.k0.t1.g
    public void j() {
        n().j(this.f57537a);
    }

    @Override // d.a.k0.t1.g
    public void k(String str) {
        n().i(this.f57537a, str);
        if (!o(this.f57537a) && !p(this.f57537a)) {
            d.a.k0.t1.d.b(this.f57537a);
            this.f57539c.remove(this.f57537a);
        } else {
            q(this.f57537a);
        }
        this.f57537a = null;
    }

    public final d.a.k0.t1.e l() {
        i iVar = new i(this.f57537a);
        this.f57539c.put(this.f57537a, iVar);
        return iVar;
    }

    public final d.a.k0.t1.e n() {
        d.a.k0.t1.e eVar = this.f57539c.get(this.f57537a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().d(str);
    }

    public boolean p(String str) {
        return n().e(str);
    }

    public void q(String str) {
        d.a.k0.t1.e eVar = this.f57539c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f57539c.remove(str);
    }

    public j() {
        this.f57539c = new HashMap<>();
    }
}

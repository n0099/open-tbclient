package d.a.j0.m2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements d.a.j0.t1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f56830a;

    /* renamed from: b  reason: collision with root package name */
    public String f56831b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.a.j0.t1.e> f56832c;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.a.j0.t1.g f56833a = new j();
    }

    public static d.a.j0.t1.g m() {
        return b.f56833a;
    }

    @Override // d.a.j0.t1.g
    public void a(int i2, String str) {
        n().c(this.f56830a, i2, str);
    }

    @Override // d.a.j0.t1.g
    public void b(int i2, String str) {
        n().f(this.f56830a, i2, str);
    }

    @Override // d.a.j0.t1.g
    public void c() {
        n().k(this.f56830a);
        q(this.f56830a);
    }

    @Override // d.a.j0.t1.g
    public void d() {
        this.f56831b = this.f56830a;
    }

    @Override // d.a.j0.t1.g
    public void e(String str) {
        if (StringUtils.isNull(this.f56831b)) {
            return;
        }
        if (!o(this.f56831b) && !p(this.f56831b)) {
            d.a.j0.t1.d.b(this.f56831b);
            this.f56832c.remove(this.f56830a);
        } else {
            q(this.f56831b);
        }
        g();
        n().h(this.f56831b, str);
        this.f56831b = null;
    }

    @Override // d.a.j0.t1.g
    public void f(int i2, int i3, String str) {
        n().b(this.f56830a, i2, i3, str);
    }

    @Override // d.a.j0.t1.g
    public void g() {
        this.f56830a = UUID.randomUUID().toString();
    }

    @Override // d.a.j0.t1.g
    public void h(int i2, String str) {
        n().g(this.f56830a, i2, str);
    }

    @Override // d.a.j0.t1.g
    public void i(int i2, String str) {
        n().l(this.f56830a, i2, str);
    }

    @Override // d.a.j0.t1.g
    public void j() {
        n().j(this.f56830a);
    }

    @Override // d.a.j0.t1.g
    public void k(String str) {
        n().i(this.f56830a, str);
        if (!o(this.f56830a) && !p(this.f56830a)) {
            d.a.j0.t1.d.b(this.f56830a);
            this.f56832c.remove(this.f56830a);
        } else {
            q(this.f56830a);
        }
        this.f56830a = null;
    }

    public final d.a.j0.t1.e l() {
        i iVar = new i(this.f56830a);
        this.f56832c.put(this.f56830a, iVar);
        return iVar;
    }

    public final d.a.j0.t1.e n() {
        d.a.j0.t1.e eVar = this.f56832c.get(this.f56830a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().d(str);
    }

    public boolean p(String str) {
        return n().e(str);
    }

    public void q(String str) {
        d.a.j0.t1.e eVar = this.f56832c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f56832c.remove(str);
    }

    public j() {
        this.f56832c = new HashMap<>();
    }
}

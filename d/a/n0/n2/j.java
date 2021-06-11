package d.a.n0.n2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements d.a.n0.u1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f61406a;

    /* renamed from: b  reason: collision with root package name */
    public String f61407b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.a.n0.u1.e> f61408c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.a.n0.u1.g f61409a = new j();
    }

    public static d.a.n0.u1.g m() {
        return b.f61409a;
    }

    @Override // d.a.n0.u1.g
    public void a(int i2, String str) {
        n().c(this.f61406a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void b(int i2, String str) {
        n().f(this.f61406a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void c() {
        n().k(this.f61406a);
        q(this.f61406a);
    }

    @Override // d.a.n0.u1.g
    public void d() {
        this.f61407b = this.f61406a;
    }

    @Override // d.a.n0.u1.g
    public void e(String str) {
        if (StringUtils.isNull(this.f61407b)) {
            return;
        }
        if (!o(this.f61407b) && !p(this.f61407b)) {
            d.a.n0.u1.d.b(this.f61407b);
            this.f61408c.remove(this.f61406a);
        } else {
            q(this.f61407b);
        }
        g();
        n().h(this.f61407b, str);
        this.f61407b = null;
    }

    @Override // d.a.n0.u1.g
    public void f(int i2, int i3, String str) {
        n().b(this.f61406a, i2, i3, str);
    }

    @Override // d.a.n0.u1.g
    public void g() {
        this.f61406a = UUID.randomUUID().toString();
    }

    @Override // d.a.n0.u1.g
    public void h(int i2, String str) {
        n().g(this.f61406a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void i(int i2, String str) {
        n().l(this.f61406a, i2, str);
    }

    @Override // d.a.n0.u1.g
    public void j() {
        n().j(this.f61406a);
    }

    @Override // d.a.n0.u1.g
    public void k(String str) {
        n().i(this.f61406a, str);
        if (!o(this.f61406a) && !p(this.f61406a)) {
            d.a.n0.u1.d.b(this.f61406a);
            this.f61408c.remove(this.f61406a);
        } else {
            q(this.f61406a);
        }
        this.f61406a = null;
    }

    public final d.a.n0.u1.e l() {
        i iVar = new i(this.f61406a);
        this.f61408c.put(this.f61406a, iVar);
        return iVar;
    }

    public final d.a.n0.u1.e n() {
        d.a.n0.u1.e eVar = this.f61408c.get(this.f61406a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().d(str);
    }

    public boolean p(String str) {
        return n().e(str);
    }

    public void q(String str) {
        d.a.n0.u1.e eVar = this.f61408c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f61408c.remove(str);
    }

    public j() {
        this.f61408c = new HashMap<>();
    }
}

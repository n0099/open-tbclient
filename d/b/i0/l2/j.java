package d.b.i0.l2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements d.b.i0.s1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f56765a;

    /* renamed from: b  reason: collision with root package name */
    public String f56766b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.b.i0.s1.e> f56767c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.b.i0.s1.g f56768a = new j();
    }

    public static d.b.i0.s1.g m() {
        return b.f56768a;
    }

    @Override // d.b.i0.s1.g
    public void a(int i, String str) {
        n().e(this.f56765a, i, str);
    }

    @Override // d.b.i0.s1.g
    public void b(String str) {
        if (StringUtils.isNull(this.f56766b)) {
            return;
        }
        if (!o(this.f56766b) && !p(this.f56766b)) {
            d.b.i0.s1.d.b(this.f56766b);
            this.f56767c.remove(this.f56765a);
        } else {
            q(this.f56766b);
        }
        e();
        n().d(this.f56766b, str);
        this.f56766b = null;
    }

    @Override // d.b.i0.s1.g
    public void c(int i, String str) {
        n().l(this.f56765a, i, str);
    }

    @Override // d.b.i0.s1.g
    public void d(int i, int i2, String str) {
        n().b(this.f56765a, i, i2, str);
    }

    @Override // d.b.i0.s1.g
    public void e() {
        this.f56765a = UUID.randomUUID().toString();
    }

    @Override // d.b.i0.s1.g
    public void f(int i, String str) {
        n().c(this.f56765a, i, str);
    }

    @Override // d.b.i0.s1.g
    public void g() {
        n().i(this.f56765a);
        q(this.f56765a);
    }

    @Override // d.b.i0.s1.g
    public void h() {
        this.f56766b = this.f56765a;
    }

    @Override // d.b.i0.s1.g
    public void i(int i, String str) {
        n().k(this.f56765a, i, str);
    }

    @Override // d.b.i0.s1.g
    public void j() {
        n().h(this.f56765a);
    }

    @Override // d.b.i0.s1.g
    public void k(String str) {
        n().f(this.f56765a, str);
        if (!o(this.f56765a) && !p(this.f56765a)) {
            d.b.i0.s1.d.b(this.f56765a);
            this.f56767c.remove(this.f56765a);
        } else {
            q(this.f56765a);
        }
        this.f56765a = null;
    }

    public final d.b.i0.s1.e l() {
        i iVar = new i(this.f56765a);
        this.f56767c.put(this.f56765a, iVar);
        return iVar;
    }

    public final d.b.i0.s1.e n() {
        d.b.i0.s1.e eVar = this.f56767c.get(this.f56765a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().g(str);
    }

    public boolean p(String str) {
        return n().j(str);
    }

    public void q(String str) {
        d.b.i0.s1.e eVar = this.f56767c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f56767c.remove(str);
    }

    public j() {
        this.f56767c = new HashMap<>();
    }
}

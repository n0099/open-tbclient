package d.b.i0.m2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public class j implements d.b.i0.t1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f58394a;

    /* renamed from: b  reason: collision with root package name */
    public String f58395b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.b.i0.t1.e> f58396c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.b.i0.t1.g f58397a = new j();
    }

    public static d.b.i0.t1.g m() {
        return b.f58397a;
    }

    @Override // d.b.i0.t1.g
    public void a(int i, String str) {
        n().e(this.f58394a, i, str);
    }

    @Override // d.b.i0.t1.g
    public void b(String str) {
        if (StringUtils.isNull(this.f58395b)) {
            return;
        }
        if (!o(this.f58395b) && !p(this.f58395b)) {
            d.b.i0.t1.d.b(this.f58395b);
            this.f58396c.remove(this.f58394a);
        } else {
            q(this.f58395b);
        }
        e();
        n().d(this.f58395b, str);
        this.f58395b = null;
    }

    @Override // d.b.i0.t1.g
    public void c(int i, String str) {
        n().l(this.f58394a, i, str);
    }

    @Override // d.b.i0.t1.g
    public void d(int i, int i2, String str) {
        n().b(this.f58394a, i, i2, str);
    }

    @Override // d.b.i0.t1.g
    public void e() {
        this.f58394a = UUID.randomUUID().toString();
    }

    @Override // d.b.i0.t1.g
    public void f(int i, String str) {
        n().c(this.f58394a, i, str);
    }

    @Override // d.b.i0.t1.g
    public void g() {
        n().i(this.f58394a);
        q(this.f58394a);
    }

    @Override // d.b.i0.t1.g
    public void h() {
        this.f58395b = this.f58394a;
    }

    @Override // d.b.i0.t1.g
    public void i(int i, String str) {
        n().k(this.f58394a, i, str);
    }

    @Override // d.b.i0.t1.g
    public void j() {
        n().h(this.f58394a);
    }

    @Override // d.b.i0.t1.g
    public void k(String str) {
        n().f(this.f58394a, str);
        if (!o(this.f58394a) && !p(this.f58394a)) {
            d.b.i0.t1.d.b(this.f58394a);
            this.f58396c.remove(this.f58394a);
        } else {
            q(this.f58394a);
        }
        this.f58394a = null;
    }

    public final d.b.i0.t1.e l() {
        i iVar = new i(this.f58394a);
        this.f58396c.put(this.f58394a, iVar);
        return iVar;
    }

    public final d.b.i0.t1.e n() {
        d.b.i0.t1.e eVar = this.f58396c.get(this.f58394a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().g(str);
    }

    public boolean p(String str) {
        return n().j(str);
    }

    public void q(String str) {
        d.b.i0.t1.e eVar = this.f58396c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f58396c.remove(str);
    }

    public j() {
        this.f58396c = new HashMap<>();
    }
}
